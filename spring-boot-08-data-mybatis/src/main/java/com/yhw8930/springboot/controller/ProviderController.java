package com.yhw8930.springboot.controller;

import com.yhw8930.springboot.entities.Provider;
import com.yhw8930.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid")Integer pid){
        return providerMapper.getProViderByPid(pid);
    }

    @GetMapping("/provider")
    public Provider addProvider(Provider provider){
        providerMapper.addProvider(provider);
        return provider;
    }

}
