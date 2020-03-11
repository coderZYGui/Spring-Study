import com.sunny.dao.EmployeeDao1;
import com.sunny.domain.Employee1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbcTest {

    @Autowired //表示将xml中创建的dao对象,注入到下面的变量中
    private EmployeeDao1 dao;

    @Test
    public void testSave(){
        Employee1 emp = new Employee1();
        emp.setName("文");
        emp.setAge(21);
        dao.save(emp);
    }

    @Test
    public void testUpdate(){
        Employee1 emp = new Employee1();
        emp.setName("西门吹风");
        emp.setAge(43);
        emp.setId(10L);
        dao.update(emp);
    }

    @Test
    public void testDelete(){
        dao.delete(11L);
    }

    @Test
    public void testGet(){
        Employee1 employee1 = dao.get(10L);
        System.out.println(employee1);
    }

    @Test
    public void testListAll(){
        List<Employee1> employee1s = dao.listAll();
        for (Employee1 employee1 : employee1s) {
            System.out.println(employee1);
        }
    }
}
