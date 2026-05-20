package com.example.ecomerce.services;

import com.example.ecomerce.entity.Pagamento;
import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.enums.StatusDoPedido;
import com.example.ecomerce.repository.PagamentoRepository;
import com.example.ecomerce.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pagamento> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public Pagamento pagarPedido(UUID pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado! ID: " + pedidoId));
        if (pedido.getPagamento() != null) {
            throw new RuntimeException("Este pedido já encontra-se pago!");
        }
        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(Instant.now());
        pagamento.setPedido(pedido);
        pedido.setStatus(StatusDoPedido.PAGO);
        return repository.save(pagamento);
    }
}