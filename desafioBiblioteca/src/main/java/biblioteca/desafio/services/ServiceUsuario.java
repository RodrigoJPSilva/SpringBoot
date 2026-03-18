package biblioteca.desafio.services;

import biblioteca.desafio.entities.Usuario;
import biblioteca.desafio.repositories.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class ServiceUsuario {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario cadastrarUsuario(Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo;
    }
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> buscarUsuarioPorId(long id) {
        return usuarioRepository.findById(id);
    }
    
//        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
//        carteira.setDataEmissao(new Date());
//        carteira.setValid(true);
//        carteira.setUsuario(novoUsuario);
//        novoUsuario.setCarteira(carteira);
//
//        // PASSO 4: Salvar o usuário usando o repository e retornar o resultado
//        usuarioRepository.save(novoUsuario);
//
//        return null; // Mude isso para retornar o usuário salvo!
//    public Usuario deletarUsuario (Usuario usuario) {
//
//    }
}
