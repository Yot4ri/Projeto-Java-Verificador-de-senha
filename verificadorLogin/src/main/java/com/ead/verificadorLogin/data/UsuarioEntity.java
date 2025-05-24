package com.ead.verificadorLogin.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name="Usuarios")

public class UsuarioEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    
    @Email(message="Email inválido")
    @NotBlank (message="Obrigatório informar um email!")
    private String email;
    
    @NotBlank (message="Obrigatório informar uma senha!")
    private String senha;
    
    @NotBlank (message="Obrigatório informar um nome!")
    private String nome;
    
    
}
