package br.com.mydata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mydata.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
