package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TipoIdentificacionNGC {
	
	public void guardarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesLogica;

	public void actualizarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesLogica;
	
	public List<TbAdmTipoidentificacion> listarTipoIdentificacion() throws ExcepcionesLogica;
	
	public TbAdmTipoidentificacion obtenerTipoIdentificacion(int id) throws ExcepcionesLogica;

}
