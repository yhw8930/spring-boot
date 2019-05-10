package com.yhw8930.springboot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步处理批量操作
 */
@Service
public class AsyncService {

    @Async
    public void batchAdd(){
        try {
            Thread.sleep(3*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("批量新增数据完成");
    }
}
