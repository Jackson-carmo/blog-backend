package br.com.jackson.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "blog")
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Length(min = 3, max = 70)
    private String nome;
    @NotEmpty
    @Length(min = 3, max = 170)
    private String titulo;
    @NotEmpty
    @Length(min = 3, max = 7000)
    private String conteudo;
}
