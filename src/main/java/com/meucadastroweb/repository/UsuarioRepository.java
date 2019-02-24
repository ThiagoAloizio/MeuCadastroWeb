/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meucadastroweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meucadastroweb.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
 
         Usuario findByLoginAndSenha (String login, String senha);
         
         @Query("Select u from Usuario u where u.email like %?1%")
         List<Usuario> findUsuarioByEmail(String email);
}