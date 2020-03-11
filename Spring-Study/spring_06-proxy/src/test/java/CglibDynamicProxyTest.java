import com.sunny._03cglib_dynamic_proxy.domain.Employee2;
import com.sunny._03cglib_dynamic_proxy.service.impl.EmployeeServiceImpl2;
import com.sunny._03cglib_dynamic_proxy.tx.TransactionManagerAdvice2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CglibDynamicProxyTest {

    // com.sunny._03cglib_dynamic_proxy.service.impl.EmployeeServiceImpl2$$EnhancerByCGLIB$$676c99e7
    @Autowired
    private TransactionManagerAdvice2 advice2;

    @Test
    public void testSave(){
        EmployeeServiceImpl2 proxy = advice2.getProxyObject();
        //System.out.println(proxy.getClass());
        proxy.save(new Employee2());
    }

    @Test
    public void testUpdate(){
        EmployeeServiceImpl2 proxy = advice2.getProxyObject();
        proxy.update(new Employee2());
    }
}
