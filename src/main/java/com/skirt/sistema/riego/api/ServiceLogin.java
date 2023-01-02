package com.skirt.sistema.riego.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skirt.sistema.riego.api.controller.UserController;
import com.skirt.sistema.riego.api.models.ResponseModel;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;



@Path("Login")
public class ServiceLogin {
	private Response respuesta;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ValidarUsuario(UsuarioLoginModel usuario) {
		UserController login = new UserController();
		if(usuario != null || !usuario.getEmail().isEmpty() || !usuario.getPassword().isEmpty()) {
			if(login.IsExistUser(usuario)) {
				respuesta = Response.status(Response.Status.FOUND).entity(new ResponseModel(200, login.user(usuario.getEmail()))).build();
			}else {
				respuesta = Response.status(Response.Status.UNAUTHORIZED).entity(new ResponseModel(401, usuario.getEmail() +  " no encontrado")).build();
			}	
		}else {
			respuesta = Response.status(Response.Status.UNAUTHORIZED).entity(new ResponseModel(402, "No hay nada en su cuerpo")).build();
		}
		
		return respuesta;
	}
}
