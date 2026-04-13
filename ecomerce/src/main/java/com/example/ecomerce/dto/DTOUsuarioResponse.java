package com.example.ecomerce.dto;

import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.enums.Role;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class DTOUsuarioResponse {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private List<Role> roles;

    public DTOUsuarioResponse() {}

    // Construtor que facilita a conversão Entidade -> DTO (não copiamos a senha!)
    public DTOUsuarioResponse(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.roles = entity.getRoles();
    }

}