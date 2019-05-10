package com.yhw8930.springboot.mapper;


import com.yhw8930.springboot.entities.Provider;

import java.util.List;

public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);
}
