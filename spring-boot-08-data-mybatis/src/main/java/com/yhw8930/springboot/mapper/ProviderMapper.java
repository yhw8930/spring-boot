package com.yhw8930.springboot.mapper;

import com.yhw8930.springboot.entities.Provider;
import org.apache.ibatis.annotations.*;

/**
 * 使用Mybatis注解版本
 */
//@Mapper //指定这是操作数据的Mapper
public interface ProviderMapper {

    @Select("select * from provider where pid=#{pid}")
    Provider getProViderByPid(Integer pid);

    //useGeneratedKeys是否使用自增主键，keyProperty指定实体类中的哪一个属性封装主键值
    @Options(useGeneratedKeys = true,keyProperty = "pid")
    @Insert("insert into provider(providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider where pid=#{pid}")
    int deleteProviderByPid(Integer pid);

    @Update("update provider set providerName=#{providerName} where pid=#{pid}")
    int updateProvider(Provider provider);

}
