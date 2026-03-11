package biblioteca.desafio.services;

import biblioteca.desafio.entities.CarteiraBiblioteca;
import biblioteca.desafio.entities.Usuario;
import biblioteca.desafio.repositories.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@Service
public class ServiceUsuario {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario cadastrarUsuario(Usuario novoUsuario) {
        // PASSO 1: Criar (instanciar) uma nova CarteiraBiblioteca
        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
        // PASSO 2: Preencher a data de emissão com a data de hoje e marcar isValid como true
        carteira.setDataEmissao(new Date());
        carteira.setValid(true);
        // PASSO 3: Fazer a ligação! Colocar o 'novoUsuario' dentro da carteira,
        // e colocar a carteira dentro do 'novoUsuario'
        carteira.setUsuario(novoUsuario);
        novoUsuario.setCarteira(carteira);

        // PASSO 4: Salvar o usuário usando o repository e retornar o resultado
        usuarioRepository.save(novoUsuario);

        return null; // Mude isso para retornar o usuário salvo!
    }
//    public Usuario deletarUsuario (Usuario usuario) {
//
//    }
}
