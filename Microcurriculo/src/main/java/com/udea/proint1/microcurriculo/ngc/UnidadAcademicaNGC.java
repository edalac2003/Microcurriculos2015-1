package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadAcademicaNGC {

	public void guardarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarListadoUnidad(List<TbAdmUnidadAcademica> lista) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbAdmUnidadAcademica obtenerUnidadAcademica(String id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmUnidadAcademica> listarUnidadAcademicas() throws ExcepcionesLogica, ExcepcionesDAO;
	
}
