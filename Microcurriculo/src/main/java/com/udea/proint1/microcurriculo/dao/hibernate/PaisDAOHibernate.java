package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PaisDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PaisDAOHibernate extends HibernateDaoSupport implements PaisDAO{

	@Override
	public TbAdmPais obtenerPais(int idPais) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPais pais = null;
		
		try{
			session = getSession();
			pais = (TbAdmPais)session.get(TbAdmPais.class, idPais);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
			
		return pais;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmPais> listarPaises() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmPais> paises = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPais.class);
			paises = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return paises;
	}

}
