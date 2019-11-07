package br.com.mydata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mydata.model.InformacoesPessoaisBasicas;

@Repository
public interface InformacoesPessoaisBasicasRepository extends JpaRepository<InformacoesPessoaisBasicas, Integer>{

}
