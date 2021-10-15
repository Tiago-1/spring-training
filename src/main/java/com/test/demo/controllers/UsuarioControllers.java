package com.test.demo.controllers;

import com.test.demo.data.UserRepository;
import com.test.demo.data.SesionRepository;
import com.test.demo.models.Usuario;
import com.test.demo.models.SesionUser;

import com.test.demo.command.PhoneCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "api")
public class UsuarioControllers {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SesionRepository sesionRepository;


    @RequestMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable String id){
        return userRepository.getUsuario(id);
    }
    
    @RequestMapping(value = "/usuarios")
    public List<Usuario> getUsuarios(){
        return userRepository.getUsuarios();
    }
    
    @RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
    public void add(@RequestBody Usuario usuario){
        userRepository.add(usuario);
    }
    
    @RequestMapping(value = "/usuario/edit")
    public Usuario edit(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alberto");
        usuario.setApellido("Santiago");
        usuario.setEmail("algo@email.com");
        usuario.setTelefono("1278937");
        return usuario;
    }
    
    @PutMapping(value  = "/usuario/{id}/change-phone")
    public void changePhone(@PathVariable String id, @RequestBody PhoneCommand command){
        Usuario usuario = userRepository.getUsuario(id);
        usuario.setTelefono(command.getPhone());
        userRepository.add(usuario);

    }

    @RequestMapping(value = "/usuario/{id}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userRepository.delete(id);
    }


    @GetMapping("/usuario/inactive")
    public List<Usuario> getInctiveUsers(){
        List<Usuario> usuarios = userRepository.getUsuarios();

        List<Usuario> inactiveUsers = usuarios
                                      .stream()
                                      .filter(usuario -> usuario.getActive() == 0 )
                                      .collect(Collectors.toList());
        return inactiveUsers;
    }

    @RequestMapping(value = "/usuario/{user}/login")
    public boolean login(@PathVariable String user){
        return userRepository.login(user);
    }
    

    @GetMapping(value = "/sesion/{provider}/system")
    public List<SesionUser> getSesionBySystem(@PathVariable String provider){
        return sesionRepository.findBySystem(provider);
    }
    
    @GetMapping(value = "/sesion/last")
    public SesionUser getLastSesion(){
        return sesionRepository.findFirstByOrderByCreatedAtDesc();
    }

}
