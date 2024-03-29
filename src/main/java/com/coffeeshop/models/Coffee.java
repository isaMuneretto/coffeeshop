package com.coffeeshop.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter //Lombok não precisa fazer com o Generate Getter e Setter
@Setter
@Entity
@Table(name="coffee")
@EqualsAndHashCode(of="id")
public class Coffee implements Serializable { //Empacota obj e desempacota manda por array tabela como obj
    @Id //o campo que vai vim abaixo é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    public Coffee(){};
}
