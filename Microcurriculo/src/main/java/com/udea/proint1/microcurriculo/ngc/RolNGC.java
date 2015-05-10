package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface RolNGC {
	
	public TbAdmRol obtenerRol(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmRol> listarRoles() throws ExcepcionesLogica, ExcepcionesDAO;

}
