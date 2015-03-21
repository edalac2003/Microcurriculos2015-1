package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EvaluacionNGC {

	public void guardarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica;
	
	public void actualizarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesLogica;

	public TbMicEvaluacion obtenerEvaluacion(int id) throws ExcepcionesLogica;
	
	public List<TbMicEvaluacion> listarEvaluacion() throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;
	
}
