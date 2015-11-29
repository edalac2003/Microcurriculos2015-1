package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CorrequisitoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CorrequisitoDAOHibernate extends HibernateDaoSupport implements CorrequisitoDAO{

	@Override
	public void guardarCorrequisito(TbAdmCorrequisito correquisitos)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(correquisitos);
			tx.commit();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Correquisito");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
	}
	
	@Override
	public void actualizarCorrequisito(TbAdmCorrequisito correquisitos) throws ExcepcionesDAO{
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(correquisitos);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Correquisito");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmCorrequisito obtenerCorrequisitos(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmCorrequisito correquisitos = null;
		
		try{
			session = getSession();
			correquisitos = (TbAdmCorrequisito)session.get(TbAdmCorrequisito.class, id);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Correquisito");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return correquisitos;
	}

	@Override
	public List<TbAdmCorrequisito> listarCorrequisitos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCorrequisito> correquisitos = new ArrayList<TbAdmCorrequisito>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmCorrequisito.class);
			
			correquisitos = criteria.list();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Correquisitos");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return correquisitos;
	}

	public List<TbAdmCorrequisito> listarCorrequisitosxMateria(TbAdmMateria materia) throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmCorrequisito> correquisitos = new ArrayList<TbAdmCorrequisito>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmCorrequisito where tbAdmMateriasByVrMateria = :materia");
               
                query.setEntity("materia", materia);
               
                correquisitos = query.list();
                
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Correquisitos");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return correquisitos;
	}
}
