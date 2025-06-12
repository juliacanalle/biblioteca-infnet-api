package bibliotecainfnetapi.controller;

import bibliotecainfnetapi.enums.TipoUsuario;
import bibliotecainfnetapi.model.Administrador;
import bibliotecainfnetapi.service.AdministradorService;
import bibliotecainfnetapi.service.ExportadorCsvService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AdministradorController {

    Scanner scanner = new Scanner(System.in);
    AdministradorService administradorService;
    ExportadorCsvService exportadorCsvService;

    public AdministradorController(AdministradorService administradorService, ExportadorCsvService exportadorCsvService) {
        this.administradorService = administradorService;
        this.exportadorCsvService = exportadorCsvService;
    }

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

    public void menuExportacao() {
        System.out.println("Escolha a opção de exportação:");
        System.out.println("1 - Exportar livros");
        System.out.println("2 - Exportar usuários");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Você está usando qual sistema operacional? (1 - Windows | 2 - macOS)");
        int sistema = scanner.nextInt();
        scanner.nextLine();

        String nomeArquivo = (opcao == 1) ? "livros.csv" : "usuarios.csv";
        String caminhoPastaDownloads;

        if (sistema == 1) {
            caminhoPastaDownloads = System.getProperty("user.home") + "\\Downloads\\" + nomeArquivo;
        } else if (sistema == 2) {
            caminhoPastaDownloads = System.getProperty("user.home") + "/Downloads/" + nomeArquivo;
        } else {
            System.out.println("Opção inválida de sistema operacional.");
            return;
        }

        if (opcao == 1) {
            exportadorCsvService.exportarLivrosParaCsv(caminhoPastaDownloads);
        } else if (opcao == 2) {
            exportadorCsvService.exportarUsuariosParaCsv(caminhoPastaDownloads);
        } else {
            System.out.println("Opção inválida de exportação.");
        }
    }
}


