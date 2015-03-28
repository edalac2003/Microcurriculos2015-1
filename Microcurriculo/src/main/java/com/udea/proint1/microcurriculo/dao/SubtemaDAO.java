package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface SubtemaDAO {

	public void guardarSubtema(TbMicSubtema subtema) throws ExcepcionesDAO;
	
	public void modificarSubtema(TbMicSubtema tema) throws ExcepcionesDAO;
	
	public TbMicSubtema obtenerSubtemas(int idSubtema) throws ExcepcionesDAO;
	
	public List<TbMicSubtema> listarSubtemas() throws ExcepcionesDAO;
	
	public List<TbMicSubtema> listarSubtemasxTema(TbMicTema tema) throws ExcepcionesDAO;
	
	public void eliminarSubtema(TbMicSubtema subtema) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
}
