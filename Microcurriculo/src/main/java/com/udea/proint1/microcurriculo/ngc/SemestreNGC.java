package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SemestreNGC {

	public void guardarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica, ExcepcionesDAO;

	public void actualizarSemestre(TbAdmSemestre semestre) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbAdmSemestre obtenerSemestre(String id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmSemestre> listarSemestres() throws ExcepcionesLogica, ExcepcionesDAO;
}
