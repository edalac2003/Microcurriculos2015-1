package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CorrequisitoNGC {
	
	public void guardarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica;
	
	public void actualizarCorrequisito(TbAdmCorrequisito correquisito) throws ExcepcionesLogica;
	
	public List<TbAdmCorrequisito> listarCorrequisitos() throws ExcepcionesLogica;
	
	public TbAdmCorrequisito obtenerCorrequisito(int id) throws ExcepcionesLogica;
	
	public List<TbAdmCorrequisito> listarCorrequisitosxMateria(String id) throws ExcepcionesLogica;
}
