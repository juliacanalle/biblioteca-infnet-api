package med.voll.bibliotecainfnetapi.model;

import jakarta.persistence.*;
import lombok.Data;
import med.voll.bibliotecainfnetapi.enums.TipoUsuario;

@Entity
@Table(name = "administradores")
@Data
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeCompleto;
    private String cpf;
    private TipoUsuario tipoUsuario;
}
