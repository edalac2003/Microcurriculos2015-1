package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriaDAOHibernate extends HibernateDaoSupport implements MateriaDAO {

	public MateriaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			session.save(materia);
			session.flush();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Materia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
	}

	@Override
	public TbAdmMateria obtenerMateria(String idMateria) throws ExcepcionesDAO {
		Session session = null;
		TbAdmMateria materia = null;
		
		try{
			session = getSession();
			materia = (TbAdmMateria)session.get(TbAdmMateria.class, idMateria);
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Materia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return materia;
	}

	@Override
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmMateria.class);
			materias = criteria.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return materias;
	}


	@Override
	public List<TbAdmMateria> listarMateriasPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
		
		try {
			session = getSession();
			Query query = session.createQuery("FROM TbAdmMateria where tbAdmNucleo = :nucleo");
			query.setEntity("nucleo", nucleo);
            materias = query.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}	
		return materias;
	}
	
	@Override
	public List<TbAdmMateria> listarMateriasPorNucleo(String nucleo) throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmMateria> materias = null;
		
		try {
			session = getSession();
			Query query = session.createQuery("FROM TbAdmMateria where tbAdmNucleo = :nucleo");
			query.setString("nucleo", nucleo);
			
            materias = query.list();			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}	
		return materias;
	}
	
	

	@Override
	public List<TbAdmMateria> listarMateriasPorSemestre(int semestre) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmCorrequisitos where nbSemestre = :nroSemestre");
               
                query.setInteger("nroSemestre", semestre);
               
                materias = query.list();
                
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return materias;
	}

	@Override
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(materia);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Materia");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
        
        try{               
                session = getSession();	
                //buscar = buscar.substring(0, buscar.length() - 2);
                               
                Query query = session.createQuery("from TbAdmMateria where vrIdmateria  like :materia");
//                Query query = session.createQuery("from TbAdmMaterias mat where mat.vrNucleo = :materia");                               
                query.setString("materia", buscar);               
                materias = query.list();                
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar buscar Materias");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return materias;
	}
	
	@Override
	public List<String> listarIdMateriasxDependencia(String idDependencia) throws ExcepcionesDAO{
		Session session = null;
		List<String> microcurriculos = new ArrayList<String>();

		try {
			session = getSession();
			Query query = session.createSQLQuery("select vr_idmateria from tb_adm_materia m, tb_adm_nucleo n, tb_adm_dependencia d "
					+ "where n.vr_dependencia = d.vr_iddependencia and m.vr_nucleo = n.vr_idnucleo and d.vr_iddependencia = '"+idDependencia+"'");
//			query.setEntity("dependencia", dependencia);
			microcurriculos = (List<String>)query.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Microcurriculos");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return microcurriculos;
	}

}
