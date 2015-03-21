package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicPensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PensumNGC {
	
	public TbMicPensum obtenerPensum (int idPensum) throws ExcepcionesLogica;
	public void guardarPensum (TbMicPensum pensum) throws ExcepcionesLogica;
    public void actualizarPensum (TbMicPensum pensum) throws ExcepcionesLogica;
    public List<TbMicPensum> listarPensum () throws ExcepcionesLogica;

}
