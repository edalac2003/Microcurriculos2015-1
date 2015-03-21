package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadAcademicaNGC {

	public void guardarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica;
	
	public void actualizarUnidadAcademica(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesLogica;

	public TbAdmUnidadAcademica obtenerUnidadAcademica(String id) throws ExcepcionesLogica;
	
	public List<TbAdmUnidadAcademica> listarUnidadAcademicas() throws ExcepcionesLogica;
	
}
