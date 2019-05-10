package com.yhw8930.springboot;

import com.yhw8930.springboot.entities.Bill;
import com.yhw8930.springboot.entities.BillProvider;
import com.yhw8930.springboot.entities.Provider;
import com.yhw8930.springboot.entities.User;
import com.yhw8930.springboot.mapper.BillMapper;
import com.yhw8930.springboot.mapper.ProviderMapper;
import com.yhw8930.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Test
    public void contextLoads() {
        Provider provider = new Provider();
        provider.setProviderName("A货");
        List<Provider> providers = providerMapper.getProviders(provider);
        System.out.println(providers.get(0));

        Provider providerByPid = providerMapper.getProviderByPid(2);
        System.out.println(providerByPid);

        providerByPid.setProviderName("B货域名供应商....");
        int size = providerMapper.updateProvider(providerByPid);
        System.out.println(size);
        //providerMapper.addProvider(new Provider(2001, "PR-AA", "梦学谷供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));
        //providerMapper.deleteProviderByPid(9);
        //providerMapper.deleteProviderByPid(10);
    }

    @Autowired
    BillMapper billMapper;
    @Test
    public void testBill() {
        Bill b = new Bill();
        b.setBillName("com");
        List<BillProvider> bills = billMapper.getBills(b);
        System.out.println(bills.get(0));

        BillProvider billProvider = billMapper.getBillByBid(4);
        System.out.println(billProvider);

        Bill bill = (Bill) billProvider;
        bill.setBillName("cn域名...");
        billMapper.updateBill(bill);

        //billMapper.addBill(new Bill(
        // 3001, "Bi-AA11", "粮油aaa", "斤", 80,480.8, new Provider(null, "PR-BB", "梦学谷供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 1));
        billMapper.deleteBillByBid(6);
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUser() {
        User u = new User();
        // u.setUsername("zhang");
        List<User> users = userMapper.getUsers(u);
        System.out.println(users.get(0));
        User user = userMapper.getUserById(1);
        System.out.println(user);
        user.setUsername("admin");
        int size = userMapper.updateUser(user);
        System.out.println(size);
        billMapper.deleteBillByBid(4);
    }
}

