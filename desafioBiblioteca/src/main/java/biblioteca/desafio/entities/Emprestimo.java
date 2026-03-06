package biblioteca.desafio.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Emprestimo {
    @Id
    private long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "emprestado_id")
    private Usuario usuario;
}
