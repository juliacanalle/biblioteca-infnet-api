package bibliotecainfnetapi.repository;

import bibliotecainfnetapi.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    public Optional<Administrador> findAdministradorByCpf(String cpf);
}
