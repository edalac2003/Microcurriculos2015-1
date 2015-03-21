package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriaxPensumDAO {
	
	public void guardarMateriasxPensum(TbMicMateriaxpensum materiasxPensum) throws ExcepcionesDAO;
	
	public TbMicMateriaxpensum obtenerMateriasxPensum(int id) throws ExcepcionesDAO;
	
	public List<TbMicMateriaxpensum> listarMateriasxPensum() throws ExcepcionesDAO;
	
	public void actualizarMateriasxPensum(TbMicMateriaxpensum materiasxPensum) throws ExcepcionesDAO;
}
