import com.sunny.domain2.HelloGui;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloGuiTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xmls/helloGui.xml");
        HelloGui helloGui = (HelloGui) context.getBean("helloGui");
        System.out.println(helloGui);
    }
}
