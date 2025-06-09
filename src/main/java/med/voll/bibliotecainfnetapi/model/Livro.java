package med.voll.bibliotecainfnetapi.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String autor;
    private String descricao;
    private String categoria;
}
