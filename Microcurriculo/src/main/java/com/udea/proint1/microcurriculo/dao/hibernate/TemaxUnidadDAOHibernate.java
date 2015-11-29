package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemaxUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TemaxUnidadDAOHibernate extends HibernateDaoSupport implements TemaxUnidadDAO {

	@Override
	public void guardarTemasXUnidad(TbMicTemaxunidad temaXunidad)	throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.saveOrUpdate(temaXunidad);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Tema x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public void modificarTemasXUnidad(TbMicTemaxunidad temaXunidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(temaXunidad);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar modificar Tema x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public TbMicTemaxunidad obtenerTemaXunidad(int idTemaxUnidad)	throws ExcepcionesDAO {
		TbMicTemaxunidad temaxUnidad = null;
		Session session = null;
		
		try{
			session = getSession();
			temaxUnidad = (TbMicTemaxunidad)session.get(TbMicTemaxunidad.class, idTemaxUnidad);
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Tema x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}	
		
		return temaxUnidad;
	}

	@Override
	public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(TbMicUnidad unidad)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicTemaxunidad where tbMicUnidad = :unidad");
               
        	query.setEntity("unidad", unidad);
               
        	temasxUnidad = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Temas x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return temasxUnidad;
	}

	@Override
	public List<TbMicTemaxunidad> ListarTemasXunidad()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPersona.class);
			
			temasxUnidad = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Temas x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return temasxUnidad;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbId) from TbMicTemaxunidad");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicTemaxunidad.class);
////			registro = criteria.list().size();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("DAO : Se presentaron problemas al intentar recuperar el Numero de Registros de la Tabla <TB_MIC_TEMAXUNIDAD>. "+e);
//		} finally{
//			session.close();
//		}
//		
//		return registro;
//	}
	
	@Override
	public void eliminarTemaxunidad(TbMicTemaxunidad temaXunidad) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(temaXunidad);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Tema x Unidad");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
