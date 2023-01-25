package com.tienda.mayorista.web.controller;

import com.tienda.mayorista.domain.Bill;
import com.tienda.mayorista.domain.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAll() {
       return new ResponseEntity<>(billService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Bill>> getByClient(@PathVariable("clientId") int clientId) {
        return billService.getByClient(clientId)
                .map(bills -> new ResponseEntity<>(bills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Bill>> getByVendor(@PathVariable("vendorId") int vendorId) {
        return billService.getByVendor(vendorId)
                .map(bills -> new ResponseEntity<>(bills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/billnumber/{billNumber}")
    public ResponseEntity<List<Bill>> getByBillNumber(@PathVariable("billNumber") int billNumber) {
        return billService.getByBillNumber(billNumber)
                .map(bills -> new ResponseEntity<>(bills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBill(@PathVariable("id") int billId) {
        return billService.getBill(billId)
                .map(bill -> new ResponseEntity<>(bill, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Bill> save(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.save(bill), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int billId) {
        if (billService.delete(billId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
