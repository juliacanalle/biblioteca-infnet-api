package med.voll.bibliotecainfnetapi.service;

import med.voll.bibliotecainfnetapi.model.Usuario;
import med.voll.bibliotecainfnetapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    UsuarioService usuarioService;

    public void validaCpfDuplicadoUsuario(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByCpf((cpf));
        if (usuario.isPresent()) {
            throw new RuntimeException("Esse CPF já está cadastrado no sistema.");
        }
    }

    public void cadastrarUsuario (Usuario usuario) {
        usuarioService.validaCpfDuplicadoUsuario(usuario.getCpf());
        usuarioRepository.save(usuario);
        System.out.println("Cadastro efetuado com sucesso!");
    }



}
