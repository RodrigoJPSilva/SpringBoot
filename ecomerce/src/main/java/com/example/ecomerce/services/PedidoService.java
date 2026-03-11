package com.example.ecomerce.services;

import com.example.ecomerce.dto.PedidoDTO;
import com.example.ecomerce.entity.Pagamento;
import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.enums.StatusDoPedido;
import com.example.ecomerce.repository.PagamentoRepository;
import com.example.ecomerce.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;


    public PedidoService(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public PedidoDTO criarPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setMomento(LocalDate.now());
        pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);

        Pagamento pagamento = new Pagamento();
        pedido.setPagamento(pagamento);
        pedidoRepository.save(pedido);
        pagamentoRepository.save(pagamento);
        return new PedidoDTO(pedido);
    }

    public void delete(UUID id) {

    }

    public Pedido insert(Pedido dto) {
        return dto;
    }


//    public Pedido insert(Pedido pedido) {
//
//        pedido.setMomento(LocalDate.now());
//
//        if (pedido.getStatus() == null) {
//            pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
//        }
//
//        return repository.save(pedido);
//    }
//
//
//    public void delete(UUID id) {
//        if (!repository.existsById(id)) {
//            throw new RuntimeException("Pedido não encontrado para o ID: " + id);
//        }
//        repository.deleteById(id);
//    }
}