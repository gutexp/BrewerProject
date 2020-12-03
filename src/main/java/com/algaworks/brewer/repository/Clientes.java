package com.algaworks.brewer.repository;

import java.util.Optional;

import com.algaworks.brewer.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientes extends JpaRepository<Cliente, Long> {
    public Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

}
