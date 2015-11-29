package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DepartamentoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DepartamentoDAOHibernate extends HibernateDaoSupport implements DepartamentoDAO {

	private static Logger log=Logger.getLogger(DepartamentoDAOHibernate.class);
	
	@Override
	public TbAdmDepartamento obtenerDepartamento(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmDepartamento departamento = null;
		
		try{
			log.info("***********Se está obteniendo Departamento por Id*********");
			session = getSession();
			departamento = (TbAdmDepartamento)session.get(TbAdmDepartamento.class, id);
			
		}catch(HibernateException e){
			log.error("Falla al obtener departamento", e);
			throw new ExcepcionesDAO(e);	
		} finally{
			session.close();
		}
				
		return departamento;
	}

	@Override
	public List<TbAdmDepartamento> listarDepartamentos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDepartamento> departamentos = new ArrayList<TbAdmDepartamento>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicMicrocurriculo.class);
			
			log.info("********Obteniendo listado de Departamentos*********");
			departamentos = criteria.list();
			
		}catch(HibernateException e){
			log.error("Falla al obtener lista de departamentos", e);
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return departamentos;
	}

		
	@Override
	public List<TbAdmDepartamento> listarDepartamentosxPais(TbAdmPais idPais)	throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDepartamento> listaDepartamentos = null;
		
		try {
			session = getSession();
			Query query = session.createQuery("from TbAdmDepartamento where tbAdmPais = :idPais");
        	query.setEntity("idPais", idPais);
        	listaDepartamentos = query.list();
        	
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e.getMessage());
		} finally{
			session.close();
		}
		
		return listaDepartamentos;
	}

	@Override
	public void modificarDepartamentos(TbAdmDepartamento departamento) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(departamento);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
