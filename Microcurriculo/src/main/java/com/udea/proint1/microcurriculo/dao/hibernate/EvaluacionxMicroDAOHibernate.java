package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EvaluacionxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EvaluacionxMicroDAOHibernate extends HibernateDaoSupport implements EvaluacionxMicroDAO {


	@Override
	public void guardarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;
		
		try{			
			session = getSession();
			session.saveOrUpdate(evaluacionxMicro);
			session.flush();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Evaluacion x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicEvaluacionxmicro obtenerEvaluacionesxmicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		try{
			session = getSession();
			evaluacionxMicro = (TbMicEvaluacionxmicro)session.get(TbMicEvaluacionxmicro.class, id);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Evaluacion x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return evaluacionxMicro;
	}

	@Override
	public List<TbMicEvaluacionxmicro> listarEvaluacionesxmicro() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEvaluacionxmicro> evaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEvaluacionxmicro.class);
			evaluacionesxMicro = criteria.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Evaluaciones x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return evaluacionesxMicro;
	}

	@Override
	public void actualizarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(evaluacionxMicro);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Evaluacion x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

//	@Override
//	public int obtenerRegistro() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbId) from TbMicEvaluacionxmicro");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicEvaluacionxmicro.class);
////			registro = criteria.list().size();
//			
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO : Error al intentar contar los registros de la tabla <EvaluacionesxMicro>    "+e.getMessage());
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicEvaluacionxmicro> ListarEvaluacionxMicroxMicro(TbMicMicrocurriculo microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicEvaluacionxmicro> evaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicEvaluacionxmicro where tbMicMicrocurriculo = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	evaluacionesxMicro = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Evaluaciones x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return evaluacionesxMicro;
	}
	
	@Override
	public void eliminarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(evaluacionxMicro);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Evaluacion x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
