package com.udea.proint1.microcurriculo.ngc.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
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
			List<TbMicEvaluacionxmicro> evaluacionxMicro)
			throws ExcepcionesLogica {
		
		String idMicro = microcurriculo.getVrIdmicrocurriculo();;
		TbMicMicrocurriculo consulta = null;
		
		try{
			consulta = microcurriculoDao.obtenerMicrocurriculo(idMicro);
		}catch(ExcepcionesDAO e){
			logger.error("Error al intentar Obtener la informacion del registro de Microcurriculo.",e);
		}
		
		if (consulta == null){
			try {
				guardarMicrocurriculoDao.guardarMicroxlotes(microcurriculo, microxEstado, temas, subtemas, 
						subtemaxTema, temasxunidad, unidades, unidadesxmicro, objetivos, objetivosxmicro, 
						bibliografia, biblioxunidad, evaluaciones, evaluacionxMicro);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar Guardar el registro de Microcurriculo."+e.getMessage());
			}
		}else{
//			throw new ExcepcionesLogica("El Microcurriculo ya existe.");
			try {
				guardarMicrocurriculoDao.actualizarMicroxlotes(microcurriculo, microxEstado, temas, subtemas, subtemaxTema, 
						temasxunidad, unidades, unidadesxmicro, objetivos, objetivosxmicro, bibliografia, biblioxunidad, 
						evaluaciones, evaluacionxMicro);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar Guardar el registro de Microcurriculo."+e.getMessage());
			}
			
		}
	}
}
