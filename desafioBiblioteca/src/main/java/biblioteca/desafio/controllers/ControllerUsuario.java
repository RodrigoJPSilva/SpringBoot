package biblioteca.desafio.controllers;

import biblioteca.desafio.DTO.DTOUsuarioRequest;
import biblioteca.desafio.entities.Usuario;
import biblioteca.desafio.services.ServiceUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Usuario> insert(@RequestBody DTOUsuarioRequest dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarUsuario(usuario));
    }
}
//    private final UsuarioRepository usuarioRepository;
//
//    public ControllerUsuario(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @PostMapping(value = "/cadastro")
//    public ResponseEntity<?> salvarUsuario(@Valid @RequestBody DTOUsuarioRequest usuario) {
//        Usuario usuario = new Usuario(usuario.getName(), usuario.get(), usuario.getQuantity());
//        usuarioRepository.save(usuario);
//        return ResponseEntity.ok("O usuario foi cadastrado com sucesso!");
//    }
//
//    @DeleteMapping(value = "/deletar/{id}")
//    public ResponseEntity<String> deletarPorId(@PathVariable long id) {
//        if (usuarioRepository.existsById(id)) {
//            usuarioRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso!");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> buscarId(@PathVariable long id) {
//
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if (usuario.isPresent()) {
//            return ResponseEntity.ok(usuario);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
//        }
//    }
//
//    @GetMapping("/all")
//    public List<DTOUsuarioRequest> buscarTodosId() {
//        List<Usuario> usuario = usuarioRepository.findAll();
//        List<DTOUsuarioRequest> listarUsuarios = new ArrayList<>();
//        listarUsuarios = usuario.stream().map(DTOUsuarioRequest::new).toList();
//        return listarUsuarios;
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> atualizar (@PathVariable long id, @RequestBody Usuario novoUsuario) {
//        Optional<Usuario> produtoExistente = usuarioRepository.findById(id);
//
//        if (produtoExistente.isPresent()) {
//            Usuario usuario = produtoExistente.get();
//            usuario.setQuantity(novoUsuario.getQuantity());
//            usuarioRepository.save(usuario);
//            return ResponseEntity.ok(usuario);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
