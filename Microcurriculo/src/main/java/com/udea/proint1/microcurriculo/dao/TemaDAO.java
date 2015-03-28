package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemaDAO {
	
	public void guardarTema(TbMicTema tema) throws ExcepcionesDAO;

	public void modificarTema(TbMicTema tema) throws ExcepcionesDAO;
	
	public TbMicTema obtenerTema(int idTema) throws ExcepcionesDAO;
	
	public List<TbMicTema> obtenerTemaxNombre(String nombre) throws ExcepcionesDAO;
	
	public List<TbMicTema> listarTemas() throws ExcepcionesDAO;
	
	public void eliminarTema(TbMicTema tema) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
	

}

