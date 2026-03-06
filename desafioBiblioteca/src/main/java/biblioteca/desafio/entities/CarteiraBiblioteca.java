package biblioteca.desafio.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CarteiraBiblioteca {
    @Id
    private long numeroCarteira;
    private Date dataEmissao;
    private boolean isValid;

    @OneToOne
    @MapsId
    private Usuario carteira;
}
