package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmArea;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AreaNGC {
	
	public void guardarArea(TbAdmArea area) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void modificarArea(TbAdmArea area) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public TbAdmArea obtenerArea(String id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmArea> listarAreas() throws ExcepcionesLogica, ExcepcionesDAO;
	
	public List<TbAdmArea> listarAreasPorNucleo(String nucleo) throws ExcepcionesLogica, ExcepcionesDAO;
}
