package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CiudadNGC {
	
	public TbAdmCiudad obtenerCiudad(int id) throws ExcepcionesLogica;
	
	public List<TbAdmCiudad> listarCiudades() throws ExcepcionesLogica;
	
	public List<TbAdmCiudad> listarCiudadesxDepartamento(TbAdmDepartamento idDepartamento) throws ExcepcionesLogica;

}
