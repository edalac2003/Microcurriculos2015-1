package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BiblioxunidadNGC {
	
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad) throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica, ExcepcionesDAO;

}
