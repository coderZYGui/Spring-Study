import com.sunny._04_bean_tag_inheritance.SomeBean1;
import com.sunny._04_bean_tag_inheritance.SomeBean2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BeanTagInheritTest {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private SomeBean1 sb1;
    @Autowired
    private SomeBean2 sb2;

    @Test
    public void test(){
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
