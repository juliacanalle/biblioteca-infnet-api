package med.voll.bibliotecainfnetapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.bibliotecainfnetapi.enums.TipoUsuario;

import java.time.LocalDate;

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
