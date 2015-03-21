package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObservacionxTablaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmObservacionxtabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObservacionxTablaDAOHibernate extends HibernateDaoSupport implements ObservacionxTablaDAO {

	@Override
	public void guardarObservacionxTabla(
			TbAdmObservacionxtabla observacionxTabla) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(observacionxTabla);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmObservacionxtabla obtenerObservacionxTabla(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmObservacionxtabla observacionxtabla = null;

		try {
			session = getSession();
			observacionxtabla = (TbAdmObservacionxtabla) session.get(TbAdmObservacionxtabla.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return observacionxtabla;
	}

	@Override
	public List<TbAdmObservacionxtabla> listarObservacionxTabla()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmObservacionxtabla> observacionxtabla = new ArrayList<TbAdmObservacionxtabla>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmObservacionxtabla.class);
			
			observacionxtabla = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return observacionxtabla;
	}

	@Override
	public void actualizarObservacionxTabla(
			TbAdmObservacionxtabla observacionxTabla) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(observacionxTabla);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
