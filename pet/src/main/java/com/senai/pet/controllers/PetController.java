package com.senai.pet.controllers;


import com.senai.pet.DTO.PetDTO;
import com.senai.pet.services.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<String> savePet(@Valid @RequestBody PetDTO dto){
        petService.salvarPet(dto);
        return ResponseEntity.ok("salvo");
    }
}
