package biblioteca.desafio.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOCarteiraBibliotecaRequest {
    @NotNull(message = "O id da carteira não pode estar vazio")
    private long id;
}
