package com.example.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

@Getter
@Setter
@Entity
@Table(name = "pedido_item")
public class ItemDoPedido {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Produto produto;

    @EmbeddedId
    private ItemDoPedido id = new ItemDoPedido();
    private int quantity;
    private double price;
    private Integer quantidade;
    private Double preco;

    public ItemDoPedido() {}

    public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

}
