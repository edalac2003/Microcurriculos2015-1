package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SubtemaxTemaNGC {

	public void guardar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesLogica;
	
	public void modificar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesLogica;
	
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema) throws ExcepcionesLogica;
	
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema) throws ExcepcionesLogica;
	
	public List<TbMicSubtemaxtema> listarSubtemaxTema() throws  ExcepcionesLogica;
	
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(int idTema) throws  ExcepcionesLogica;
	
//	public int contarRegistros() throws  ExcepcionesLogica;
}
