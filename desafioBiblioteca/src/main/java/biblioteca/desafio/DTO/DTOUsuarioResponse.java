package biblioteca.desafio.DTO;

import biblioteca.desafio.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOUsuarioResponse {
    private long id;
    private String nome;
    private String email;

    public DTOUsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
