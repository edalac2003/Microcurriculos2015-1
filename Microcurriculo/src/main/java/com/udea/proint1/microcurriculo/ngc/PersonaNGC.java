package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PersonaNGC {
	
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesLogica;

	public void actualizarPersona(TbAdmPersona persona) throws ExcepcionesLogica;

	public TbAdmPersona obtenerPersona(String id)throws ExcepcionesLogica;
	
	public boolean existePersona(String idPersona) throws ExcepcionesLogica;
	
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesLogica;
	
	public List<TbAdmPersona> obtenerDocentes() throws ExcepcionesLogica;

}
