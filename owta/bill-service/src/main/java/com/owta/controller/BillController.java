package com.owta.controller;

import com.owta.model.Bill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BillController {

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello! see your bills here";
    }

    @GetMapping(path = "/helloBill")
    public Bill helloBill(){
        Bill bill=new Bill();
        bill.setAmount(1000.0);
        bill.setDate(LocalDateTime.now());
        bill.setReceiptNo(1);
        bill.setProduct("TEST PRODUCT");
        return bill;
    }

}
