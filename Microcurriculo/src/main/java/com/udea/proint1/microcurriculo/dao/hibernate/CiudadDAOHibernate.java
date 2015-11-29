package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CiudadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CiudadDAOHibernate extends HibernateDaoSupport implements CiudadDAO {

	@Override
	public TbAdmCiudad obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		Session session = null;
		TbAdmCiudad ciudad = null;
		
		try{
			session = getSession();
			ciudad = (TbAdmCiudad)session.get(TbAdmCiudad.class, idCiudad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
			
		return ciudad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmCiudad> listarCiudades() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCiudad> ciudades = null;
		
		try{
			session = getSession();			
			Criteria criteria = session.createCriteria(TbAdmCiudad.class);
			ciudades = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return ciudades;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmCiudad> listarCiudadesxDepartamento(TbAdmDepartamento idDepartamento) throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCiudad> listaCiudades = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from TbAdmCiudad where tbAdmDepartamento = :idDepartamento");
        	query.setEntity("idDepartamento", idDepartamento);
        	listaCiudades = query.list();
        	
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e.getMessage());
		} finally{
			session.close();
		}
		
		return listaCiudades;
	}

	
}
