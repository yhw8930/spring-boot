package com.yhw8930.springboot.mapper;

import com.yhw8930.springboot.entities.Bill;
import com.yhw8930.springboot.entities.BillProvider;

import java.util.List;

public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deleteBillByBid(Integer bid);
}
