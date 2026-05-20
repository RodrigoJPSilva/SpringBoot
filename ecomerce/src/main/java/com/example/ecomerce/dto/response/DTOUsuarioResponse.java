package com.example.ecomerce.dto.response;

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
    private String photo;
    private List<Role> roles;

    // Construtor vazio (boa prática para evitar erros com o Jackson/Spring)
    public DTOUsuarioResponse() {}

    // Construtor recebendo APENAS a entidade (resolve o erro no Controller)
    public DTOUsuarioResponse(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.roles = entity.getRoles();
        this.photo = entity.getPhoto(); // <-- Pegamos a foto direto da Entidade!
    }

}