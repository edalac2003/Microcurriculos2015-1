package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadAcademicaDAO {
	
	public void guardarUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesDAO;
	
	public void guardarListadoUnidad(List<TbAdmUnidadAcademica> lista) throws ExcepcionesDAO;
	
	public TbAdmUnidadAcademica obtenerUnidad(String idUnidad) throws ExcepcionesDAO;
	
	public void modificarUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesDAO;
	
	public List<TbAdmUnidadAcademica> listarUnidades() throws ExcepcionesDAO;
	
}
