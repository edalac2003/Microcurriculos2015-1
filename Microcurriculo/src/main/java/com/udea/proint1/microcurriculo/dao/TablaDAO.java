package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TablaDAO {

	public void guardarTabla(TbAdmTabla tabla) throws ExcepcionesDAO;
	
	public TbAdmTabla obtenerTabla(int id) throws ExcepcionesDAO;
	
	public List<TbAdmTabla> listarTabla() throws ExcepcionesDAO;
	
	public void actualizarTabla(TbAdmTabla tabla) throws ExcepcionesDAO;
	
}
