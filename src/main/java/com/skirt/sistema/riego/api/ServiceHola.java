package com.skirt.sistema.riego.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.skirt.sistema.riego.api.models.ResponseModel;



@Path("hola")
public class ServiceHola {
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hola() {
		return Response.status(Response.Status.CREATED).entity(new ResponseModel(100, "Saldo(s) Registrados")).build();	
	}
}
