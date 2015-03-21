package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface CiudadDAO {
	
	public TbAdmCiudad obtenerCiudad(int idCiudad) throws ExcepcionesDAO;
	
	public List<TbAdmCiudad> listarCiudades() throws ExcepcionesDAO;
	
	public List<TbAdmCiudad> listarCiudadesxDepartamento(TbAdmDepartamento idDepartamento) throws ExcepcionesDAO;
	
}
