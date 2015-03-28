package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivoxMicroNGC {
	
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicObjetivoxmicro obtenerObjetivosxMicroxObjetivo(int idObjetivo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicObjetivoxmicro>obtenerObjetivosxMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;

}
