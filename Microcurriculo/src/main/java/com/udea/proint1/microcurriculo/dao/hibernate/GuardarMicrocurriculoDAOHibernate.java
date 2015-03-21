package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class GuardarMicrocurriculoDAOHibernate extends HibernateDaoSupport implements GuardarMicrocurriculoDAO {

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	

	@Override
	public void guardarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, List<TbMicTema> temas, 
			List<TbMicSubtema> subtemas, List<TbMicSubtemaxtema> subtemaxTema,
			List<TbMicTemaxunidad> temasxunidad,List<TbMicUnidad> unidades, 
			List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivo> objetivos,
			List<TbMicObjetivoxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro)
			throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(microcurriculo);
			session.saveOrUpdate(microxEstado);
			
			if (unidades != null){
				for(TbMicUnidad unidad:unidades)
					session.save(unidad);
			}
			
			if (temas != null){
				for(TbMicTema tema:temas)
					session.save(tema);	
			}
			
			if (objetivos != null){
				for(TbMicObjetivo objetivo:objetivos)
					session.save(objetivo);	
			}
			
			if (evaluaciones != null){
				for(TbMicEvaluacion evalua:evaluaciones)
					session.save(evalua);
			}
			
			if (subtemas != null){
				for(TbMicSubtema subtema:subtemas)
					session.save(subtema);
			}
			
			if (bibliografia != null){
				for(TbMicBibliografia biblio:bibliografia)
					session.save(biblio);	
			}
			
			if (unidadesxmicro != null){
				for(TbMicUnidadxmicro unidadxmicro:unidadesxmicro)
					session.save(unidadxmicro);	
			}
			
			if(objetivosxmicro != null){
				for(TbMicObjetivoxmicro objetivoxmicro:objetivosxmicro)
					session.save(objetivoxmicro);	
			}
			
			if (temasxunidad != null){
				for(TbMicTemaxunidad temasxUnidad:temasxunidad)
					session.save(temasxUnidad);	
			}
			
			if (evaluacionxMicro != null){
				for(TbMicEvaluacionxmicro exM : evaluacionxMicro)
					session.save(exM);			
			}
			
			if (subtemaxTema != null){
				for(TbMicSubtemaxtema sxT : subtemaxTema)
					session.save(sxT);
			}
			
			if(biblioxunidad != null){
				for (TbMicBiblioxunidad bxU : biblioxunidad)
					session.save(bxU);
			}
					
			tx.commit();			
		} catch (HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("Error al guardar"+" --- "+e.getMessage()+" --- "+e.getCause());
//			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
//					"Los Cambios realizados en la Base de Datos fueron Revertidos Satisfactoriamente.   "+e.getMessage());
		} finally {
			session.close();
		}
	}


	@Override
	public void actualizarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, List<TbMicTema> temas,
			List<TbMicSubtema> subtemas, List<TbMicSubtemaxtema> subtemaxTema,
			List<TbMicTemaxunidad> temasxunidad, List<TbMicUnidad> unidades,
			List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivo> objetivos,
			List<TbMicObjetivoxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro) throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = getSession();
			tx = session.beginTransaction();
			
			session.update(microcurriculo);
			session.update(microxEstado);
			
			if (unidades != null){
				for(TbMicUnidad unidad:unidades)
					session.saveOrUpdate(unidad);
			}
			
			if (temas != null){
				for(TbMicTema tema:temas)
					session.saveOrUpdate(tema);	
			}
			
			if (objetivos != null){
				for(TbMicObjetivo objetivo:objetivos)
					session.saveOrUpdate(objetivo);	
			}
			
			if (evaluaciones != null){
				for(TbMicEvaluacion evalua:evaluaciones)
					session.saveOrUpdate(evalua);
			}
			
			if (subtemas != null){
				for(TbMicSubtema subtema:subtemas)
					session.saveOrUpdate(subtema);
			}
			
			if (bibliografia != null){
				for(TbMicBibliografia biblio:bibliografia)
					session.saveOrUpdate(biblio);	
			}
			
			if (unidadesxmicro != null){
				for(TbMicUnidadxmicro unidadxmicro:unidadesxmicro)
					session.saveOrUpdate(unidadxmicro);	
			}
			
			if(objetivosxmicro != null){
				for(TbMicObjetivoxmicro objetivoxmicro:objetivosxmicro)
					session.saveOrUpdate(objetivoxmicro);	
			}
			
			if (temasxunidad != null){
				for(TbMicTemaxunidad temasxUnidad:temasxunidad)
					session.saveOrUpdate(temasxUnidad);	
			}
			
			if (evaluacionxMicro != null){
				for(TbMicEvaluacionxmicro exM : evaluacionxMicro)
					session.saveOrUpdate(exM);			
			}
			
			if (subtemaxTema != null){
				for(TbMicSubtemaxtema sxT : subtemaxTema)
					session.saveOrUpdate(sxT);
			}
			
			if(biblioxunidad != null){
				for (TbMicBiblioxunidad bxU : biblioxunidad)
					session.saveOrUpdate(bxU);
			}
					
			tx.commit();			
		} catch (HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("Error al guardar"+" --- "+e.getMessage()+" --- "+e.getCause());
//			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
//					"Los Cambios realizados en la Base de Datos fueron Revertidos Satisfactoriamente.   "+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	
}
