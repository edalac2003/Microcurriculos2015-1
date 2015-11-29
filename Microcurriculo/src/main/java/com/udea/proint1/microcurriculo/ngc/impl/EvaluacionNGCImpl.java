package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.ngc.EvaluacionNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionNGCImpl implements EvaluacionNGC {
	
	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(EvaluacionNGCImpl.class);
	
	EvaluacionDAO evaluacionDao;

	public void setEvaluacionDao(EvaluacionDAO evaluacionDao) {
		this.evaluacionDao = evaluacionDao;
	}

	@Override
	public void guardarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Evaluacion esta vacio");
			throw expLog;
		}
//		try {
//			int id = evaluacion.getNbIdevaluacion();
//			TbMicEvaluacion evaluacionConsulta = evaluacionDao.obtenerEvaluaciones(id);
//		
//			if(evaluacionConsulta != null){
//				throw new ExcepcionesLogica("La evaluacion a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionDao: "+ e);
//		}
		
		try {
			
			evaluacionDao.guardarEvaluaciones(evaluacion);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Evaluacion");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Evaluacion esta vacio");
			throw expLog;
		}
		try {
			int id = evaluacion.getNbIdevaluacion();
			TbMicEvaluacion evaluacionConsulta = evaluacionDao.obtenerEvaluaciones(id);
		
			if(evaluacionConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Evaluacion a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo consultar Evaluacion");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			evaluacionDao.actualizarEvaluaciones(evaluacion);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Evaluacion");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicEvaluacion obtenerEvaluacion(int id) throws ExcepcionesLogica, ExcepcionesDAO{
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Evaluacion, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicEvaluacion evaluacion = null;
		
		try {
			evaluacion = evaluacionDao.obtenerEvaluaciones(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Evaluacion");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(evaluacion == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Evaluacion con Id");
			throw expLog;
		}else{
			return evaluacion;
		}
	}

	@Override
	public List<TbMicEvaluacion> listarEvaluacion() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicEvaluacion> listaEvaluaciones = null;
		try {
			listaEvaluaciones = evaluacionDao.listarEvaluaciones();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Evaluaciones");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEvaluaciones == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontraron datos en listado de Evaluaciones");
			throw expLog;
		}else{
			return listaEvaluaciones;
		}
	}

//	@Override
//	public int contarRegistros() throws ExcepcionesLogica {
//		int registros = 0;
//			
//		try {
//			registros = evaluacionDao.contarRegistros();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Se presentaron errores al intentar Obtener el numero de Registros de la Tabla Evaluaciones.");
//		}
//		return registros;
//	}
	
	@Override
	public void eliminarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			evaluacionDao.eliminarEvaluacion(evaluacion);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Evaluacion");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}
