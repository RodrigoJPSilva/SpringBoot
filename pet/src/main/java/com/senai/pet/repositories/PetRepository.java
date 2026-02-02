package com.senai.pet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.pet.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
