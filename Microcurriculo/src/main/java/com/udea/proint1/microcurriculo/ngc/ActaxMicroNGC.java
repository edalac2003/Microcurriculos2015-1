package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicActaxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ActaxMicroNGC {

	public TbMicActaxmicro obtenerActaxmicro (int id) throws ExcepcionesLogica, ExcepcionesDAO;
	
	public void guardarActaxmicro (TbMicActaxmicro actaxmicro) throws ExcepcionesLogica;
	
    public void actualizarActaxmicro (TbMicActaxmicro actaxmicro) throws ExcepcionesLogica;
    
    public List<TbMicActaxmicro> listarActaxmicro () throws ExcepcionesLogica;
	
}
