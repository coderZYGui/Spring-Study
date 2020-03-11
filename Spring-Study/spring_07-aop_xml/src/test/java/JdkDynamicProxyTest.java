import com.sunny.domain.Employee1;
import com.sunny._02_dynamic_proxy.service.EmployeeService1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdkDynamicProxyTest {

    // com.sun.proxy.$Proxy14
    @Autowired
    private EmployeeService1 service1;

    @Test
    public void testSave(){
        System.out.println(service1.getClass());
        service1.save(new Employee1());
    }

    @Test
    public void testUpdate(){
        service1.update(new Employee1());

    }
}
