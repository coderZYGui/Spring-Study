import com.sunny.createbean._01_constructor.Cat1;
import com.sunny.createbean._02_static_factory.Cat2;
import com.sunny.createbean._02_static_factory.Cat2Factory;
import com.sunny.createbean._03_instance_factory.Cat3;
import com.sunny.createbean._03_instance_factory.Cat3Factory;
import com.sunny.createbean._04_factory_bean.Cat4;
import com.sunny.createbean._04_factory_bean.Cat4Factory;
import com.sunny._01_static_proxy.domain.Person;
import com.sunny.lifecycle.MyDataSource;
import com.sunny.scope.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJunit4 {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上

    // ------ person----------
    @Autowired
    private Person person;

    @Test
    public void test(){
        System.out.println(person);
    }
    // -------------------------




    // ------- 4种Bean实例化的方式---------
    @Autowired
    private Cat1 cat1;
    @Autowired
    private Cat2 cat2;
    @Autowired
    private Cat3 cat3;
    @Autowired
    private Cat4 cat4;

    // 不使用Spring容器的时候,使用这4种方式的实例化步骤
    @Test
    public void testOld() throws Exception {
        // 使用构造器_实例化bean
        Cat1 cat1 = new Cat1();
        // 使用静态工厂方法_实例化bean
        Cat2 cat2 = Cat2Factory.createInstance();
        // 使用实例工厂方法_实例化bean
        Cat3 cat3 = new Cat3Factory().createInstance();
        // 实现FactoryBean接口实例化_实例化bean
        Cat4 cat4 = new Cat4Factory().getObject();
    }
    @Test
    public void test2(){
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
    }
    // -------------------------------------------------------------

    // ----------bean的scope范围-----------------
    // 表示从容器中拿到实例化的dog对象
    @Autowired
    private Dog dog1;
    @Autowired
    private Dog dog2;

    @Test
    public void test3(){
        // 因为bean的scope默认就是singleton,所以容器生成的Dog对象就是同一个
        System.out.println(dog1);
        System.out.println(dog2);
    }

    // --------------------------------------------

    // ------bean的初始化和销毁--------
    // 没有使用Spring容器的操作
    @Test
    public void testOld1(){
        // 创建对象
        MyDataSource ds = new MyDataSource();
        System.out.println("-------");
        // 初始化操作
        ds.open();
        // 工作
        ds.doWork();
        // 销毁
        ds.close();
    }
    // 使用Spring容器的方式
    @Autowired
    private MyDataSource ds;

    @Test
    public void test4(){
        ds.doWork();
    }
}
