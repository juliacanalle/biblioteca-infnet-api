package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Administrador;
import bibliotecainfnetapi.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public void validaCpfDuplicadoAdministrador(String cpf) {
        Optional<Administrador> administrador = administradorRepository.findAdministradorByCpf(cpf);
        if (administrador.isPresent()) {
            throw new RuntimeException("Esse CPF já está cadastrado no sistema.");
        }
    }

    public void cadastrarAdm(Administrador administrador) {
        validaCpfDuplicadoAdministrador(administrador.getCpf());
        administradorRepository.save(administrador);
        System.out.println("Cadastro como administrador efetuado com sucesso!");
    }
}
