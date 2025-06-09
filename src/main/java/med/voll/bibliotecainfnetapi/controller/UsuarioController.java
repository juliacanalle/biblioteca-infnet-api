package med.voll.bibliotecainfnetapi.controller;

import med.voll.bibliotecainfnetapi.enums.TipoUsuario;
import med.voll.bibliotecainfnetapi.model.Usuario;
import med.voll.bibliotecainfnetapi.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioController {

    UsuarioService usuarioService;

    Scanner scanner = new Scanner(System.in);

    public void exibeFormularioCadastroUsuario() {

        System.out.println("Digite seu nome completo:");
        String nomeCompleto = scanner.nextLine();

        System.out.println("Digite seu cpf:");
        String cpf = scanner.nextLine();

        System.out.println("Digite seu telefone:");
        String telefone = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setCpf(cpf);
        usuario.setTelefone(telefone);
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);

        try {
            usuarioService.cadastrarUsuario(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}


