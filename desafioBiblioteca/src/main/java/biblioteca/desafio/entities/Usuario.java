package biblioteca.desafio.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    private long id;
    private String nome;
    private String email;

    @OneToOne(mappedBy = "carteira", cascade = CascadeType.ALL)
    private CarteiraBiblioteca usuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;
}
