package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PaisDAO {
	
	public TbAdmPais obtenerPais(int idPais) throws ExcepcionesDAO;

	public List<TbAdmPais> listarPaises() throws ExcepcionesDAO;
}
