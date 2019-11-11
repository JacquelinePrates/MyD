package com.tt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tt.model.Conta;
import com.tt.model.Endereco;
import com.tt.model.InformacoesUsuario;
import com.tt.model.Investimentos;
import com.tt.model.Perfil;
import com.tt.model.Usuario;

@RestController
@RequestMapping("informacao")
public class Controller {

	@PostMapping
	public InformacoesUsuario informacaoSobreUsuario(@RequestBody String cpf){
		System.out.println("Controller.informacaoSobreUsuario()");
		
		InformacoesUsuario resposta = new InformacoesUsuario();
		
		if(cpf.equals("12345678900")) {
			Usuario usuario = new Usuario();
			usuario.setCpf("12345678900");
			usuario.setEmail("jose@gmail.com");
			usuario.setNome("Jose Dos Santos");
			resposta.setUsuario(usuario);
			
			Conta conta = new Conta();
			conta.setCreditoDisponivel("1500");
			conta.setNomeDaAgencia("Cotia");
			conta.setNumeroDaAgencia("1234");
			conta.setNumeroDaConta("12345678-9");
			conta.setSaldo("564");
			conta.setTipoDaOperacao("corrente");
			resposta.setConta(conta);
			
			Endereco endereco = new Endereco();
			endereco.setCep("08440030");
			endereco.setBairro("Jose Bonifacio");
			endereco.setCidade("São Paulo");
			endereco.setLogradouro("São Bolfim");
			endereco.setNumero("450");
			endereco.setPais("Brasil");
			endereco.setUf("SP");
			resposta.setEndereco(endereco);
			
			Investimentos investimentos = new Investimentos();
			investimentos.setTipo("Tesouro Selic");
			investimentos.setQuantia("1500");
			resposta.setInvestimentos(investimentos);
			
			Perfil perfil = new Perfil();
			perfil.setNumeroDeFilhos(1);
			perfil.setScoreSerasa(540);
			resposta.setPerfil(perfil);
			
			return resposta;
			
		}else if(cpf.equals("9875432100")) {
			return null;
			
		}else {
			return null;
		}
	}

}
