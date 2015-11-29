package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ActividadxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicActividadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ActividadxMicroDAOHibernate extends HibernateDaoSupport implements ActividadxMicroDAO {

	@Override
	public void guardarActividadxMicro(TbMicActividadxmicro actividadxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(actividadxMicro);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Actividad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicActividadxmicro obtenerActividadxMicro(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicActividadxmicro actividadxmicro = null;

		try {
			session = getSession();
			actividadxmicro = (TbMicActividadxmicro) session.get(TbMicActividadxmicro.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Actividad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return actividadxmicro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicActividadxmicro> listarActividadxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicActividadxmicro> actividadxmicro = new ArrayList<TbMicActividadxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicActividadxmicro.class);
			
			actividadxmicro = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Actividad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return actividadxmicro;
	}

	@Override
	public void actualizarActividadxMicro(TbMicActividadxmicro actividadxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(actividadxMicro);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Actividad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
