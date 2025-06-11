package bibliotecainfnetapi.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Carrinho {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void exibirLivros() {
        livros.forEach(System.out::println);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void limpar() {
        livros.clear();
    }
}
