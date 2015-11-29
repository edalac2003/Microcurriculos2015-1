package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionDAO;
import com.udea.proint1.microcurriculo.dao.EvaluacionxMicroDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionxMicroNGCImpl implements EvaluacionxMicroNGC {
	
	@SuppressWarnings("unused")
	private static Logger log=Logger.getLogger(EvaluacionNGCImpl.class);
	
	MicrocurriculoDAO microcurriculoDao;
	EvaluacionDAO evaluacionDao;
	EvaluacionxMicroDAO evaluacionxMicroDao;

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	public void setEvaluacionDao(EvaluacionDAO evaluacionDao) {
		this.evaluacionDao = evaluacionDao;
	}

	public void setEvaluacionxMicroDao(EvaluacionxMicroDAO evaluacionxMicroDao) {
		this.evaluacionxMicroDao = evaluacionxMicroDao;
	}

	
	
	@Override
	public void guardarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacionxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo guardar, El objeto Evaluacion x Microcurriculo esta vacio");
			throw expLog;
		}
//		try {
//			int id = evaluacionxMicro.getNbId();
//			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
//		
//			if(evaluacionxMicroConsulta != null){
//				throw new ExcepcionesLogica("La evaluacionxMicro a insertar ya existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
//		}
		
		try {
			
			evaluacionxMicroDao.guardarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo guardar Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public void actualizarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacionxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo modificar, el objeto Evaluacion x Microcurriculo esta vacio");
			throw expLog;
		}
		try {
			int id = evaluacionxMicro.getNbId();
			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
		
			if(evaluacionxMicroConsulta == null){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("La Evaluacion x Microcurriculo a actualizar no existe");
				throw expLog;
			}
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			
			evaluacionxMicroDao.actualizarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo actualizar Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

	@Override
	public TbMicEvaluacionxmicro obtenerEvaluacionxmicro(int id) throws ExcepcionesLogica, ExcepcionesDAO {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se pudo consultar Evaluacion x Microcurriculo, no se ha encontrado id de consulta");
			throw expLog;
		}
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		try {
			evaluacionxMicro = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(evaluacionxMicro == null){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("No se encontró Evaluacion x Microcurriculo con Id");
			throw expLog;
		}else{
			return evaluacionxMicro;
		}
	}

	@Override
	public List<TbMicEvaluacionxmicro> actualizarEvaluacionesxmicro() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicEvaluacionxmicro> listaEvaluacionesxMicro = null;
		try {
			listaEvaluacionesxMicro = evaluacionxMicroDao.listarEvaluacionesxmicro();
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Evaluaciones x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEvaluacionesxMicro == null){
			throw new ExcepcionesLogica("No se encontraron EvaluacionesxMicro en la tabla TbMicEvaluacionesxmicro");
		}else{
			return listaEvaluacionesxMicro;
		}
	}

//	@Override
//	public int obtenerRegistros() throws ExcepcionesLogica, ExcepcionesDAO {
//		int registro = 0;
//		
//		try {
//			registro = evaluacionxMicroDao.obtenerRegistro();
//		} catch (ExcepcionesDAO e) {
//			throw new ExcepcionesLogica("NGC : Error al intentar contar los Registros de la tabla <EvaluacionesxMicro>"+e.getMessage());
//		}
//		
//		return registro;
//	}
	
	@Override
	public List<TbMicEvaluacionxmicro> ListarEvaluacionxMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbMicEvaluacionxmicro> listaEvaluacionesxMicro = null;
		
		TbMicMicrocurriculo microcurriculo= null;
		
		try {
			microcurriculo = microcurriculoDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		
		try {
			listaEvaluacionesxMicro = evaluacionxMicroDao.ListarEvaluacionxMicroxMicro(microcurriculo);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo listar Evaluaciones x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en �l.
		 */
		return listaEvaluacionesxMicro;
	}
	
	@Override
	public void eliminarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO{
		try {
			evaluacionxMicroDao.eliminarEvaluacionxmicro(evaluacionxMicro);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo eliminar Evaluacion x Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
	}

}
