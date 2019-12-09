package com.tt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tt.model.Empresa;
import com.tt.model.Informacao;

@RestController
@RequestMapping("informacao")
public class Controller {

	@PostMapping
	public Empresa informacaoSobreUsuario(@RequestBody String cpf){
		System.out.println("Controller.informacaoSobreUsuario()");
		
		List<Informacao> informacoes = new ArrayList<Informacao>();
		
		Empresa empresa = new Empresa();
		empresa.setCnpj("29.416.244/0001-08");
		empresa.setRazaoSocial("Nubank");
		empresa.setUrlDaLogo("https://raw.githubusercontent.com/JacquelinePrates/MyD/criacaoDosReciclerViews/Imagens/nubank.png");
		
		if(cpf.equals("12345678900")) {
			Informacao nome = new Informacao("Nome", "Jose");
			informacoes.add(nome);
			Informacao email = new Informacao("Email", "jose@gmail.com");
			informacoes.add(email);
			Informacao qtdFilhos = new Informacao("Cargo", "Marceneiro");
			informacoes.add(qtdFilhos);
			Informacao salario = new Informacao("Salario", "1.500R$");
			informacoes.add(salario);
			Informacao score = new Informacao("Score no serasa", "453");
			informacoes.add(score);
			Informacao conjuge = new Informacao("Cônjuge", "Maria dos Santos");
			informacoes.add(conjuge);
			empresa.setListaDeInformacoes(informacoes);
		}else if(cpf.equals("48986485842")) {
			Informacao nome = new Informacao("Nome", "Lucas");
			informacoes.add(nome);
			empresa.setListaDeInformacoes(informacoes);
		}else {
			
		}
		return empresa;
	}

}
