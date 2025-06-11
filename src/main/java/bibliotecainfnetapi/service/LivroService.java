package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Livro;
import bibliotecainfnetapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public void cadastroLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public void exibirListaDeLivros() {
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no sistema.");
        } else {
            System.out.println("=== Lista de Livros Disponíveis ===");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
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
