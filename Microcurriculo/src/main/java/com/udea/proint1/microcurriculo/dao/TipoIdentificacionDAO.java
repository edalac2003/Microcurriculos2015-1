package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TipoIdentificacionDAO {
	
	public void guardarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO;
	
	public TbAdmTipoidentificacion obtenerTipoIdentificacion(int id) throws ExcepcionesDAO;
	
	public List<TbAdmTipoidentificacion> listarTipoIdentificacion() throws ExcepcionesDAO;
	
	public void actualizarTipoIdentificacion(TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO;
}
