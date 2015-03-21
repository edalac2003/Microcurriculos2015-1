package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DependenciaNGC {
	
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;
	
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;

	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica;
	
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesLogica;

	public List<TbAdmDependencia> listarDependenciasPorUnidad(String unidad) throws ExcepcionesLogica;
	
	public List<TbAdmDependencia> listarDependenciasPorUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesLogica;
	
	public List<TbAdmDependencia> buscarDepedencias(String buscar) throws ExcepcionesLogica;
}
