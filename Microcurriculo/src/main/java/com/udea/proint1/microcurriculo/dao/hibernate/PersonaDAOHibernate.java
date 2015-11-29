package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
//import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {

	public PersonaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(persona);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		} finally{
			session.close();
		}

	}

	@Override
	public void modificarPersona(TbAdmPersona persona) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(persona);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		} finally{
			session.close();
		}

	}

	@Override
	public TbAdmPersona obtenerPersona(String idPersona) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPersona persona = null;
		
		try {
			session = getSession();
			persona = (TbAdmPersona)session.get(TbAdmPersona.class, idPersona);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		} finally{
			session.close();
		}
		return persona;
	}

	@Override
	public List<TbAdmPersona> obtenerDocentes(TbAdmRol rol) throws ExcepcionesDAO {
//		Session session = null;
//        List<TbAdmPersona> personas = new ArrayList<TbAdmPersona>();
//       
//        try{
//        	session = getSession();
//        	Query query = session.createQuery("from TbAdmRolxPersona where tbAdmRol = :rol");
//        	query.setEntity("rol", rol);
//        	personas = query.list();
//        }catch(HibernateException e){
//                throw new ExcepcionesDAO(e);
//        } finally{
//			session.close();
//		}
        return null;
	}

	
	
	@Override
	public boolean existePersona(String idPersona) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPersona persona = null;
		Boolean hallado = false;
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPersona.class, idPersona);
			persona = (TbAdmPersona) criteria.uniqueResult();			
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e.getMessage());
		} finally{
			session.close();
		}
		
		if (persona != null)
			hallado = true;
		else
			hallado = false;
		
		return hallado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmPersona> personas = new ArrayList<TbAdmPersona>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPersona.class);
			
			personas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return personas;
	}

}
