package br.com.mydata.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@Service
public class CadastroService {
	
	@Autowired
	UsuarioRepository repository;
	
	public Usuario cadastraUsuario(Usuario usuario) {
		
		if(Objects.isNull(repository.findByCpf(usuario.getCpf()))) {
		repository.save(usuario);
		}
		return repository.findByCpf(usuario.getCpf());
	}

}
