package com.owta.controller;

import com.owta.model.Bill;
import com.owta.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping(path = "/helloBill")
    public ResponseEntity<Bill> helloBill(){
        Bill bill=new Bill();
        bill.setAmount(1000.0);
        bill.setDate(LocalDateTime.now());
        bill.setReceiptNo(1);
        bill.setProduct("TEST PRODUCT");
        return billService.createBill(bill);
    }

    @GetMapping(path = "/getBill/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable("id")Integer id){
        return billService.getBill(id);
    }

    @PostMapping(path = "/createBill")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        return billService.createBill(bill);
    }

    @PutMapping(path = "/updateBill/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable("id")Integer id,@RequestBody Bill bill){
        System.out.println("RIBBIT RIBBIT");
        return billService.updateBill(id,bill);
    }

    @DeleteMapping(path = "/deleteBill/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable("id")Integer id){
        return billService.deleteBill(id);
    }

}
