package com.owta.service.impl;

import com.owta.model.Bill;
import com.owta.repository.BillRepository;
import com.owta.service.BillService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public ResponseEntity<Bill> getBill(Integer id) {
        Optional<Bill> bill = billRepository.findById(id);
        return bill.isPresent()?ResponseEntity.status(200).body(bill.get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<Bill> updateBill(Integer id,Bill newBill) {
        Optional<Bill> originalBill= billRepository.findById(id);
        if(!originalBill.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        newBill.setId(originalBill.get().getId());
        return ResponseEntity.status(201).body(billRepository.save(newBill));
    }

    @Override
    public ResponseEntity<Bill> createBill(Bill bill) {
        return ResponseEntity.status(201).body(billRepository.save(bill));
    }

    @Override
    public ResponseEntity<String> deleteBill(Integer id) {
        billRepository.deleteById(id);
        return ResponseEntity.status(200).body("DELETED RECORD");
    }
}
