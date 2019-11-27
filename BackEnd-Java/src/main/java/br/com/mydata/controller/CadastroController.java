package br.com.mydata.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Usuario;
import br.com.mydata.service.CadastroService;

@RestController
@CrossOrigin
@RequestMapping("cadastro")
public class CadastroController {

	@Autowired
	CadastroService cadastroService;

	@GetMapping("buscar/{id}")
	public Usuario buscarPerfilUsuario(@PathVariable Long id) {
		return cadastroService.buscarPerfil(id);
	}

	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario novoUsuario) {
		return cadastroService.cadastraUsuario(novoUsuario);
	}

	@PostMapping("atualizar")
	public Usuario atualizar(@RequestBody Usuario Usuario) {
		return cadastroService.atualizaUsuario(Usuario);
	}
}
