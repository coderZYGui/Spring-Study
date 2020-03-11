import com.sunny._01_static_proxy.domain.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PersonTest {

    // 使用BeanFactory创建Spring IoC容器
    /**
     * --------------------------------
     * Person对象创建啦!
     * Person(name=CoderZYGui, age=23)
     *
     * 结论: BeanFactory有延迟初始化(懒加载)的特点,在创建Spring容器的时候,不会立刻去创建容器,
     *      管理Bean对象,而是要等到从容器中获取对象的时候,才去创建对象.
     */
    @Test
    public void test1(){
        Resource resource = new ClassPathResource("xmls/person.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("--------------------------------");
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
    }

    // 使用ApplicationContext创建Spring IoC容器
    /**
     * Person对象创建啦!
     * --------------------------------
     * Person(name=CoderZYGui, age=23)
     *
     * 结论: 在创建Spring容器的时候,会把容器中管理的Bean立刻初始化,而不会等到获取Bean的时候才初始化.
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xmls/person.xml");
        System.out.println("--------------------------------");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }
}
