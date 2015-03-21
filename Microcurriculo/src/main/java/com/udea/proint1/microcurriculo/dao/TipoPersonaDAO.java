package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TipoPersonaDAO {
	
	public TbAdmTipopersona obtenerTipoPersona(int id) throws ExcepcionesDAO;
	
	public List<TbAdmTipopersona> listarTipoPersonas() throws ExcepcionesDAO;

}
