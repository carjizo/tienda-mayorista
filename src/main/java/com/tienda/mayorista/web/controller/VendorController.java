package com.tienda.mayorista.web.controller;

import com.tienda.mayorista.domain.Vendor;
import com.tienda.mayorista.domain.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/all")
    public ResponseEntity<List<Vendor>> getAll(){
        return new ResponseEntity<>(vendorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendor(@PathVariable("id") int vendorId){
        return vendorService.getVendor(vendorId)
                .map(vendor -> new ResponseEntity<>(vendor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ruc/{ruc}")
    public ResponseEntity<Vendor> getByRuc(@PathVariable("ruc") String ruc){
        return vendorService.getByRuc(ruc)
                .map(vendor -> new ResponseEntity<>(vendor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Vendor> save(@RequestBody Vendor vendor){
        return new ResponseEntity<>(vendorService.save(vendor), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int vendorId){
        if (vendorService.delete(vendorId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
