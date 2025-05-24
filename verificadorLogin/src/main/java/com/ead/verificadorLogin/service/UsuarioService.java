package com.ead.verificadorLogin.service;

import com.ead.verificadorLogin.data.UsuarioEntity;

import com.ead.verificadorLogin.data.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ead.verificadorLogin.exception.ResourceNotFoundException;

@Service

public class UsuarioService {
    
    @Autowired
    
    UsuarioRepository usuarioRepository;
    
    public UsuarioEntity criarUsuario(UsuarioEntity usuario){
        usuario.setId(null);
        
        usuarioRepository.save(usuario);
        
        return usuario;
        
    }
    
    public UsuarioEntity getUsuarioId(Integer usuarioId){
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado" + usuarioId));
    }
    
    public UsuarioEntity atualizarUsuario (Integer usuarioId, UsuarioEntity usuarioRequest){
        
        UsuarioEntity usuario = getUsuarioId(usuarioId);
        
        usuario.setNome(usuarioRequest.getNome());
        
        usuario.setEmail(usuarioRequest.getEmail());
        
        usuario.setSenha(usuarioRequest.getSenha());
        
        usuarioRepository.save(usuario);
        
        return usuario;
    }
    
    public void deletarUsuario(Integer usuarioId){
        UsuarioEntity usuario = getUsuarioId(usuarioId);
        
        usuarioRepository.deleteById(usuario.getId());
    }
}
