package com.skirt.sistema.riego.api.models;

public class UsuarioLoginModel {
	private String email;
	private String password;
	
	public UsuarioLoginModel() {
		
	}
	
	public UsuarioLoginModel(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UsuarioLoginModel [email=" + email + ", password=" + password + "]";
	}
	
	
}
