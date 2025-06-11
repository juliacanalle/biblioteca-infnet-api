package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Usuario;
import bibliotecainfnetapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validaCpfDuplicadoUsuario(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByCpf(cpf);
        if (usuario.isPresent()) {
            throw new RuntimeException("Esse CPF já está cadastrado no sistema.");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        validaCpfDuplicadoUsuario(usuario.getCpf());
        usuarioRepository.save(usuario);
        System.out.println("Cadastro efetuado com sucesso!");
    }
}
