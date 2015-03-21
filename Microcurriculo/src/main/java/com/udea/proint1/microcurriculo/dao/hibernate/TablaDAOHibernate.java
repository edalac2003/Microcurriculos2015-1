package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TablaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TablaDAOHibernate extends HibernateDaoSupport implements TablaDAO {

	@Override
	public void guardarTabla(TbAdmTabla tabla) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(tabla);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmTabla obtenerTabla(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmTabla tabla = null;

		try {
			session = getSession();
			tabla = (TbAdmTabla) session.get(TbAdmTabla.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return tabla;
	}

	@Override
	public List<TbAdmTabla> listarTabla() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmTabla> tabla = new ArrayList<TbAdmTabla>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmTabla.class);
			
			tabla = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return tabla;
	}

	@Override
	public void actualizarTabla(TbAdmTabla tabla) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(tabla);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
