package com.example.ecomerce.services;

import com.example.ecomerce.entity.Categoria;
import com.example.ecomerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria insert(String nome) {
        Categoria cat = new Categoria();
        cat.setNome(nome);
        return repository.save(cat);
    }
}