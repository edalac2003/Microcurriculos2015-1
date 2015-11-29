package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;




//import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DocentexDependenciaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DocentexDependenciaDAOHibernate extends HibernateDaoSupport implements DocentexDependenciaDAO {


	@Override
	public void guardarDocentesxDependencia(TbAdmDocentexDependencia docentesxDependencia)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(docentesxDependencia);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmDocentexDependencia obtenerDocentesxDependencia(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmDocentexDependencia docentesxDependencia = null;

		try {
			session = getSession();
			docentesxDependencia = (TbAdmDocentexDependencia) session.get(TbAdmDocentexDependencia.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return docentesxDependencia;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<TbAdmDocentexDependencia> listarDocentesxDependencia() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmDocentexDependencia> docentesxDependencia = null;
        
		try {
			session = getSession();
//			Criteria criteria = session.createCriteria(TbAdmDocentexDependencia.class);
			Criteria criteria = (Criteria) session.createCriteria(TbAdmDocentexDependencia.class);
			criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
			
			docentesxDependencia = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);			
		} finally{
			session.close();
		}
		return docentesxDependencia;
	}


	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public List<TbAdmDocentexDependencia> listaDocentesxDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDocentexDependencia> docentesxDependencias = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from TbAdmDocentexDependencia where vrDependencia = :dependencia");
			query.setEntity("dependencia", dependencia);
			docentesxDependencias = query.list();
			
		} catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally {
			session.close();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmDocentexDependencia> listarDependenciasxDocente(TbAdmPersona docente) throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDocentexDependencia> docentesxDependencias = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("from TbAdmDocentexDependencia where tbAdmPersona = :docente");
			query.setEntity("docente", docente);
			docentesxDependencias = query.list();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Dependencias x Docente");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return docentesxDependencias;
	}
	
	@Override
	public void actualizarDocentesxDependencia(TbAdmDocentexDependencia docentesxDependencia)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(docentesxDependencia);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
