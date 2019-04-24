package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 供应商控制层
 */

@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;
    //查询所有供应商并响应列表页面
    @GetMapping("/providers")
    public String list(@RequestParam(value = "providerName", required = false) String providerName,
                       Map<String,Object> map){
        logger.info("供应商列表查询..." + providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers",providers);
        map.put("providerName",providerName);
        return "provider/list";
    }

    /**
     *type = null,则进入view.html,查看供应商详情
     * type = update,则进入update.html，更新供应商信息
     * @param pid
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/providers/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        //return "provider/view";
        //type = null,则进入view.html; type = update,则进入update.html
        return "provider/"+type;
    }

    //修改供应商信息
    @PutMapping("/providers")
    public String update(Provider provider){
        logger.info("修改供应商信息：" + provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //添加供应商信息
    @GetMapping("/addProvider")
    public String addProvider(){
        return "provider/add";
    }

    //处理添加供应商请求
    @PostMapping("/providers")
    public String addProvider(Provider provider) {
        //SpringMVC会自动将请求参数与形参对象的属性一一绑定
        //要求：请求参数名要与形参对象的属性名相同
        logger.info("添加供应商信息：" + provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //删除操作
    @DeleteMapping("/providers/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除供应商：" + pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
