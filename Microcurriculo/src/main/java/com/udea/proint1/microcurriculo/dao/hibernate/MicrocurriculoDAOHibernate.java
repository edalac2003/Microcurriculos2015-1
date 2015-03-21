package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@Transactional
//@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
/**
 * 
 * @author eacosta
 *
 */
public class MicrocurriculoDAOHibernate extends HibernateDaoSupport implements MicrocurriculoDAO {

	@Override
	public void guardarMicrocurriculo(TbMicMicrocurriculo microcurriculo)
			throws ExcepcionesDAO {
//		Session session = null;
//
//		try {
//			session = getSession();
//			session.save(microcurriculo);
//			session.flush(); 
//		} catch (HibernateException e) {
//			throw new ExcepcionesDAO("Error al Intentar guardar el Registro Microcurriculo en la Base de Datos. "+e);			
//		}

	}

	

	@Override
	public TbMicMicrocurriculo obtenerMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO {
		Session session = null;
		TbMicMicrocurriculo microcurriculo = null;;
		try{
			session = getSession();
			microcurriculo = (TbMicMicrocurriculo)session.get(TbMicMicrocurriculo.class, idMicrocurriculo);
		
		} catch (HibernateException e){
			throw new ExcepcionesDAO("DAO : Error al Intentar Obtener el Registro Microcurriculo en la Base de Datos."+e);
		} finally{
			session.close();
		}
		return microcurriculo;
	}


	@Override
	public void modificarMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
		try {
			session = getSession();
			this.getHibernateTemplate().update(microcurriculo);
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculos() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMicrocurriculo.class);
			microcurriculos = criteria.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculo where idSemestre = :semestre");
			query.setString("semestre", idSemestre);
			microcurriculos = query.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(
			TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculo where tbAdmNucleo = :buscarNucleo");
			query.setEntity("buscarNucleo", nucleo);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(
			TbAdmMateria materia) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();
		
		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculo where tbAdmMateria = :buscarMateria");
			query.setEntity("buscarMateria", materia);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return microcurriculos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String materia) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();
		
		try {
			session = getSession();
//			Query query = session.createQuery("from TbMicMicrocurriculos where tbAdmMaterias = :buscarMateria");
//			String sql = "Select * from TbMicMicrocurriculo join TbAdmMateria on "
//					+ "TbMicMicrocurriculo.VrMateria = TbAdmMateria.VrIdMateria where TbAdmMateria.VrIdMateria = "+materia;
//			String sql = "SELECT mic.vrIdMicrocurriculo From TbMicMicrocurriculo mic";
			String sql = "From TbMicMicrocurriculo mic";
			Query query = session.createQuery(sql);
			//query.setEntity("buscarMateria", materia);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO("Se presentaron problemas al intentar Listar los Microcurriculos por Materia.");
		} finally{
			session.close();
		}
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(
			TbAdmPersona responsable) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {

			session = getSession();

			Query query = session
					.createQuery("from TbMicMicrocurriculo where tbAdmPersona= :buscarResponsable");

			query.setEntity("buscarResponsable", responsable);

			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return microcurriculos;
	}

}
