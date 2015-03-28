package br.com.itexto.springforum.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	@Size(max=128) @NotNull @NotEmpty
	private String nome;
	
	@Email(message="Isto não é um E-mail válido") @NotNull @NotEmpty
	private String email;
	
	@NotNull
	private Date dataCadastro = new Date();
	
	@NotNull @NotEmpty
	@Size(min=8, max=32, message="Login muito curto ou muito longo")
	private String login;
	private String senha;
	
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
