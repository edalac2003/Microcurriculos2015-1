package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EvaluacionxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EvaluacionxMicroDAOHibernate extends HibernateDaoSupport implements EvaluacionxMicroDAO {


	@Override
	public void guardarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;
		
		try{			
			session = getSession();
			session.save(evaluacionxMicro);
			session.flush();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar "+e);
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
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        } finally{
			session.close();
		}
        return evaluacionesxMicro;
	}
	

}
