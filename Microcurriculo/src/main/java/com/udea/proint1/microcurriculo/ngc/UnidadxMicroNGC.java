package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadxMicroNGC {

	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesLogica, ExcepcionesDAO;
		
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbMicUnidadxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica, ExcepcionesDAO;

	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbMicUnidadxmicro> listarUnidadesXmicro() throws ExcepcionesLogica, ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void eliminarUnidadxmicro(TbMicUnidadxmicro unidadxmicro) throws ExcepcionesLogica, ExcepcionesDAO;
}
