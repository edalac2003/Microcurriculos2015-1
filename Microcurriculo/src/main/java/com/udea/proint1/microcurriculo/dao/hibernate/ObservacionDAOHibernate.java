package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObservacionDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObservacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObservacionDAOHibernate extends HibernateDaoSupport implements ObservacionDAO {

	@Override
	public void guardarObservacion(TbMicObservacion observacion)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(observacion);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicObservacion obtenerObservacion(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicObservacion observacion = null;

		try {
			session = getSession();
			observacion = (TbMicObservacion) session.get(TbMicObservacion.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return observacion;
	}

	@Override
	public List<TbMicObservacion> listarObservacion() throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObservacion> observacion = new ArrayList<TbMicObservacion>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObservacion.class);
			
			observacion = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return observacion;
	}

	@Override
	public void actualizarObservacion(TbMicObservacion observacion)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(observacion);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(TbMicObservacion.class);
//			registro = criteria.list().size();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Ocurrieron problemas al contar los registros de la tabla <TbMicObservaciones>.");
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}
	
	

}
