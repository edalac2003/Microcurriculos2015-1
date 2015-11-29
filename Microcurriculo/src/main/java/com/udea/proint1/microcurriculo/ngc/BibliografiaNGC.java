package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BibliografiaNGC {

	public void guardarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void modificarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicBibliografia> listarBibliografia(char tipo) throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesLogica, ExcepcionesDAO;
}
