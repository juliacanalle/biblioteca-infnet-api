package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    public double calcularValorAluguel(List<Livro> livros, int dias) {
        double precoPorLivroPorDia = 2.50;
        return livros.size() * dias * precoPorLivroPorDia;
    }
}
