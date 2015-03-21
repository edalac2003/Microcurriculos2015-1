package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AuditoriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmAuditoria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AuditoriaDAOHibernate extends HibernateDaoSupport implements AuditoriaDAO {

	@Override
	public void guardarAuditoria(TbAdmAuditoria auditoria)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(auditoria);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmAuditoria obtenerAuditoria(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmAuditoria auditoria = null;

		try {
			session = getSession();
			auditoria = (TbAdmAuditoria) session.get(TbAdmAuditoria.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return auditoria;
	}

	@Override
	public List<TbAdmAuditoria> listarAuditoria() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmAuditoria> auditoria = new ArrayList<TbAdmAuditoria>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmAuditoria.class);
			
			auditoria = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return auditoria;
	}

	@Override
	public void actualizarAuditoria(TbAdmAuditoria auditoria)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(auditoria);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
