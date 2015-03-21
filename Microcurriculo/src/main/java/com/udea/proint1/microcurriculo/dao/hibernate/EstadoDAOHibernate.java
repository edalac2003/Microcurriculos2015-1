package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EstadoDAOHibernate extends HibernateDaoSupport implements EstadoDAO {

	public EstadoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEstado(TbMicEstado estado) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(estado);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicEstado obtenerEstado(int idEstado) throws ExcepcionesDAO {
		TbMicEstado estado = null;
		Session session = null;
		
		try{
			session = getSession();
			estado = (TbMicEstado)session.get(TbMicEstado.class, idEstado);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}	
		return estado;
	}

	@Override
	public List<TbMicEstado> obtenerEstadoxNombre(String nombre)
			throws ExcepcionesDAO {
		List<TbMicEstado> listaEstados = new ArrayList<TbMicEstado>();
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("FROM TbMicEstados tb where tb.vrDescripcion =:nombre");
			
			listaEstados = query.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return listaEstados;
	}

	@Override
	public List<TbMicEstado> listarEstados() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEstado> estados = new ArrayList<TbMicEstado>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEstado.class);
			estados = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return estados;
	}

	@Override
	public void actualizarEstado(TbMicEstado estado) throws ExcepcionesDAO{
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(estado);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}
}
