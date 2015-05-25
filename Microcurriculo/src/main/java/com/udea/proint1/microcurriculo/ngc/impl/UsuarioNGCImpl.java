package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UsuarioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.ngc.UsuarioNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UsuarioNGCImpl implements UsuarioNGC {


	private static Logger log=Logger.getLogger(UsuarioNGCImpl.class);
	
	UsuarioDAO usuarioDao;
	
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void guardarUsuarios(TbAdmUsuario usuario) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(usuario == null){
			throw new ExcepcionesLogica("El objeto usuario est� vacio");
		}
		try {
			String login = usuario.getVrLogin();
			TbAdmUsuario usuarioConsulta = usuarioDao.obtenerUsuarios(login);
		
			if(usuarioConsulta != null){
				throw new ExcepcionesLogica("El usuario a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUsuarios de la clase usuarioDao: "+ e);
		}
		
		try {
			
			usuarioDao.guardarUsuarios(usuario);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUsuarios de la clase usuarioDao: "+ e);
		}
	}

	@Override
	public TbAdmUsuario obtenerUsuarios(String login) throws ExcepcionesLogica, ExcepcionesDAO {
		TbAdmUsuario usuario = null;
		
		try {
			usuario = usuarioDao.obtenerUsuarios(login);
		} catch(ExcepcionesDAO expDAO){
			throw expDAO;
		} catch(Exception exp){
			ExcepcionesLogica expLog = new ExcepcionesLogica();
			expLog.setMsjUsuario("Error al invocar el metodo obtener Usuario");
			expLog.setMsjTecnico(exp.getMessage());
			expLog.setOrigen(exp);
			throw expLog;
		}		
		return usuario;
	}
	
	
	@Override
	public Boolean existeUsuario(String login) throws ExcepcionesLogica {
		boolean estado = false;
		TbAdmUsuario usuario = null;
		
		try {
			usuario = usuarioDao.obtenerUsuarios(login);
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (usuario != null)
			estado = true;
		
		return estado;
	}

	

	@Override
	public Boolean validarPassword(String usuario, String paswword)	throws ExcepcionesLogica {
		Boolean estado = false;
		
		return estado;
	}
	
	
	

	@Override
	public List<TbAdmUsuario> listarUsuarios() throws ExcepcionesLogica {
		List<TbAdmUsuario> listaUsuarios = null;
		try {
			listaUsuarios = usuarioDao.listarUsuarios();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUsuarios de la clase usuarioDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUsuarios == null){
			throw new ExcepcionesLogica("No se encontraron usuarios en la tabla TbAdmUsuarios");
		}else{
			return listaUsuarios;
		}
	}

	@Override
	public void actualizarUsuarios(TbAdmUsuario usuario)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(usuario == null){
			throw new ExcepcionesLogica("El objeto usuario está vacio");
		}
		try {
			String login = usuario.getVrLogin();
			TbAdmUsuario usuarioConsulta = usuarioDao.obtenerUsuarios(login);
		
			if(usuarioConsulta == null){
				throw new ExcepcionesLogica("El Usuario a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUsuarios de la clase usuarioDao: "+ e);
		}
		
		try {			
			usuarioDao.actualizarUsuarios(usuario);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarUsuarios de la clase usuarioDao: "+ e);
		}
	}

}
