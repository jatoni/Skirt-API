package com.skirt.sistema.riego.dao;

import com.skirt.sistema.riego.api.models.UsuarioLoginModel;

public interface UsuarioLoginDAO {
	public boolean validateUser(UsuarioLoginModel usuario);
	public String Usuario(String email);
}
