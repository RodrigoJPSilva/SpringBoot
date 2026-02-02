package com.senai.pet.DTO;


import com.senai.pet.entities.Pet;
import com.senai.pet.enums.Porte;
import com.senai.pet.enums.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    @NotNull(message = "id vazio")
    private long id;
    private String nome;
    private int idade;
    @NotNull(message = "Precisa colocar um porte")
    private Porte porte;
    @NotNull(message = "Precisa colocar um tipo")
    private Tipo tipo;
    private String raca;

    public PetDTO(Pet pet) {
        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
        this.tipo = tipo;
        this.raca = raca;
    }

}
