package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class TemaDAOHibernate extends HibernateDaoSupport implements TemaDAO {


	@Override
	public void guardarTema(TbMicTema tema) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(tema);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public void modificarTema(TbMicTema tema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(tema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicTema obtenerTema(int idTema) throws ExcepcionesDAO {
		Session session = null;
		TbMicTema tema = null;
		
		try{
			session = getSession();
			tema = (TbMicTema)session.get(TbMicTema.class, idTema);			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}			
		return tema;
	}

	
	
	@Override
	public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicTema> temas = new ArrayList<TbMicTema>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicTemas where vrDescripcion = :nombre");
               
        	query.setString("nombre", nombre);
               
        	temas = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        } finally{
			session.close();
		}
        return temas;
	}

	@Override
	public List<TbMicTema> listarTemas() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicTema> temas = new ArrayList<TbMicTema>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicTema.class);
			temas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		
		return temas;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbIdtema) from TbMicTema");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicTema.class);
////			registro = criteria.list().size();
//			
//		} catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO : No es posible retornar un valor numerico de los registros. "+e);
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}

}
