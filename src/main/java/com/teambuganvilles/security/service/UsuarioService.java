package com.teambuganvilles.security.service;


import com.teambuganvilles.exceptions.UsuarioNotFoundException;
import com.teambuganvilles.model.Usuario;
import com.teambuganvilles.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(final int id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> getUsuario(final int id) {
        return usuarioRepository.findById(id);
    }

    public Iterable<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(int id, Usuario newUsuario) throws UsuarioNotFoundException {
        Optional<Usuario> currentUsuarioOptional = getUsuario(id);
        if (currentUsuarioOptional.isPresent()) {
            Usuario currentUsuario = currentUsuarioOptional.get();
            currentUsuario.setId(id);
            currentUsuario.setNombre(newUsuario.getNombre());
            currentUsuario.setNombreUsuario(newUsuario.getNombreUsuario());
            currentUsuario.setPassword(newUsuario.getPassword());
            currentUsuario.setEmail(newUsuario.getEmail());
            currentUsuario.setRoles(newUsuario.getRoles());
            save(currentUsuario);
            return currentUsuario;
        } else {
            throw new UsuarioNotFoundException(id);
        }
    }
    }
