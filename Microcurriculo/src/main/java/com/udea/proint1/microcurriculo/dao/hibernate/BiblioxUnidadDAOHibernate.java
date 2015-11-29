package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BiblioxUnidadDAOHibernate extends HibernateDaoSupport implements BiblioxUnidadDAO {

	
	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(biblioxUnidad);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Bibliografia x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(biblioxUnidad);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Bibliografia x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicBiblioxunidad BiblioxUnidad = null;

		try {
			session = getSession();
			BiblioxUnidad = (TbMicBiblioxunidad) session.get(TbMicBiblioxunidad.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Bibliografia x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return BiblioxUnidad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBiblioxunidad> BibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBiblioxunidad.class);
			
			BibliosxUnidad = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Bibliografias x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return BibliosxUnidad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(TbMicUnidad unidad)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBiblioxunidad> bibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicBiblioxunidad where tbMicUnidad = :unidad");
               
        	query.setEntity("unidad", unidad);
               
        	bibliosxUnidad = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Bibliografias x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return bibliosxUnidad;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbId) from TbMicBiblioxunidad");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicBiblioxunidad.class);
////			registro = criteria.list().size();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO(e);
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}
	
	@Override
	public void eliminarBiblioxunidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(biblioxUnidad);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Bibliografia x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
