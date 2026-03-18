package biblioteca.desafio.controllers;

import biblioteca.desafio.DTO.DTOUsuarioRequest;
import biblioteca.desafio.DTO.DTOUsuarioResponse;
import biblioteca.desafio.entities.Usuario;
import biblioteca.desafio.services.ServiceUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import biblioteca.desafio.repositories.UsuarioRepository;
//import jakarta.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    private final ServiceUsuario service;

    public ControllerUsuario(ServiceUsuario service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<DTOUsuarioResponse> criarUsuario(@RequestBody DTOUsuarioRequest dtoRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(dtoRequest.getNome());
        usuario.setEmail(dtoRequest.getEmail());

        Usuario novoUsuario = service.cadastrarUsuario(usuario);

        DTOUsuarioResponse dtoResponse = new DTOUsuarioResponse(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
    }

//    @PutMapping
//    public ResponseEntity<?> alterarUsuario(@PathVariable long id, DTOUsuarioRequest dto) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//
//    }
    @GetMapping("/buscar/todos")
    public ResponseEntity<List<DTOUsuarioResponse>> mostrarTodosUsuarios() {
        List<Usuario> listaDeUsuarios = service.buscarTodosUsuarios();

        List<DTOUsuarioResponse> listaDeRespostas = new ArrayList<>();

        for (Usuario usuario : listaDeUsuarios) {
            DTOUsuarioResponse dtoResponse = new DTOUsuarioResponse(usuario);
            listaDeRespostas.add(dtoResponse);
        }
        return ResponseEntity.ok(listaDeRespostas); // Retorna status 200 (OK) com a lista pronta
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<DTOUsuarioResponse> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioPedido = service.buscarUsuarioPorId(id);

        if (usuarioPedido.isPresent()) {
            Usuario usuarioEncontrado = usuarioPedido.get();
            DTOUsuarioResponse dtoResponse = new DTOUsuarioResponse(usuarioEncontrado);
            return ResponseEntity.ok(dtoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<>
}
