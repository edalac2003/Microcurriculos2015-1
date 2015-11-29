package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EvaluacionxMicroNGC {

	public void guardarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbMicEvaluacionxmicro obtenerEvaluacionxmicro(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicEvaluacionxmicro> actualizarEvaluacionesxmicro() throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int obtenerRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicEvaluacionxmicro> ListarEvaluacionxMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
}
