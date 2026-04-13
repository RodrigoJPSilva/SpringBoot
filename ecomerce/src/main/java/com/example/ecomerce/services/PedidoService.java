package com.example.ecomerce.services;

import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.entity.Usuario;
import com.example.ecomerce.enums.StatusDoPedido;
import com.example.ecomerce.repository.PedidoRepository;
import com.example.ecomerce.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Optional<Pedido> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public Pedido insert(UUID clienteId) {
        // Busca o cliente pelo ID
        Usuario cliente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado! ID: " + clienteId));

        Pedido pedido = new Pedido();
        pedido.setMomento(Instant.now()); // Usa a data atual
        pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO); // Status inicial
        pedido.setCliente(cliente);

        return repository.save(pedido);
    }

    @Transactional
    public Optional<Pedido> atualizarStatus(UUID id, StatusDoPedido novoStatus) {
        Optional<Pedido> pedidoExistente = repository.findById(id);

        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setStatus(novoStatus);
            return Optional.of(repository.save(pedido));
        }
        return Optional.empty();
    }

    public boolean deleteById(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}