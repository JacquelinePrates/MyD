package br.com.mydata.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Usuario;
import br.com.mydata.repository.UsuarioRepository;

@Service
public class CadastroService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastraUsuario(Usuario usuario) {

		if (Objects.isNull(usuarioRepository.findByCpf(usuario.getCpf()))) {
			usuarioRepository.save(usuario);
		}
		return usuarioRepository.findByCpf(usuario.getCpf());
	}

	public Usuario buscarPerfil(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).get();
	}

}