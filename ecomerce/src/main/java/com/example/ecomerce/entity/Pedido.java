package com.example.ecomerce.entity;

import com.example.ecomerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate momento;
    private StatusDoPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private  Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemDoPedido> items = new HashSet<>();

    public void setItems(Set<ItemDoPedido> items) {
        this.items = items;
    }

    public Set<ItemDoPedido> getItems() {
        return items;
    }
}
