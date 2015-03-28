package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemaxUnidadDAO {

	public void guardarTemasXUnidad(TbMicTemaxunidad temaXunidad) throws ExcepcionesDAO;
	
	public void modificarTemasXUnidad(TbMicTemaxunidad temaXunidad) throws ExcepcionesDAO;
	
	public TbMicTemaxunidad obtenerTemaXunidad(int idTemaxUnidad) throws ExcepcionesDAO;
	
	public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(TbMicUnidad unidad) throws ExcepcionesDAO;
	
	public List<TbMicTemaxunidad> ListarTemasXunidad() throws ExcepcionesDAO;
	
	public void eliminarTemaxunidad(TbMicTemaxunidad temaXunidad) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
	
}