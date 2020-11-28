package com.algaworks.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.helper.cerveja.CervejasQueries;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {	// com isso conseguimos extender o uso do JpaRepository para nosso model cerveja e o Long vem do tipo da nossa chave primaria das cerveja que no caso é long

	
	
}
