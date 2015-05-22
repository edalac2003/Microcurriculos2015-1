package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.RolDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class RolDAOHibernate extends HibernateDaoSupport implements RolDAO {

	public RolDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarRol(TbAdmRol rol) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmRol obtenerRol(TbAdmRol rol) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmRol obtenerRol(Integer id) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRol(TbAdmRol rol) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmRol> listarRoles() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
