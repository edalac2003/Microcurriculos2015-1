package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface NucleoDAO {
	
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public void guardarListadoNucleo(List<TbAdmNucleo> lista) throws ExcepcionesDAO;
	
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleoPorDependencia(String dependencia) throws ExcepcionesDAO;
	
	public List<TbAdmNucleo> listarNucleoPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO;
	
	public List<TbAdmNucleo> buscarNucleos(String buscar)throws ExcepcionesDAO;
}
