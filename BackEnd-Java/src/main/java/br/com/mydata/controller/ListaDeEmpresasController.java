package br.com.mydata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mydata.model.InformaçõesRetornadasPelaEmpresaSobreUsuario;
import br.com.mydata.model.Usuario;
import br.com.mydata.service.ListaDeEmpresasService;

@RestController
@RequestMapping("empresas")
public class ListaDeEmpresasController {
	
	@Autowired
	ListaDeEmpresasService service;

	@GetMapping("/todas/informacoes/todas")
	private List<InformaçõesRetornadasPelaEmpresaSobreUsuario> todasInformaçõesDoUsuarioNasEmpresas(Usuario usuario) {
		return service.todasInformaçõesDoUsuarioNasEmpresas(usuario);

	}
}
