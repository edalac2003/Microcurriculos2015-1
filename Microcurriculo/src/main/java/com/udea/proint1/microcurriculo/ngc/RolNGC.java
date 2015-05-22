package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface RolNGC {
	public void guardarRol(TbAdmRol rol) throws ExcepcionesLogica;
	
	public TbAdmRol obtenerRol(TbAdmRol rol) throws ExcepcionesLogica;
	
	public TbAdmRol obtenerRol(Integer id) throws ExcepcionesLogica;
	
	public void eliminarRol(TbAdmRol rol) throws ExcepcionesLogica;
	
	public List<TbAdmRol> listarRoles() throws ExcepcionesLogica;

}
