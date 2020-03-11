import com.sunny.domain.Employee1;
import com.sunny._02_dynamic_proxy.service.EmployeeService1;
import com.sunny._02_dynamic_proxy.tx.TransactionManagerAdvice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdkDynamicProxyTest {

    // com.sun.proxy.$Proxy13
    @Autowired
    private TransactionManagerAdvice advice;

    @Test
    public void testSave(){
        // 获取到代理对象
        EmployeeService1 proxy = advice.getProxyObject();
        System.out.println(proxy.getClass());
        proxy.save(new Employee1());
    }

    @Test
    public void testUpdate(){
        // 获取到代理对象
        EmployeeService1 proxy = advice.getProxyObject();
        proxy.update(new Employee1());
    }

    @Test
    public void testDelete(){
        EmployeeService1 proxy = advice.getProxyObject();
        proxy.delete(1L);
    }

    @Test
    public void testQueryAll1(){
        EmployeeService1 proxy = advice.getProxyObject();
        proxy.queryAll(); // 没有增强该方法,作了判断过滤
    }
}
