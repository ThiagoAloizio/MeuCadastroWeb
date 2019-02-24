/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meucadastroweb.controllers;

import com.meucadastroweb.entity.Usuario;
import com.meucadastroweb.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    
    	@Autowired
	private UsuarioService service; //	Injeta a classe de serviços
    
    	//Vai para tela principal do CRUD aonde são listados todos os posts
	@GetMapping("/usuario")
	public ModelAndView findAll() {
		
            ModelAndView mv = new ModelAndView("/usuario");
            mv.addObject("usuarios", service.findAll());
		
	    return mv;
	}
        
        //Vai para tela de adição de post
	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		
		ModelAndView mv = new ModelAndView("/usuarioAdd");
		mv.addObject("usuario", usuario);
		
		return mv;
	}
        
        //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		
		return add(service.findOne(id));
	}
	
    	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(usuario);
		}
		
		service.save(usuario);
		
		return findAll();
	}
        
	@PostMapping("**/search")
	public ModelAndView search(@RequestParam("emailpesquisa") String emailpesquisa)
        {
		ModelAndView mv = new ModelAndView("/usuario");
		mv.addObject("usuarios", service.findUsuarioByEmail(emailpesquisa));
		
		return mv;
	}
}
