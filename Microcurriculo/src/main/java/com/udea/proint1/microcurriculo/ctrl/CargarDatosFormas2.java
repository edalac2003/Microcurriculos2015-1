package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Gestiona la carga de datos a las vistas: listado, duplicado y consulta de microcurriculos.
 * @author Elmer Urrea & Edwin Acosta
 *  prueba para jenkins 2
 */
@SuppressWarnings("rawtypes")
public class CargarDatosFormas2 extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CargarDatosFormas2.class);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
	Combobox cmbUnidadAcademica2;
	Combobox cmbDependencia2;
	Combobox cmbNucleo2;
	Combobox cmbMateria2;
	Combobox cmbMicrocurriculo2;
	Combobox cmbDocente;
	Combobox cmbEstado;
	
	Listbox listaMicrocurriculo;
	
	Toolbarbutton tool_duplica;
	
	/**
	 * Listados para manejar las consultas
	 */

	public static List<TbAdmUnidadAcademica> listaUnidadAcademica;
	public static List<TbAdmDependencia> listaDependencias;
	public static List<TbAdmNucleo> listaNucleos;
	public static List<TbAdmMateria> listaMaterias;
	public static List<TbAdmPersona> listaDocentes;
	public static List<TbAdmSemestre> listaSemestre;
	public static List<TbMicEstado> listaEstados;
	public static List<TbMicMicrocurriculo> listaMicrocurriculos;
	
	Label lblEncabezadoMicro;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	PaisNGC paisNGC;
	EstadoNGC estadoNGC;
	RolxUsuarioNGC rolxUsuarioNGC;
	
	public void setRolxUsuarioNGC(RolxUsuarioNGC rolxUsuarioNGC) {
		this.rolxUsuarioNGC = rolxUsuarioNGC;
	}

	/**
	 * Metodo set para inyeccion de dependencia spring para unidades academicas en la capa del negocio
	 * @param unidadAcademicaNGC objeto instaciado de capa de negocio
	 */
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para dependencias en la capa del negocio
	 * @param dependenciaNGC objeto instaciado de capa de negocio
	 */
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para nucleos en la capa del negocio
	 * @param nucleoNGC objeto instaciado de capa de negocio
	 */
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para materias en la capa del negocio
	 * @param materiaNGC objeto instaciado de capa de negocio
	 */
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para semestres en la capa del negocio
	 * @param semestreNGC objeto instaciado de capa de negocio
	 */
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para persona en la capa del negocio
	 * @param personaNGC objeto instaciado de capa de negocio
	 */
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para microcurriculos en la capa del negocio
	 * @param microcurriculoNGC objeto instaciado de capa de negocio
	 */
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para paises en la capa del negocio
	 * @param paisNGC objeto instaciado de capa de negocio
	 */
	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}
	
	/**
	 * Metodo set para inyeccion de dependencia spring para estados en la capa del negocio
	 * @param estadoNGC objeto instaciado de capa de negocio
	 */
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}
	
	/*********************************************************************************************
	 * Aqui comienzan los metodos de listado
	 */
	
	/**
	 * ante el evento click en el boton buscar, el metodo procede a revisar los filtros diligenciados
	 * y se muestran todos los microcurriculos relacionados con la busqueda
	 */
	public void onClick$btnBuscar(){
		List<TbMicMicrocurriculo> microcurriculosEncontrados;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoEstado = new ArrayList<TbMicMicrocurriculo>();
		
		/**
		 * Verifica los campos de busqueda por dependencias y los prioriza en orden para proceder a llamar el metodo que hará la carga
		 * de los microcurriculos en la lista
		 */
		
		if(!"[Seleccione]".equals(cmbMateria.getValue().toString())&&(!"".equals(cmbMateria.getValue().toString()))){
			TbAdmMateria materia = listaMaterias.get(cmbMateria.getSelectedIndex()-1);
			String busca = materia.getVrIdmateria();
			busca = busca + "%";
			microcurriculosEncontrados = consultarMicrocurriculos(busca);
		}else{
			if(!"[Seleccione]".equals(cmbNucleo.getValue().toString())&&(!"".equals(cmbNucleo.getValue().toString()))){
				TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
				String busca = nucleo.getVrIdnucleo();
				busca = busca + "%";
				microcurriculosEncontrados = consultarMicrocurriculos(busca);
			}else{
				if(!"[Seleccione]".equals(cmbDependencia.getValue().toString())&&(!"".equals(cmbDependencia.getValue().toString()))){
					TbAdmDependencia dependencia = listaDependencias.get(cmbDependencia.getSelectedIndex()-1);
					String busca = dependencia.getVrIddependencia();
					busca = busca + "%";
					microcurriculosEncontrados = consultarMicrocurriculos(busca);
				}else{
					if(!"[Seleccione]".equals(cmbUnidadAcademica.getValue().toString())&&(!"".equals(cmbUnidadAcademica.getValue().toString()))){
						TbAdmUnidadAcademica unidadAcademica = listaUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
						String busca = unidadAcademica.getVrIdunidad();
						busca = busca + "%";
						microcurriculosEncontrados = consultarMicrocurriculos(busca);
					}else{
						microcurriculosEncontrados = consultarMicrocurriculos("%");
					}
				}
			}
		}
		
		/**
		 * Una vez se tiene el microcurriculo se procede a filtrar por los campos especiales semestre, docente responsable y estado
		 */
		
		microcurriculosFiltradoSemestre = filtrarMicrocurriculosPorSemestre(microcurriculosEncontrados);
		microcurriculosFiltradoResponsable = filtrarMicrocurriculosPorResponsable(microcurriculosFiltradoSemestre);
		microcurriculosFiltradoEstado = filtrarMicrocurriculosPorEstado(microcurriculosFiltradoResponsable);
		
		/**
		 * se llama al metodo para que liste los microcurriculos que se le pasaran por un objeto, el cual ya
		 * se encuentra filtrado para mostrar
		 */
		
		listarMicrocurriculos(microcurriculosFiltradoEstado);
	}
	
	/**
	 * El metodo pide a la capa del negocio que le retorne todos los microcurriculos con el concepto de busqueda
	 * @param materiaBuscar cadena de caracteres concodigo de materia a buscar como like (coincidan primeros digitos)
	 * @return objeto array list con microcurriculos encontrados
	 */
	
	public List<TbMicMicrocurriculo> consultarMicrocurriculos(String materiaBuscar){
		List<TbMicMicrocurriculo> microcurriculosEncontrados = null;
		
		try{
			microcurriculosEncontrados = microcurriculoNGC.listarMicrocurriculosPorMateria(materiaBuscar);
			listaMicrocurriculo.getItems().clear();
			
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("error al intentar listar los microcurriculos ","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		return microcurriculosEncontrados;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por semestre
	 * @param microcurriculosEncontrados objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por semestre
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorSemestre(List<TbMicMicrocurriculo> microcurriculosEncontrados){
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre = new ArrayList<TbMicMicrocurriculo>();
		
		if("[Seleccione]".equals(cmbSemestre.getValue().toString()) || ("".equals(cmbSemestre.getValue().toString()))){
			microcurriculosFiltradoSemestre = microcurriculosEncontrados;
		}else{
			if(microcurriculosEncontrados != null){
				TbAdmSemestre semestre = listaSemestre.get(cmbSemestre.getSelectedIndex()-1);
				String idSemestre = semestre.getVrIdsemestre();
				for(TbMicMicrocurriculo microcurriculo: microcurriculosEncontrados){
					if(microcurriculo.getTbAdmSemestre().getVrIdsemestre().equals(idSemestre)){
						microcurriculosFiltradoSemestre.add(microcurriculo);
					}
				}
			}
		}
		return microcurriculosFiltradoSemestre;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por docente responsable
	 * @param microcurriculosFiltradoSemestre objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por responsable del microcurriculo
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorResponsable(List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre){
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable = new ArrayList<TbMicMicrocurriculo>();
		
		if("[Seleccione]".equals(cmbDocente.getValue().toString()) || ("".equals(cmbDocente.getValue().toString()))){
			microcurriculosFiltradoResponsable = microcurriculosFiltradoSemestre;
		}else{
			if(microcurriculosFiltradoSemestre != null){
				TbAdmPersona docente = listaDocentes.get(cmbDocente.getSelectedIndex()-1);
				String idDocente = docente.getVrIdpersona();
				for(TbMicMicrocurriculo microcurriculo: microcurriculosFiltradoSemestre){
					if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idDocente)){
						microcurriculosFiltradoResponsable.add(microcurriculo);
					}
				}
			}
		}
		return microcurriculosFiltradoResponsable;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por estado
	 * @param microcurriculosFiltradoResponsable objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por estado actual del microcurriculo
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorEstado(List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable){
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoEstado = new ArrayList<TbMicMicrocurriculo>();
		
		if("[Seleccione]".equals(cmbEstado.getValue().toString()) || ("".equals(cmbEstado.getValue().toString()))){
			microcurriculosFiltradoEstado = microcurriculosFiltradoResponsable;
		}else{
			TbMicEstado estado = listaEstados.get(cmbEstado.getSelectedIndex()-1);
			int idEstado = estado.getNbIdestado();
			if(microcurriculosFiltradoResponsable != null){
				for(TbMicMicrocurriculo microcurriculo: microcurriculosFiltradoResponsable){
					if(idEstado == microcurriculo.getTbMicEstado().getNbIdestado()){
						microcurriculosFiltradoEstado.add(microcurriculo);
					}
				}
			}
		}
		return microcurriculosFiltradoEstado;
	}
	
	 /**
	  * Procede a mostrar el listado de los microcurriculos encontrados
	  * @param microsListar objeto array list con microcurriculos ya filtrados y los cuales se listaran
	  */
	public void listarMicrocurriculos(List<TbMicMicrocurriculo> microsListar){
		if(microsListar != null){
			
			for(TbMicMicrocurriculo micro: microsListar){
				final Listitem listaItem = new Listitem();
				
				Listcell celdaCodigo = new Listcell(micro.getVrIdmicrocurriculo().toString());
				Listcell celdaUnidad = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
				Listcell celdaDependencia = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
				Listcell celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
				Listcell celdaMateria = new Listcell(micro.getTbAdmMateria().getVrNombre());
				Listcell celdaResponsable = new Listcell(micro.getTbAdmPersona().getVrNombres()+" "+micro.getTbAdmPersona().getVrApellidos());
				Listcell celdaEstado = new Listcell(micro.getTbMicEstado().getVrDescripcion());
				
				celdaCodigo.setStyle("font-size:10px");
				celdaUnidad.setStyle("font-size:10px");
				celdaDependencia.setStyle("font-size:10px");
				celdaNucleo.setStyle("font-size:10px");
				celdaMateria.setStyle("font-size:10px");
				celdaResponsable.setStyle("font-size:10px");
				celdaEstado.setStyle("font-size:10px");
				
				listaItem.appendChild(celdaCodigo);
				listaItem.appendChild(celdaUnidad);
				listaItem.appendChild(celdaDependencia);
				listaItem.appendChild(celdaNucleo);
				listaItem.appendChild(celdaMateria);
				listaItem.appendChild(celdaResponsable);
				listaItem.appendChild(celdaEstado);
				
				listaMicrocurriculo.appendChild(listaItem);
			}
		}
	}
	
	/**
	 * Ante el evento click en el listbox listaMicrocurriculo, procede a verificar que elemento del listbox fue
	 * seleccionado, para guardar en la session la variable que identificará al microcurriculo al cual se le 
	 * implemntará las acciones de consulta, duplicado, actualizacion o impresion.  
	 */
	public void onClick$listaMicrocurriculo(){
		Listitem itemSelect = listaMicrocurriculo.getSelectedItem();
		if(itemSelect != null){
			Listcell celdaIdMicro = (Listcell) itemSelect.getChildren().get(0);
			String idMicro = celdaIdMicro.getLabel();
			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
			TbMicMicrocurriculo microcurriculo = null;
			
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
			if(microcurriculo.getTbMicEstado().getNbIdestado()!=6){
				tool_duplica.setDisabled(true);
			}else{
				tool_duplica.setDisabled(false);
			}
		}
	}
	
	/*********************************************************************************************
	 * Hasta aqui van los metodos de listado
	 */
	
	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
	 */
	private void cargarUnidades(){
		try {
			listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
				}
				cmbUnidadAcademica.setValue("[Seleccione]");
			}
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas las dependencias existentes y las ubica en el combobox cmbDependencia
	 * Si existe el combobox cmbDependencia2 se procede a llenar dicho elemento tambien
	 */
	private void cargarDependencias(String unidad){
		if(!"".equals(unidad)){
			try {
				unidad = unidad + "%";
				listaDependencias = dependenciaNGC.buscarDepedencias(unidad);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
				Messagebox.show("Se presentaron errores al buscar registros de Dependencias","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
		}else{
			
			try {
				listaDependencias = dependenciaNGC.listarDependencias();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
		}
		
		cmbDependencia.getItems().clear();
		if (listaDependencias != null){
			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDependencia dependencia : listaDependencias){
				Comboitem item = new Comboitem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
				cmbDependencia.appendChild(item);
			}
			cmbDependencia.setValue("[Seleccione]");
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas los nucleos existentes y las ubica en el combobox cmbNucleo
	 * Si existe el combobox cmbNucleo2 se procede a llenar dicho elemento tambien
	 */
	private void cargarNucleos(String dependencia){
		if(!"".equals(dependencia)){
			
			try {
				dependencia = dependencia + "%";
				listaNucleos = nucleoNGC.buscarNucleos(dependencia);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
		}else{
			
			try {
				listaNucleos = nucleoNGC.listarNucleos();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
		}
		
		cmbNucleo.getItems().clear();
		if (listaNucleos != null){
			cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmNucleo nucleo : listaNucleos){
				Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+nucleo.getVrNombre());
				cmbNucleo.appendChild(item);
			}
			cmbNucleo.setValue("[Seleccione]");
		}
			
	}
	
	/**
	 * Solicita de la capa del negocio todas las materias existentes y las ubica en el combobox cmbMateria
	 * Si existe el combobox cmbMateria2 se procede a llenar dicho elemento tambien
	 */
	public void cargarMaterias(String nucleo){
		if (!nucleo.equals("") && (nucleo.length() > 1)){
			
			try {
				nucleo = nucleo + "%";
				listaMaterias = materiaNGC.buscarMaterias(nucleo);
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
		} else {
			
			try {
				listaMaterias = materiaNGC.listarMaterias();
			}catch(ExcepcionesDAO expDAO){
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			}catch(ExcepcionesLogica expNgs){
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}catch(Exception exp){
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(exp);
			}
			
		}
				
		cmbMateria.getItems().clear();
		if(listaMaterias != null){
			cmbMateria.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmMateria materia : listaMaterias){
				Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
				cmbMateria.appendChild(item);
			}
			cmbMateria.setValue("[Seleccione]");
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los semestres existentes y los ubica en el combobox cmbSemestre
	 */
	private void cargarSemestres(){
		
		try {
			listaSemestre = semestreNGC.listarSemestres();
			cmbSemestre.getItems().clear();
			if (listaSemestre != null){
				cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
				for (TbAdmSemestre semestre : listaSemestre){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre.appendChild(item);
				}
				cmbSemestre.setValue("[Seleccione]");
			} else
				Messagebox.show("No se Encontraron Registros de Semestres");
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
	}
	
	/**
	 * Solicita de la capa del negocio todos los estados existentes y los ubica en el combobox cmbEstado
	 */
	public void cargarEstados(){
		
		try {
			List<TbMicEstado> listaEstados = estadoNGC.listarEstados();
			cmbEstado.getItems().clear();
			if(listaEstados != null){
				cmbEstado.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicEstado estado: listaEstados){
					Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
					item.setDescription(estado.getVrDescripcion());
					cmbEstado.appendChild(item);
				}
				cmbEstado.setValue("[Seleccione]");
			}else{
				//Messagebox.show("No se hallaron estados");
			}
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		cmbDocente.getItems().clear();
		
		try {
			List<TbAdmRolxUsuario> listaRolesxUsuario = rolxUsuarioNGC.listarDocentes();
			for(TbAdmRolxUsuario rolxUsuario: listaRolesxUsuario){
				listaDocentes.add(rolxUsuario.getTbAdmUsuario().getTbAdmPersona());
			}			
			if (listaDocentes != null){
				cmbDocente.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona()+" - "+ docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
	}
	
	/**
	 * Solicita de la capa del negocio todos los estados existentes y los ubica en el combobox cmbEstado
	 */
	private void cargarEstados2(){
		cmbEstado.getItems().clear();
		
		try {
			 listaEstados = estadoNGC.listarEstados();
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(listaEstados != null){
			cmbEstado.appendChild(new Comboitem("[Seleccione]"));
			for(TbMicEstado estado: listaEstados){
				Comboitem item = new Comboitem(estado.getVrDescripcion());
				cmbEstado.appendChild(item);
			}
			cmbEstado.setValue("[Seleccione]");
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo
	 */
	private void cargarMicrocurriculos(String buscaMicro){
		if(cmbMicrocurriculo != null){
			if (!buscaMicro.equals("")){
				
				try {
					buscaMicro = buscaMicro + "%";
					listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicro);
				}catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
//					Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				
			} else {
				
				try {
					listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
				}catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
//					Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				
			}
					
			cmbMicrocurriculo.getItems().clear();
			if(listaMaterias != null){
				cmbMicrocurriculo.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
					if(microcurriculo.getTbMicEstado().getNbIdestado()==6){
						Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
						cmbMicrocurriculo.appendChild(item);
					}
					cmbMicrocurriculo.setValue("[Seleccione]");
				}
			}
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo2
	 */
	private void cargarMicrocurriculos2(){
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
				Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
				cmbMicrocurriculo2.appendChild(item);
			}
		}
		cmbMicrocurriculo2.setValue("[Seleccione]");
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica(){
		if(cmbUnidadAcademica.getSelectedIndex() != 0){
			TbAdmUnidadAcademica unidad = listaUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
			cargarDependencias(unidad.getVrIdunidad());
			cargarNucleos(unidad.getVrIdunidad());
			cargarMaterias(unidad.getVrIdunidad());
			cargarMicrocurriculos(unidad.getVrIdunidad());
		}else{
			cargarDependencias("");
			cargarNucleos("");
			cargarMaterias("");
			cargarMicrocurriculos("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
//	public void onSelect$cmbUnidadAcademica2(){
//		recargarDependencias2(cmbUnidadAcademica2.getValue());
//		recargarNucleos2(cmbUnidadAcademica2.getValue());
//		recargarMaterias2(cmbUnidadAcademica2.getValue());
//		recargarMicrocurriculos2(cmbUnidadAcademica2.getValue());
//	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia(){
		if(cmbDependencia.getSelectedIndex() != 0){
			TbAdmDependencia dependencia = listaDependencias.get(cmbDependencia.getSelectedIndex()-1); 
			cargarNucleos(dependencia.getVrIddependencia());
			cargarMaterias(dependencia.getVrIddependencia());
			cargarMicrocurriculos(dependencia.getVrIddependencia());
		}else{
			cargarNucleos("");
			cargarMaterias("");
			cargarMicrocurriculos("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
//	public void onSelect$cmbDependencia2(){
//		TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
//		recargarNucleos2(nucleo.getVrIdnucleo());
//		recargarMaterias2(nucleo.getVrIdnucleo());
//		recargarMicrocurriculos2(nucleo.getVrIdnucleo());
//	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo(){
		if(cmbNucleo.getSelectedIndex() != 0){
			TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
			cargarMaterias(nucleo.getVrIdnucleo());
			cargarMicrocurriculos(nucleo.getVrIdnucleo());
		}else{
			cargarMaterias("");
			cargarMicrocurriculos("");
		}
		
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
//	public void onSelect$cmbNucleo2(){
//		recargarMaterias2(cmbNucleo2.getValue());
//		recargarMicrocurriculos2(cmbNucleo2.getValue());
//		
//	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMateria este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbMateria(){
		if(cmbMateria.getSelectedIndex() != 0){
			TbAdmMateria materia = listaMaterias.get(cmbMateria.getSelectedIndex()-1);
			cargarMicrocurriculos(materia.getVrIdmateria());
		}else{
			cargarMicrocurriculos("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMateria2 este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
//	public void onSelect$cmbMateria2(){
//		recargarMicrocurriculos2(cmbMateria2.getValue());
//	}
	/**
	 * Ante el evento seleccion en el combobox cmbMicrocurriculo2 el metodo procede a guardar en la sesion el
	 * microcurriculo seleccionado
	 */
	public void onSelect$cmbMicrocurriculo2(){
		String idMicro = cmbMicrocurriculo2.getValue().toString();
		
		if(!idMicro.equals("")&&(!idMicro.equals("[Seleccione]"))){
			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
		}else{
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
	}
	
	/**
	 * Se inicializan todos los combobox
	 */
	private void inicializarFormaListado(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);		
	}
	
	public void listadoInicial(){
		List<TbMicMicrocurriculo> microcurriculos = null;
		
		try{
			microcurriculos = microcurriculoNGC.listarMicrocurriculos();
			listaMicrocurriculo.getItems().clear();
			
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		listarMicrocurriculos(microcurriculos);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		
		if (comp.getParent().getId().equals("formaListarMicro")){
			inicializarFormaListado();
			cargarMaterias("");
			cargarUnidades();
			cargarDependencias("");
			cargarNucleos("");
			cargarSemestres();
			cargarDocentes();
			cargarEstados2();
			listadoInicial();
		} else if(comp.getParent().getId().equals("panelDuplicarMicro")){
			cargarMaterias("");
			cargarUnidades();
			cargarDependencias("");
			cargarNucleos("");
			cargarMicrocurriculos("");
			cargarSemestres();
		} else if(comp.getParent().getId().equals("blyConsultarMicro")){
			cargarMaterias("");
			cargarUnidades();
			cargarDependencias("");
			cargarNucleos("");
			cargarMicrocurriculos2();
		}
	}
	
}
