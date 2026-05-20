package com.example.ecomerce.controller;

import com.example.ecomerce.dto.request.DTOProdutoRequest;
import com.example.ecomerce.entity.Produto;
import com.example.ecomerce.services.PhotoService;
import com.example.ecomerce.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private PhotoService photoService; // <-- Injetando o serviço de foto

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Produto> insert(
            @RequestPart("dados") @Valid DTOProdutoRequest dto,
            @RequestPart(value = "photo", required = false) MultipartFile imagem) throws IOException {

        if (imagem != null && !imagem.isEmpty()) {
            String pathImagem = photoService.savePhoto(imagem);
            dto.setImgUrl(pathImagem);
        }

        Produto entity = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }
}