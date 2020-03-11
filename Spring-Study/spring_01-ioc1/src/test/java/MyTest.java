import com.sunny._01_static_proxy.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        /*// 用户实际调用的是业务层,dao层不需要接触
        // UserServiceImpl userService = new UserServiceImpl();

        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoOracleImpl());

        userService.getUser();*/

        // 创建Spring IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl serviceImpl = (UserServiceImpl) context.getBean("serviceImpl");
        serviceImpl.getUser();
    }
}
