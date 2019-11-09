package br.com.mydata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@Service
public class CadastroService {
	
	@Autowired
	UsuarioRepository repository;
	
	public Usuario cadastraUsuario(Usuario usuario) {
		repository.save(usuario);
		return repository.getOne(usuario.getId());
	}

}
