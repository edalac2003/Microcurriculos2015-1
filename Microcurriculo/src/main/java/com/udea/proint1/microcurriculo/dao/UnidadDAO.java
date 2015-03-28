package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadDAO {
	
	public void guardarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO;
	
	public TbMicUnidad obtenerUnidad(int idUnidad) throws ExcepcionesDAO;
	
	public void modificarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO;
	
	public List<TbMicUnidad> listarUnidades() throws ExcepcionesDAO;
	
	public void eliminarUnidad(TbMicUnidad unidad) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;

}
