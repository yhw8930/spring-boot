package com.yhw8930.springboot.Entity;

import javax.persistence.*;

//使用JPA注解进行配置映射关系
@Entity //说明它是和数据表映射的类
@Table(name = "tbl_user") //指定对应映射的表名，省略默认表名就是类名
public class User {

    @Id //标识主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //标识自增长主键
    private Integer id;

    @Column(name = "user_name",length = 5) //这是和数据表对应的一个列
    private String userName;

    @Column //省略默认列名就是属性名
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
