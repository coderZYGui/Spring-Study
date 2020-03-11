package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//当前项目的配置类,好比是applicationContext.xml
@Configuration					//标识当前类为一个配置类
@Import(DataSourceConfig.class)	//包含其他的配置类
@ComponentScan("com.sunny")                //IoC注解解析器
@EnableTransactionManagement//事务注解解析器
public class JavaConfig {
    //创建事务管理的Bean
    @Bean
    public DataSourceTransactionManager txManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
