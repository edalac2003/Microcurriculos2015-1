package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DocentexNucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexnucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DocentexNucleoDAOHibernate extends HibernateDaoSupport implements DocentexNucleoDAO {

	@Override
	public void guardarDocentesxNucleo(TbAdmDocentexnucleo docentesxNucleo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(docentesxNucleo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmDocentexnucleo obtenerDocentesxNucleo(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmDocentexnucleo docentesxnucleo = null;

		try {
			session = getSession();
			docentesxnucleo = (TbAdmDocentexnucleo) session.get(TbAdmDocentexnucleo.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return docentesxnucleo;
	}

	@Override
	public List<TbAdmDocentexnucleo> listarDocentesxNucleo()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmDocentexnucleo> docentesxnucleo = new ArrayList<TbAdmDocentexnucleo>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmDocentexnucleo.class);
			
			docentesxnucleo = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return docentesxnucleo;
	}

	@Override
	public void actualizarDocentesxNucleo(TbAdmDocentexnucleo docentesxNucleo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(docentesxNucleo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
