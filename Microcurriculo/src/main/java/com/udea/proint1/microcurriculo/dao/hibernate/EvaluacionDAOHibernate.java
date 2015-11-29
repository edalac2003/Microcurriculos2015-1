package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EvaluacionDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EvaluacionDAOHibernate extends HibernateDaoSupport implements EvaluacionDAO {


	@Override
	public void guardarEvaluaciones(TbMicEvaluacion evaluacion) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			
			session = getSession();
			session.saveOrUpdate(evaluacion);
			session.flush();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Evaluacion");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicEvaluacion obtenerEvaluaciones(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicEvaluacion evaluacion = null;
		
		try{
			session = getSession();
			evaluacion = (TbMicEvaluacion)session.get(TbMicEvaluacion.class, id);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Evaluacion");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return evaluacion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicEvaluacion> listarEvaluaciones() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEvaluacion> evaluaciones = new ArrayList<TbMicEvaluacion>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEvaluacion.class);
			evaluaciones = criteria.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Evaluaciones");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return evaluaciones;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbIdevaluacion) from TbMicEvaluacion");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicEvaluacion.class);
////			registro = criteria.list().size();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO : Se presentaron Errores al Contar los Registros de la Tabla Evaluaciones. "+e);
//		} finally{
//			session.close();
//		}	
//		return registro;
//	}

	@Override
	public void actualizarEvaluaciones(TbMicEvaluacion evaluacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(evaluacion);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Evaluacion");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public void eliminarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(evaluacion);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Evaluacion");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
