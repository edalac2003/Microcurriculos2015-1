package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriaxPensumNGC {
	
	public TbMicMateriaxpensum obtenerMateriasxpensum (int id) throws ExcepcionesLogica;
	
	public void guardarMateriasxpensum (TbMicMateriaxpensum materiasxPensum) throws ExcepcionesLogica;
	
    public void actualizarMateriasxpensum (TbMicMateriaxpensum materiasxPensum) throws ExcepcionesLogica;
    
    public List<TbMicMateriaxpensum> listarMateriasxpensum () throws ExcepcionesLogica;

}
