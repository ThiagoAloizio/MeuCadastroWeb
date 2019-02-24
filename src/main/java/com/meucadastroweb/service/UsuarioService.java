package com.meucadastroweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meucadastroweb.entity.Usuario;
import com.meucadastroweb.repository.UsuarioRepository;

@Service //Define a classe como um bean do Spring
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos posts inseridos
	public List<Usuario> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um post a partir do ID
	public Usuario findOne(Integer id) {
		return repository.getOne(id);
	}
	
	//Salva ou atualiza um post
	public Usuario save(Usuario usuario) {
		return repository.saveAndFlush(usuario);
	}
        
        //Pesquisa por email
        public List<Usuario> findUsuarioByEmail(String email) {
		return repository.findUsuarioByEmail(email);
	}

}
