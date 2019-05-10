package com.yhw8930.springboot.mapper;

import com.yhw8930.springboot.entities.Bill;

public interface BillMapper {

    Bill getBillByBid(Integer bid);

    int addBill(Bill bill);
}
