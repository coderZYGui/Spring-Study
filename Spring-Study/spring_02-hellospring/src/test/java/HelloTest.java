import com.sunny._01_static_proxy.domain.HelloSpring;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloTest {

    @Test
    public void test(){
        HelloSpring hs = new HelloSpring();
        hs.setStr("你好,春天");

        System.out.println(hs);
    }

    @Test
    public void test2(){

        HelloSpring helloSpring = null;

        // 方式一: 官方推荐
        // 获取ApplicationContext: 拿到Spring容器
       /* ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            helloSpring = (HelloSpring) context.getBean("helloSpring");*/

        // 方式二:
        //1. 从classpath去找配置文件,创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2. 根据资源对象,创建Spring IoC容器对象
        BeanFactory factory = new XmlBeanFactory(resource);
        //3. 从Spring IoC容器中获取指定名称(helloSpring)的对象

        //3.1 签名1: Object getBean (String beanName); // 根据bean对象在容器中的名称来获取
        // helloSpring = (HelloSpring) factory.getBean("helloSpring");

        //3.2 签名2: <T> T getBean(Class<T> requiredType) // 按照指定的类型去寻找bean对象
        // helloSpring = factory.getBean(HelloSpring.class); // HelloSpring只能对应一个Bean,多个Bean的时候就会报错

        //3.3 签名3: <T> T getBean(String name,@Nullable Class<T> requiredType): 根据bean的类型 + ID 去寻找.
        helloSpring = factory.getBean("helloSpring2", HelloSpring.class);

        System.out.println(helloSpring);
    }
}
