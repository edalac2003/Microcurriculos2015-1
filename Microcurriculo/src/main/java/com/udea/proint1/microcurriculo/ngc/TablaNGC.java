package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTabla;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TablaNGC {

	public TbAdmTabla obtenerTabla (int id) throws ExcepcionesLogica;
	
	public void guardarTabla (TbAdmTabla tabla) throws ExcepcionesLogica;
	
    public void actualizarTabla (TbAdmTabla tabla) throws ExcepcionesLogica;
    
    public List<TbAdmTabla> listarTabla () throws ExcepcionesLogica;
	
}
