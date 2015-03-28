package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObjetivoDAO {
	
	public void guardarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO;
	
	public TbMicObjetivo obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesDAO;
	
	public void modificarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivo> listarObjetivos () throws ExcepcionesDAO;
	
	public void eliminarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO;
	
//	public int numeroRegistros() throws ExcepcionesDAO;

}
