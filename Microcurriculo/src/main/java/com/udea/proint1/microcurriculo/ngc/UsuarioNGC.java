package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UsuarioNGC {

	public void guardarUsuarios(TbAdmUsuario usuario) throws ExcepcionesLogica;
	
	public TbAdmUsuario obtenerUsuarios(int id) throws ExcepcionesLogica;
	
	public List<TbAdmUsuario> listarUsuarios() throws ExcepcionesLogica;
	
	public void actualizarUsuarios(TbAdmUsuario usuario) throws ExcepcionesLogica;
	
}
