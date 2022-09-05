package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.UsuarioException;
import com.example.ordersrestapi.models.Usuario;
import com.example.ordersrestapi.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario>findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow( ()-> new UsuarioException("Usuario com o ID:"+id+" não existe"));
    }

    public void deleteById(long id){

        Usuario usuario = this.findById(id);

        usuarioRepository.delete(usuario);
    }

    public void saveUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
