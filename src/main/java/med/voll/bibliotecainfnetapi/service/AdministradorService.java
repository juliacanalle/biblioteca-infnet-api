package med.voll.bibliotecainfnetapi.service;

import med.voll.bibliotecainfnetapi.controller.AdministradorController;
import med.voll.bibliotecainfnetapi.model.Administrador;
import med.voll.bibliotecainfnetapi.model.Usuario;
import med.voll.bibliotecainfnetapi.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    AdministradorRepository administradorRepository;
    AdministradorService administradorService;

    public void validaCpfDuplicadoAdministrador(String cpf) {
        Optional <Administrador> administrador = administradorRepository.findAdministradorByCpf((cpf));
        if (administrador.isPresent()) {
            throw new RuntimeException("Esse CPF já está cadastrado no sistema.");
        }
    }

    public void cadastrarAdm (Administrador administrador) {
        administradorService.validaCpfDuplicadoAdministrador(administrador.getCpf());
        administradorRepository.save(administrador);
        System.out.println("Cadastro como administrador efetuado com sucesso!");
    }
}
