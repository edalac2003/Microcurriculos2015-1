package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PrerrequisitoNGC {
	
	public void guardarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void actualizarPrerrequisito(TbAdmPrerrequisito prerrequisito) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmPrerrequisito> listarPrerrequisitos() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbAdmPrerrequisito obtenerPrerrequisito(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmPrerrequisito> listarPrerrequisitosxMateria(String id) throws ExcepcionesLogica, ExcepcionesDAO;

}
