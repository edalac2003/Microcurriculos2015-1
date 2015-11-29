package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
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


@SuppressWarnings({ "rawtypes", "unused" })
public class CopyOfCargarDatosFormas extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CopyOfCargarDatosFormas.class);
	
	private static String modUsuario = "SYSTEM";
	private static Date modFecha = new Date();
	private static Date fechaEstimada = null;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
	Combobox cmbDocente;
	Combobox cmbEstado;
	Combobox cmbPaisBiblio;
	
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreMateria;
	Label lblNombreDocente;
	Label lblNombreNucleo;
	Label lblNombreEstado;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	Borderlayout contenidoCargando;
	Borderlayout contenidoPrincipal;
	
	Button btnBuscar;
	
	Grid grillaListado;
	
	Listbox listaMicrocurriculo;
	
	Toolbarbutton tool_save;
	
	/*
	 * Variables locales
	 */
	List<TbMicMicrocurriculo> listadoMicrocurriculo = null;
	private static Date fechaActual = new Date();
	String userName;
	String nombrePersona;
	String apellidoPersona;
	String idPersona;
	
	/**
	 * Estos objetos los traje de ValidarDatos
	 */
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtObjetivoEspecifico;
	Textbox txtResumenMicro;
	Textbox txtNombreUnidad;
	Textbox txtActividadMicro;
	Textbox txtNombreSitioCiber;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;	
	Listbox listaCibergrafia;
	
	Label lblidMicrocurriculo;
	
	Label lblUsuarioLogin;
	Label lblFechaActual;
	
	Menu menOpcionesGuardar;
	
	private static List<TbMicUnidadxmicro> listadoUnidadesxMicro;
	private static List<TbMicTemaxunidad> listadoTemasxUnidad;
	private static List<TbMicEvaluacionxmicro> listadoEvaluacionesxMicro;
	private static List<TbMicObjetivoxmicro> listadoObjetivosxMicro;
	private static List<TbMicBiblioxunidad> listadoBibliografiaxUnidad;
	private static List<TbMicSubtemaxtema> listadoSubtemaxTema;	
	private static List<TbMicUnidad> listadoUnidades;
	private static List<TbMicObjetivo> listadoObjetivos;
	private static List<TbMicEvaluacion> listadoEvaluaciones;
	private static List<TbMicTema> listadoTemas;
	private static List<TbMicSubtema> listadoSubtemas;
	private static List<TbMicBibliografia> listadoBibliografia;
	//*****************************************************************************************************

	private static List<TbAdmUnidadAcademica> listaUnidadAcademica;
	private static List<TbAdmDependencia> listaDependencias;
	private static List<TbAdmDependencia> listaDependenciasxUnidad;
	private static List<TbAdmNucleo> listaNucleos;
	private static List<TbAdmNucleo> listaNucleosxDependencia; 
	private static List<TbAdmMateria> listaMaterias;
	private static List<TbAdmMateria> listaMateriaxNucleo;
	private static List<TbAdmPersona> listaDocentes = new ArrayList<TbAdmPersona>();
	private static List<TbAdmSemestre> listaSemestre;
	private static List<TbMicEstado> listaEstados;
	private static List<TbMicMicrocurriculo> listaMicrocurriculos;
	

	/**
	 * Aqui se definen los objetos de tipos NGC los cuales se les harán las solicitudes de datos
	 */
		
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	PaisNGC paisNGC;
	EstadoNGC estadoNGC;
	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;
	RolxUsuarioNGC rolxUsuarioNGC;
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}
	
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}
			
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}

	public void setGuardarMicrocurriculoNGC(
			GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
	}

	public void setRolxUsuarioNGC(RolxUsuarioNGC rolxUsuarioNGC) {
		this.rolxUsuarioNGC = rolxUsuarioNGC;
	}

	private void cargarUnidades(){
		try {
			listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
				}				
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
	
	private void cargarDependencias(){
		try {
			listaDependencias = dependenciaNGC.listarDependencias();
			cmbDependencia.getItems().clear();
			if (listaDependencias != null){
				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmDependencia dependencia : listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
				}
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
	
	private void cargarNucleos(){
		cmbNucleo.getItems().clear();
		try {
			listaNucleos = nucleoNGC.listarNucleos();
			if (listaNucleos != null){
				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
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
	
	private void cargarMaterias(String nucleo){
		if (!nucleo.equals("") && (nucleo.length() > 1)){
			try {
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
			for(TbAdmMateria materia : listaMaterias){
				Comboitem item = new Comboitem(materia.getVrIdmateria());
				item.setDescription(materia.getVrNombre());
				cmbMateria.appendChild(item);
			}
		}		
	}
	
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
	
	private void cargarEstados(){
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
			cmbEstado.setValue(listaEstados.get(0).getVrDescripcion());
			for(TbMicEstado estado: listaEstados){
				Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
				item.setDescription(estado.getVrDescripcion());
				cmbEstado.appendChild(item);
			}
		}		
	}
	
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
			} else{
				Messagebox.show("No Se Hallaron Registros de Docentes");
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
	
	private void cargarMicrocurriculos(){
		cmbMicrocurriculo.getItems().clear();
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
				cmbMicrocurriculo.appendChild(item);
			}
		}		
	}
	
	private void cargarMicroxMateriaxSemestre(String codigoMicro){		
		TbMicMicrocurriculo microcurriculo = null;
		cmbMicrocurriculo.getItems().clear();
		
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(codigoMicro);
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
		
		if (microcurriculo != null){
			Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
			cmbMicrocurriculo.appendChild(item);
		}
		
	}
	
	private void inicializarFormaListado(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);		
	}
	
//	private void cargarDependenciaPorUnidadAcademica(String unidad){		
//		try {		
//			listaDependenciasxUnidad = dependenciaNGC.listarDependenciasPorUnidad(unidad);
//			cmbDependencia.getItems().clear();
//			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
//			if (listaDependencias != null){
//				for(TbAdmDependencia dependencia : listaDependenciasxUnidad){
//					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
//					item.setDescription(dependencia.getVrNombre());
//					cmbDependencia.appendChild(item);
//				}
//			}
//			cmbDependencia.setValue("[Seleccione]");
//		} catch (ExcepcionesLogica e) {
//			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
//		}	
//	}
	
	private void cargarDependenciaPorUnidadAcademica(TbAdmUnidadAcademica unidad){
		cmbDependencia.getItems().clear();
		try {		
			listaDependenciasxUnidad = dependenciaNGC.listarDependenciasPorUnidad(unidad);			
			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
			if (listaDependenciasxUnidad != null){
				for(TbAdmDependencia dependencia : listaDependenciasxUnidad){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia()+" - "+ dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
				}
			}
			cmbDependencia.setValue("[Seleccione]");
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
	
	
	private void cargarNucleosPorDependencia(TbAdmDependencia dependencia){
		cmbNucleo.getItems().clear();
		try {
			listaNucleosxDependencia = nucleoNGC.listarNucleosPorDependencia(dependencia);
			
			if (listaNucleosxDependencia != null){
				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmNucleo nucleo : listaNucleosxDependencia){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+ nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
			}
			cmbNucleo.setValue("[Seleccione]");
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
	
//	private void cargarMateriasPorNucleo(String nucleo){
//		try {
//			listaMateriaxNucleo = materiaNGC.listarMateriasxNucleo(nucleo);
//			if (listaMateriaxNucleo != null){
//				cmbMateria.getItems().clear();
//				for(TbAdmMateria materia : listaMateriaxNucleo){
//					Comboitem item = new Comboitem(materia.getVrIdmateria());
//					item.setDescription(materia.getVrNombre());
//					cmbMateria.appendChild(item);
//				}
//			}
//			cmbMateria.setValue("[Seleccione]");
//		} catch (ExcepcionesLogica e) {
//			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Materia>.  "+e);
//		}
//	}
	
	private void cargarMateriasPorNucleo(TbAdmNucleo nucleo){
		cmbMateria.getItems().clear();
		try {
			listaMateriaxNucleo = materiaNGC.listarMateriasxNucleo(nucleo);
			if (listaMateriaxNucleo != null){
				
				cmbMateria.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmMateria materia : listaMateriaxNucleo){
					Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
					cmbMateria.appendChild(item);
				}
			}
			cmbMateria.setValue("[Seleccione]");
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
	
	private void inicializarFormaCrear(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
	}
	
	/**
	 * Definiendo los Eventos de los Objetos de la Forma
	 */
	
	public void onOK$cmbUnidadAcademica(){
		cmbDependencia.setDisabled(false);
		cmbDependencia.focus();
	}
	
	public void onOK$cmbDependencia(){
		cmbNucleo.setDisabled(false);
		cmbNucleo.focus();
	}
	
	public void onOK$cmbNucleo(){
		cmbMateria.setDisabled(false);
		cmbMateria.focus();
	}
		
	public void onOK$cmbMateria(){
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
	public void onOK$cmbSemestre(){
		cmbMicrocurriculo.setDisabled(false);
		String codigo = cmbMateria.getValue().toString()+"-"+cmbSemestre.getValue().toString();
		cargarMicroxMateriaxSemestre(codigo);
	}
	
	
	public void onSelect$cmbUnidadAcademica(){
		cmbDependencia.setDisabled(false);
		if(cmbUnidadAcademica.getSelectedIndex() > 0){
			TbAdmUnidadAcademica unidad = listaUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
			cargarDependenciaPorUnidadAcademica(unidad);
		}		
	}
	
	public void onSelect$cmbDependencia(){
		cmbNucleo.setDisabled(false);
		if (cmbDependencia.getSelectedIndex() > 0){
			TbAdmDependencia dependencia = listaDependenciasxUnidad.get(cmbDependencia.getSelectedIndex()-1);
			cargarNucleosPorDependencia(dependencia);
		}
	}
	
	public void onSelect$cmbNucleo(){
		cmbMateria.setDisabled(false);
		if (cmbNucleo.getSelectedIndex() > 0){
			TbAdmNucleo nucleo = listaNucleosxDependencia.get(cmbNucleo.getSelectedIndex()-1);
			cargarMateriasPorNucleo(nucleo);
		}
	}
	
	public void onSelect$cmbMateria(){
		cmbSemestre.setDisabled(false);
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
		
//	public void onSelect$cmbSemestre(){
//		//cmbMicrocurriculo.setDisabled(false);
//		String codigo = cmbMateria.getValue().toString()+"-"+cmbSemestre.getValue().toString();
////		cargarMicroxMateriaxSemestre(codigo);	
//	}
	
	
	private void mostrarInfoMateria(String idMateria){
		TbAdmMateria materia = listaMateriaxNucleo.get(cmbMateria.getSelectedIndex()-1);
		if (materia != null ){
			lblCreditosMateria.setValue(Integer.toString(materia.getNbCreditos()));
			lblHtMateria.setValue(Integer.toString(materia.getNbHt()));
			lblHpMateria.setValue(Integer.toString(materia.getNbHp()));
			lblHtpMateria.setValue(Integer.toString(materia.getNbHtp()));
			Integer horaClaseSemestral = (materia.getNbHt()+materia.getNbHp()+materia.getNbHtp())*16;
			lblHoraClaseSemestral.setValue(Integer.toString(horaClaseSemestral));
			if (materia.getBlValidable() == 1)
				ckbValidable.setChecked(true);
			else
				ckbValidable.setChecked(false);
			
			if (materia.getBlHabilitable() == 1)
				ckbHabilitable.setChecked(true);
			else
				ckbHabilitable.setChecked(false);
			
			if (materia.getBlClasificable() == 1)
				ckbClasificable.setChecked(true);
			else
				ckbClasificable.setChecked(false);	
		} else 
			Messagebox.show("El Registro esta vacio.");
	}
	
	
	//*************************************************************************************************
	
	
	
//	private void inhabilitarControles(){
////		cmbUnidadAcademica.setDisabled(true);;
//		cmbDependencia.setDisabled(true);
//		cmbNucleo.setDisabled(true);
//		cmbMateria.setDisabled(true);
//		cmbSemestre.setDisabled(true);
//		cmbMicrocurriculo.setDisabled(true);
//		cmbEstado.setDisabled(true);
//		cmbDocente.setDisabled(true);
//		ckbValidable.setDisabled(true);
//		ckbHabilitable.setDisabled(true);
//		ckbClasificable.setDisabled(true);
//	}
// ********************************************************************************************************
//	AQUI COMIENZAN LOS METODOS DE GUARDAR
//		
	public void onClick$tool_save(){
		TbMicMicrocurriculo microcurriculo = empaquetarMicrocurriculo();
		if (microcurriculo != null){
			TbMicMicroxestado microxEstado = empaquetarMicroxEstado(microcurriculo);
			empaquetarObjetivos(microcurriculo);
			if (listaUnidades.getItems().size() > 0)
				empaquetarUnidades(microcurriculo);
			if (listaTemas.getItems().size() > 0)
				empaquetarTemas(listadoUnidades);
			if (listaEvaluaciones.getItems().size() > 0)
				empaquetarEvaluaciones(microcurriculo);
			if (listaSubtemas.getItems().size() >0 )
				empaquetarSubtemas(listadoTemas);
			if(listaBibliografia.getItems().size() > 0)
				empaquetarBibliografias(listadoUnidades);			
			
			/**
			 * Verificación si el microcurriculo es duplicado o creado para crear historial
			 */
			TbAdmHistorico historicoGuardar = null;
			if(Executions.getCurrent().getSession().hasAttribute("duplicar")){
				if(Executions.getCurrent().getSession().getAttribute("duplicar").equals("verdadero")){
					String microDuplicar = (String)Executions.getCurrent().getSession().getAttribute("idMicro");
					String detalleModificar = "Duplicar microcurriculo: "+microDuplicar+".";
					historicoGuardar = new TbAdmHistorico(new Date(), microcurriculo, detalleModificar, "usuario", "usuario", new Date());
				}
			}else{
				String detalleModificar = "Crear microcurriculo.";
				historicoGuardar = new TbAdmHistorico(new Date(), microcurriculo, detalleModificar, "usuario", "usuario", new Date());
			}
			try {
				guardarMicrocurriculoNGC.guardarMicroxlotes(microcurriculo, microxEstado, listadoTemas, listadoSubtemas, listadoSubtemaxTema, listadoTemasxUnidad, 
							listadoUnidades, listadoUnidadesxMicro, listadoObjetivos, listadoObjetivosxMicro, listadoBibliografia, listadoBibliografiaxUnidad, 
							listadoEvaluaciones, listadoEvaluacionesxMicro, historicoGuardar);				
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
			
			if (verificarCampos() == 1){
				cmbEstado.setDisabled(false);
				Messagebox.show("El Microcurriculo se ha guardado correctamente. Puede Cambiar el estado del Microcurriculo cuando lo desee.");
			} else if (verificarCampos() == 0){
				Messagebox.show("El Microcurriculo se ha guardado correctamente. Su estado inicial es <Borrador>. \n Para cambiar el estado, el Microcurriculo "+
						"debe estar completamente Diligenciado.", "REGISTRO ALMACENADO", Messagebox.OK,Messagebox.INFORMATION);
			} else{
				Messagebox.show("Errores al guardar.  Revise la información.");
			}				
		} else{
			Messagebox.show("El formulario no cumple con la información minina necesaria para crear un Microcurriculo. \n Por favor verifique los campos e intentelo nuevamente.","ERROR",Messagebox.OK,Messagebox.ERROR);
		}
	}

	
	/*
	 * Este método se encarga de empaquetar la información y devolver un Objeto de tipo Microcurriculo
	 *  
	 * @return Objeto de Tipo Microcurriculo.
	 */
	private TbMicMicrocurriculo empaquetarMicrocurriculo(){
		TbMicMicrocurriculo microcurriculo = null;
		String codigoMicrocurriculo = "";
		TbAdmMateria materia = null;
		TbAdmSemestre semestre = null;
		TbAdmPersona responsable = null;
		TbMicEstado estado = null;
		
		if(cmbMateria.getSelectedIndex() > 0)
			materia = listaMateriaxNucleo.get(cmbMateria.getSelectedIndex()-1);
		else{
			if(!"".equals(cmbMateria.getValue().toString()) && (!"[Seleccione]".equals(cmbMateria.getValue().toString()))){
				String comboMateria = cmbMateria.getValue().toString();
				String[] cadenaMateria = comboMateria.split(" - ");
				try {
					materia = materiaNGC.obtenerMateria(cadenaMateria[0]);
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
		}
		if(cmbSemestre.getSelectedIndex() > 0)
			semestre = listaSemestre.get(cmbSemestre.getSelectedIndex()-1);
		else{
			if(!"".equals(cmbSemestre.getValue().toString()) && (!"[Seleccione]".equals(cmbSemestre.getValue().toString()))){
				String comboSemestre = cmbSemestre.getValue().toString();
				try {
					semestre = semestreNGC.obtenerSemestre(comboSemestre);
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
		}
		
		if (cmbDocente.getSelectedIndex() > 0 && (listaDocentes != null))
			responsable = listaDocentes.get(cmbDocente.getSelectedIndex()-1);
		else{
			if(!"".equals(cmbDocente.getValue().toString()) && (!"[Seleccione]".equals(cmbDocente.getValue().toString()))){
				String comboDocente = cmbDocente.getValue().toString();
				String[] cadenaDocente = comboDocente.split(" - ");
				try {
					responsable = personaNGC.obtenerPersona(cadenaDocente[0]);
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
		}
		
		if(listaEstados != null)
			estado = listaEstados.get(0);
		else{
			try {
				estado = estadoNGC.obtenerEstados(1);
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
		
		if (materia != null){
			if (semestre != null){
				codigoMicrocurriculo = materia.getVrIdmateria().toUpperCase()+"-"+semestre.getVrIdsemestre().toUpperCase();
				if ((codigoMicrocurriculo.length() > 0) && (!codigoMicrocurriculo.equals(""))){
					if (responsable != null){						
						microcurriculo = new TbMicMicrocurriculo(codigoMicrocurriculo, materia, semestre, txtPropositoMicro.getValue().toString(), 
								txtJustificacionMicro.getValue().toString(), txtResumenMicro.getValue().toString(), responsable, estado, modUsuario, modFecha);
						if(lblidMicrocurriculo != null)
							lblidMicrocurriculo.setValue(codigoMicrocurriculo.toString());
					}
				} else
					Messagebox.show("No se pudo crear el objeto Microcurriculo");				
			}
		}		
		return microcurriculo;
	}
	
	private TbMicMicroxestado empaquetarMicroxEstado(TbMicMicrocurriculo microcurriculo){
		TbMicMicroxestado microxEstado = null;
		TbMicEstado estado = null;
		TbAdmPersona responsable = null;
		
		if(listaEstados != null){
			if(listaEstados.size() > 0)
				estado = listaEstados.get(0);
		}else{
			try {
				estado = estadoNGC.obtenerEstados(1);
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
		if(listaDocentes != null){
			if (cmbDocente.getSelectedIndex() > 0)
				responsable = listaDocentes.get(cmbDocente.getSelectedIndex()-1);
		}else{
			String comboDocente = cmbDocente.getValue().toString();
			String[] cadenaDocente = comboDocente.split(" - ");
			try {
				responsable = personaNGC.obtenerPersona(cadenaDocente[0]);
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
		if(estado != null){
			microxEstado = new TbMicMicroxestado(estado, modFecha, microcurriculo, responsable, modUsuario, modFecha);
		}		
		return microxEstado;
	}
	
	/**
	 * Este metodo se encarga de tomar la información de la ListaObjetivosEspecificos y empaquetar ListaObjetivos y ListadoObjetivosxMicrocurriculo.
	 * @param microcurriculo
	 * @return Lista con objetos de Tipo Objetivos
	 */
	private void empaquetarObjetivos(TbMicMicrocurriculo microcurriculo){
		TbMicObjetivo objetivo = null;
		TbMicObjetivoxmicro objetivosxMicro = null;		
		listadoObjetivos = new ArrayList<TbMicObjetivo>();
		listadoObjetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
		
		if((txtObjetivoGeneral.getValue().trim().length() > 0) && !(txtObjetivoGeneral.equals(""))){
			objetivo = new TbMicObjetivo(txtObjetivoGeneral.getValue(), modUsuario, modFecha);
			listadoObjetivos.add(objetivo);
			objetivosxMicro = new TbMicObjetivoxmicro(objetivo,microcurriculo,'1',modUsuario,modFecha);
			listadoObjetivosxMicro.add(objetivosxMicro);
			
			for (int i=0; i<listaObjetivosEspecificos.getItems().size(); i++){
				Listitem item = (Listitem)listaObjetivosEspecificos.getChildren().get(i);
				Listcell celdaObjetivo = (Listcell)item.getChildren().get(0);
				objetivo = new TbMicObjetivo(celdaObjetivo.getLabel(), modUsuario, modFecha);
				listadoObjetivos.add(objetivo);
				objetivosxMicro = new TbMicObjetivoxmicro(objetivo,microcurriculo,'0',modUsuario,modFecha);
				listadoObjetivosxMicro.add(objetivosxMicro);
			}
		} else {
			Messagebox.show("Sin Información en el Campo Objetivo General.");
			txtObjetivoGeneral.setFocus(true);
		}		
	}
	
	private void empaquetarUnidades(TbMicMicrocurriculo microcurriculo){
		TbMicUnidad unidad = null;
		TbMicUnidadxmicro unidadxMicro = null;		
		String nombreUnidad = "";
		listadoUnidades = new ArrayList<TbMicUnidad>();
		listadoUnidadesxMicro = new ArrayList<TbMicUnidadxmicro>();
		
		for (int i=1; i <= listaUnidades.getItems().size(); i++){
			Listitem item = (Listitem)listaUnidades.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)item.getChildren().get(1);
			nombreUnidad = celdaUnidad.getLabel();
			unidad = new TbMicUnidad(nombreUnidad, modUsuario, modFecha);
			listadoUnidades.add(unidad);
			unidadxMicro = new TbMicUnidadxmicro(unidad, microcurriculo, modUsuario, modFecha);
			listadoUnidadesxMicro.add(unidadxMicro);
		}
	}
	
	private void empaquetarTemas(List<TbMicUnidad> listadoUnidades){
		TbMicTema tema = null;
		TbMicTemaxunidad temaxUnidad = null;
		TbMicUnidad unidad = null;
		listadoTemas = new ArrayList<TbMicTema>();
		listadoTemasxUnidad = new ArrayList<TbMicTemaxunidad>();
				
		for (int i=1;i<=listaTemas.getItems().size(); i++){
			Listitem listaitem = (Listitem)listaTemas.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaNombreTema = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSemanas = (Listcell)listaitem.getChildren().get(2);
			unidad = obtenerUnidad(listadoUnidades, celdaUnidad.getLabel());			
			String descripcion = celdaNombreTema.getLabel();
			tema = new TbMicTema(descripcion, modUsuario, modFecha);
			listadoTemas.add(tema);
			temaxUnidad = new TbMicTemaxunidad(unidad, tema, Integer.parseInt(celdaSemanas.getLabel()), modUsuario, modFecha);
			listadoTemasxUnidad.add(temaxUnidad);
		}		
	}
	
	/**
	 * 
	 * @param lista
	 * @param nombre
	 * @return
	 */
	private TbMicUnidad obtenerUnidad(List<TbMicUnidad> lista, String nombre){
		TbMicUnidad unidad = null;
		for (TbMicUnidad un : lista){
			if(nombre.equals(un.getVrNombre().trim())){
				unidad = un;
				break;
			}				
		}
		return unidad;
	}
	
	
	private void empaquetarEvaluaciones(TbMicMicrocurriculo microcurriculo){
		TbMicEvaluacion evaluacion = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		listadoEvaluaciones = new ArrayList<TbMicEvaluacion>();
		listadoEvaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
				
		for(int i=1;i<=listaEvaluaciones.getItemCount();i++){
			Listitem listaitem = (Listitem)listaEvaluaciones.getChildren().get(i);
			Listcell celdaEvaluacion = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaPorcentaje = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaFecha = (Listcell)listaitem.getChildren().get(2);
			String tmpFecha = celdaFecha.getLabel().toString();			
			try {
				fechaEstimada = df.parse(tmpFecha);
			} catch (ParseException e) {
				logger.error("Error en le Formato de Fecha.");
			}

			evaluacion = new TbMicEvaluacion(celdaEvaluacion.getLabel(), modUsuario, modFecha);
			listadoEvaluaciones.add(evaluacion);
			evaluacionxMicro = new TbMicEvaluacionxmicro(evaluacion, microcurriculo, Integer.parseInt(celdaPorcentaje.getLabel()), fechaEstimada, modUsuario, modFecha);
			listadoEvaluacionesxMicro.add(evaluacionxMicro);
		}
	}
	
	
	private void empaquetarSubtemas(List<TbMicTema> lista){
		TbMicTema tema = null;
		TbMicSubtema subtema = null;
		TbMicSubtemaxtema subtemaxTema = null;	
		listadoSubtemas = new ArrayList<TbMicSubtema>();
		listadoSubtemaxTema = new ArrayList<TbMicSubtemaxtema>();
		
		for(int i=1; i<=listaSubtemas.getItems().size(); i++){
			Listitem listaitem = (Listitem)listaSubtemas.getChildren().get(i);
			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSubtema = (Listcell)listaitem.getChildren().get(2);
			String nombreTema = celdaTemas.getLabel().toString();
			
			tema = obtenerTema(lista, nombreTema);
						
			if (tema != null){
				subtema = new TbMicSubtema(celdaSubtema.getLabel().toString(), modUsuario, modFecha);
				listadoSubtemas.add(subtema);
				subtemaxTema = new TbMicSubtemaxtema(tema, subtema, modUsuario, modFecha);
				listadoSubtemaxTema.add(subtemaxTema);
			} 
		}		
	}
	
	private TbMicTema obtenerTema(List<TbMicTema> lista, String nombre){
		TbMicTema tema = null;
		for(TbMicTema tm : lista){
			if (nombre.equals(tm.getVrDescripcion().trim())){
				tema = tm;
				break;
			}
		}
		return tema;
	}
	
	private void empaquetarBibliografias(List<TbMicUnidad> lista){
		TbMicBibliografia bibliografia = null;
		TbMicBiblioxunidad biblioxUnidad = null;
		char tipoBibliografia;
		
		listadoBibliografia = new ArrayList<TbMicBibliografia>();
		listadoBibliografiaxUnidad = new ArrayList<TbMicBiblioxunidad>();
		
		for(int i=1; i<=listaBibliografia.getItems().size(); i++){
			Listitem listaitem = (Listitem)listaBibliografia.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaReferencia = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaAutor = (Listcell)listaitem.getChildren().get(2);
			Listcell celdaISBN = (Listcell)listaitem.getChildren().get(3);
			Listcell celdaTipo = (Listcell)listaitem.getChildren().get(4);
			String strReferencia = celdaReferencia.getLabel().toString();
			String strAutor = celdaAutor.getLabel().toString();
			String strISBN = celdaISBN.getLabel().toString();
			
			if ("BASICA".equals(celdaTipo.getLabel().toUpperCase()))
				tipoBibliografia = '1';
			else 
				tipoBibliografia = '0';
						
			bibliografia = new TbMicBibliografia(strReferencia, null, strISBN, strAutor, tipoBibliografia, modUsuario, modFecha);
						
			listadoBibliografia.add(bibliografia);
			
			TbMicUnidad unidad = obtenerUnidad(lista, celdaUnidad.getLabel().toString().toUpperCase());
			biblioxUnidad = new TbMicBiblioxunidad(bibliografia, unidad, modUsuario, modFecha);
			listadoBibliografiaxUnidad.add(biblioxUnidad);
		}
		
		for(int i=0; i<listaCibergrafia.getItemCount();i++){
			Listitem listaItem = (Listitem)listaCibergrafia.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
			Listcell celdaReferencia = (Listcell)listaItem.getChildren().get(1);
			Listcell celdaSitio = (Listcell)listaItem.getChildren().get(2);
			Listcell celdaTipo = (Listcell)listaItem.getChildren().get(3);
			String strReferencia = celdaReferencia.getLabel().toString();
			String strSitio = celdaSitio.getLabel().toString();
			
			if ("BASICA".equals(celdaTipo.getLabel().toUpperCase()))
				tipoBibliografia = '1';
			else 
				tipoBibliografia = '0';
			
			TbMicUnidad unidad = obtenerUnidad(lista, celdaUnidad.getLabel().toString().toUpperCase());			
			bibliografia = new TbMicBibliografia(strReferencia, strSitio, null, null, tipoBibliografia, modUsuario, modFecha);
			biblioxUnidad = new TbMicBiblioxunidad(bibliografia, unidad, modUsuario, modFecha);
			listadoBibliografia.add(bibliografia);
			listadoBibliografiaxUnidad.add(biblioxUnidad);			
		}	
	}
	
	
	/**
	 * Este método se encarga de validar la información ingresada y clasifica el estado en el que se guardará el Microcurriculo.
	 * @return
	 */
	public int verificarCampos(){
		int estado = -1;
		if (comprobarInformacionGeneral()){
			if (comprobarInformacionComplementaria()){
				estado = 0;
				if (comprobarUnidadesDetalladas()){
					if (comprobarEvaluaciones()){
						if (comprobarReferencias()){
							estado = 1;							
						} 
					} 
				}
			} 
		}
		return estado;
	}
	
	/**
	 * Este metodo verifica que los campos de la Pestaña Información General no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarInformacionGeneral(){
		Boolean estado = false;
		if((cmbSemestre.getValue().trim().length() > 0) && !("".equals(cmbSemestre.getValue().toString()))){
			if ((cmbNucleo.getValue().trim().length() > 0) && !("".equals(cmbNucleo.getValue().toString()))){
				if ((cmbDocente.getValue().trim().length() > 0) && !("".equals(cmbDocente.getValue().toString()))){
					if ((cmbMateria.getValue().trim().length() > 0) && !("".equals(cmbMateria.getValue().toString()))){
						estado = true;
					} 				
				}
			}
		}		
		return estado;
	}
	
	
	/**
	 * Este metodo verifica que los Componentes de la Pestaña Información Complementaria no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarInformacionComplementaria(){
		boolean estado = false;
		if (!("".equals(txtPropositoMicro.getValue().toString())) && (txtPropositoMicro.getValue().trim().length() > 0)){
			if (!("".equals(txtJustificacionMicro.getValue().toString())) && (txtJustificacionMicro.getValue().trim().length() > 0)){
				if (!("".equals(txtObjetivoGeneral.getValue().toString())) && (txtObjetivoGeneral.getValue().trim().length() > 0)){
					if (listaObjetivosEspecificos.getItems().size() > 0){
						if (!("".equals(txtResumenMicro.getValue().toString())) && (txtResumenMicro.getValue().trim().length() > 0)){
							estado = true;
						} else {
							Messagebox.show("Falta Informacion en el Campo <Contenido Resumido>");
						}
					} 
				} 
			} 
		} 				
		return estado;
	}
	
	/**
	 * Este metodo verifica que los Componentes de la Pestaña Unidades Detalladas no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarUnidadesDetalladas(){
		Boolean estado = false;
		if ((listaUnidades.getItems().size() > 0) && (listaUnidades != null)){
			if ((listaTemas.getItems().size() > 0) && (listaTemas != null)){
				if ((listaSubtemas.getItems().size() > 0) && (listaSubtemas != null)){
					estado = true;
				} 
			}
		} 
		
		return estado;
	}
	
	/**
	 * Este metodo verifica que los componentes de la Pestaña Evaluaciones no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarEvaluaciones(){
		Boolean estado = false;
		if ((listaEvaluaciones.getItems().size() > 0) && (listaEvaluaciones != null))
			estado = true;			
		return estado;
	}
	
	/**
	 * Este metodo verifica que los componentes de la Pestaña Bibliográficas no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarReferencias(){
		Boolean estado = false;
		if ((listaBibliografia.getItems().size() > 0) && (listaBibliografia != null)){
			if ((listaCibergrafia.getItems().size() > 0) && (listaCibergrafia != null)){
				estado = true;
			}
		} 
		return estado;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuarioLogin")){
			TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuarioLogin");
			TbAdmRol rolPersona = rolxUsuario.getTbAdmRol();
			if(rolPersona.getNbId() == 4){
				if (comp.getParent().getId().equals("formaCrearMicro")){
					idPersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrIdpersona();
					nombrePersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrNombres();
					apellidoPersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrApellidos();
					userName = rolxUsuario.getTbAdmUsuario().getVrLogin();
					lblUsuarioLogin.setValue(userName);
					inicializarFormaCrear();
					cargarEstados();
					cargarDocentes();
					cargarUnidades();
					cargarSemestres();
					/**
					 * fecha
					 */
					Date now = new Date();
					DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
					String s4 = df4.format(now);
					lblFechaActual.setValue(s4);
					
					contenidoCargando.setVisible(false);
					contenidoPrincipal.setVisible(true);
				} else if (comp.getParent().getId().equals("formaListarMicro")){
					inicializarFormaListado();
					cargarMaterias(cmbNucleo.getValue());
					cargarMicrocurriculos();			
					cargarDependencias();
					cargarNucleos();			
				} else if (comp.getParent().getId().equals("consultarMicro")){
					cargarMicrocurriculos();
					cargarDependencias();
					cargarNucleos();
					//inhabilitarControles();
				}
			}else{
				Executions.getCurrent().sendRedirect("/index.zul");
			}
		}else{
			Executions.getCurrent().sendRedirect("/index.zul");
		}
	}
}
