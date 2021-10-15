package com.test.demo.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.demo.models.Usuario;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository // Hace referencia que va a tener acceso a las funcionalidades de los repositorios
@Transactional //  Como va armar las consultas SQL con la BD en forma de transaccion
public class UserImp implements UserRepository{

    @PersistenceContext //lo necesita no sabemos por que
    private EntityManager entityManager;

    @Override
    public Usuario getUsuario(String id){
        String query = String.format("FROM Usuario WHERE id = %s", id);
        return (Usuario)entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id){
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }
    
    @Override
    public void add(Usuario usuario){
        entityManager.merge(usuario);
    }

    @Override
    public boolean login(String user){
        String query = String.format("FROM Usuario WHERE name = %s", user);
        List<Usuario> usuario = entityManager.createQuery(query).getResultList();
        return usuario.isEmpty();
    }    
    
}
