package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UsuarioDAO {

	public void guardarUsuarios(TbAdmUsuario usuario) throws ExcepcionesDAO;
	
	public TbAdmUsuario obtenerUsuarios(int id) throws ExcepcionesDAO;
	
	public List<TbAdmUsuario> listarUsuarios() throws ExcepcionesDAO;
	
	public void actualizarUsuarios(TbAdmUsuario usuario) throws ExcepcionesDAO;
}
