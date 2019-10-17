package br.com.mydata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@SpringBootApplication
public class MyDJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDJavaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.save(new Usuario(01, "primerildo@gmail.com", "123456", "tipo"));
		};
		
	}
}
