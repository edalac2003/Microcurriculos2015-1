package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface RolxUsuarioDAO {
	
	public void guardarRolxUsuario() throws ExcepcionesDAO;
	
	public TbAdmRolxUsuario obtenerRolxUsuario(TbAdmUsuario usuario) throws ExcepcionesDAO;
	
	public List<TbAdmRolxUsuario> obtenerRolxUsuarioxRol(TbAdmRol rol) throws ExcepcionesDAO;
}
