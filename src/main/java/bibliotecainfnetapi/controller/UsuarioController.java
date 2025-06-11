package bibliotecainfnetapi.controller;

import bibliotecainfnetapi.enums.FormaPagamento;
import bibliotecainfnetapi.enums.TipoUsuario;
import bibliotecainfnetapi.model.Carrinho;
import bibliotecainfnetapi.model.Livro;
import bibliotecainfnetapi.model.Usuario;
import bibliotecainfnetapi.repository.LivroRepository;
import bibliotecainfnetapi.repository.UsuarioRepository;
import bibliotecainfnetapi.service.AluguelService;
import bibliotecainfnetapi.service.LivroService;
import bibliotecainfnetapi.service.UsuarioService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final Scanner scanner;
    private final LivroService livroService;
    private final LivroRepository livroRepository;
    private final Carrinho carrinho;
    private final AluguelService aluguelService;
    private final UsuarioRepository usuarioRepository;
    private final FormaPagamentoController formaPagamentoController;

    public UsuarioController(UsuarioService usuarioService, LivroService livroService, LivroRepository livroRepository, Carrinho carrinho, AluguelService aluguelService, UsuarioRepository usuarioRepository, FormaPagamentoController formaPagamentoController) {
        this.usuarioService = usuarioService;
        this.livroRepository = livroRepository;
        this.carrinho = carrinho;
        this.aluguelService = aluguelService;
        this.formaPagamentoController = formaPagamentoController;
        this.scanner = new Scanner(System.in);
        this.livroService = livroService;
        this.usuarioRepository = usuarioRepository;
    }

    public void exibeFormularioCadastroUsuario() {

        System.out.println("Digite seu CPF para continuar:");
        String cpf = scanner.nextLine();

        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByCpf(cpf);

        Usuario usuario;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
            System.out.println("Usuário encontrado: " + usuario.getNomeCompleto());
        } else {
            System.out.println("Usuário não encontrado. Vamos fazer seu cadastro.");

            System.out.println("Digite seu nome completo:");
            String nomeCompleto = scanner.nextLine();

            System.out.println("Digite seu telefone:");
            String telefone = scanner.nextLine();

            usuario = new Usuario();
            usuario.setNomeCompleto(nomeCompleto);
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);
            usuario.setTipoUsuario(TipoUsuario.CLIENTE);

            try {
                usuarioService.cadastrarUsuario(usuario);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                return;
            }
        }
    }

    private FormaPagamento escolherFormaPagamento(int opcao) {
        return switch (opcao) {
            case 1 -> FormaPagamento.CARTAO;
            case 2 -> FormaPagamento.BOLETO;
            case 3 -> FormaPagamento.PIX;
            default -> {
                System.out.println("Opção inválida. Definindo como PIX por padrão.");
                yield FormaPagamento.PIX;
            }
        };
    }

    public void exibeFormularioFluxoAluguel() {
        exibeFormularioCadastroUsuario();

        Carrinho carrinho = new Carrinho();

        livroService.exibirListaDeLivros();

        while (true) {
            System.out.println("Digite o ID do livro para adicionar ao carrinho (ou 0 para finalizar):");
            long idLivro = scanner.nextLong();
            scanner.nextLine();

            if (idLivro == 0) break;

            Livro livro = livroRepository.findLivroById(idLivro);
            if (livro != null) {
                carrinho.adicionarLivro(livro);
                System.out.println("Livro adicionado ao carrinho.");
            } else {
                System.out.println("Livro não encontrado.");
            }
        }

        System.out.println("Informe por quantos dias deseja alugar os livros:");
        int dias = scanner.nextInt();
        scanner.nextLine();

        double valorTotal = aluguelService.calcularValorAluguel(carrinho.getLivros(), dias);

        System.out.println("Valor total do aluguel: R$ " + valorTotal);
        System.out.println("Escolha a forma de pagamento (1 - Cartão, 2 - Boleto, 3 - Pix):");
        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoPagamento) {
            case 1 -> formaPagamentoController.processarPagamentoCartao();
            case 2 -> formaPagamentoController.processarPagamentoBoleto();
            case 3 -> formaPagamentoController.processarPagamentoPix();
            default -> System.out.println("Opção inválida.");
        }

        System.out.println("Aluguel realizado com sucesso! Aproveite seus livros.");
    }

    public void exibeFormularioFluxoAssinatura() {
        exibeFormularioCadastroUsuario();

        System.out.println("Escolha um plano de assinatura:");
        System.out.println("1 - Mensal (R$ 19.90)");
        System.out.println("2 - Semestral (R$ 99.90)");
        System.out.println("3 - Anual (R$ 179.90)");

        int escolhaPlano = scanner.nextInt();
        scanner.nextLine();

        double valorPlano;
        String nomePlano;

        switch (escolhaPlano) {
            case 1:
                valorPlano = 19.90;
                nomePlano = "Mensal";
                break;
            case 2:
                valorPlano = 99.90;
                nomePlano = "Semestral";
                break;
            case 3:
                valorPlano = 179.90;
                nomePlano = "Anual";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Você escolheu o plano " + nomePlano + " no valor de R$ " + valorPlano);

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão");
        System.out.println("2 - Boleto");
        System.out.println("3 - Pix");

        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoPagamento) {
            case 1 -> formaPagamentoController.processarPagamentoCartao();
            case 2 -> formaPagamentoController.processarPagamentoBoleto();
            case 3 -> formaPagamentoController.processarPagamentoPix();
            default -> System.out.println("Opção inválida.");
        }

        System.out.println("Assinatura concluída com sucesso! Aproveite seu plano " + nomePlano + ".");
    }

}


