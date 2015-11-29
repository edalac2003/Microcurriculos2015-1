package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
//import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PersonaDAO {

	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesDAO;
	
	public void modificarPersona(TbAdmPersona persona) throws ExcepcionesDAO;
	
	public TbAdmPersona obtenerPersona(String idPersona) throws ExcepcionesDAO;
	
	public boolean existePersona(String idPersona) throws ExcepcionesDAO;
	
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesDAO;
	
	public List<TbAdmPersona> obtenerDocentes(TbAdmRol rol) throws ExcepcionesDAO;	
}
