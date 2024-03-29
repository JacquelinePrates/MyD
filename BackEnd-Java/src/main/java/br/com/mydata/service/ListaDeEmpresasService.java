package br.com.mydata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.Informacao;
import br.com.mydata.model.Usuario;
import br.com.mydata.repository.EmpresaRepository;
import br.com.mydata.repository.UsuarioRepository;
import br.com.mydata.restConection.RestConection;

@Service
public class ListaDeEmpresasService {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	RestConection restConection;

	public List<Empresa> todasInformaçõesDoUsuarioNasEmpresas(Long id) {
		List<Empresa> listaDeInformacoes = new ArrayList<Empresa>();

		List<Empresa> todasEmpresas = empresaRepository.findAll();
		Optional<Usuario> optionalUsuarioDoBanco = usuarioRepository.findById(id);
		Usuario usuarioDoBanco = optionalUsuarioDoBanco.get();

		String cpf = usuarioDoBanco.getCpf();

		for (Empresa empresa : todasEmpresas) {
			String url = empresa.getUrlDeConexao();

			Empresa informacoesDaEmpresa = (Empresa) restConection.post(url, cpf, new Empresa());
			
			empresa.setUrlDaLogo(informacoesDaEmpresa.getUrlDaLogo());
			if (Objects.nonNull(informacoesDaEmpresa.getListaDeInformacoes())){
				listaDeInformacoes.add(empresa);
			}
		}

		return listaDeInformacoes;

	}

}
