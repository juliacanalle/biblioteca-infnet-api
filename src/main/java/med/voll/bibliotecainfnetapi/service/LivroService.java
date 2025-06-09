package med.voll.bibliotecainfnetapi.service;

import med.voll.bibliotecainfnetapi.model.Livro;
import med.voll.bibliotecainfnetapi.repository.LivroRepository;

import java.util.List;

public class LivroService {

    LivroRepository livroRepository;

    public void cadastroLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public void exibirListaDeLivros() {
        livroRepository.findAll();
    }

    public void editarTituloLivro(long id, String novoTitulo) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(novoTitulo);
        livroRepository.save(livro);
    }

    public void editarAutorLivro(long id, String novoAutor) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setAutor(novoAutor);
        livroRepository.save(livro);
    }

    public void editarDescricaoLivro(long id, String novaDescricao) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setDescricao(novaDescricao);
        livroRepository.save(livro);
    }

    public void editarCategoriaLivro(long id, String novaCategoria) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setCategoria(novaCategoria);
        livroRepository.save(livro);
    }
}
