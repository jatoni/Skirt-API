package com.skirt.sistema.riego.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skirt.sistema.riego.api.controller.LoginUserController;
import com.skirt.sistema.riego.api.models.ResponseModel;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;



@Path("Login")
public class ServiceLogin {
	private Response respuesta;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ValidarUsuario(UsuarioLoginModel usuario) {
		LoginUserController login = new LoginUserController();
		if(login.IsExistUser(usuario)) {
			respuesta = Response.status(Response.Status.CREATED).entity(new ResponseModel(200, "Usuario " + usuario.getEmail() + " existe")).build();
		}else {
			respuesta = Response.status(Response.Status.CREATED).entity(new ResponseModel(401, usuario.getEmail() +  " no encontrado")).build();
		}	
		return respuesta;
	}
}
