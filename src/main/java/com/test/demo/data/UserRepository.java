package com.test.demo.data;

import com.test.demo.models.Usuario;

import java.util.List;

public interface UserRepository{

    Usuario getUsuario(String id);

    List<Usuario> getUsuarios();

    void delete(Long id);

    void add(Usuario usuario);

    boolean login(String user);

}
