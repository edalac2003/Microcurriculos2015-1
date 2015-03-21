package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmAuditoria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface AuditoriaDAO {

	public void guardarAuditoria(TbAdmAuditoria auditoria) throws ExcepcionesDAO;
	
	public TbAdmAuditoria obtenerAuditoria(int id) throws ExcepcionesDAO;
	
	public List<TbAdmAuditoria> listarAuditoria() throws ExcepcionesDAO;
	
	public void actualizarAuditoria(TbAdmAuditoria auditoria) throws ExcepcionesDAO;
	
}
