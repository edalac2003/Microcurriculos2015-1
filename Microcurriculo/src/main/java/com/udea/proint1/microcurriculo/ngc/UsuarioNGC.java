package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UsuarioNGC {

	public void guardarUsuarios(TbAdmUsuario usuario) throws ExcepcionesLogica;
	
	public TbAdmUsuario obtenerUsuarios(String login) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public Boolean validarPassword(String usuario, String paswword) throws ExcepcionesLogica;
	
	public Boolean existeUsuario(String login) throws ExcepcionesLogica;
	
	public List<TbAdmUsuario> listarUsuarios() throws ExcepcionesLogica;
	
	public void actualizarUsuarios(TbAdmUsuario usuario) throws ExcepcionesLogica;
	
}
