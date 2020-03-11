import com.sunny.di.Person;
import com.sunny.di.ValueBean;
import com.sunny.lifecycle.SomeBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LifeCycleTest {

    @Autowired
    private SomeBean sb1;
    @Autowired
    private SomeBean sb2;

    @Test
    public void test(){
        System.out.println(sb1);
        System.out.println(sb2);
        sb1.doWork();
    }
}
