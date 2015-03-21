package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivoxMicroNGC {
	
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica;
	
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica;
	
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesLogica;
	
	public TbMicObjetivoxmicro obtenerObjetivosxMicroxObjetivo(int idObjetivo) throws ExcepcionesLogica;
	
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro() throws ExcepcionesLogica;
	
	public List<TbMicObjetivoxmicro>obtenerObjetivosxMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;

}
