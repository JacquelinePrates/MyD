package br.com.mydata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;
import br.com.mydata.utilities.Criptografia;

@SpringBootApplication
public class MyDJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDJavaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner (UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.save(new Usuario(01L, "primerildo@gmail.com", Criptografia.sha256("123456"), "48986485824", true));
		};
		
	}
}
