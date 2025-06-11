package bibliotecainfnetapi.model;

import bibliotecainfnetapi.enums.FormaPagamento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Aluguel {
    private Usuario usuario;
    private List<Livro> livros;
    private int dias;
    private FormaPagamento formaPagamento;
}

