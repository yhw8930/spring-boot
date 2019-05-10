package com.yhw8930.springboot.service.impl;

import com.yhw8930.springboot.Entity.User;
import com.yhw8930.springboot.dao.UserRepository;
import com.yhw8930.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 事务管理：
     * 1. 在启动类上 ，使用 @EnableTransactionManagement 开启注解方式事务支持
     * 2. 在 Service层方法上添加 @Transactional 进行事务管理
     * 隔离级别与事务传播
     * @param user
     * @return boolean
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public Boolean addUser(User user) {
        userRepository.save(new User("1", "1"));
        userRepository.save(new User("12", "2"));
        userRepository.save(new User("123", "3"));
        userRepository.save(new User("1234", "4"));
        userRepository.save(new User("12345", "5"));
        //用户名长度大于5会报错，应该回滚事务的
        //userRepository.save(new User("123456","6"));
        userRepository.save(user);
        return true;
    }
}
