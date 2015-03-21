package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class NucleoDAOHibernate extends HibernateDaoSupport implements NucleoDAO {

	public NucleoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(nucleo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		} finally{
			session.close();
		}
	}

	@Override
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(nucleo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmNucleo nucleo = null;

		try {
			session = getSession();
			nucleo = (TbAdmNucleo) session.get(TbAdmNucleo.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return nucleo;
	}

	@Override
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmNucleo> nucleos = null;

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmNucleo.class);
			nucleos = criteria.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}

		return nucleos;
	}
	
	
	@Override
	public List<TbAdmNucleo> listarNucleoPorDependencia(String dependencia) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmNucleo> nucleos = null;
        
        try{
            session = getSession();
            Query query = session.createQuery("from TbAdmNucleo where tbAdmDependencia = :dependencia");
            query.setString("dependencia", dependencia);
            nucleos = query.list();
        }catch(HibernateException e){
            throw new ExcepcionesDAO("DAO: Se presentaron errores al intentar listar los Nucleos por Dependencia.  "+e);
        } finally{
			session.close();
		}
        return nucleos;
	}
	
	
	
	@Override
	public List<TbAdmNucleo> listarNucleoPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO {
		List<TbAdmNucleo> listaNucleos = null;
		Session session = null;
		
		try {
			session = getSession();
			Query query = session.createQuery("from TbAdmNucleo where tbAdmDependencia = :dependencia");
			query.setEntity("dependencia", dependencia);
			listaNucleos = query.list();
		} catch (HibernateException e) {
			
		} finally{
			session.close();
		}
		
		return listaNucleos;
	}

	@Override
	public List<TbAdmNucleo> buscarNucleos(String buscar)throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmNucleo> nucleos = new ArrayList<TbAdmNucleo>();
        
        try{               
            session = getSession();
            if(buscar.length() > 0){
            	Query query = session.createQuery("from TbAdmNucleo where vrIdnucleo  like :nucleo");                            
                query.setString("nucleo", buscar);               
                nucleos = query.list();  
            } else
            	listarNucleos();   
        }catch(HibernateException e){
            throw new ExcepcionesDAO(e);
        } finally{
			session.close();
		}
        return nucleos;
	}
	

}
