package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.GuardarNucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;


public class GuardarNucleoDAOHibernate extends HibernateDaoSupport implements GuardarNucleoDAO  {

	@Override
	public void guardarNucleos(List<TbAdmUnidadAcademica> listaUnidades,
			List<TbAdmDependencia> listaDependencias,
			List<TbAdmNucleo> listaNucleos) throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			if (listaUnidades != null){
				for (TbAdmUnidadAcademica unidad : listaUnidades){
					session.saveOrUpdate(unidad);
				}
			}
			
			if (listaDependencias != null){
				for (TbAdmDependencia dependencia : listaDependencias){
					session.saveOrUpdate(dependencia);
				}
			}
			
			if (listaNucleos != null){
				for (TbAdmNucleo nucleo : listaNucleos){
					session.saveOrUpdate(nucleo);
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;

		} finally {
			session.close();
		}
		
	}



}
