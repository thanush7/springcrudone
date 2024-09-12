package com.kgisll.sb101.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisll.sb101.entity.Person;
import com.kgisll.sb101.service.PersonService;

@RequestMapping("/person")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonController {
     
   @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> findAllProducts() {
        return service.getDetails();
    }

    // @PostMapping
    // public List<Person> addProducts(@RequestBody List<Person> products) {
    //     return service.saveProducts(products);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable int id) {
        service.deleteByid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Person> addStock(@RequestBody Person stock) {
        Person savedStock = service.saveStock(stock);
        return new ResponseEntity<>(savedStock,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person stock) {
        Person updateStock = service.update(id, stock);
        if (updateStock != null) {
            return new ResponseEntity<>(updateStock,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updateStock,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getStockById(@PathVariable int id) {
        Optional<Person> stock = service.getStockById(id);
        if (stock.isPresent()) {
            return ResponseEntity.ok(stock.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
