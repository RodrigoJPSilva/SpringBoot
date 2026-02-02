package com.senai.pet.services;

import com.senai.pet.DTO.PetDTO;
import com.senai.pet.entities.Pet;
import com.senai.pet.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService{

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public String salvarPet(PetDTO dto) {
        Pet pet = new Pet(dto.getNome(), dto.getIdade(), dto.getPorte(), dto.getTipo(), dto.getRaca());
        petRepository.save(pet);

        return "Pet salvo com sucesso";
    }
}
