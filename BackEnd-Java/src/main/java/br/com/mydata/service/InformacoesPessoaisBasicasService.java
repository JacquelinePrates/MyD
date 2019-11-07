package br.com.mydata.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mydata.model.InformacoesPessoaisBasicas;
import br.com.mydata.repository.InformacoesPessoaisBasicasRepository;

public class InformacoesPessoaisBasicasService {
	
	@Autowired
	private InformacoesPessoaisBasicas informacoesPessoaisBasicas;
	private InformacoesPessoaisBasicasRepository informacoesPessoaisBasicasRepository;
	
	public InformacoesPessoaisBasicas buscarInformacoesPessoaisBasicasPorUsuario() {
		
		
		return null;
	}

}
