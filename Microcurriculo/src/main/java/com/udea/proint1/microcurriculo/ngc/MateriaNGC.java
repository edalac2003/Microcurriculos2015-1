package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriaNGC {

	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbAdmMateria obtenerMateria(String id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasxNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesLogica, ExcepcionesDAO;
	
}
