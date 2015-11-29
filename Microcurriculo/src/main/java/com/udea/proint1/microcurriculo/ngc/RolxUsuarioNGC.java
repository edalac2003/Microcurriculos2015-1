package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface RolxUsuarioNGC {
	
	public void guardarRolxUsuario() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbAdmRolxUsuario obtenerRolxUsuario(TbAdmUsuario usuario) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmRolxUsuario> listarDocentes() throws ExcepcionesLogica, ExcepcionesDAO;
}
