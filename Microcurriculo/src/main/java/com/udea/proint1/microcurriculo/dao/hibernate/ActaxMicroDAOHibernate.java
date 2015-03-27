package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ActaxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicActaxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ActaxMicroDAOHibernate extends HibernateDaoSupport implements ActaxMicroDAO {

	@Override
	public void guardarActaxMicro(TbMicActaxmicro actaxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(actaxMicro);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al guardar ActaxMicro");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbMicActaxmicro obtenerActaxMicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicActaxmicro actaxmicro = null;

		try {
			session = getSession();
			actaxmicro = (TbMicActaxmicro) session.get(TbMicActaxmicro.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return actaxmicro;
	}

	@Override
	public List<TbMicActaxmicro> listarActaxMicro() throws ExcepcionesDAO {
		Session session = null;
        List<TbMicActaxmicro> actaxmicro = new ArrayList<TbMicActaxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicActaxmicro.class);
			
			actaxmicro = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		} finally{
			session.close();
		}
		return actaxmicro;
	}

	@Override
	public void actualizarActaxMicro(TbMicActaxmicro actaxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(actaxMicro);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

}
