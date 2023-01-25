package com.tienda.mayorista.web.controller;

import com.tienda.mayorista.domain.RegisterStock;
import com.tienda.mayorista.domain.service.RegisterSotckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class RegisterStockController {

    @Autowired
    private RegisterSotckService registerSotckService;

    @GetMapping("/all")
    public ResponseEntity<List<RegisterStock>> getAll(){
        return new ResponseEntity<>(registerSotckService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterStock> getRegister(@PathVariable("id") int registerStockId){
        return registerSotckService.getRegisterStock(registerStockId)
                .map(registerStock -> new ResponseEntity<>(registerStock, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/product/{productId}")
    public ResponseEntity<List<RegisterStock>> getByProduct(@PathVariable("productId") int productId){
        return registerSotckService.getByProduct(productId)
                .map(registerStocks -> new ResponseEntity<>(registerStocks, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<RegisterStock> save(@RequestBody RegisterStock registerStock){
        return new ResponseEntity<>(registerSotckService.save(registerStock), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int registerStockId){
        if (registerSotckService.delete(registerStockId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
