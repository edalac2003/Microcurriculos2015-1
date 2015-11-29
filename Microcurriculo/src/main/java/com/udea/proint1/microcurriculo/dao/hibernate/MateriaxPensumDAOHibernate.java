package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriaxPensumDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriaxPensumDAOHibernate extends HibernateDaoSupport implements MateriaxPensumDAO {

	@Override
	public void guardarMateriasxPensum(TbMicMateriaxpensum materiasxPensum)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(materiasxPensum);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicMateriaxpensum obtenerMateriasxPensum(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicMateriaxpensum materiasxPensum = null;

		try {
			session = getSession();
			materiasxPensum = (TbMicMateriaxpensum) session.get(TbMicMateriaxpensum.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return materiasxPensum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicMateriaxpensum> listarMateriasxPensum()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicMateriaxpensum> materiasxPensum = new ArrayList<TbMicMateriaxpensum>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMateriaxpensum.class);
			
			materiasxPensum = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return materiasxPensum;
	}

	@Override
	public void actualizarMateriasxPensum(TbMicMateriaxpensum materiasxPensum)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(materiasxPensum);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
