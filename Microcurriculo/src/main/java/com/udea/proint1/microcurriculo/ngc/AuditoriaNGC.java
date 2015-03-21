package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmAuditoria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AuditoriaNGC {

	public TbAdmAuditoria obtenerAuditoria (int id) throws ExcepcionesLogica;
	
	public void guardarAuditoria (TbAdmAuditoria auditoria) throws ExcepcionesLogica;
	
    public void actualizarAuditoria (TbAdmAuditoria auditoria) throws ExcepcionesLogica;
    
    public List<TbAdmAuditoria> listarAuditoria () throws ExcepcionesLogica;
	
}
