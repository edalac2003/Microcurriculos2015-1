package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
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
			List<TbMicEvaluacionxmicro> evaluacionxMicro,
			TbAdmHistorico historicoGuardar)
			throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;

		try {
			session = getSession();
			tx = session.beginTransaction();
			
			session.saveOrUpdate(microcurriculo);
			session.saveOrUpdate(microxEstado);
			
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
			
			session.save(historicoGuardar);
					
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
		} catch (Exception e) {
			tx.rollback();
			
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar guardar Microcurriculo");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
//			throw new ExcepcionesDAO("Error al guardar"+" --- "+e.getMessage()+" --- "+e.getCause());
//			throw new ExcepcionesDAO("No fue posible guardar la informaci�n del Microcurriculo. \n Por favor verifique la informaci�n ingresada. \n" + 
//					"Los Cambios realizados en la Base de Datos fueron Revertidos Satisfactoriamente.   "+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	@Override
	public void modificarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado,
			List<TbMicObjetivoxmicro> objetivosxMicroBorrar,
			List<TbMicSubtemaxtema> subtemasxTemaBorrar,
			List<TbMicTemaxunidad> temasxUnidadBorrar,
			List<TbMicEvaluacionxmicro> evaluacionesxMicroBorrar,
			List<TbMicBiblioxunidad> bibliosxUnidadBorrar,
			List<TbMicUnidadxmicro> unidadesxMicroBorrar, 
			List<TbMicObjetivoxmicro> objetivosxMicroGuardar,
			List<TbMicUnidadxmicro> unidadesxMicroGuardar,
			List<TbMicBiblioxunidad> bibliosxUnidadGuardar,
			List<TbMicEvaluacionxmicro> evaluacionesxMicroGuardar,
			List<TbMicTemaxunidad> temasxUnidadGuardar,
			List<TbMicSubtemaxtema> subtemasxTemaGuardar,
			List<TbAdmHistorico> listaObjetivosxMicroGuardar) throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			
			session.update(microcurriculo);
			if(microxEstado != null){
				session.save(microxEstado);
			}
			
			if (objetivosxMicroBorrar != null){
				for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicroBorrar){
					session.delete(objetivoxMicro);
					session.delete(objetivoxMicro.getTbMicObjetivo());
				}
			}
			
			if (subtemasxTemaBorrar != null){
				for(TbMicSubtemaxtema subtemaxTema: subtemasxTemaBorrar){
					session.delete(subtemaxTema);
					session.delete(subtemaxTema.getTbMicSubtema());
				}
			}
			
			if (temasxUnidadBorrar != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidadBorrar){
					session.delete(temaxUnidad);
					session.delete(temaxUnidad.getTbMicTema());
				}
			}
			
			if (evaluacionesxMicroBorrar != null){
				for(TbMicEvaluacionxmicro evaluacionxMicro: evaluacionesxMicroBorrar){
					session.delete(evaluacionxMicro);
					session.delete(evaluacionxMicro.getTbMicEvaluacion());
				}
			}
			
			if (bibliosxUnidadBorrar != null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidadBorrar){
					session.delete(biblioxUnidad);
					session.delete(biblioxUnidad.getTbMicBibliografia());
				}
			}
			
			if (unidadesxMicroBorrar != null){
				for(TbMicUnidadxmicro unidadxMicro: unidadesxMicroBorrar){
					session.delete(unidadxMicro);
					session.delete(unidadxMicro.getTbMicUnidad());
				}
			}
			
			if (objetivosxMicroGuardar != null){
				for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicroGuardar){
					session.saveOrUpdate(objetivoxMicro.getTbMicObjetivo());
					session.saveOrUpdate(objetivoxMicro);
				}
			}
			
			if (unidadesxMicroGuardar != null){
				for(TbMicUnidadxmicro unidadxMicro: unidadesxMicroGuardar){
					session.saveOrUpdate(unidadxMicro.getTbMicUnidad());
					session.saveOrUpdate(unidadxMicro);
				}
			}
			
			if (bibliosxUnidadGuardar != null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidadGuardar){
					session.saveOrUpdate(biblioxUnidad.getTbMicBibliografia());
					session.saveOrUpdate(biblioxUnidad);
				}
			}
			
			if (evaluacionesxMicroGuardar != null){
				for(TbMicEvaluacionxmicro evaluacionxMicro: evaluacionesxMicroGuardar){
					session.saveOrUpdate(evaluacionxMicro.getTbMicEvaluacion());
					session.saveOrUpdate(evaluacionxMicro);
				}
			}
			
			if (temasxUnidadGuardar != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidadGuardar){
					session.saveOrUpdate(temaxUnidad.getTbMicTema());
					session.saveOrUpdate(temaxUnidad);
				}
			}
			
			if (subtemasxTemaGuardar != null){
				for(TbMicSubtemaxtema subtemaxTema: subtemasxTemaGuardar){
					session.saveOrUpdate(subtemaxTema.getTbMicSubtema());
					session.saveOrUpdate(subtemaxTema);
				}
			}
			
			if(listaObjetivosxMicroGuardar != null){
				for(TbAdmHistorico historico: listaObjetivosxMicroGuardar){
					session.saveOrUpdate(historico);
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
	
	@Override
	public void eliminarMicrocurridulo(TbMicMicrocurriculo microcurriculo,
			List<TbMicMicroxestado> microsxEstado,
			List<TbMicSubtemaxtema> subtemasxTema,
			List<TbMicTemaxunidad> temasxUnidad,
			List<TbMicUnidadxmicro> unidadesxMicro,
			List<TbMicObjetivoxmicro> objetivosxMicro,
			List<TbMicBiblioxunidad> bibliosxUnidad,
			List<TbMicEvaluacionxmicro> evaluacionesxMicro,
			List<TbAdmHistorico> historicos) throws ExcepcionesDAO{
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			
			if(historicos != null){
				for(TbAdmHistorico historico: historicos){
					session.delete(historico);
				}
			}
			
			if(microsxEstado != null){
				for(TbMicMicroxestado microxEstado: microsxEstado){
					session.delete(microxEstado);
				}
			}
			
			if (objetivosxMicro != null){
				for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
					session.delete(objetivoxMicro);
					session.delete(objetivoxMicro.getTbMicObjetivo());
				}
			}
			
			if (subtemasxTema != null){
				for(TbMicSubtemaxtema subtemaxTema: subtemasxTema){
					session.delete(subtemaxTema);
					session.delete(subtemaxTema.getTbMicSubtema());
				}
			}
			
			if (temasxUnidad != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidad){
					session.delete(temaxUnidad);
					session.delete(temaxUnidad.getTbMicTema());
				}
			}
			
			if (evaluacionesxMicro != null){
				for(TbMicEvaluacionxmicro evaluacionxMicro: evaluacionesxMicro){
					session.delete(evaluacionxMicro);
					session.delete(evaluacionxMicro.getTbMicEvaluacion());
				}
			}
			
			if (bibliosxUnidad != null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidad){
					session.delete(biblioxUnidad);
					session.delete(biblioxUnidad.getTbMicBibliografia());
				}
			}
			
			if (unidadesxMicro != null){
				for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
					session.delete(unidadxMicro);
					session.delete(unidadxMicro.getTbMicUnidad());
				}
			}
			session.delete(microcurriculo);
			
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
