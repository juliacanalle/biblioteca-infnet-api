package bibliotecainfnetapi;

import bibliotecainfnetapi.controller.AdministradorController;
import bibliotecainfnetapi.controller.LivroController;
import bibliotecainfnetapi.controller.UsuarioController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliotecaInfnetApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaInfnetApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(MenuPrincipal menuPrincipal) {
        return args -> {
            menuPrincipal.exibirMenuPrincipal();
        };
    }
}

