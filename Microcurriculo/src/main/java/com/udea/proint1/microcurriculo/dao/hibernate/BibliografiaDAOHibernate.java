package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
//import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiaDAOHibernate extends HibernateDaoSupport implements BibliografiaDAO {


	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
				
		try{
			session = getSession();			
			//save example - without transaction
	        session.saveOrUpdate(bibliografia);
	        session.flush(); //address will not get saved without this
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

	}

	@Override
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesDAO{
		Session session = null;
		TbMicBibliografia bibliografia = null;

		try {
			session = getSession();
			bibliografia = (TbMicBibliografia) session.get(TbMicBibliografia.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return bibliografia;
	}
	
	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(bibliografia);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
			
			bibliografias = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return bibliografias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicBibliografia> listarBibliografiaxTipo(char tipo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();

		try {
			session = getSession();

			Query query = session
					.createQuery("from TbMicBibliografia where blTipo = :tipoBibliografia");

			query.setEntity("tipoBibliografia", tipo);

			bibliografias = query.list();

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

		return bibliografias;
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesDAO {
//		int registro = 0;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Query query = session.createQuery("select max(nbIdbibliografia) from TbMicBibliografia");
//			registro = (Integer)query.list().get(0);
////			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
////			registro = criteria.list().size();
//			
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Problemas para contar el numero de registros de la tabla Bibliografias");
//		} finally{
//			session.close();
//		}
//
//		return registro;
//	}
	
	@SuppressWarnings("unchecked")
	public List<TbMicBibliografia> listarBibliografias() throws ExcepcionesDAO{
		Session session = null;
        List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
			
			bibliografias = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Bibliografias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return bibliografias;
	}
	
	@Override
	public void eliminarBiblio(TbMicBibliografia bibliografia) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.delete(bibliografia);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar borrar Bibliografia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

}
