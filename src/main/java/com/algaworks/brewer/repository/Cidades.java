package com.algaworks.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.algaworks.brewer.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByEstadoCodigo(Long codigoEstado);

}
