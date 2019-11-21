package br.com.mydata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.Informacao;
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

	public Empresa buscarInformacoesDoUsuarioPorEmpresa(Long idEmpresa, Long idUsuario) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(idEmpresa);
		Empresa empresa =  optionalEmpresa.get();
		
		String url = empresa.getUrlDeConexao();
		String urlCompleta = url;
		
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
		Usuario usuario = optionalUsuario.get();
		
		String cpf = usuario.getCpf();
		
		Empresa empresaComInfomacoes = restTemplate.postForObject(urlCompleta, cpf, Empresa.class);
		empresaComInfomacoes.setId(empresa.getId());
		
		return empresaComInfomacoes;
	}

	public Informacao solicitarAlteracaoDado(Long idEmpresa, Informacao informacoesUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Informacao solicitarExclusaoDado(Long idEmpresa, Informacao informacoesUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
