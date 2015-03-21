package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PrerrequisitoDAO {
	
	public List<TbAdmPrerrequisito> listarPrerrequisitosxMateria(TbAdmMateria materia) throws ExcepcionesDAO;
	
	public List<TbAdmPrerrequisito> listarPrerrequisitos() throws ExcepcionesDAO;
	
	public TbAdmPrerrequisito obtenerPrerrequisito(int id) throws ExcepcionesDAO;
	
	public void guardarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesDAO;
	
	public void actualizarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesDAO;

}
