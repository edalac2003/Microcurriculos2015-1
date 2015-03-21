package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface NucleoNGC {
	
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica;
	
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica;

	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesLogica;
	
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesLogica;
	
	public List<TbAdmNucleo> listarNucleosPorDependencia(String dependencia) throws ExcepcionesLogica;
	
	public List<TbAdmNucleo> listarNucleosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;
	
	public List<TbAdmNucleo> buscarNucleos(String buscar)throws ExcepcionesLogica;

}
