package com.ead.verificadorLogin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    UsuarioEntity findByNome (String nome);
    
    UsuarioEntity findByEmail (String email);
}
