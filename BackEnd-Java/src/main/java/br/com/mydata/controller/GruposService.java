package br.com.mydata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.InformacoesUsuario;
import br.com.mydata.model.Usuario;
import br.com.mydata.repository.EmpresaRepository;
import br.com.mydata.repository.UsuarioRepository;

@Service
public class GruposService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RestTemplate restTemplate;

	public InformacoesUsuario buscarInformacoesDoUsuarioPorEmpresa(Long idEmpresa, Long idUsuario) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(idEmpresa);
		Empresa empresa =  optionalEmpresa.get();
		
		String url = empresa.getUrlDeConexao();
		String urlCompleta = url + "/informacao";
		
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
		Usuario usuario = optionalUsuario.get();
		
		String cpf = usuario.getCpf();
		
		InformacoesUsuario informacoesUsuario = restTemplate.postForObject(urlCompleta, cpf, InformacoesUsuario.class);
		
		return informacoesUsuario;
	}

	public InformacoesUsuario solicitarAlteracaoDado(Long idEmpresa, InformacoesUsuario informacoesUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public InformacoesUsuario solicitarExclusaoDado(Long idEmpresa, InformacoesUsuario informacoesUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
