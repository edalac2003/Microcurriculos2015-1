package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SubtemaDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
//import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class SubtemaDAOHibernate extends HibernateDaoSupport implements SubtemaDAO {

	@Override
	public void guardarSubtema(TbMicSubtema subtema) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(subtema);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Subtema");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public void modificarSubtema(TbMicSubtema subtema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(subtema);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar modificar Subtema");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

	}

	@Override
	public TbMicSubtema obtenerSubtemas(int idTema) throws ExcepcionesDAO {
		Session session = null;
		TbMicSubtema subtema = null;
		
		try{
			session = getSession();
			subtema = (TbMicSubtema)session.get(TbMicSubtema.class, idTema);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Subtema");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return subtema;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicSubtema> listarSubtemas() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicSubtema> subtemas = new ArrayList<TbMicSubtema>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicSubtema.class);
			subtemas = criteria.list();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Subtemas");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return subtemas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicSubtema> listarSubtemasxTema(TbMicTema tema) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicSubtema> subtemas = new ArrayList<TbMicSubtema>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicSubtemas where tbMicTemas = :tema");
               
        	query.setEntity("tema", tema);
               
        	subtemas = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Subtemas");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return subtemas;
	}

	@Override
	public void eliminarSubtema(TbMicSubtema subtema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(subtema);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Subtema");
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
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbIdsubtema) from TbMicSubtema");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicSubtema.class);
////			registro = criteria.list().size();
//			
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO : Se presentaron errores al contar los Registros de la Tabla Subtemas. "+e);
//		} finally{
//			session.close();
//		}		
//		return registro;
//	}

	
}
