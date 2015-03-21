package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicPensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PensumDAO {
	
	public void guardarPensum(TbMicPensum pensum) throws ExcepcionesDAO;
	
	public TbMicPensum obtenerPensum(int id) throws ExcepcionesDAO;
	
	public List<TbMicPensum> listarPensum() throws ExcepcionesDAO;
	
	public void actualizarPensum(TbMicPensum pensum) throws ExcepcionesDAO;
}
