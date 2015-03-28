package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface SubtemaxTemaDAO {
	
	public void guardar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO;
	
	public void modificar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO;
	
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema) throws ExcepcionesDAO;
	
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema) throws ExcepcionesDAO;
	
	public List<TbMicSubtemaxtema> listarSubtemaxTema() throws ExcepcionesDAO;
	
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(TbMicTema tema) throws ExcepcionesDAO;
	
	public void eliminarSubtemaxTema(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;

}
