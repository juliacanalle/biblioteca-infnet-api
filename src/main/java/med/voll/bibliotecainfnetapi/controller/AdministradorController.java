package med.voll.bibliotecainfnetapi.controller;

import med.voll.bibliotecainfnetapi.enums.TipoUsuario;
import med.voll.bibliotecainfnetapi.model.Administrador;
import med.voll.bibliotecainfnetapi.model.Usuario;
import med.voll.bibliotecainfnetapi.service.AdministradorService;

import java.util.Scanner;

public class AdministradorController {

    Scanner scanner = new Scanner(System.in);
    AdministradorService administradorService;

    public void exibeFormularioCadastroAdm() {

        System.out.println("Digite seu nome completo:");
        String nomeCompleto = scanner.nextLine();

        System.out.println("Digite seu cpf:");
        String cpf = scanner.nextLine();

        Administrador administrador = new Administrador();
        administrador.setNomeCompleto(nomeCompleto);
        administrador.setCpf(cpf);
        administrador.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

        try {
            administradorService.cadastrarAdm(administrador);
            System.out.println("Administrador cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar administrador: " + e.getMessage());
        }
    }
}


