package br.com.mydata.controller;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("login")
	public Usuario login(@RequestBody Usuario usuario) {
		
		Usuario usuarioDoBanco = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(Objects.nonNull(usuarioDoBanco)) {
			return usuarioDoBanco;
		}else {
			return new Usuario(-1, null, null, null, false);
		}
	}
}
