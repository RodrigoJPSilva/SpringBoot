package com.example.ecomerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_item_pedido")
public class ItemDoPedido {

    // A chave composta sendo incorporada aqui
    @EmbeddedId
    @EqualsAndHashCode.Include
    private ItemDoPedidoPK id = new ItemDoPedidoPK();

    private Integer quantidade;
    private Double preco;

    // Construtor prático para facilitar a criação do item no Service
    public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // --- MÉTODOS AUXILIARES ---

    @JsonIgnore // Essencial para evitar o loop infinito ao serializar o Pedido em JSON
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Double getSubTotal() {
        return preco * quantidade;
    }
}