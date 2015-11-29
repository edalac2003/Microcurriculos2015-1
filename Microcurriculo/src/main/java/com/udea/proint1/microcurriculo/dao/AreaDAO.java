package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmArea;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface AreaDAO {
	
	public void guardarArea(TbAdmArea area) throws ExcepcionesDAO;
	
	public void modificarArea(TbAdmArea area) throws ExcepcionesDAO;
	
	public TbAdmArea obtenerArea(String id) throws ExcepcionesDAO;
	
	public List<TbAdmArea> listarAreas() throws ExcepcionesDAO;
	
	public List<TbAdmArea> listarAreasPorNucleo(String nucleo) throws ExcepcionesDAO;
	

}
