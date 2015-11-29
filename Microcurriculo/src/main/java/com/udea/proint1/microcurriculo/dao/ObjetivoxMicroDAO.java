package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
//import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivoxMicroDAO {
	
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesDAO;
	
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesDAO;
	
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesDAO;
	
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxObjetivo(TbMicObjetivo idObjetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxMicro(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro() throws ExcepcionesDAO;
	
	public void eliminarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
	
}
