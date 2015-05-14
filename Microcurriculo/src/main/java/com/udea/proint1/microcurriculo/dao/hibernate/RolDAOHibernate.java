package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.RolDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class RolDAOHibernate extends HibernateDaoSupport implements RolDAO {

	public RolDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmRol obtenerRol(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmRol rol = null;

		try {
			session = getSession();
			rol = (TbAdmRol) session.get(TbAdmRol.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Rol");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return rol;
	}

	@Override
	public List<TbAdmRol> listarRoles() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmRol> roles = null;

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmNucleo.class);
			roles = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Roles");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

		return roles;
	}
	
}
