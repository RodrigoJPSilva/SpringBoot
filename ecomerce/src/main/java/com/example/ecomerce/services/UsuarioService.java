package com.example.ecomerce.services;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.repository.PedidoRepository;
import com.example.ecomerce.repository.UsuarioRepository;

import java.util.UUID;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = UsuarioService.this.usuarioRepository;
        return (Usuario) usuarioRepository;
    }

    public String salvarUsuario(Usuario dto) {
        Pet pet = new Pet(dto.getNome(), dto.getIdade(), dto.getPorte(), dto.getTipo(), dto.getRaca());
        usuarioRepository.save(pet);

        return "Pet salvo com sucesso";
    }

    public void delete(UUID id) {
    }

    public Pedido insert(Pedido dto) {
    }
}
