package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface CorrequisitoDAO {
	
	public void guardarCorrequisito(TbAdmCorrequisito correquisitos) throws ExcepcionesDAO;
	
	public void actualizarCorrequisito(TbAdmCorrequisito correquisitos) throws ExcepcionesDAO;
	
	public TbAdmCorrequisito obtenerCorrequisitos(int id) throws ExcepcionesDAO;
	
	public List<TbAdmCorrequisito> listarCorrequisitos() throws ExcepcionesDAO;
	
	public List<TbAdmCorrequisito> listarCorrequisitosxMateria(TbAdmMateria materia) throws ExcepcionesDAO;
}
