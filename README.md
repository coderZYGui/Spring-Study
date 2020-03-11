# Spring-Study
Record spring learned

## <span id="j0">目录</span>

这里是部分笔记,全部笔记请点击[链接](https://blog.csdn.net/m0_37989980/article/details/103987924)

- [一、丑陋的代码](#j1)
- [二、 Spring简介](#j2)
	- [1、为什么说Spring是一个一站式的轻量级开源框架呢？](#j3)
	- [2、Spring的优点](#j4)
	- [3、Spring的体系结构](#j5)
- [三、IoC和DI思想](#j6)
- [四、 Spring初体验](#j7)
	- [1、什么是BeanFactryo？](#j8)
	- [2、Spring IoC管理bean的原理](#j9)
	- [3、Spring的基本配置](#j10)
	- [4、Spring的测试框架](#j11)
- [五、 解决丑陋代码](#j12)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200228110227367.png)

---
# 一、丑陋的代码<span id="j1"></span>
[<font size = 1>跳转到目录</font>](#j0)
代码耦合严重
- DAO
```java
// DAO接口
public interface UserDao {
    void getUser();
}

// DAO实现类
public class UserDaoMysqlImpl implements UserDao{
    public void getUser() {
        System.out.println("使用MySQL!");
    }
}
public class UserDaoOracleImpl implements UserDao{
    public void getUser() {
        System.out.println("使用Oracle!");
    }
}
```

- Service
```java
// Service接口
public interface UserService {
    void getUser();
}

// Service实现类
public class UserServiceImpl implements UserService{

	// private UserDao dao = new UserDaoOracleImpl();
    private UserDao dao = new UserDaoMysqlImpl();
    public void getUser() {
        dao.getUser();
    }
}
```
- 测试类
```java
public class MyTest {
    public static void main(String[] args) {
         UserService userService = new UserServiceImpl();
         userService.getUser();
}
```
- 输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227184226186.png)
此时如果把`UserDao`的实现类换成UserDaoOracleImpl ,此时就需要修改`UserServiceImpl`的源代码, 不符合开闭原则!
> 开闭原则: 对扩展开放,对修改关闭;

# 二、Spring简介<span id="j2"></span>
[<font size = 1>跳转到目录</font>](#j0)
Spring 是分层的 Java SE/EE 应用 full-stack 轻量级开源框架，以 <font color=red>IoC（Inverse Of Control：反转控制）</font>和 <font color=red>AOP（Aspect Oriented Programming：面向切面编程）</font>为内核，提供了`展现层 Spring MVC` 和`持久层 Spring JDBC` 以及业务层事务管理等众多的企业级应用技术，还能整合开源世界众多著名的第三方框架和类库，逐渐成为使用最多的 Java EE 企业应用开源框架

>什么是容器(Container): 从程序设计角度看就是封装对象的对象,因为存在放入、拿出等操作,所以容器还要管理对象的生命周期,如Tomcat就是Servlet和JSP的容器;

 Spring 官网：[https://spring.io/projects/spring-framework](https://spring.io/projects/spring-framework)

下载地址: [https://repo.spring.io/libs-release-local/org/springframework/spring/](https://repo.spring.io/libs-release-local/org/springframework/spring/)

### 1、 为什么说Spring是一个一站式的轻量级开源框架呢？<span id="j3"></span>
[<font size = 1>跳转到目录</font>](#j0)

 首先轻量级：不是指Spring框架的模块少，数量很轻，而是指`Spring框架的非侵入性`，即对象可以不必依赖Spring的API类

其次，JavaEE开发可分成三层架构，针对JavaEE的三层结构，每一层Spring都提供了不同的解决技术。
- WEB层：SpringMVC
- 业务层：Spring的IoC
- 持久层：Spring的JDBCTemplate (Spring的JDBC模板，ORM模板用于整合其他的持久层框架)

Spring提供了JavaEE每一层的解决方案，所以也说Spring是JavaEE的全栈式（full stack）框架。

### 2.、Spring的优点<span id="j4"></span>
[<font size = 1>跳转到目录</font>](#j0)
- 方便解耦，简化开发。
       Spring就是一个大工厂，可以将所有对象的创建和依赖关系的维护，交给Spring管理。

- AOP编程的支持
       Spring提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能。

- 声明式事务的支持
       只需要通过配置就可以完成对事务的管理，而无须手动编程。

- 方便程序的测试
       Spring对Junit4支持，可以通过注解方便的测试Spring程序。

- 方便集成各种优秀的框架
       Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架(如:Struts2/Hibernate/MyBatis/Quartz等)的直接支持。

- 降低JavaEE API的使用难度
       Spring对JavaEE开发中非常难用的一些API(JDBC、JavaMail、远程调用等)都提供了封装，使这些API应用难度大大降低。

### 3、Spring的体系结构<span id="j5"></span>
[<font size = 1>跳转到目录</font>](#j0)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227181650357.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

##### 核心容器
核心容器由 <font color=red>spring-core，spring-beans，spring-context 和 spring-expression</font>（SpEL，Spring表达式语言，Spring Expression Language）等模块组成，它们的细节如下：

- `spring-core`：提供了框架的基本组成部分，包括 IoC 和依赖注入功能。

- `spring-beans`：提供 BeanFactory，工厂模式的微妙实现，它移除了编码式单例的需要，并且可以把配置和依赖从实际编码逻辑中解耦。

- `spring-context`：模块建立在由core和 beans 模块的基础上建立起来的，它以一种类似于JNDI注册的方式访问对象。Context模块继承自Bean模块，并且添加了国际化（比如，使用资源束）、事件传播、资源加载和透明地创建上下文（比如，通过Servelet容器）等功能

- `spring-expression`：提供了强大的表达式语言，用于在运行时查询和操作对象图。它是JSP2.1规范中定义的统一表达式语言的扩展，支持set和get属性值、属性赋值、方法调用、访问数组集合及索引的内容、逻辑算术运算、命名变量、通过名字从Spring IoC容器检索对象，还支持列表的投影、选择以及聚合等。

# 三、IoC和DI思想<span id="j6"></span>
[<font size = 1>跳转到目录</font>](#j0)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227195424815.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
- IoC : Inversion of Control (控制反转), 其本意就是将`原本在程序中手动创建对象的控制权`,交给Spring来管理;

1、在没有IoC之前,我们的操作是:<font color=blue> 若调用者需要使用某个对象,其自身就得负责该对象及该对象所依赖对象的创建和组装;

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227190802640.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
2、有IoC之后,调用者<font color=blue>只管负责从Spring容器中获取需要使用的对象,不关心对象的创建过程,也不关心该对象依赖对象的创建以及依赖关系的组装</font>;也就是把创建对象的控制权反转给了Spring框架.![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227191013136.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
- DI: Dependency Injection`(依赖注入)`从字面上分析:IoC :指将对象的创建权,反转给了Spring容器;DI : 指Spring创建对象的过程中,将`对象依赖属性(常量,对象，集合)通过配置设值给该对象。`

	IoC从字面意思上很难体现出谁来维护对象之间的关系, Martin Fowler提出一个新的概念一- -DI ,更明确描述了“被注入对象 ( Service对象)依赖IoC容器来配置依赖对象( DAO对象)" .

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227191246705.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

# 四、 Spring初体验<span id="j7"></span>
[<font size = 1>跳转到目录</font>](#j0)
1、首先导入Maven坐标
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.2.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.2.RELEASE</version>
    </dependency>
```
2、HelloSpring类
```java
import lombok.Data;

@Data
public class HelloSpring {
    private String str;
    private int age;
}
```
3、在resources中创建配置文件,命名为: `applicationContext.xml`或`beans.xml`都行
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
    <bean id="helloSpring" class="com.sunny.domain.HelloSpring">
        <property name="str" value="桂朝阳"/> <!--对应HelloSpring中的setStr方法-->
        <property name="age" value="22"/>    <!--对应HelloSpring中的setAge方法-->
    </bean>

</beans>
```
4、测试类
```java
public class HelloTest {

    @Test
    public void test2(){

        HelloSpring helloSpring = null;

        // 方式一: 官方推荐
        // 获取ApplicationContext: 拿到Spring容器
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       helloSpring = (HelloSpring) context.getBean("helloSpring");

        // 方式二:
        /*//1. 从classpath去找配置文件,创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2. 根据资源对象,创建Spring IoC容器对象
        BeanFactory factory = new XmlBeanFactory(resource);
        //3. 从Spring IoC容器中获取指定名称(helloSpring)的对象
        helloSpring = factory.getBean("helloSpring", HelloSpring.class);*/

        System.out.println(helloSpring);
    }
}

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227195608737.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

- <font color=red>ClassPathXmlApplicationContext</font> 默认加载classpath路径下的文件，只需指明对应文件的classpath路径下的配置文件名字即可。

- FileSystemXmlApplicationContext : 该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径。

- WebXmlApplicationContext：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。

- 面向接口编程：返回 <font color=red>**ApplicationContext** </font>(实际上ApplicationContext是一个接口), 即 **Spring 的 IOC容器**：

- ConfigurableApplicationContext 子接口, 提供了一些方法 close(), refresh(), 可以让 ApplicationContext 刷新和关闭。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227192520888.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
#### 什么是BeanFactryo<span id="j8"></span>
[<font size = 1>跳转到目录</font>](#j0)
上面代码写了两种创建Spring IoC容器的办法,下面介绍一下第二种; 
- BeanFactory是Spring最古老的接口,表示Spring IoC容器,生产bean对象的工厂, 负责配置,创建和管理bean.
-  被Spring IoC容器管理的对象称之为bean;
- Spring IoC容器如何知道哪些是它管理的对象; 此时就需要配置文件,IoC容器读取配置文件的元数据,通过元数据对应用的各个对象进行实例化及装配.
- 元数据配置的三种方式
`XML-based configuration`
`Annotation-based configuration`
`Java-based configuration`

#### **Spring IoC管理bean的原理**<span id="j9"></span>
[<font size = 1>跳转到目录</font>](#j0)
1. 通过Resource对象加载配置文件
2. 解析配置文件,得到指定名称的bean
3. 解析bean元素, id作为bean的名字, class用于反射得到bean的实例; 
<font color=red>**注意: 此时bean类必须存在一个无参数构造器(和访问权限无关)**</font>
4. 调用getBean方法的时候, 从容器中返回对象的实例;

**使用getBean方法,从容器中返回对象实例的三种方式:** 
- 签名1: `Object getBean (String beanName);` // 根据bean对象在容器中的名称来获取
 	>helloSpring = (HelloSpring) factory.getBean("helloSpring");

- 签名2: `<T> T getBean(Class<T> requiredType)` // 按照指定的类型去寻找bean对象
	
	>helloSpring = factory.getBean(HelloSpring.class); // HelloSpring只能对应一个Bean,多个Bean的时候就会报错
- 签名3: `<T> T getBean(String name,@Nullable Class<T> requiredType)`: 根据bean的类型 + ID 去寻找.
	
	>  helloSpring = factory.getBean("helloSpring2", HelloSpring.class);

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200227193349262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)

#### Spring的配置<span id="j10"></span>
[<font size = 1>跳转到目录</font>](#j0)
- `<import resource=" "/>`
当在Spring的配置文件 `applicationContext.xml`中配置很多的`bean`就会很不好管理.在开发中,随着应用规模越来愈大, 该文件中就变得特别臃肿; 为了提高可读性,我们可以将一个applicationContext.xml文件分解为多个配置文件,然后在applicationContext.xml中使用`<import resource=" "/>`来包含其他的配置文件即可!

- 语法
在`applicationContext.xml`文件中导入
	```xml
	<import resource="classpath:xmls/helloSpring.xml"/>
	```
然后`helloSpring.xml`专门为了生成指定类对象的容器配置文件;
	**注意:** 只有当框架实现了Resource接口才能够使用classpath前缀标识符


#### Spring的测试框架<span id="j11"></span>
[<font size = 1>跳转到目录</font>](#j0)
- 普通的单元测试
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020022811152239.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
**存在的问题:**
1、每次测试都要重启Spring,启动容器的开销大,测试效率低
2、不应是在测试代码管理Spring容器, 应该是在Spring容器在管理测试代码
3、<font color=blue>普通的单元测试不能正常关闭Spring容器,Spring容器声明周期非正常退出(后面会给出验证)</font>

##### Spring Test框架
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200228111602378.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzM3OTg5OTgw,size_16,color_FFFFFF,t_70)
1、使用Spring的测试框架
导入Maven依赖
```java
<!--https://mvnrepository.com/artifact/org.springframework/spring-test -->
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-test</artifactId>
<version>5.2.2.RELEASE</version>
</dependency>
```

2、基于junit4的测试
其中: `@Autowired注解, 表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上`
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunit4 {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private Person person;
    
    @Test
    public void test(){
        System.out.println(person);
    }
```
3、基于junit5的测试
```java
@SpringJUnitConfig
public class SpringJunit5{
	@Autowired
	private Person peroson;
	
	@Test
	void test1(){
		System.out.println(person);
	}
}
```

# 五、 解决丑陋代码<span id="j12"></span>
[<font size = 1>跳转到目录</font>](#j0)
- DAO 代码不变
- Service
```java
public interface UserService {
    void getUser();
}

public class UserServiceImpl implements UserService{

    private UserDao dao;

    // 利用set进行动态实现值的注入!
    public void setUserDao(UserDao dao){
        this.dao = dao;
    }

    public void getUser() {
        dao.getUser();
    }
}
```
- 测试类
```java
public class MyTest {
    public static void main(String[] args) {
    
        // 创建Spring IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl serviceImpl = (UserServiceImpl) context.getBean("serviceImpl");
        serviceImpl.getUser();
    }
}
```