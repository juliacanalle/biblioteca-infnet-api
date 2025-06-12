package bibliotecainfnetapi.service;

import bibliotecainfnetapi.model.Livro;
import bibliotecainfnetapi.model.Usuario;
import bibliotecainfnetapi.repository.LivroRepository;
import bibliotecainfnetapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path path = Paths.get(caminhoArquivo);

        try (OutputStream os = Files.newOutputStream(path);
             OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            writer.write('\uFEFF');

            writer.write("ID;Título;Autor;Descrição;Categoria");
            writer.newLine();

            for (Livro livro : livros) {
                writer.write(String.format("%d;\"%s\";\"%s\";\"%s\";\"%s\"",
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getDescricao(),
                        livro.getCategoria()));
                writer.newLine();
            }

            System.out.println("Exportação de livros concluída com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar livros: " + e.getMessage());
        }
    }

    public void exportarUsuariosParaCsv(String caminhoArquivo) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        Path path = Paths.get(caminhoArquivo);

        try (OutputStream os = Files.newOutputStream(path);
             OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            writer.write('\uFEFF');

            writer.write("ID;Nome Completo;CPF;Telefone;Tipo Usuário");
            writer.newLine();

            for (Usuario usuario : usuarios) {
                writer.write(String.format("%d;\"%s\";\"%s\";\"%s\";\"%s\"",
                        usuario.getId(),
                        usuario.getNomeCompleto(),
                        usuario.getCpf(),
                        usuario.getTelefone(),
                        usuario.getTipoUsuario().name()));
                writer.newLine();
            }

            System.out.println("Exportação de usuários concluída com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar usuários: " + e.getMessage());
        }
    }
}
