package br.com.mydata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.Informacao;
import br.com.mydata.service.ListaDeEmpresasService;

@RestController
@CrossOrigin
@RequestMapping("empresas")
public class ListaDeEmpresasController {
	
	@Autowired
	ListaDeEmpresasService service;

	@GetMapping("/todas/informacoes")
	public List<Empresa> todasEmpresasQuePossuemInformacoes(@RequestParam long id) {
		return service.todasInformaçõesDoUsuarioNasEmpresas(id);
	}
	 
}
