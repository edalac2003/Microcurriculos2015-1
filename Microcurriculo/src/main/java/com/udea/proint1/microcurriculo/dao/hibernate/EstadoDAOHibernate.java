package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
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
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Estado");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
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
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Estado");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
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
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Estados");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return listaEstados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicEstado> listarEstados() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEstado> estados = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEstado.class);
			estados = criteria.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Estado");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
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

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Estado");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
}
