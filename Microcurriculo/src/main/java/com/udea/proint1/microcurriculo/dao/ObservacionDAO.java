package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObservacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObservacionDAO {

	public void guardarObservacion(TbMicObservacion observacion) throws ExcepcionesDAO;
	
	public TbMicObservacion obtenerObservacion(int id) throws ExcepcionesDAO;
	
	public List<TbMicObservacion> listarObservacion() throws ExcepcionesDAO;
	
	public void actualizarObservacion(TbMicObservacion observacion) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
	
}
