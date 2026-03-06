package biblioteca.desafio.entities;

import jakarta.persistence.*;import lombok.Getter;import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class CarteiraBiblioteca {
    @Id
    private long numeroCarteira;
    private Date dataEmissao;
    private boolean isValid;

    @OneToOne
    @MapsId
    private Usuario usuario;
}
