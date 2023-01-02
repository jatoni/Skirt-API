package com.skirt.sistema.riego.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQueries({
	@NamedQuery(name="TbUsuario.findAll", query="SELECT t FROM TbUsuario t"),
	@NamedQuery(name="TbUsuario.findUserByEmailPass", query="SELECT t FROM TbUsuario t WHERE t.correo = :email AND t.password = :pass"),
	@NamedQuery(name="TbUsuario.finUser", query="SELECT t FROM TbUsuario t WHERE t.correo = :email")
})
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short idUsuario;

	private String apellidos;

	private String correo;

	private String nombre;

	private String password;

	private String usuario;

	public TbUsuario() {
	}

	public short getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(byte idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}