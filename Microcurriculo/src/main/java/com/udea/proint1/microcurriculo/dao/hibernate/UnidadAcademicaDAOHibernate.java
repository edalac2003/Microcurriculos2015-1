package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadAcademicaDAOHibernate extends HibernateDaoSupport implements UnidadAcademicaDAO{

	@Override
	public void guardarUnidad(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidadAcademica);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmUnidadAcademica obtenerUnidad(String idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbAdmUnidadAcademica unidad = null;

		try {
			session = getSession();
			unidad = (TbAdmUnidadAcademica) session.get(TbAdmUnidadAcademica.class, idUnidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return unidad;
	}

	@Override
	public void modificarUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}
	
	@Override
	public List<TbAdmUnidadAcademica> listarUnidades() throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmUnidadAcademica> unidadesAcademicas = new ArrayList<TbAdmUnidadAcademica>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUnidadAcademica.class);			
			unidadesAcademicas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return unidadesAcademicas;
	}

}
