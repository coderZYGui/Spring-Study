import com.sunny._01_static_proxy.domain.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {
    @Test
    public void test(){
        // 得到 Spring IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("xmls/helloSpring.xml");
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        System.out.println(helloSpring);
    }
}
