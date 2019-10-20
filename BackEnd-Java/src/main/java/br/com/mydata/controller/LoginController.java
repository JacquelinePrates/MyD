package br.com.mydata.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Usuario;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@PostMapping("autenticacao")
	public Boolean login(@RequestBody Usuario usuario) {
		return null;
	}
}
