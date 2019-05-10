package com.yhw8930.springboot;

import com.yhw8930.springboot.entities.User;
import com.yhw8930.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot13CacheApplicationTests {
    //操作的复杂类型，如User
    @Autowired
    RedisTemplate redisTemplate;
    //针对的都是操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate jsonRedisTemplate;
    @Autowired
    UserService userService;
    /**
     * 五大数据类型
     * stringRedisTemplate.opsForValue();//操作字符串
     * stringRedisTemplate.opsForList();//操作List
     * stringRedisTemplate.opsForSet();//操作Set
     * stringRedisTemplate.opsForZSet();//操作ZSet
     * stringRedisTemplate.opsForHash();//操作Hash
     */
    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("name","mengxuegu");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);

        //stringRedisTemplate.opsForList().leftPush("mylist","a");
        //stringRedisTemplate.opsForList().leftPushAll("mylist","b","c","d");
        List<String> mylist = stringRedisTemplate.opsForList().range("mylist", 0, -1);
        System.out.println(mylist);
    }

    @Test
    public void testRedis(){
        User user = userService.getUserById(3);
        System.out.println(user);
        //保存的数据对象必须序列化 implements Serializable
        //因为redisTemplate默认采用的是jdk序列化器
        //redisTemplate.opsForValue().set("user",user);
        //User user1 = (User) redisTemplate.opsForValue().get("user");
        jsonRedisTemplate.opsForValue().set("user",user);
        //System.out.println(user1);
    }

}
