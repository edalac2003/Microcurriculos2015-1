package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.RolDAO;
import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class RolxUsuarioNGCImpl implements RolxUsuarioNGC {

	private static Logger log=Logger.getLogger(RolxUsuarioNGCImpl.class);
	
	RolxUsuarioDAO rolxUsuarioDao;
	RolDAO rolDao;
	
	public void setRolxUsuarioDao(RolxUsuarioDAO rolxUsuarioDao) {
		this.rolxUsuarioDao = rolxUsuarioDao;
	}

	public void setRolDao(RolDAO rolDao) {
		this.rolDao = rolDao;
	}

	@Override
	public TbAdmRolxUsuario obtenerRolxUsuario(TbAdmUsuario usuario) throws ExcepcionesLogica, ExcepcionesDAO{
		TbAdmRolxUsuario rolxUsuario;
		try {
			rolxUsuario = rolxUsuarioDao.obtenerRolxUsuario(usuario);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Rol por Usuario");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		return rolxUsuario;
	}
	
	@Override
	public List<TbAdmRolxUsuario> listarDocentes() throws ExcepcionesLogica, ExcepcionesDAO {
		List<TbAdmRolxUsuario> listaRolesxUsuario = null;
		
		TbAdmRol rol = null;
		
		try {
			rol = rolDao.obtenerRol(4);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Rol");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		try {
			listaRolesxUsuario = rolxUsuarioDao.obtenerRolxUsuarioxRol(rol);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Rol por Usuario");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaRolesxUsuario == null){
			throw new ExcepcionesLogica("No se encontraron personas de tipo docente en la tabla personaDao");
		}else{
			return listaRolesxUsuario;
		}
	}

	@Override
	public void guardarRolxUsuario() throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub
		
	}

}
