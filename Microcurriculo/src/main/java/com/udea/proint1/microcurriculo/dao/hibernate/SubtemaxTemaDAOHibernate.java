package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SubtemaxTemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class SubtemaxTemaDAOHibernate extends HibernateDaoSupport implements SubtemaxTemaDAO {

	@Override
	public void guardar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			session.saveOrUpdate(subtemaxTema);
			session.flush();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Subtema x Tema");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

	}

	@Override
	public void modificar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(TbMicTema tema)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicSubtemaxtema> subtemaxTema = new ArrayList<TbMicSubtemaxtema>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicSubtemaxtema where tbMicTema = :tema");
               
        	query.setEntity("tema", tema);
               
        	subtemaxTema = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Subtemas x Tema");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return subtemaxTema;
	}
	
	@Override
	public void eliminarSubtemaxTema(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(subtemaxTema);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Subtema x Tema");
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
//			Query query = session.createQuery("select max(nbid) from TbMicSubtemaxtema");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicSubtemaxtema.class);
////			registro = criteria.list().size();
//			
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO: Se generaron problemas al contar los registros de la tabla <SubtemaxTema>"+e.getMessage());
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}

}
