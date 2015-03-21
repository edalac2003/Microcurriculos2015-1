package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentexnucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DocentexNucleoNGC {
	
	public void guardarDocentexNucleo(TbAdmDocentexnucleo docentexNucleo) throws ExcepcionesLogica;
	
	public void actualizarDocentexNucleo(TbAdmDocentexnucleo docentexNucleo) throws ExcepcionesLogica;

	public List<TbAdmDocentexnucleo> listarDocentesxNucleo() throws ExcepcionesLogica;
	
	public TbAdmDocentexnucleo obtenerDocentexNucleo(int id) throws ExcepcionesLogica;
}
