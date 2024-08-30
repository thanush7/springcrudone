package com.kgisll.sb101.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.kgisll.sb101.entity.Person;
import com.kgisll.sb101.repository.PersonRepository;

@EnableAspectJAutoProxy
@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getDetails(){
        List<Person> all=repository.findAll();
        return all;
    }

    public List<Person> saveProducts(List<Person> products){
        return repository.saveAll(products);
    }
    public String deleteByid(int id){
        repository.deleteById(id);
        return "removed";
    }

    public Person saveStock(Person stock){
        return repository.save(stock);
    }
    public Person update(int id,Person updateStock){
        Person person = repository.findById(id).orElse(null);
        if (person != null) {
            return repository.save(updateStock);
        }
      return null;
    }

    public Optional<Person> getStockById(int id) {
        return repository.findById(id);
    }    
}
