package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EvaluacionNGC {

	public void guardarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbMicEvaluacion obtenerEvaluacion(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicEvaluacion> listarEvaluacion() throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica, ExcepcionesDAO;
	
}
