package com.tt.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tt.model.InformaçõesRetornadasPelaEmpresaSobreUsuario;

@RestController
@RequestMapping("informacao")
public class Controller {
	
	@PostMapping
	public InformaçõesRetornadasPelaEmpresaSobreUsuario informacaoSobreUsuario(@RequestBody String cpf){
		System.out.println("Controller.informacaoSobreUsuario()");
		
		InformaçõesRetornadasPelaEmpresaSobreUsuario resposta = new InformaçõesRetornadasPelaEmpresaSobreUsuario();
		resposta.setCnpj("59.414.208/0001-08");
		resposta.setNomeDaEmpresa("Segur - Seguradora");
		HashMap<String, String> informacoes = new HashMap<>();
		
		if(cpf.contains("12345678900")) {
			informacoes.put("Nome", "Jose Almeida Santos");
			informacoes.put("Data de nascimento", "20/02/1995");
			informacoes.put("Numero de Filhos", "2");
			informacoes.put("CEP", "08440040");
		}
		
		resposta.setInformaçõesDoUsuario(informacoes);
		
		return resposta;
	}
	
}
