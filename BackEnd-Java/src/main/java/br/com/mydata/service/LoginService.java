package br.com.mydata.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario login(br.com.mydata.model.Usuario usuario) {
		Usuario usuarioDoBanco = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(Objects.nonNull(usuarioDoBanco)) {
			return usuarioDoBanco;
		}else {
			return new Usuario(-1L, "", "", "", false);
		}
	}
}
