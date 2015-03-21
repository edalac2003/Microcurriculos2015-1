package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriaNGC {

	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesLogica;
	
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesLogica;
	
	public TbAdmMateria obtenerMateria(String id) throws ExcepcionesLogica;
	
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesLogica;
	
	public List<TbAdmMateria> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica;
	
	public List<TbAdmMateria> listarMateriasxNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica;
	
	public List<TbAdmMateria> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica;
	
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesLogica;
	
}
