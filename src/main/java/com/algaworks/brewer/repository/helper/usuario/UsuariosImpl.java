package com.algaworks.brewer.repository.helper.usuario;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.brewer.model.Usuario;

public class UsuariosImpl implements UsuariosQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Optional<Usuario> porEmailEAtivo(String email) {

        // abaixo estaremos usando a notação em jpql e não em sql para estar acessando nosso server
        return manager.createQuery("from Usuario where lower(email) = lower(:email) and ativo = true", Usuario.class).setParameter("email", email).getResultList().stream().findFirst();
    }

}
