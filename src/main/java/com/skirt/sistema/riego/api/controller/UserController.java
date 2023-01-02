package com.skirt.sistema.riego.api.controller;

import com.skirt.sistema.riego.api.dao.impl.UsuarioDaoImpl;
import com.skirt.sistema.riego.api.entity.TbUsuario;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;
import com.skirt.sistema.riego.dao.UsuarioDAO;

public class UserController {
	private UsuarioDAO login;
	
	public UserController() {
		this.login = new UsuarioDaoImpl();
	}
	
	public boolean IsExistUser(UsuarioLoginModel usuarioLoginModel) {
		return this.login.validateUser(usuarioLoginModel);
	}
	
	public String user(String email) {
		return this.login.Usuario(email);
	}
	
	
	public boolean insertUser(TbUsuario userNew) {
		return this.login.Create(userNew);
	}
	
	
}
