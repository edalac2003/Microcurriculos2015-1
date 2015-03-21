package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BiblioxunidadNGC {
	
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica;
	
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica;
	
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesLogica;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad() throws ExcepcionesLogica;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad) throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;

}
