package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
//import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadDAOHibernate extends HibernateDaoSupport implements UnidadDAO {

	@Override
	public void guardarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(unidad);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public TbMicUnidad obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbMicUnidad unidad = null;
		
		try{
			session = getSession();
			unidad = (TbMicUnidad)session.get(TbMicUnidad.class, idUnidad);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return unidad;
	}

	
	@Override
	public void modificarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidad);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar modificar Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		Session session = null;
//		int registro = 0;
//		try {
//			session = getSession();
//			Query query = session.createQuery("select max(nbIdunidad) from TbMicUnidad");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicUnidad.class);
////			registro = criteria.list().size();			
//		} catch(HibernateException e){
//			throw new ExcepcionesDAO("No Devolvi� Ningun Numero de Registro "+e);
//		} finally{
//			session.close();
//		}	
//		return registro;
//	}

	@Override
	public List<TbMicUnidad> listarUnidades() throws ExcepcionesDAO{
		Session session = null;
		List<TbMicUnidad> unidades = new ArrayList<TbMicUnidad>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicUnidad.class);
			
			unidades = criteria.list();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Unidades");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return unidades;
	}
	
	@Override
	public void eliminarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(unidad);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
