package com.owta.service;

import com.owta.model.Bill;
import org.springframework.http.ResponseEntity;

public interface BillService {
    ResponseEntity<Bill> getBill(Integer id);

    ResponseEntity<Bill> updateBill(Integer id,Bill bill);

    ResponseEntity<Bill> createBill(Bill bill);

    ResponseEntity<String> deleteBill(Integer id);
}
