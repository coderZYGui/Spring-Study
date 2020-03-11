import com.sunny.di.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonTest {
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xmls/di.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }
}
