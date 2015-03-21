package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PaisNGC {
	
	public List<TbAdmPais> listarPaises() throws ExcepcionesLogica;
	
	public TbAdmPais obtenerPais(int id) throws ExcepcionesLogica;
	
}
