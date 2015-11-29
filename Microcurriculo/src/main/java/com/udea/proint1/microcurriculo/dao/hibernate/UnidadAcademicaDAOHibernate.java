package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadAcademicaDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadAcademicaDAOHibernate extends HibernateDaoSupport implements UnidadAcademicaDAO{

	@Override
	public void guardarUnidad(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidadAcademica);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Unidad Academica");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public void guardarListadoUnidad(List<TbAdmUnidadAcademica> lista) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;

		try{
			session = getSession();
			tx = session.beginTransaction();
			for (TbAdmUnidadAcademica unidad : lista)
				session.saveOrUpdate(unidad);
			
			tx.commit();
		} catch (HibernateException e){
			tx.rollback();			
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar el listado de Unidades Academicas. \n Todos los posibles cambios fueron revertidos.");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally {
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

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Unidad Academica");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
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

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar modificar Unidad Academica");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public List<TbAdmUnidadAcademica> listarUnidades() throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmUnidadAcademica> unidadesAcademicas = null;
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUnidadAcademica.class);			
			unidadesAcademicas = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Unidades Academica");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);			
			throw expDAO;
		} finally{
			session.close();
		}
		return unidadesAcademicas;
	}

}
