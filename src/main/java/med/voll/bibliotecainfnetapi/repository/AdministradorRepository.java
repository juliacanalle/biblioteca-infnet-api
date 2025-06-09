package med.voll.bibliotecainfnetapi.repository;

import med.voll.bibliotecainfnetapi.model.Administrador;
import med.voll.bibliotecainfnetapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    public Optional<Administrador> findAdministradorByCpf(String cpf);
}
