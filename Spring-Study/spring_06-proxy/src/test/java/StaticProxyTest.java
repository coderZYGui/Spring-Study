import com.sunny._01_static_proxy.domain.Employee;
import com.sunny._01_static_proxy.proxy.EmployeeServiceProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StaticProxyTest {

    // class com.sunny._01_static_proxy.proxy.EmployeeServiceProxy
    @Autowired // 注入代理对象
    private EmployeeServiceProxy service;

    @Test
    public void testSave(){
        System.out.println(service.getClass());
        service.save(new Employee());
    }

    @Test
    public void testUpdate1(){
        service.update(new Employee());
    }
}
