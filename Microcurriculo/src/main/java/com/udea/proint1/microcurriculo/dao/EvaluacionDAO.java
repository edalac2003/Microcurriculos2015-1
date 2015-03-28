package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface EvaluacionDAO {

	public void guardarEvaluaciones(TbMicEvaluacion evaluacion) throws ExcepcionesDAO;
	
	public TbMicEvaluacion obtenerEvaluaciones(int id) throws ExcepcionesDAO;
	
	public List<TbMicEvaluacion> listarEvaluaciones() throws ExcepcionesDAO;
	
	public void actualizarEvaluaciones(TbMicEvaluacion evaluacion) throws ExcepcionesDAO;
	
	public void eliminarEvaluacion(TbMicEvaluacion evaluacion) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
}
