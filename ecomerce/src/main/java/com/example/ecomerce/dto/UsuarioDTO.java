package com.example.ecomerce.dto;

import com.example.ecomerce.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Role roles;
}
