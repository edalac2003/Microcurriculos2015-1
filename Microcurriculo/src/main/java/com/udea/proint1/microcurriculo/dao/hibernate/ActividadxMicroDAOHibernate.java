package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
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

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return actividadxmicro;
	}

	@Override
	public List<TbMicActividadxmicro> listarActividadxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicActividadxmicro> actividadxmicro = new ArrayList<TbMicActividadxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicActividadxmicro.class);
			
			actividadxmicro = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
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

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
