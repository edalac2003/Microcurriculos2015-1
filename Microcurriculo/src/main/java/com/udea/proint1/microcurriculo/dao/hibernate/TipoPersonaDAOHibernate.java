package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TipoPersonaDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TipoPersonaDAOHibernate extends HibernateDaoSupport implements TipoPersonaDAO {

	public TipoPersonaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmTipopersona obtenerTipoPersona(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmTipopersona tipoPersona = null;
		
		try{
			session = getSession();
			tipoPersona = (TbAdmTipopersona)session.get(TbAdmTipopersona.class, id);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return tipoPersona;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmTipopersona> listarTipoPersonas() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmTipopersona> tipoPersonas = new ArrayList<TbAdmTipopersona>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmTipopersona.class);
			
			tipoPersonas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		} finally{
			session.close();
		}
		
		return tipoPersonas;
	}

}
