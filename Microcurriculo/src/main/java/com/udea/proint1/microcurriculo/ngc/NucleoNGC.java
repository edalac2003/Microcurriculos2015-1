package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface NucleoNGC {
	
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public  void guardarListadoNucleo(List<TbAdmNucleo> lista) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleosPorDependencia(String dependencia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmNucleo> buscarNucleos(String buscar)throws ExcepcionesLogica, ExcepcionesDAO;

}
