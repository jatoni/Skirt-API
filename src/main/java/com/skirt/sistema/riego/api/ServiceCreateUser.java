package com.skirt.sistema.riego.api;

import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skirt.sistema.riego.api.controller.UserController;
import com.skirt.sistema.riego.api.entity.TbUsuario;
import com.skirt.sistema.riego.api.models.ResponseModel;



@Path("Create")
public class ServiceCreateUser {
	private Response respuesta;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(TbUsuario usuarioNuevo) {
		UserController create = new UserController();
		if (Objects.isNull(usuarioNuevo)) {
			respuesta = Response.status(Response.Status.BAD_REQUEST)
					.entity(new ResponseModel(300, "No se aceptan curpos vacios al crear un usuario")).build();
		} else {
			if (create.insertUser(usuarioNuevo)) {
				respuesta = Response.status(Response.Status.CREATED)
						.entity(new ResponseModel(200, "El usuario: " + usuarioNuevo.getNombre() + " ha sido creado")).build();
			}else {
				respuesta = Response.status(Response.Status.FORBIDDEN)
						.entity(new ResponseModel(301, "El usuario: " + usuarioNuevo.getNombre() + " no ha sido creado")).build();
			}
		}
		return respuesta;
	}
}
