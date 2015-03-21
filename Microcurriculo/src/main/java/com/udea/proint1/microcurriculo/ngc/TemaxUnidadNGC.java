package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemaxUnidadNGC {
	
	public TbMicTemaxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica;
	
	public void guardarTemasxUnidad (TbMicTemaxunidad temasxUnidad) throws ExcepcionesLogica;
	
    public void actualizarTemaxUnidad (TbMicTemaxunidad temasxUnidad) throws ExcepcionesLogica;
    
    public List<TbMicTemaxunidad> listarTemasxUnidad () throws ExcepcionesLogica;
    
//    public int contarRegistros() throws ExcepcionesLogica;
    
    public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(int idUnidad) throws ExcepcionesLogica;

}
