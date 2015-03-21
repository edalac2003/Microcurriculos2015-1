package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EvaluacionxMicroNGC {

	public void guardarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica;
	
	public void actualizarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica;

	public TbMicEvaluacionxmicro obtenerEvaluacionxmicro(int id) throws ExcepcionesLogica;
	
	public List<TbMicEvaluacionxmicro> actualizarEvaluacionesxmicro() throws ExcepcionesLogica;
	
//	public int obtenerRegistros() throws ExcepcionesLogica;
	
	public List<TbMicEvaluacionxmicro> ListarEvaluacionxMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
}
