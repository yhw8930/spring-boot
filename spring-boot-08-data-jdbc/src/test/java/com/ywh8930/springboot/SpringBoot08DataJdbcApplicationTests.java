package com.ywh8930.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot08DataJdbcApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //datasource:class com.zaxxer.hikari.HikariDataSource
        System.out.println("datasource:" + dataSource.getClass());
        System.out.println(dataSource.getConnection());
        dataSource.getConnection().close();
    }

}
