package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BibliografiaNGC {

	public void guardarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica;
	
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesLogica;
	
	public void modificarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica;
	
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicBibliografia> listarBibliografia(char tipo) throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;
}
