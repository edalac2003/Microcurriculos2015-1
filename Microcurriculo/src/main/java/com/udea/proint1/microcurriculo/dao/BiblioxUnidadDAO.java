package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface BiblioxUnidadDAO {
	
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO;
	
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO;
	
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad() throws ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(TbMicUnidad unidad) throws ExcepcionesDAO;
	
	public void eliminarBiblioxunidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;

}
