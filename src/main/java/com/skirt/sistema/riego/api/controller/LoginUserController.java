package com.skirt.sistema.riego.api.controller;

import com.skirt.sistema.riego.api.dao.impl.UsuarioLoginDaoImpl;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;

public class LoginUserController {
	private UsuarioLoginDaoImpl login;
	
	
	public LoginUserController() {
		this.login = new UsuarioLoginDaoImpl();
	}
	
	public boolean IsExistUser(UsuarioLoginModel usuarioLoginModel) {
		return this.login.validateUser(usuarioLoginModel);
	}
	
	public String user(String email) {
		return this.login.Usuario(email);
	}
	
}
