import com.sunny._01_register.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RegisterTest {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private UserController uc;

    @Test
    public void test(){
        uc.register();
    }
}
