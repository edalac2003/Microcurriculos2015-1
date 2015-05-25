package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PersonaNGC {
	
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesLogica, ExcepcionesDAO;

	public void actualizarPersona(TbAdmPersona persona) throws ExcepcionesLogica, ExcepcionesDAO;

	public TbAdmPersona obtenerPersona(String id)throws ExcepcionesLogica, ExcepcionesDAO;
	
	public boolean existePersona(String idPersona) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public List<TbAdmPersona> obtenerDocentes() throws ExcepcionesLogica, ExcepcionesDAO;

}
