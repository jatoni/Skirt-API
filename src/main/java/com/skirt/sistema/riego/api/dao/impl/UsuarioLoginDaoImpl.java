package com.skirt.sistema.riego.api.dao.impl;



import java.util.List;

import javax.persistence.*;

import com.skirt.sistema.riego.api.entity.TbUsuario;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;
import com.skirt.sistema.riego.dao.UsuarioLoginDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UsuarioLoginDaoImpl implements UsuarioLoginDAO{
	
	private static final Logger logger = LogManager.getLogger(UsuarioLoginDaoImpl.class);

	@Override
	public boolean validateUser(UsuarioLoginModel usuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Skirt-API");
		boolean status = false;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createNamedQuery("TbUsuario.findUserByEmailPass", TbUsuario.class);
			query.setParameter("email", usuario.getEmail());
			query.setParameter("pass", usuario.getPassword());
			if(!query.getResultList().isEmpty()) {
				status = true;
			}else {
				status = false;
			}
		}catch (Exception e) {
			logger.error("Hubo un error al hacer una consulta para hacer un login para el usuario con el correo: " + usuario.getEmail() + "\nError: " + e.getMessage());
			status = false;
		}
		return status;
	}

	@Override
	public String Usuario(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Skirt-API");
		List<TbUsuario> usuarios;
		String user = "";
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createNamedQuery("TbUsuario.finUser", TbUsuario.class);
			query.setParameter("email", email);
			usuarios = query.getResultList();
			for(TbUsuario usuario : usuarios) {
				user = usuario.getNombre() + " " + usuario.getApellidos();
			}
		}catch (Exception e) {
			logger.error("Hubo un error al hacer la consulta de tipo: " + e.getMessage());
			user = "";
		}
		return user;
	}

}
