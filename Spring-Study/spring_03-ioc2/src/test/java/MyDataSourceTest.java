import com.sunny.lifecycle.MyDataSource;
import lombok.Cleanup;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDataSourceTest {
    /**
     * 在这里没有打印出销毁资源,这就是普通测试和Spring测试的区别;
     * Spring测试会正常释放资源
     * 普通的单元测试不会正常释放资源,这时就需要手动来释放资源了
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmls/mydatasource.xml");
        MyDataSource ds = ctx.getBean("ds", MyDataSource.class);
        ds.doWork();
        ds.close(); // 手动释放资源
    }

    @Test
    public void test1(){
        @Cleanup //使用第三方框架lombok中的Clearup注解来释放.
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmls/mydatasource.xml");
        MyDataSource ds = ctx.getBean("ds", MyDataSource.class);
        ds.doWork();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmls/mydatasource.xml");
        MyDataSource ds = ctx.getBean("ds", MyDataSource.class);
        ds.doWork();
        // 这种方式是将Spring线程作为JVM的子线程,当JVM关闭后,该Spring线程也会被关闭
        ctx.registerShutdownHook();
    }
}
