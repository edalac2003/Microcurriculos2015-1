package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.HistoricoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class HistoricoDAOHibernate extends HibernateDaoSupport implements HistoricoDAO {

	public HistoricoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(historico);
			session.flush(); 
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Historico");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}
	
	@Override
	public void modificarHistorico(TbAdmHistorico historico) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(historico);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar actualizar Historico");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmHistorico obtenerHistorico(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmHistorico historico = null;

		try {
			session = getSession();
			historico = (TbAdmHistorico) session.get(TbAdmHistorico.class, id);

		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Historico");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		return historico;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmHistorico> listarHistoricos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmHistorico> historicos = null;

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmHistorico.class);
			historicos = criteria.list();
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar listar Historicos");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}

		return historicos;
	}
	
	@SuppressWarnings("unchecked")
	public List<TbAdmHistorico> obtenerHistoricosxMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmHistorico> historicos = new ArrayList<TbAdmHistorico>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbAdmHistorico where tbMicMicrocurriculo = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	historicos = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Historico x Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return historicos;
	}

}
