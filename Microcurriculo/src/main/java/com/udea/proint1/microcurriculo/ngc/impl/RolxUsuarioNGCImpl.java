package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class RolxUsuarioNGCImpl implements RolxUsuarioNGC {


	RolxUsuarioDAO rolxPersonaDao;
	
	public void setRolxPersonaDao(RolxUsuarioDAO rolxPersonaDao) {
		this.rolxPersonaDao = rolxPersonaDao;
	}
	
	
	@Override
	public void guardarRolxUsuario() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TbAdmRolxUsuario obtenerRolxUsuario(TbAdmUsuario usuario)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmRolxUsuario> listarRolxPersona() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}


}
