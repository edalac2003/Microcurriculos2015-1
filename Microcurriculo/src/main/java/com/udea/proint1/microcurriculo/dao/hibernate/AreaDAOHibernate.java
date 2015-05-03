package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AreaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmArea;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AreaDAOHibernate extends HibernateDaoSupport implements AreaDAO {

	public AreaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarArea(TbAdmArea area) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarArea(TbAdmArea area) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmArea obtenerArea(String id) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmArea> listarAreas() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmArea> listarAreasPorNucleo(TbAdmNucleo nucleo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
