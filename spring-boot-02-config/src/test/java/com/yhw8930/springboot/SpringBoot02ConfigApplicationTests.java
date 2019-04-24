package com.yhw8930.springboot;

import com.yhw8930.springboot.bean.Emp;
import com.yhw8930.springboot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    Emp emp;
    @Autowired
    ApplicationContext context;

    @Test
    public void testXml() {
        EmpService empService2 = (EmpService) context.getBean("empService2");
        System.out.println(empService2);
        empService2.add();

    }

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

}

