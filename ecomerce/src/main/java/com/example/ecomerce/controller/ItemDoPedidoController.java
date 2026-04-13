package com.example.ecomerce.controller;

import com.example.ecomerce.dto.DTOItemDoPedidoRequest;
import com.example.ecomerce.dto.DTOItemDoPedidoResponse;
import com.example.ecomerce.entity.ItemDoPedido;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class ItemDoPedidoController {

    @Autowired
    private ItemDoPedidoService service;

    @PostMapping("/{pedidoId}/itens")
    public ResponseEntity<DTOItemDoPedidoResponse> adicionarItem(
            @PathVariable UUID pedidoId,
            @Valid @RequestBody DTOItemDoPedidoRequest dto) {

        // Chama o service que criamos para processar a regra de negócio
        ItemDoPedido obj = service.adicionarItemAoPedido(
                pedidoId,
                dto.getProdutoId(),
                dto.getQuantidade()
        );

        // Converte a entidade salva para o DTO de resposta
        DTOItemDoPedidoResponse responseDto = new DTOItemDoPedidoResponse();

        // Retorna o status 201 (Created) e o corpo com os dados do item
        return ResponseEntity.status(201).body(responseDto);
    }
}