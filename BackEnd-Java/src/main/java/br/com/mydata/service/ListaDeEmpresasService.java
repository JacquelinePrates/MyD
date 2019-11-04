package br.com.mydata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mydata.model.Empresa;
import br.com.mydata.model.InformaçõesRetornadasPelaEmpresaSobreUsuario;
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
	RestConection<InformaçõesRetornadasPelaEmpresaSobreUsuario> restConection;

	public List<InformaçõesRetornadasPelaEmpresaSobreUsuario> todasInformaçõesDoUsuarioNasEmpresas(Usuario usuario) {
		List<InformaçõesRetornadasPelaEmpresaSobreUsuario> listaDeInformações = new ArrayList<InformaçõesRetornadasPelaEmpresaSobreUsuario>();

		List<Empresa> todasEmpresas = empresaRepository.findAll();
		Usuario usuarioDoBanco = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

		String cpf = usuarioDoBanco.getCpf();

		for (Empresa empresa : todasEmpresas) {
			String url = empresa.getUrlDeConexao();

			InformaçõesRetornadasPelaEmpresaSobreUsuario informacoesDaEmpresa = (InformaçõesRetornadasPelaEmpresaSobreUsuario) restConection.post(url, cpf, new InformaçõesRetornadasPelaEmpresaSobreUsuario());

			if (Objects.nonNull(informacoesDaEmpresa.getInformaçõesDoUsuario())) {
				listaDeInformações.add(informacoesDaEmpresa);
			}
		}

		return listaDeInformações;

	}

}
