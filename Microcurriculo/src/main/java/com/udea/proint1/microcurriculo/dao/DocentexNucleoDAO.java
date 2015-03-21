package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentexnucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DocentexNucleoDAO {

	public void guardarDocentesxNucleo(TbAdmDocentexnucleo docentesxNucleo) throws ExcepcionesDAO;
	
	public TbAdmDocentexnucleo obtenerDocentesxNucleo(int id) throws ExcepcionesDAO;
	
	public List<TbAdmDocentexnucleo> listarDocentesxNucleo() throws ExcepcionesDAO;
	
	public void actualizarDocentesxNucleo(TbAdmDocentexnucleo docentesxNucleo) throws ExcepcionesDAO;
}
