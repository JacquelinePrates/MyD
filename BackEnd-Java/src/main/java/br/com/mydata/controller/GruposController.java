package br.com.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.Informacao;
import br.com.mydata.service.GruposService;

@RestController
public class GruposController {
	
	@Autowired
	private GruposService service;

	@GetMapping("empresa/{idEmpresa}/usuario/{idUsuario}")
	public Empresa buscarInformacoesDoUsuarioPorEmpresa(@PathVariable Long idEmpresa, @PathVariable Long idUsuario) {
		return service.buscarInformacoesDoUsuarioPorEmpresa(idEmpresa, idUsuario);
	}
	
	@PostMapping("nada")
	public Informacao solicitarAlteracaoDado(@PathVariable Long idEmpresa, @RequestBody Informacao informacoesUsuario) {
		return service.solicitarAlteracaoDado(idEmpresa, informacoesUsuario);
	}
	
	@PostMapping("baba")
	public Informacao solicitarExclusaoDado(@PathVariable Long idEmpresa, @RequestBody Informacao informacoesUsuario) {
		return service.solicitarExclusaoDado(idEmpresa, informacoesUsuario);
	}
}
