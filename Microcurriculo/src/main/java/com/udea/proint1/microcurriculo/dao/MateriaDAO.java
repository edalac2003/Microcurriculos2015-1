package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriaDAO {
	
	public void guardarMateria(TbAdmMateria materia) throws ExcepcionesDAO;
	
	public TbAdmMateria obtenerMateria(String id) throws ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMaterias() throws ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasPorNucleo(String nucleo) throws ExcepcionesDAO;
	
	public List<TbAdmMateria> listarMateriasPorSemestre(int semestre) throws ExcepcionesDAO;
	
	public void actualizarMateria(TbAdmMateria materia) throws ExcepcionesDAO;
	
	public List<TbAdmMateria> buscarMaterias(String buscar) throws ExcepcionesDAO;
	
	public List<String> listarIdMateriasxDependencia(String idDependencia) throws ExcepcionesDAO;
}
