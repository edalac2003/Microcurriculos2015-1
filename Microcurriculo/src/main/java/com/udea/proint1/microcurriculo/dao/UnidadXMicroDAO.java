package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadXMicroDAO {

	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO;
	
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO;
	
	public TbMicUnidadxmicro obtenerUnidadXmicro(int idUnidad) throws ExcepcionesDAO;
	
	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicUnidadxmicro> listarUnidadesXmicro() throws ExcepcionesDAO;
	
	public void eliminarUnidadxmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO;
	
//	public int contarRegistros() throws ExcepcionesDAO;
	
}
