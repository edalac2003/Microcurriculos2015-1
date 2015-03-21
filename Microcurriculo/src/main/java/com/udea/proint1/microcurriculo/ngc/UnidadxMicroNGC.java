package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadxMicroNGC {

	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesLogica;
		
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesLogica;
	
	public TbMicUnidadxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica;

	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicUnidadxmicro> listarUnidadesXmicro() throws ExcepcionesLogica;
	
//	public int contarRegistros() throws ExcepcionesLogica;
}
