/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meucadastroweb.controllers;

import com.meucadastroweb.entity.Usuario;
import com.meucadastroweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    	@Autowired
	private UsuarioRepository ur;

        @RequestMapping( value = { "/" , "" }) 
        public ModelAndView login(){
            return new ModelAndView("login");
        }

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String usuarioLogin(@RequestParam("login") String login, @RequestParam("senha") String senha, RedirectAttributes attributes) {

                String redirect = "redirect:/";
                
                Usuario usuario = ur.findByLoginAndSenha(login, senha);
		
		if (usuario == null) 
                {
                    attributes.addFlashAttribute("mensagem", "Invalid user id or password.");
		} 
                else 
                {
                    attributes.addFlashAttribute("mensagem", "Welcome " + usuario.getNome() + ", You have successfully logged in");
                    redirect = "redirect:/usuario"; //welcome com uma lista de opcoes
		}
                
                return redirect;
        }

        /*
        @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView usuarioLogin(@RequestParam("login") String login, @RequestParam("senha") String senha, BindingResult result, RedirectAttributes attributes) {
            
		ModelAndView mv = new ModelAndView();
                
                Usuario usuario = ur.findByLoginAndSenha(login, senha);

		if (usuario == null) 
                {
			//mv.addObject("msg", "Invalid user id or password.");
			attributes.addFlashAttribute("mensagem", "Invalid user id or password.");
                        mv.setViewName("login");
		} 
                else 
                {
                    attributes.addFlashAttribute("mensagem", "Welcome " + usuario.getNome() + ", You have successfully logged in");
                    System.out.println("usuario.getNome(): " + usuario.getNome());
		      // mv.addObject("msg", "Welcome " + usuario.getNome() + ", You have successfully logged in.");
                       //mv.setViewName("login");
		       mv.setViewName("welcome");//welcome sera uma lista de usuario para alterar e consultar
		}

		//mv.setViewName("register");

		return mv;

	}
        */
}
