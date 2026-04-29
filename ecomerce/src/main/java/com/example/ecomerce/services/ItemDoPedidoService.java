package com.example.ecomerce.services;

import com.example.ecomerce.entity.ItemDoPedido;
import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Produto;
import com.example.ecomerce.repository.ItemDoPedidoRepository;
import com.example.ecomerce.repository.PedidoRepository;
import com.example.ecomerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ItemDoPedidoService {

    @Autowired
    private ItemDoPedidoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ItemDoPedido adicionarItemAoPedido(UUID pedidoId, UUID produtoId, Integer quantidade) {

        // 1. Verifica se o Pedido existe no banco
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado! ID: " + pedidoId));

        // 2. Verifica se o Produto existe no banco
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado! ID: " + produtoId));

        // 3. Instancia o Item do Pedido
        // Usamos o construtor que você criou na entidade, e pegamos o preço direto do banco (produto.getPreco())
        ItemDoPedido item = new ItemDoPedido(pedido, produto, quantidade, produto.getPreco());

        // 4. Salva o item na tabela associativa
        return repository.save(item);
    }
}