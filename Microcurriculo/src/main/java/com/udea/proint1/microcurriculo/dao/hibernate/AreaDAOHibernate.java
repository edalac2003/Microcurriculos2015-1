package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AreaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmArea;
//import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AreaDAOHibernate extends HibernateDaoSupport implements AreaDAO {

	public AreaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarArea(TbAdmArea area) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarArea(TbAdmArea area) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmArea obtenerArea(String id) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmArea> listarAreas() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmArea> areas = null;
		
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmArea.class);
			areas = criteria.list();
			
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Areas");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
		} finally{
			session.close();
		}
		
		return areas;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmArea> listarAreasPorNucleo(String nucleo)	throws ExcepcionesDAO {
		
		Session session = null;
        List<TbAdmArea> areas = null;        
        try{               
            session = getSession();	
            Query query = session.createQuery("from TbAdmArea where tbAdmNucleoAcademico  = :nucleo");
            query.setString("nucleo", nucleo);               
            areas = query.list();                
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Areas");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return areas;
	
	}

}
