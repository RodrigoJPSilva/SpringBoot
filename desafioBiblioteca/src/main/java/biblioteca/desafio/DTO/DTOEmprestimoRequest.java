package biblioteca.desafio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DTOEmprestimoRequest {
    @NotNull(message = "O id do empréstimo não pode estar vazio")
    private long id;
    @NotNull(message = "A data do empréstimo não pode estar vazia")
    private Date dataEmprestimo;
    @NotNull(message = "A data de devolução não pode estar vazia")
    private Date dataDevolucao;
}
