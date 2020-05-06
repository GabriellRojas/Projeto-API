package rojas.gabriel.projetoapi.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@ToString

@Entity
@Table(name="jogo")

public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jogo")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "genero")
    private String genero;

    @Column(name = "data_lancamento")
    private String data_lancamento;
}
