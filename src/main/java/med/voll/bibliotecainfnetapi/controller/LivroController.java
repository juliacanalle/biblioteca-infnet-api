package med.voll.bibliotecainfnetapi.controller;

import med.voll.bibliotecainfnetapi.model.Livro;
import med.voll.bibliotecainfnetapi.service.LivroService;

import java.util.Scanner;

public class LivroController {

    LivroService livroService = new LivroService();

    Scanner scanner = new Scanner(System.in);

    public void exibeFormularioCadastroLivro () {
        System.out.println("Digite o nome do livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.println("Digite o descrição do livro: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o categoria do livro: ");
        String categoria = scanner.nextLine();

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setDescricao(descricao);
        livro.setCategoria(categoria);

        livroService.cadastroLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void exibeFormularioExclusaoLivro () {
        System.out.println("Livros cadastrados: ");
        livroService.exibirListaDeLivros();

        System.out.println("Digite o id do livro que deseja excluir: ");
        long livroParaExcluir = scanner.nextLong();
        scanner.nextLine();

        livroService.excluirLivro(livroParaExcluir);
        System.out.println("Livro excluido com sucesso!");
    }

    public void exibeFormularioEditaLivro() {
        System.out.println("Livros cadastrados: ");
        livroService.exibirListaDeLivros();

        System.out.println("Digite o id do livro que deseja editar: ");
        long livroParaEditar = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Informe qual informação sobre o livro deseja editar: ");
        String informacao = scanner.nextLine();

        switch (informacao.toLowerCase()) {
            case "titulo":
                System.out.println("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();
                livroService.editarTituloLivro(livroParaEditar, novoTitulo);
                System.out.println("Livro editado com sucesso!");
                break;
            case "autor":
                System.out.println("Digite o novo autor: ");
                String novoAutor = scanner.nextLine();
                livroService.editarAutorLivro(livroParaEditar, novoAutor);
                System.out.println("Livro editado com sucesso!");
                break;
            case "descricao":
                System.out.println("Digite a nova descricao: ");
                String novaDescricao = scanner.nextLine();
               livroService.editarDescricaoLivro(livroParaEditar, novaDescricao);
                System.out.println("Livro editado com sucesso!");
                break;
            case "categoria":
                System.out.println("Digite a nova categoria: ");
                String novaCategoria = scanner.nextLine();
                livroService.editarCategoriaLivro(livroParaEditar, novaCategoria);
                System.out.println("Livro editado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }
}
