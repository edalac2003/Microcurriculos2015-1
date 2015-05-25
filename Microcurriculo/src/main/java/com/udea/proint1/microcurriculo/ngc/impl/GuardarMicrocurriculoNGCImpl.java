package com.udea.proint1.microcurriculo.ngc.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
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
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class GuardarMicrocurriculoNGCImpl implements GuardarMicrocurriculoNGC {

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
	MicrocurriculoDAO microcurriculoDao;
	GuardarMicrocurriculoDAO guardarMicrocurriculoDao;
	
	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}
	
	public void setGuardarMicrocurriculoDao(GuardarMicrocurriculoDAO guardarMicrocurriculoDao) {
		this.guardarMicrocurriculoDao = guardarMicrocurriculoDao;
	}


	@Override
	public void guardarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado,
			List<TbMicTema> temas, 
			List<TbMicSubtema> subtemas,
			List<TbMicSubtemaxtema> subtemaxTema,
			List<TbMicTemaxunidad> temasxunidad, 
			List<TbMicUnidad> unidades, 
			List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivo> objetivos,
			List<TbMicObjetivoxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro,
			TbAdmHistorico historicoGuardar)
			throws ExcepcionesLogica, ExcepcionesDAO {
		
		String idMicro = microcurriculo.getVrIdmicrocurriculo();;
		TbMicMicrocurriculo consulta = null;
		
		try{
			consulta = microcurriculoDao.obtenerMicrocurriculo(idMicro);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al intentar obtener información del Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		if (consulta == null){
			try {
				guardarMicrocurriculoDao.guardarMicroxlotes(microcurriculo, microxEstado, temas, subtemas, 
						subtemaxTema, temasxunidad, unidades, unidadesxmicro, objetivos, objetivosxmicro, 
						bibliografia, biblioxunidad, evaluaciones, evaluacionxMicro, historicoGuardar);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al intentar guardar el registro del Microcurriculo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
		}else{
//			throw new ExcepcionesLogica("El Microcurriculo ya existe.");
			try {
				guardarMicrocurriculoDao.actualizarMicroxlotes(microcurriculo, microxEstado, temas, subtemas, subtemaxTema, 
						temasxunidad, unidades, unidadesxmicro, objetivos, objetivosxmicro, bibliografia, biblioxunidad, 
						evaluaciones, evaluacionxMicro);
			} catch(ExcepcionesDAO expDAO){
				throw expDAO;
			} catch(Exception exp){
				ExcepcionesLogica expLog = new ExcepcionesLogica();
				expLog.setMsjUsuario("Error al intentar guardar el registro del Microcurriculo");
				expLog.setMsjTecnico(exp.getMessage());
				expLog.setOrigen(exp);
				throw expLog;
			}
			
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
			List<TbAdmHistorico> listaObjetivosxMicroGuardar) throws ExcepcionesLogica, ExcepcionesDAO{
		try{
			guardarMicrocurriculoDao.modificarMicroxlotes(microcurriculo, microxEstado, objetivosxMicroBorrar, 
					subtemasxTemaBorrar, temasxUnidadBorrar, evaluacionesxMicroBorrar, bibliosxUnidadBorrar, 
					unidadesxMicroBorrar, objetivosxMicroGuardar, unidadesxMicroGuardar, bibliosxUnidadGuardar, 
					evaluacionesxMicroGuardar, temasxUnidadGuardar, subtemasxTemaGuardar, listaObjetivosxMicroGuardar);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error invocar metodo, actualizar Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
	}
	
	public void eliminarMicrocurridulo(TbMicMicrocurriculo microcurriculo,
			List<TbMicMicroxestado> microxEstado,
			List<TbMicSubtemaxtema> subtemasxTema,
			List<TbMicTemaxunidad> temasxUnidad,
			List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivoxmicro> objetivosxMicro,
			List<TbMicBiblioxunidad> bibliosxUnidad,
			List<TbMicEvaluacionxmicro> evaluacionesxMicro,
			List<TbAdmHistorico> historicos) throws ExcepcionesLogica, ExcepcionesDAO{
		
		try{
			guardarMicrocurriculoDao.eliminarMicrocurridulo(microcurriculo, microxEstado, 
					subtemasxTema, temasxUnidad, unidadesxmicro, objetivosxMicro, bibliosxUnidad, 
					evaluacionesxMicro, historicos);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error invocar metodo, actualizar Microcurriculo");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
	}
}
