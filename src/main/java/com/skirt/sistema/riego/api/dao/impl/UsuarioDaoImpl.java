package com.skirt.sistema.riego.api.dao.impl;

import java.util.List;

import javax.persistence.*;

import com.skirt.sistema.riego.api.entity.TbUsuario;
import com.skirt.sistema.riego.api.models.UsuarioLoginModel;
import com.skirt.sistema.riego.dao.UsuarioDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioDaoImpl implements UsuarioDAO {

	private static final Logger logger = LogManager.getLogger(UsuarioDaoImpl.class);
	private boolean status;

	@Override
	public boolean validateUser(UsuarioLoginModel usuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Skirt-API");
		EntityManager em = emf.createEntityManager();
		boolean status = false;
		try {
			Query query = em.createNamedQuery("TbUsuario.findUserByEmailPass", TbUsuario.class);
			query.setParameter("email", usuario.getEmail());
			query.setParameter("pass", usuario.getPassword());
			if (!query.getResultList().isEmpty()) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			logger.error("Hubo un error al hacer una consulta para hacer un login para el usuario con el correo: "
					+ usuario.getEmail() + "\nError: " + e.getMessage());
			status = false;
		} finally {
			em.close();
			emf.close();
		}
		return status;
	}

	@Override
	public String Usuario(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Skirt-API");
		EntityManager em = emf.createEntityManager();
		List<TbUsuario> usuarios;
		String user = "";
		try {
			Query query = em.createNamedQuery("TbUsuario.finUser", TbUsuario.class);
			query.setParameter("email", email);
			usuarios = query.getResultList();
			for (TbUsuario usuario : usuarios) {
				user = usuario.getNombre() + " " + usuario.getApellidos();
			}
		} catch (Exception e) {
			logger.error("Hubo un error al hacer la consulta de tipo: " + e.getMessage());
			user = "";
		} finally {
			emf.close();
			em.close();
		}
		return user;
	}

	@Override
	public boolean Create(TbUsuario userNew) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Skirt-API");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ent = em.getTransaction();
		try {
			ent.begin();
			em.persist(userNew);
			ent.commit();
			logger.info("Se pudo hacer el commit con exito");
			status = true;
		} catch (Exception e) {
			ent.rollback();
			logger.error("Hubo un error de tipo: ", e);
			status = false;

		} finally {
			emf.close();
			em.close();
			
		}
		return status;
	}

}
