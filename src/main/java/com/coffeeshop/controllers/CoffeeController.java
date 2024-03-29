package com.coffeeshop.controllers;

import com.coffeeshop.models.Coffee;
import com.coffeeshop.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee") //essa é a rota que a aplicação vai aparecer
public class CoffeeController {
    @Autowired //ele não implementa os métodos mas sabe que CoffeeRepository é um obj
    CoffeeRepository coffeeRepository; //cria obj
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE) //essa rota recebe json e retorna uma lista de obj
    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll(); //onde tem os métodos para trabalhar com o banco
    }

    //método para salvar
    @PostMapping(value = "/createCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) //envia json (produces) e volta json(consumes)
    public Coffee createNewCoffee(@RequestBody Coffee coffee){ //volta do banco como obj pelo corpo do json
        Coffee createCoffee = new Coffee();
        createCoffee.setName(coffee.getName());
        createCoffee.setPrice(coffee.getPrice());

        return coffeeRepository.save(createCoffee);
    }
    //método para atualizar
    @PutMapping(value = "updatedCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updatedCoffee(@RequestBody Coffee coffee){
        Coffee getCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();

        Coffee updatedCoffee = new Coffee();
        updatedCoffee.setId(coffee.getId()); //tem que enviar o id para atualizar, sem o id é o mesmo que o post
        updatedCoffee.setName(coffee.getName());
        updatedCoffee.setPrice(coffee.getPrice());

        return coffeeRepository.save(updatedCoffee);
    }
    //deletar
    @DeleteMapping(value = "/deleteCoffee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee deleteCoffee(@PathVariable Long id){
        Coffee getCoffee = coffeeRepository.findById(id).orElseThrow();
        coffeeRepository.delete(getCoffee);
        return getCoffee;
    }
}