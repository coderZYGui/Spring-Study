import com.sunny.di.Person;
import com.sunny.di.ValueBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DiTest {

    //@Autowired
    @Resource
    private Person person;

    @Autowired
    private ValueBean valueBean;

    @Test
    public void test(){
        System.out.println(person);
        System.out.println(valueBean);
    }
}
