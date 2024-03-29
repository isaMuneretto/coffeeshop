package com.coffeeshop.repositories;

import com.coffeeshop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

//vamos implementar os métodos e herdar os métodos para operar de uma classe de banco de dados JpaRepository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

}
