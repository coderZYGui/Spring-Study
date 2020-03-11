import com.sunny._02_di_setter.CollectionBean;
import com.sunny._02_di_setter.Employee;
import com.sunny._02_di_setter.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DiSetterTest {
    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private Employee employee;
    @Autowired
    private Person person;
    @Autowired
    private CollectionBean cb;

    @Test
    public void test1(){
        System.out.println(employee);
        System.out.println(person);
        System.out.println(cb);
    }
}
