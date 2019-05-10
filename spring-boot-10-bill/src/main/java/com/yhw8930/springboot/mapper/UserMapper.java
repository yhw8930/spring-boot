package com.yhw8930.springboot.mapper;

import com.yhw8930.springboot.entities.User;

import java.util.List;

public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);
}
