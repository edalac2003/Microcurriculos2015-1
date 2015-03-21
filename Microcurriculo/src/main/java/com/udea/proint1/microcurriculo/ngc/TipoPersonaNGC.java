package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TipoPersonaNGC {
	
	/*public void guardarTipoPersona(TbAdmTipopersona tipoPersona) throws ExcepcionesLogica;
	
	public void actualizarTipoPersona(TbAdmTipopersona tipoPersona) throws ExcepcionesLogica;*/
	
	public List<TbAdmTipopersona> listarTipoPersona() throws ExcepcionesLogica;
	
	public TbAdmTipopersona obtenerTipoPersona(int id) throws ExcepcionesLogica;
}
