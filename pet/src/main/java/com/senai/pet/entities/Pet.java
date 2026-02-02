package com.senai.pet.entities;

import com.senai.pet.enums.Porte;
import com.senai.pet.enums.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pet")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private int idade;
    private Porte porte;
    private Tipo tipo;
    private String raca;

    public Pet(String nome, int idade, Porte porte, Tipo tipo, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
        this.tipo = tipo;
        this.raca = raca;
    }
}
















