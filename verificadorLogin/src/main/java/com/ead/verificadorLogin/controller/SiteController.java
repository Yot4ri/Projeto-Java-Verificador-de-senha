package com.ead.verificadorLogin.controller;

import com.ead.verificadorLogin.service.UsuarioService;
import com.ead.verificadorLogin.data.UsuarioEntity;
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SiteController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/login")
    public String login(Model model){
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario",usuario);
        return "index";
    }   
    
    @PostMapping("/login")
    public String salvarUsuario(@Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult result){
        
        if (result.hasErrors()){
            return "index";
        }
        
        if (usuario.getId() == null){
            usuarioService.criarUsuario(usuario);
        }
        
        else{
            usuarioService.atualizarUsuario(usuario.getId(),usuario);
        }
        
        return "index";
    }
}
