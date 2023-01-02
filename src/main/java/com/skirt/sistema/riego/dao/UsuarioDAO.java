package com.skirt.sistema.riego.dao;

import com.skirt.sistema.riego.api.entity.TbUsuario;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;

public interface UsuarioDAO {
	public boolean validateUser(UsuarioLoginModel usuario);
	public String Usuario(String email);
	public boolean Create(TbUsuario userNew);
}
