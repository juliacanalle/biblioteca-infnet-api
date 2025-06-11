package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Livro;
import bibliotecainfnetapi.model.Usuario;
import bibliotecainfnetapi.repository.LivroRepository;
import bibliotecainfnetapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class ExportadorCsvService {

    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public ExportadorCsvService(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void exportarLivrosParaCsv(String caminhoArquivo) {
        List<Livro> livros = livroRepository.findAll();
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.append("ID,Título,Autor,Descrição,Categoria\n");
            for (Livro livro : livros) {
                writer.append(String.format("%d,\"%s\",\"%s\",\"%s\",\"%s\"\n",
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getDescricao(),
                        livro.getCategoria()));
            }
            System.out.println("Exportação de livros concluída com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar livros: " + e.getMessage());
        }
    }

    public void exportarUsuariosParaCsv(String caminhoArquivo) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.append("ID,Nome Completo,CPF,Telefone,Tipo Usuário\n");
            for (Usuario usuario : usuarios) {
                writer.append(String.format("%d,\"%s\",\"%s\",\"%s\",\"%s\"\n",
                        usuario.getId(),
                        usuario.getNomeCompleto(),
                        usuario.getCpf(),
                        usuario.getTelefone(),
                        usuario.getTipoUsuario().name()));
            }
            System.out.println("Exportação de usuários concluída com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar usuários: " + e.getMessage());
        }
    }
}
