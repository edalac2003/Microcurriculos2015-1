package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriaxSemestreDAO;
//import com.udea.proint1.microcurriculo.dao.NucleoDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateriaxsemestre;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriaxSemestreDAOHibernate extends HibernateDaoSupport implements MateriaxSemestreDAO {

	public MateriaxSemestreDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(materiaxsemestre);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Materia por Semestre");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public void modificarMateriaxSemestre(TbAdmMateriaxsemestre materiaxsemestre) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(materiaxsemestre);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Materia por Semestre");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmMateriaxsemestre obtenerMateriaxsemestre(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmMateriaxsemestre materiaxsemestre = null;

		try {
			session = getSession();
			materiaxsemestre = (TbAdmMateriaxsemestre) session.get(TbAdmMateriaxsemestre.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Materia por Semestre");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return materiaxsemestre;
	}

	@Override
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestre() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmMateriaxsemestre> materiaxSemestres = null;

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmMateriaxsemestre.class);
			materiaxSemestres = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias x Semestre");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

		return materiaxSemestres;
	}
	
	
	@Override
	public List<TbAdmMateriaxsemestre> listarMateriasxSemestrexSemestre(TbAdmSemestre semestre) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmMateriaxsemestre> materiaxsemestres = null;
        
        try{
            session = getSession();
            Query query = session.createQuery("from TbAdmMateriaxsemestre where tbAdmSemestre = :semestre");
            query.setEntity("semestre", semestre);
            materiaxsemestres = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Materias para un semestre especifico");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return materiaxsemestres;
	}
	
}
