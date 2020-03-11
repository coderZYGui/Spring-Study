import com.sunny._04cglib_methodinterceptor.domain.Employee3;
import com.sunny._04cglib_methodinterceptor.log.LogAdvice;
import com.sunny._04cglib_methodinterceptor.service.impl.EmployeeServiceImpl3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CglibMethodInterceptorTest {

    // com.sunny._04cglib_methodinterceptor.service.impl.EmployeeServiceImpl3$$EnhancerByCGLIB$$b1d8ba01
    @Autowired
    private LogAdvice advice;

    @Test
    public void testSave(){
        EmployeeServiceImpl3 proxy = advice.getProxyObject();
        // System.out.println(proxy.getClass());
        proxy.save(new Employee3());
    }

    @Test
    public void testUpdate(){
        EmployeeServiceImpl3 proxy = advice.getProxyObject();
        proxy.update(new Employee3());
    }
}
