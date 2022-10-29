package com.skirt.sistema.riego.api.models;

public class ResponseModel {
	private int codigo;
	private String mensaje;
	
	public ResponseModel() {
		
	}
	
	public ResponseModel(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ResponseModel [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}
	
}
