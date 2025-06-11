package bibliotecainfnetapi.model;


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

    @Override
    public String toString() {
        return "\n--- Livro ---" +
                "\nID: " + id +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nDescrição: " + descricao +
                "\nCategoria: " + categoria +
                "\n---------------";
    }
}
