package jnerisdev.com.agenda.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "sobrenome")
    private String sobrenome;

    @Column (name = "email")
    private String email;

    @Column (name = "cpf")
    private String cpf;

}
