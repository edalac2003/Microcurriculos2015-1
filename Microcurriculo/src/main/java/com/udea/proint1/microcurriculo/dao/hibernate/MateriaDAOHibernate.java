package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
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
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
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
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
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

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar");
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
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        } finally{
			session.close();
		}
        return materias;
	}

}
