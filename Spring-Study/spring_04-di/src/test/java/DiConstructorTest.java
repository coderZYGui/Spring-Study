import com.sunny._03_di_constructor.CollectionBean1;
import com.sunny._03_di_constructor.Employee1;
import com.sunny._03_di_constructor.Person1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DiConstructorTest {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private Employee1 emp;
    @Autowired
    private Person1 p1;
    @Autowired
    private CollectionBean1 cb1;

    @Test
    public void test1(){
        System.out.println(emp);
        System.out.println(p1);
        System.out.println(cb1);
    }
}
