package br.com.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.InformacoesUsuario;

@RestController
public class GruposController {
	
	@Autowired
	private GruposService service;

	@GetMapping("empresa/{idEmpresa}/usuario/{idUsuario}")
	public InformacoesUsuario buscarInformacoesDoUsuarioPorEmpresa(@PathVariable Long idEmpresa, @PathVariable Long idUsuario) {
		return service.buscarInformacoesDoUsuarioPorEmpresa(idEmpresa, idUsuario);
	}
	
	@PostMapping("nada")
	public InformacoesUsuario solicitarAlteracaoDado(@PathVariable Long idEmpresa, @RequestBody InformacoesUsuario informacoesUsuario) {
		return service.solicitarAlteracaoDado(idEmpresa, informacoesUsuario);
	}
	
	@PostMapping("baba")
	public InformacoesUsuario solicitarExclusaoDado(@PathVariable Long idEmpresa, @RequestBody InformacoesUsuario informacoesUsuario) {
		return service.solicitarExclusaoDado(idEmpresa, informacoesUsuario);
	}
}
