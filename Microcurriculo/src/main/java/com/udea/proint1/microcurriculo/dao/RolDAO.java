package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface RolDAO {
	
	public TbAdmRol obtenerRol(int id) throws ExcepcionesDAO;
	
	public List<TbAdmRol> listarRoles() throws ExcepcionesDAO;
	
}
