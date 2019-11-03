package br.com.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Usuario;
import br.com.mydata.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping
	public Usuario login(@RequestBody Usuario usuario) {
		return service.login(usuario);
	}
}
