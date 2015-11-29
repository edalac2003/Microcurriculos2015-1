package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/*
 * Interfaz MicrocurriculosDAO
 * 
 *  Esta Interfaz define los metodos asociados a los Microcurriculos
 *  
 *  @Author.  Grupo Proyecto Integrador I. 2014-2
 */

public interface MicrocurriculoDAO {

	public void guardarMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
	public TbMicMicrocurriculo obtenerMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public void modificarMicrocurriculo (TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculos() throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(TbAdmMateria materia) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String materia) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(TbAdmPersona responsable) throws ExcepcionesDAO;
	
//	public List<TbMicMicrocurriculo> listarMicrocurriculosPorDependencia(TbAdmDependencia dependencia) throws ExcepcionesDAO;
	
}
