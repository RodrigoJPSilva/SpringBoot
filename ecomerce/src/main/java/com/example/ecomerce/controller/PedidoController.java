package com.example.ecomerce.controller;

import com.example.ecomerce.dto.DTOPedidoRequest;
import com.example.ecomerce.dto.DTOPedidoResponse;
import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.enums.StatusDoPedido;
import com.example.ecomerce.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<DTOPedidoResponse> insert(@Valid @RequestBody DTOPedidoRequest dto) {

        Pedido obj = service.insert(dto.getClienteId());

        DTOPedidoResponse responseDto = new DTOPedidoResponse(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<DTOPedidoResponse>> encontrarTodos() {
        List<Pedido> list = service.findAll();
        List<DTOPedidoResponse> listDto = list.stream()
                .map(DTOPedidoResponse::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DTOPedidoResponse> encontrarPorId(@PathVariable UUID id) {
        Optional<Pedido> obj = service.findById(id);

        return obj.isPresent()
                ? ResponseEntity.ok(new DTOPedidoResponse(obj.get()))
                : ResponseEntity.notFound().build();
    }

    // Endpoint específico para atualizar apenas o status (Ex: PUT /pedidos/{id}/status)
    @PutMapping(value = "/{id}/status")
    public ResponseEntity<DTOPedidoResponse> atualizarStatus(@PathVariable UUID id, @RequestBody StatusDoPedido status) {
        Optional<Pedido> pedidoAtualizado = service.atualizarStatus(id, status);

        return pedidoAtualizado.isPresent()
                ? ResponseEntity.ok(new DTOPedidoResponse(pedidoAtualizado.get()))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        boolean deletado = service.deleteById(id);

        return deletado
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}