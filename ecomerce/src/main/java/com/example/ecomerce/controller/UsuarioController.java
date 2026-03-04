package com.example.ecomerce.controller;


import com.example.ecomerce.entity.Pedido;
import com.example.ecomerce.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import java.net.URI;
import java.util.UUID;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Pedido> insert(@RequestBody Pedido dto) {
        dto = service.insert(dto);
        // Cria a URL com o ID do novo pedido (Boa prática REST)
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna Status 204 No Content (sucesso sem corpo na resposta)
//    public ResponseEntity<?> create(PedidoDTO dto){
//        service.create(dto);
//        return ResponseEntity.ok("Criado com sucesso !");
//    }
    }
}
