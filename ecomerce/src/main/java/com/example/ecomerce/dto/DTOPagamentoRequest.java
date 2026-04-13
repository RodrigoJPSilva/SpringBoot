package com.example.ecomerce.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class DTOPagamentoRequest {

    @NotNull(message = "O ID do pedido é obrigatório")
    private UUID pedidoId;

    public UUID getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
    }
}