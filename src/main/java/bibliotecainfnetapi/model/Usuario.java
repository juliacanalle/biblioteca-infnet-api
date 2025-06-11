package bibliotecainfnetapi.model;

import jakarta.persistence.*;
import lombok.Data;
import bibliotecainfnetapi.enums.TipoUsuario;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private TipoUsuario tipoUsuario;
}
