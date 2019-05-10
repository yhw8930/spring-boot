package com.yhw8930.springboot.entities;

/**
 * 账单列表还有详情都要有供应商名称
 */
public class BillProvider extends Bill{

    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
