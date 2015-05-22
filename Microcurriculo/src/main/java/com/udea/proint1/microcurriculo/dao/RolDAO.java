package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface RolDAO {
	
	public void guardarRol(TbAdmRol rol) throws ExcepcionesDAO;
	
	public TbAdmRol obtenerRol(TbAdmRol rol) throws ExcepcionesDAO;
	
	public TbAdmRol obtenerRol(Integer id) throws ExcepcionesDAO;
	
	public void eliminarRol(TbAdmRol rol) throws ExcepcionesDAO;
	
	public List<TbAdmRol> listarRoles() throws ExcepcionesDAO;

}
