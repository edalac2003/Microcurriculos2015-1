package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadXMicroDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadxMicroDAOHibernate extends HibernateDaoSupport implements UnidadXMicroDAO {

	@Override
	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(unidadXmicro);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al guardar Unidad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidadXmicro);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al modificar Unidad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicUnidadxmicro obtenerUnidadXmicro(int idUnidadxMicro) throws ExcepcionesDAO {
		TbMicUnidadxmicro unidadxMicro = null;
		Session session = null;
		
		try{
			session = getSession();
			unidadxMicro = (TbMicUnidadxmicro)session.get(TbMicUnidadxmicro.class, idUnidadxMicro);
			if (unidadxMicro != null)
				return unidadxMicro;
			else
				return null;
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al obtener Unidad x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadxmicro> unidadesXMicro = new ArrayList<TbMicUnidadxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicUnidadxmicro where tbMicMicrocurriculo = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	unidadesXMicro = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al listar Unidades x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return unidadesXMicro;
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXmicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadxmicro> unidadesXMicro = new ArrayList<TbMicUnidadxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUnidadAcademica.class);
			
			unidadesXMicro = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al listar Unidades x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return unidadesXMicro;
	}
	
	@Override
	public void eliminarUnidadxmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(unidadXmicro);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Unidad x Microcurriculo");
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
//			Query query = session.createQuery("select max(nbId) from TbMicUnidadxmicro");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicUnidadxmicro.class);
////			registro = criteria.list().size();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Se produjo un Error al Intentar contar los Registros de la Tabla Unidades x Microcurriculo. "+e);
//		} finally{
//			session.close();
//		}
//	
//		return registro;
//	}
	
	

}
