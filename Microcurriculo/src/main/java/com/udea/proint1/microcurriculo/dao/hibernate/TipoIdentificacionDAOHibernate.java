package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TipoIdentificacionDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
//import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TipoIdentificacionDAOHibernate extends HibernateDaoSupport implements TipoIdentificacionDAO {

	@Override
	public void guardarTipoIdentificacion(
			TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(tipoIdentificacion);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmTipoidentificacion obtenerTipoIdentificacion(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmTipoidentificacion tipoIdentificacion = null;
		
		try{
			session = getSession();
			tipoIdentificacion = (TbAdmTipoidentificacion)session.get(TbAdmTipoidentificacion.class, id);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return tipoIdentificacion;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmTipoidentificacion> listarTipoIdentificacion()	throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmTipoidentificacion> listaTipoIdentificacion = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmTipoidentificacion.class);
			listaTipoIdentificacion = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		} finally{
			session.close();
		}
		
		return listaTipoIdentificacion;
	}

	
	@Override
	public void actualizarTipoIdentificacion(
			TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(tipoIdentificacion);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
