package com.yhw8930.springboot.controller;

import com.yhw8930.springboot.entities.Bill;
import com.yhw8930.springboot.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {


    @Autowired
    BillMapper billMapper;

    @GetMapping("/bill/{bid}")
    public Bill getBill(@PathVariable Integer bid) {
        return billMapper.getBillByBid(bid);
    }

    @GetMapping("/bill")
    public Bill addBill(Bill bill) {
        billMapper.addBill(bill);
        return bill;
    }
}
