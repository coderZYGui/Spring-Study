import com.alibaba.druid.pool.DruidDataSource;
import lombok.Cleanup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PropertyPlaceholderTest {

    // @Autowired:表示从Spring IoC容器中根据类型找到对应的bean,并自动注入到某个字段上
    @Autowired
    private DruidDataSource ds;

    @Test
    public void test() throws Exception{
        /*ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("1111");
        ds.setInitialSize(2);*/

        @Cleanup
        Connection conn = ds.getConnection();
        String sql = "SELECT id, name, age FROM student";
        @Cleanup
        PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.print(rs.getLong("id")+",");
            System.out.print(rs.getString("name")+",");
            System.out.println(rs.getInt("age"));
        }
    }
}
