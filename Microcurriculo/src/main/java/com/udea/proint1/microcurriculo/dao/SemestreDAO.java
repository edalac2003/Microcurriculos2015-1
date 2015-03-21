package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface SemestreDAO {
	
	public void guardarSemestre(TbAdmSemestre semestre) throws ExcepcionesDAO;
	
	public void modificarSemestre(TbAdmSemestre semestre) throws ExcepcionesDAO;
	
	public List<TbAdmSemestre> listarSemestres() throws ExcepcionesDAO;
	
	public TbAdmSemestre obtenerSemestre(String id) throws ExcepcionesDAO;
	
}
