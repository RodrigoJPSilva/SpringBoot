package biblioteca.desafio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOUsuarioRequest {
    @NotNull(message = "O id do usuário não pode estar vazio")
    private long id;
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @NotBlank(message = "O email não pode estar vazio")
    private String email;
}
