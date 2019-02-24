/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meucadastroweb.entity;
 
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
 
@Entity
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 255)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;
    private String endereco;
    private String email;
    
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Login é uma informação obrigatória.")
    private String login;
    
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Senha é uma informação obrigatória.")
    private String senha;
    
    public Usuario() {}
    
    public Usuario(String nome, String endereco, String email, String login, String senha) {
            this.nome = nome;
            this.endereco = endereco;
            this.email = email;
            this.login = login;
            this.senha = senha;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}