package br.com.mydata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.Usuario;
import br.com.mydata.repository.EmpresaRepository;
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
			usuarioRepository.save(new Usuario(01L, "jose@gmail.com", Criptografia.sha256("123456"),"Jose", "12345678900", true));
		};
		
	}
	
	@Bean
	CommandLineRunner criaEmpresaNoBanco (EmpresaRepository empresaRepository) {
		return args -> {
			empresaRepository.save(new Empresa("Porto Seguro", "59.414.208/0001-08", "http://localhost:8081/informacao"));
			empresaRepository.save(new Empresa("Nubank", "59.414.208/0001-08", "http://localhost:8082/informacao"));
			empresaRepository.save(new Empresa("McDonald's", "59.942.668/0001-08", "http://localhost:8083/informacao"));
			empresaRepository.save(new Empresa("Coca Cola", "29.365.763/0001-08", "http://localhost:8084/informacao"));
		};
		
	}
}
