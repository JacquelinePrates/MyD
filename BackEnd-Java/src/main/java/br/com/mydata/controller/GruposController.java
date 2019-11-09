package br.com.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mydata.model.InformacoesUsuario;

public class GruposController {
	
	@Autowired
	private GruposService service;

	@GetMapping
	public InformacoesUsuario buscarInformacoesDoUsuarioPorEmpresa(@PathVariable Long idEmpresa, @PathVariable Long idUsuario) {
		return service.buscarInformacoesDoUsuarioPorEmpresa(idEmpresa, idUsuario);
	}
	
	@PostMapping
	public InformacoesUsuario solicitarAlteracaoDado(@PathVariable Long idEmpresa, @RequestBody InformacoesUsuario informacoesUsuario) {
		return service.solicitarAlteracaoDado(idEmpresa, informacoesUsuario);
	}
	
	@PostMapping
	public InformacoesUsuario solicitarExclusaoDado(@PathVariable Long idEmpresa, @RequestBody InformacoesUsuario informacoesUsuario) {
		return service.solicitarExclusaoDado(idEmpresa, informacoesUsuario);
	}
}
