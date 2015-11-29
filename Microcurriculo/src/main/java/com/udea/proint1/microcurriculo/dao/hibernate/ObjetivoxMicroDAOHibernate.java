package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivoxMicroDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
//import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivoxMicroDAOHibernate extends HibernateDaoSupport implements ObjetivoxMicroDAO {
	
	@Override
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro)	throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(objetivoxMicro);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Objetivo x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(objetivoxMicro);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar modificar Objetivo x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicObjetivoxmicro objetivosxMicro = null;

		try {
			session = getSession();
			objetivosxMicro = (TbMicObjetivoxmicro) session.get(TbMicObjetivoxmicro.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Objetivo x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return objetivosxMicro;
	}
	

	@Override
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivoxmicro where tbMicObjetivo = :objetivo");
               
        	query.setEntity("objetivo", objetivo);
               
        	objetivosxMicro = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Objetivos x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return objetivosxMicro;
	}
	
	@Override
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxMicro(
			TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivoxmicro where tbMicMicrocurriculo = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	objetivosxMicro = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Objetivo x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return objetivosxMicro;
	}
	
	@Override
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivoxmicro.class);
			
			objetivosxMicro = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Objetivos x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return objetivosxMicro;
	}
	
	@Override
	public void eliminarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesDAO{
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(objetivoxMicro);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Objetivo x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbId) from TbMicObjetivoxmicro");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicObjetivoxmicro.class);
////			registro = criteria.list().size();
//			
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Se produjo un error al calcular los Registros de la Tabla Objetivos x Microcurriculo. "+e);			
//		} finally{
//			session.close();
//		}
//		return registro;
//	}

}
