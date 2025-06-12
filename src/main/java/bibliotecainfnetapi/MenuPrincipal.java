package bibliotecainfnetapi;

import bibliotecainfnetapi.controller.AdministradorController;
import bibliotecainfnetapi.controller.FormaPagamentoController;
import bibliotecainfnetapi.controller.LivroController;
import bibliotecainfnetapi.controller.UsuarioController;
import bibliotecainfnetapi.service.*;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuPrincipal {

    private final UsuarioController usuarioController;
    private final AdministradorController administradorController;
    private final Scanner scanner;
    private final LivroController livroController;


    public MenuPrincipal(UsuarioController usuarioController, AdministradorController administradorController, LivroController livroController, LivroService livroService, ExportadorCsvService exportadorCsvService, UsuarioService usuarioService, AdministradorService administradorService, FormaPagamentoController formaPagamentoController, AluguelService aluguelService) {
        this.usuarioController = usuarioController;
        this.administradorController = administradorController;
        this.scanner = new Scanner(System.in);
        this.livroController = livroController;
    }

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("#1 - Usuário");
            System.out.println("#2 - Administrador");
            System.out.println("#0 - Encerrar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> exibirMenuUsuario();
                case 2 -> exibirMenuAdministrador();
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenuUsuario() {
        System.out.println("\n===== MENU USUÁRIO =====");
        System.out.println("#1 - Aluguel");
        System.out.println("#2 - Assinatura");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> usuarioController.exibeFormularioFluxoAluguel();
            case 2 -> usuarioController.exibeFormularioFluxoAssinatura();
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void exibirMenuAdministrador() {
        while (true) {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("#1 - Cadastro de administrador");
            System.out.println("#2 - Cadastrar livro");
            System.out.println("#3 - Editar registro de livro");
            System.out.println("#4 - Remover livro do catálogo");
            System.out.println("#5 - Exportar arquivos CSV");
            System.out.println("#0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> administradorController.exibeFormularioCadastroAdm();
                case 2 -> livroController.exibeFormularioCadastroLivro();
                case 3 -> livroController.exibeFormularioEditaLivro();
                case 4 -> livroController.exibeFormularioExclusaoLivro();
                case 5 -> administradorController.menuExportacao();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

