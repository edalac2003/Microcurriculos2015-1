package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PensumDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicPensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PensumDAOHibernate extends HibernateDaoSupport implements PensumDAO {

	@Override
	public void guardarPensum(TbMicPensum pensum) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(pensum);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicPensum obtenerPensum(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicPensum pensum = null;

		try {
			session = getSession();
			pensum = (TbMicPensum) session.get(TbMicPensum.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return pensum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicPensum> listarPensum() throws ExcepcionesDAO {
		Session session = null;
        List<TbMicPensum> pensums = new ArrayList<TbMicPensum>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicPensum.class);
			
			pensums = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return pensums;
	}

	@Override
	public void actualizarPensum(TbMicPensum pensum) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(pensum);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
