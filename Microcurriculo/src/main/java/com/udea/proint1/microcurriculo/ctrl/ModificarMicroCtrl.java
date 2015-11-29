package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
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
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * controlador principal para la modificación de microcurriculos
 * @author Elmer Urrea & Edwin Acosta
 *
 */
public class ModificarMicroCtrl extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(ModificarMicroCtrl.class);
	
	Div divSeleccionaMicrocurriculo;
	
	Panel panelModificarMicro;
	
	Button btnAddObjetivo;
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddSubTema;
	Button btnAddEvaluacion;
	Button btnAddBibliografia;
	Button btnAddCibergrafia;
	Button btnGuardar;
	
	Include panelDuplicarMicro;
	
	Borderlayout blyDuplicarMicro;
	Borderlayout blyConsultarMicro;
	Borderlayout blyModificarMicro;
	
	Tabbox fichaContenidos;
	
	Div divContenido;
	
	Panel panelSemestre;
	Panel panelBuscarMicro;
	
	Combobox cmbSemestre2;
	Combobox cmbDocente;
	Combobox cmbSemestre;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbMateria;
	Combobox cmbUnidadAcademica2;
	Combobox cmbDependencia2;
	Combobox cmbNucleo2;
	Combobox cmbMateria2;
	Combobox cmbMicrocurriculo;
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbListaTemas;
	Combobox cmbListaUnidadBiblio;
	Combobox cmbTipoBibliografia;
	Combobox cmbTipoCibergrafia;
	Combobox cmbEstado;
	
	Label lblIdMicrocurriculo;
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreNucleo;
	Label lblNombreMateria;
	Label lblNombreDocente;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	Label lblCampoFormacion;
	Label lblCorrequisitos;
	Label lblPrerrequisitos;
	Label lblProgramasVinculados;
	Label lblResumenMicro;
	Label lblPropositoMicro;
	Label lblJustificacionMicro;
	Label lblObjetivoGeneral;
	Label lblUsuarioLogin;
	Label lblFechaActual;
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtResumenMicro;
	Textbox txtObjetivoEspecifico;
	Textbox txtNombreUnidad;
	Textbox txtNombreTema;
	Longbox txtNumeroSemanas;
	Textbox txtSubTemas;
	Textbox txtActividadMicro;
	Longbox txtPorcentajeActividad;
	Textbox txtReferenciaBiblio;
	Textbox txtAutorBiblio;
	Textbox txtISBNBiblio;
	Textbox txtNombreSitioCiber;
	Textbox txtURLSitioCiber;
	
	Datebox dtFechaEvaluacion;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	Toolbarbutton tool_save;
	Toolbarbutton tool_print;
	Toolbarbutton tool_atras;
	
	TbAdmRol rolPersona;
	
	private static Date fechaActual = new Date();
	String userName;
	String nombrePersona;
	String apellidoPersona;
	String idPersona;
	int rol;
	
	/**
	 * Objeto docente logueado en session.
	 */
	TbAdmPersona docenteSession = null;
	
	/**
	 * definición de formato de fecha corta
	 */
	DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	/**
	 * microcurriculo editado
	 */
	TbMicMicrocurriculo microcurriculoGuardar;
	
	/**
	 * microcurriculo x estado a guardar
	 */
	TbMicMicroxestado microxEstadoGuardar = null;
	
	/**
	 * listas de guardado de datos
	 */
	
	public static List<TbAdmUnidadAcademica> listaUnidadAcademica;
	public static List<TbAdmDependencia> listaDependencias;
	public static List<TbAdmNucleo> listaNucleos;
	public static List<TbAdmMateria> listaMaterias;
	public static List<TbAdmPersona> listaDocentes;
	public static List<TbAdmSemestre> listaSemestre;
	public static List<TbMicEstado> listaEstados;
	public static List<TbMicMicrocurriculo> listaMicrocurriculos;
	
	/**
	 * Listas manejo de datos a modificar
	 */
	
	public static List<TbMicObjetivoxmicro> listaObjetivosxMicroGuardar = new ArrayList<TbMicObjetivoxmicro>();
	public static List<TbMicObjetivoxmicro> listaObjetivosxMicroBorrar = new ArrayList<TbMicObjetivoxmicro>();
	public static List<TbMicUnidadxmicro> listaUnidadesxMicroGuardar = new ArrayList<TbMicUnidadxmicro>();
	public static List<TbMicUnidadxmicro> listaUnidadesxMicroBorrar = new ArrayList<TbMicUnidadxmicro>();
	public static List<TbMicTemaxunidad> listaTemasxUnidadGuardar = new ArrayList<TbMicTemaxunidad>();
	public static List<TbMicTemaxunidad> listaTemasxUnidadBorrar = new ArrayList<TbMicTemaxunidad>();
	public static List<TbMicSubtemaxtema> listaSubtemasxTemaGuardar = new ArrayList<TbMicSubtemaxtema>();
	public static List<TbMicSubtemaxtema> listaSubtemasxTemaBorrar = new ArrayList<TbMicSubtemaxtema>();
	public static List<TbMicEvaluacionxmicro> listaEvaluacionesxMicroGuardar = new ArrayList<TbMicEvaluacionxmicro>();
	public static List<TbMicEvaluacionxmicro> listaEvaluacionesxMicroBorrar = new ArrayList<TbMicEvaluacionxmicro>();
	public static List<TbMicBiblioxunidad> listaBibliosxUnidadGuardar = new ArrayList<TbMicBiblioxunidad>();
	public static List<TbMicBiblioxunidad> listaBibliosxUnidadBorrar = new ArrayList<TbMicBiblioxunidad>();
	public static List<TbAdmHistorico> listaHistoricos = new ArrayList<TbAdmHistorico>();
	
	/**
	 * Variable de actualización objetivo general
	 */
	public static TbMicObjetivo objetivoGeneralGuardar = null;
	
	/**
	 * Variable de control de porcentaje, que no sobrepase el 100%
	 */
	int porcentajeEvaluacion = 0;
	
	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;
	UnidadNGC unidadNGC;
	ObjetivoNGC objetivoNGC;
	TemaNGC temaNGC;
	SubtemaNGC subtemaNGC;
	BibliografiaNGC bibliografiaNGC;
	EvaluacionNGC evaluacionNGC;
	MicroxEstadoNGC microxEstadoNGC;
	MicrocurriculoNGC microcurriculoNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	EstadoNGC estadoNGC;
	RolxUsuarioNGC rolxUsuarioNGC;
	
	public void setRolxUsuarioNGC(RolxUsuarioNGC rolxUsuarioNGC) {
		this.rolxUsuarioNGC = rolxUsuarioNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la gestion de microcurriculo por lotes
	 * @param guardarMicrocurriculoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setGuardarMicrocurriculoNGC(
			GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicUnidad
	 * @param unidadNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setUnidadNGC(UnidadNGC unidadNGC) {
		this.unidadNGC = unidadNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicObjetivo
	 * @param objetivoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setObjetivoNGC(ObjetivoNGC objetivoNGC) {
		this.objetivoNGC = objetivoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicTema
	 * @param temaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setTemaNGC(TemaNGC temaNGC) {
		this.temaNGC = temaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicSubtema
	 * @param subtemaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setSubtemaNGC(SubtemaNGC subtemaNGC) {
		this.subtemaNGC = subtemaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicBibliografia
	 * @param bibliografiaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setBibliografiaNGC(BibliografiaNGC bibliografiaNGC) {
		this.bibliografiaNGC = bibliografiaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicEvaluacion
	 * @param evaluacionNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setEvaluacionNGC(EvaluacionNGC evaluacionNGC) {
		this.evaluacionNGC = evaluacionNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmMicroxEstado
	 * @param microxEstadoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmUnidadAcademica
	 * @param unidadAcademicaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmDependencia
	 * @param dependenciaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmNucleo
	 * @param nucleoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmMateria
	 * @param materiaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicEstado
	 * @param estadoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}
	
	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicMicrocurriculo
	 * @param microcurriculoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmSemestre
	 * @param semestreNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbAdmPersona
	 * @param personaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicObjetivoxMicro
	 * @param objetivoxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicCorrequisito
	 * @param correquisitoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicPrerrequisito
	 * @param prerrequisitoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicUnidad
	 * @param unidadxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicTemaxUnidad
	 * @param temaxUnidadNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicSubtemaxTema
	 * @param subtemaxTemaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicEvaluacionxMicro
	 * @param evaluacionxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	/**
	 * Metodo set para la inyección de dependencia y gestionar datos en la tabla TbMicBiblioxUnidad
	 * @param biblioxUnidadNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}
	
	private void reiniciarListas(){
		listaObjetivosxMicroGuardar.clear();
		listaObjetivosxMicroBorrar.clear();
		listaUnidadesxMicroGuardar.clear();
		listaUnidadesxMicroBorrar.clear();
		listaTemasxUnidadGuardar.clear();
		listaTemasxUnidadBorrar.clear();
		listaSubtemasxTemaGuardar.clear();
		listaSubtemasxTemaBorrar.clear();
		listaEvaluacionesxMicroGuardar.clear();
		listaEvaluacionesxMicroBorrar.clear();
		listaBibliosxUnidadGuardar.clear();
		listaBibliosxUnidadBorrar.clear();
		
		listaObjetivosEspecificos.getItems().clear();
		listaBibliografia.getItems().clear();
		listaCibergrafia.getItems().clear();
		listaEvaluaciones.getItems().clear();
		listaObjetivosEspecificos.getItems().clear();
		listaSubtemas.getItems().clear();
		listaTemas.getItems().clear();
		listaUnidades.getItems().clear();
	}
	
	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
	 */
//	private void cargarUnidades(){
//		try {
//			listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
//			if (listaUnidadAcademica != null){			
//				cmbUnidadAcademica2.appendChild(new Comboitem("[Seleccione]"));
//				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
//					Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
//					cmbUnidadAcademica2.appendChild(item);
//				}
//				cmbUnidadAcademica2.setValue("[Seleccione]");
//			}
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
////			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//	}		
//	}
//	
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
//				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
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
		
		cmbDependencia2.getItems().clear();
		if (listaDependencias != null){
			cmbDependencia2.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDependencia dependencia : listaDependencias){
				Comboitem item = new Comboitem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
				cmbDependencia2.appendChild(item);
			}
			cmbDependencia2.setValue("[Seleccione]");
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
		
		cmbNucleo2.getItems().clear();
		if (listaNucleos != null){
			cmbNucleo2.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmNucleo nucleo : listaNucleos){
				Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+nucleo.getVrNombre());
				cmbNucleo2.appendChild(item);
			}
			cmbNucleo2.setValue("[Seleccione]");
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
		
		cmbMateria2.getItems().clear();
		if(listaMaterias != null){
			cmbMateria2.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmMateria materia : listaMaterias){
				Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
				cmbMateria2.appendChild(item);
			}
			cmbMateria2.setValue("[Seleccione]");
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
			if(listaMicrocurriculos != null){
				cmbMicrocurriculo.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
					Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
					cmbMicrocurriculo.appendChild(item);
				}
				cmbMicrocurriculo.setValue("[Seleccione]");
			}
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		cmbDocente.getItems().clear();
		listaDocentes = new ArrayList<TbAdmPersona>();
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
	
	/**
	 * Hace la busqueda de estados y los ubica en el cmbEstado
	 */
//	private void cargarEstados(){
//		cmbEstado.getItems().clear();
//		try {
//			 listaEstados = estadoNGC.listarEstados();
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
////			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//		
//		if(listaEstados != null){
//			for(TbMicEstado estado: listaEstados){
//				if((estado.getNbIdestado()==1)||(estado.getNbIdestado()==2)){
//					Comboitem item = new Comboitem(estado.getVrDescripcion());
//					cmbEstado.appendChild(item);
//				}
//			}
//		}		
//	}
	
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
		
		imprimirEstados();
				
	}
	
	private void imprimirEstados(){
		if(listaEstados != null){
			cmbEstado.setValue(listaEstados.get(0).getVrDescripcion());
			
			switch (rol) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				for(TbMicEstado estado: listaEstados){
					if((estado.getNbIdestado() == 2)||(estado.getNbIdestado() == 3)||(estado.getNbIdestado() == 4)){
						Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
						item.setDescription(estado.getVrDescripcion());
						cmbEstado.appendChild(item);
					}
				}
				break;
			case 4:
				for(TbMicEstado estado: listaEstados){
					if((estado.getNbIdestado() == 1)||(estado.getNbIdestado() == 2)){
						Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
						item.setDescription(estado.getVrDescripcion());
						cmbEstado.appendChild(item);
					}
				}
				break;
			case 7:
				for(TbMicEstado estado: listaEstados){
					if((estado.getNbIdestado() == 4)||(estado.getNbIdestado() == 5)||(estado.getNbIdestado() == 6)){
						Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
						item.setDescription(estado.getVrDescripcion());
						cmbEstado.appendChild(item);
					}
				}
				break;
			}
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica2(){
		if(cmbUnidadAcademica.getSelectedIndex() != 0){
			TbAdmUnidadAcademica unidad = listaUnidadAcademica.get(cmbUnidadAcademica2.getSelectedIndex()-1);
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
	 * Ante el evento seleccion en el combobox cmbDependencia este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia2(){
		if(cmbDependencia.getSelectedIndex() != 0){
			TbAdmDependencia dependencia = listaDependencias.get(cmbDependencia2.getSelectedIndex()-1); 
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
	 * Ante el evento seleccion en el combobox cmbNucleo este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo2(){
		if(cmbNucleo.getSelectedIndex() != 0){
			TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo2.getSelectedIndex()-1);
			cargarMaterias(nucleo.getVrIdnucleo());
			cargarMicrocurriculos(nucleo.getVrIdnucleo());
		}else{
			cargarMaterias("");
			cargarMicrocurriculos("");
		}
		
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMateria este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbMateria2(){
		if(cmbMateria.getSelectedIndex() != 0){
			TbAdmMateria materia = listaMaterias.get(cmbMateria2.getSelectedIndex()-1);
			cargarMicrocurriculos(materia.getVrIdmateria());
		}else{
			cargarMicrocurriculos("");
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbMicrocurriculo el metodo procede a guardar en la sesion el
	 * microcurriculo seleccionado
	 */
	public void onSelect$cmbMicrocurriculo(){
		String idMicro = cmbMicrocurriculo.getValue().toString();
		
		if(!idMicro.equals("")&&(!idMicro.equals("[Seleccione]"))){
			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
		}else{
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
	}
	
	/**
	 * El Metodo gestiona el llenado de datos a modificar en el nuevo microcurriculo
	 * @param idMicro cadena de caracteres con identificacion de microcurriculo
	 */
	public void llenarDatos(TbMicMicrocurriculo micro){
		
		TbMicMicrocurriculo microcurriculo = micro;
		
//		if(idMicro != null&&(!idMicro.equals(""))){
//			try {
//				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
//			}catch(ExcepcionesDAO expDAO){
//				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expDAO.getMsjTecnico());
//			}catch(ExcepcionesLogica expNgs){
//				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expNgs.getMsjTecnico());
//			}catch(Exception exp){
////				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(exp);
//			}
			
			/**
			 * Verifica que el microcurriculo retornado no es nulo o si no reinicia busqueda para seleccionar nuevo
			 * microcurriculo a duplicar
			 */
			
			if(microcurriculo != null){				
				microcurriculoGuardar = microcurriculo;
				reiniciarListas();
				llenarInfoGeneral(microcurriculo);
				llenarDatosDependencias(microcurriculo);
				llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarDatosMateria(microcurriculo.getTbAdmMateria());
				llenarDatosComplementarios(microcurriculo);
				llenarUnidadesTemasBiblios(microcurriculo.getVrIdmicrocurriculo());
				llenarEvaluaciones(microcurriculo.getVrIdmicrocurriculo());
				
			}else{
				redireccionar();
			}
//		}
	}
	
//	public void onClick$tool_atras(){
//		redireccionar();
//	}
	
	public void redireccionar(){
		Executions.getCurrent().sendRedirect("/_ambientes/_docente/inicioDocente.zul");
	}
	
//	/**
//	 *  reinicia la busqueda de microcurriculos a modificar
//	 */
//	public void ReiniciarBusqueda(){
//		panelModificarMicro.setVisible(true);
//		fichaContenidos.setVisible(false);
//		cargarUnidades();
//		cargarDependencias("");
//		cargarNucleos("");
//		cargarMaterias("");
//		cargarMicrocurriculos("");
//		
//		/**
//		 * Remueve variables de sesion si existen
//		 */
//		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
//			Executions.getCurrent().getSession().removeAttribute("idMicro");
//		}
//	}
	
	/**
	 * Permite mostrar en la vista los datos asociados a la información general del microcurriculo
	 * y es controlada para evitar errores del usuario
	 * @param microcurriculo objeto con parametros definidos para microcurriculo
	 */
	public void llenarInfoGeneral(TbMicMicrocurriculo microcurriculo){
		
		cmbSemestre.setValue(microcurriculo.getTbAdmSemestre().getVrIdsemestre());
		cmbSemestre.setDisabled(true);
		lblIdMicrocurriculo.setValue(microcurriculo.getVrIdmicrocurriculo());
		cmbEstado.setValue(microcurriculo.getTbMicEstado().getVrDescripcion());
		
		/**
		 * Variable de conteo de items (contador)
		 */
		
		int contador = 0;
		if(listaDocentes != null){
			for(TbAdmPersona docente: listaDocentes){
				contador++;
				if(docente.getVrIdpersona().equals(microcurriculo.getTbAdmPersona().getVrIdpersona())){
					cmbDocente.setSelectedIndex(contador);
				}
			}
		}
		
	}
	
	/**
	 * Permite mostrar en la vista los datos asociados a las dependencias del microcurriculo y son controladas
	 * para evitar errores del usuario
	 * @param microcurriculo objeto con parametros definidos para microcurriculo
	 */
	public void llenarDatosDependencias(TbMicMicrocurriculo microcurriculo){
		
		cmbUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad()
				+" - "+ microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
		cmbUnidadAcademica.setDisabled(true);
		cmbDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia()
				+" - "+microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
		cmbDependencia.setDisabled(true);
		cmbNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrIdnucleo()+" - "+microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
		cmbNucleo.setDisabled(true);
		cmbMateria.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria()+" - "+microcurriculo.getTbAdmMateria().getVrNombre());
		cmbMateria.setDisabled(true);
		
	}
	
	/**
	 * Permite mostrar en la vista los datos de la materia asociada al microcurriculo a duplicar o consultar
	 * @param materia objeto con parametros definidos para materia
	 */
	public void llenarDatosMateria(TbAdmMateria materia){
		
		lblCreditosMateria.setValue(Integer.toString(materia.getNbCreditos()));
		lblHtMateria.setValue(Integer.toString(materia.getNbHt()));
		lblHpMateria.setValue(Integer.toString(materia.getNbHp()));
		lblHtpMateria.setValue(Integer.toString(materia.getNbHtp()));
		
		int ht = materia.getNbHt();
		int hp = materia.getNbHp();
		int htp = materia.getNbHtp();
		int horasSemestral = (ht+hp+htp)*16;
		
		lblHoraClaseSemestral.setValue(Integer.toString(horasSemestral));
		if((materia.getBlClasificable())==1){
			ckbClasificable.setChecked(true);
		}else if((materia.getBlClasificable())==0){
			ckbClasificable.setChecked(false);
		}
		if((materia.getBlHabilitable()) == 1){
			ckbHabilitable.setChecked(true);
		}else if((materia.getBlHabilitable()) == 0){
			ckbHabilitable.setChecked(false);
		}
		if((materia.getBlValidable()) == 1){
			ckbValidable.setChecked(true);
		}else if((materia.getBlValidable()) == 0){
			ckbValidable.setChecked(false);
		}
		
	}
	
	/**
	 * Hace busqueda y muestra al usuario los correquisitos asociados a la materia
	 * @param idMateria cadena de caracteres con identificacion de la materia
	 */
	public void llenarCorrequisitos(String idMateria){
		String listaCorrequisitos = "";
		 
		List<TbAdmCorrequisito> correquisitos = null;
		try {
			correquisitos = correquisitoNGC.listarCorrequisitosxMateria(idMateria);
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
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera = true;
		if(correquisitos != null){
			for(TbAdmCorrequisito correquisito: correquisitos){
				if(bandera){
					listaCorrequisitos = correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre();
					bandera = false;
				}else{
					listaCorrequisitos = listaCorrequisitos + "\n"+(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
				}
			}
		}
		lblCorrequisitos.setValue(listaCorrequisitos);
	}
	
	/**
	 * Hace busqueda y muestra al usuario los prerrequisitos asociados a la materia
	 * @param idMateria cadena de caracteres con identificacion de la materia
	 */
	public void llenarPrerrequisitos(String idMateria){
		String listaPrerrequisitos = "";
		
		List<TbAdmPrerrequisito> prerrequisitos = null;
		try {
			prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(idMateria);
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
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera2 = true;
		if(prerrequisitos != null){
			for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
				if(bandera2){
					listaPrerrequisitos = prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre();
					bandera2 = false;
				}else{
					listaPrerrequisitos = listaPrerrequisitos + "\n"+(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
				}
			}
		}
		lblPrerrequisitos.setValue(listaPrerrequisitos);
	}
	
	/**
	 * Permite mostrar en la vista los datos complementarios asociados al microcurriculo a duplicar
	 * dejandolos listos para ser modificados
	 * @param microcurriculo objeto con parametros definidos para materia
	 */
	public void llenarDatosComplementarios(TbMicMicrocurriculo microcurriculo){
		
		txtJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
		txtPropositoMicro.setValue(microcurriculo.getVrProposito());
		txtResumenMicro.setValue(microcurriculo.getVrResumen());
		List<TbMicObjetivoxmicro> objetivosxMicro = null;
		try {
			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(microcurriculo.getVrIdmicrocurriculo());
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
		
		if(objetivosxMicro != null){
			for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
				if(objetivoxMicro.getBlTipo()=='1'){
					txtObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				}else{
					
					/**
					 * implantacion del metodo de borrado de item, a través del doble click
					 */
					
					final Listitem item = new Listitem();
					item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							eliminaListItem(item,"");
						}
					});
					
					Listcell celda = new Listcell(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
					item.appendChild(celda);
					listaObjetivosEspecificos.appendChild(item);
					
					listaObjetivosxMicroGuardar.add(objetivoxMicro);
					
				}
			}
//			System.out.println("objetivos especificos");
//			for(TbMicObjetivoxmicro objetivoxMicro: listaObjetivosxMicroGuardar){
//				System.out.println(objetivoxMicro.getTbMicObjetivo().getNbIdobjetivo());
//			}
		}
	}
	
	/**
	 * Metodo a la espera del evento click en el boton btnAddObjetivo para validar si la información se ingresó
	 * para luego ser adicionada al listbox
	 * @param event
	 */
	public void onClick$btnAddObjetivo(Event event){
		if(txtObjetivoEspecifico.getValue() != null && (txtObjetivoEspecifico.getValue().trim().length() >0)){	
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem,"");
				}
			});
			Listcell celda = new Listcell(txtObjetivoEspecifico.getValue());
			listaItem.appendChild(celda);			
			listaObjetivosEspecificos.appendChild(listaItem);
			TbMicObjetivo objetivoGuardar = new TbMicObjetivo(txtObjetivoEspecifico.getValue().toString(), "SYSTEM", new Date());
			TbMicObjetivoxmicro objetivoxMicro = new TbMicObjetivoxmicro(objetivoGuardar, microcurriculoGuardar, '0', "SYSTEM", new Date());
			listaObjetivosxMicroGuardar.add(objetivoxMicro);
			txtObjetivoEspecifico.setText(null);
			txtObjetivoEspecifico.setValue(null);
		} else {
			Messagebox.show("Se Requiere información en el Campo <Objetivo Especifico>");
		}
	}
	
	/**
	 * El metodo procede a llenar los datos encontrados de unidades,temas, subtemas y bibliografias del microcurriculo
	 * @param idMicrocurriculo cadena de caracteres con identificacion de microcurriculo
	 */
	public void llenarUnidadesTemasBiblios(String idMicrocurriculo){
		
		List<TbMicUnidadxmicro> unidadesxMicro = null;
		try {
			unidadesxMicro = unidadxMicroNGC.listarUnidadesXMicroxMicro(idMicrocurriculo);
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
		/**
		 * Inicia buscando unidades relacionadas al microcurriculo y luego son agregadas
		 * a los listbox y combobox
		 */
		
		if(unidadesxMicro!=null)
		for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
			final Listitem item = new Listitem();
			final String tmpUnidad = unidadxMicro.getTbMicUnidad().getVrNombre(); 
			item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(item, tmpUnidad);
				}
			});
			
			Listcell celda1 = new Listcell("");
			item.appendChild(celda1);
			Listcell celda2 = new Listcell(unidadxMicro.getTbMicUnidad().getVrNombre());
			item.appendChild(celda2);
			listaUnidades.appendChild(item);
			
			Comboitem comboUnidad1 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbIdUnidad.appendChild(comboUnidad1);
			Comboitem comboUnidad2 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbListaUnidades.appendChild(comboUnidad2);
			Comboitem comboUnidad3 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbListaUnidadBiblio.appendChild(comboUnidad3);
			
			listaUnidadesxMicroGuardar.add(unidadxMicro);
			
			/**
			 * busca todos los temas x unidad asociados a las unidades y se ubican extraen los temas
			 * para llenar los listbox
			 */
			
			List<TbMicTemaxunidad> temasxUnidad = null;
			try {
				temasxUnidad = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
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
			if(temasxUnidad != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidad){
					final Listitem itemTemas = new Listitem();
					itemTemas.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							eliminaListItem(itemTemas, "");
						}
					});
					
					Listcell celdaTemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
					itemTemas.appendChild(celdaTemas1);
					Listcell celdaTemas2 = new Listcell(temaxUnidad.getTbMicTema().getVrDescripcion());
					itemTemas.appendChild(celdaTemas2);
					Listcell celdaTemas3 = new Listcell(Integer.toString(temaxUnidad.getNbSemanasRequeridas()));
					itemTemas.appendChild(celdaTemas3);
					listaTemas.appendChild(itemTemas);
					
					listaTemasxUnidadGuardar.add(temaxUnidad);
					
					/**
					 * Busca los subtemas x unidad y los extrae para ser agregados al listbox listaSubtemas
					 */
					
					List<TbMicSubtemaxtema> subtemasxTema = null;
					try {
						subtemasxTema = subtemaxTemaNGC.listarSubtemaxTema_Tema(temaxUnidad.getTbMicTema().getNbIdtema());
					}catch(ExcepcionesDAO expDAO){
						Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expDAO.getMsjTecnico());
					}catch(ExcepcionesLogica expNgs){
						Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(expNgs.getMsjTecnico());
					}catch(Exception exp){
//						Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
						logger.error(exp);
					}
					if(subtemasxTema != null){
						for(TbMicSubtemaxtema subtemaxTema: subtemasxTema){
							final Listitem itemSubtemas = new Listitem();
							itemSubtemas.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
								@Override
								public void onEvent(Event arg0) throws Exception {
									eliminaListItem(itemSubtemas, "");
								}
							});
							
							Listcell celdaSubtemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
							itemSubtemas.appendChild(celdaSubtemas1);
							Listcell celdaSubtemas2 = new Listcell(subtemaxTema.getTbMicTema().getVrDescripcion());
							itemSubtemas.appendChild(celdaSubtemas2);
							Listcell celdaSubtemas3 = new Listcell(subtemaxTema.getTbMicSubtema().getVrDescripcion());
							itemSubtemas.appendChild(celdaSubtemas3);
							listaSubtemas.appendChild(itemSubtemas);
							
							listaSubtemasxTemaGuardar.add(subtemaxTema);
							
						}
					}
				}
			}
			
			/**
			 * Hace la busqueda de las bibliografias asociadas a las unidades del microcurriculo y las agrega
			 * finalmente a los list box de las bibliografias
			 */
			
			List<TbMicBiblioxunidad> bibliosxUnidad = null;
			try {
				bibliosxUnidad = biblioxUnidadNGC.listadoBiblioxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
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
			
			if(bibliosxUnidad!=null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidad){
					if(biblioxUnidad.getTbMicBibliografia().getVrSitioweb() == null){
						final Listitem itemBiblio = new Listitem();
						itemBiblio.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
							@Override
							public void onEvent(Event arg0) throws Exception {
								eliminaListItem(itemBiblio, "");
							}
						});
						
						Listcell celdaBiblio0 = new Listcell(biblioxUnidad.getTbMicUnidad().getVrNombre());
						itemBiblio.appendChild(celdaBiblio0);
						Listcell celdaBiblio1 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrNombre());
						itemBiblio.appendChild(celdaBiblio1);
						Listcell celdaBiblio2 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrAutor());
						itemBiblio.appendChild(celdaBiblio2);
						Listcell celdaBiblio3 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrIsbn());
						itemBiblio.appendChild(celdaBiblio3);
						if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='1'){
							Listcell celdaBiblio4 = new Listcell("COMPLEMENTARIA");
							itemBiblio.appendChild(celdaBiblio4);
						}else if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='0'){
							Listcell celdaBiblio4 = new Listcell("BÁSICA");
							itemBiblio.appendChild(celdaBiblio4);
						}
						listaBibliografia.appendChild(itemBiblio);
						
						listaBibliosxUnidadGuardar.add(biblioxUnidad);
						
					}else{
						final Listitem itemBiblio = new Listitem();
						itemBiblio.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
							@Override
							public void onEvent(Event arg0) throws Exception {
								eliminaListItem(itemBiblio, "");
							}
						});
						
						Listcell celdaBiblio0 = new Listcell(biblioxUnidad.getTbMicUnidad().getVrNombre());
						itemBiblio.appendChild(celdaBiblio0);
						Listcell celdaBiblio1 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrNombre());
						itemBiblio.appendChild(celdaBiblio1);
						Listcell celdaBiblio2 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrSitioweb());
						itemBiblio.appendChild(celdaBiblio2);
						if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='1'){
							Listcell celdaBiblio3 = new Listcell("COMPLEMENTARIA");
							itemBiblio.appendChild(celdaBiblio3);
						}else if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='0'){
							Listcell celdaBiblio3 = new Listcell("BÁSICA");
							itemBiblio.appendChild(celdaBiblio3);
						}
						listaCibergrafia.appendChild(itemBiblio);
						
						listaBibliosxUnidadGuardar.add(biblioxUnidad);
						
					}
				}
			}
		}
//		System.out.println("unidades");
//		for(TbMicUnidadxmicro unidad: listaUnidadesxMicroGuardar){
//			System.out.println(unidad.getNbId());
//		}
//		System.out.println("temas");
//		for(TbMicTemaxunidad tema: listaTemasxUnidadGuardar){
//			System.out.println(tema.getNbId());
//		}
//		System.out.println("subtemas");
//		for(TbMicSubtemaxtema subtema: listaSubtemasxTemaGuardar){
//			System.out.println(subtema.getNbid());
//		}
	}
	
	/**
	 * El metodo procede a llenar las evaluaciones encontradas del microcurriculo
	 * Solo aplica para la consulta, porque para el duplicado se asumen fechas diferentes de evaluaciones
	 * @param idMicrocurriculo cadena de caracteres con identificacion del microcurriculo
	 */
	public void llenarEvaluaciones(String idMicrocurriculo){
		
		List<TbMicEvaluacionxmicro> evaluacionesxMicro = null;
		try {
			evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(idMicrocurriculo);
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
		if(evaluacionesxMicro != null){
			for(TbMicEvaluacionxmicro evaluacionxmicro: evaluacionesxMicro){
				final Listitem item = new Listitem();
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						eliminaListItem(item, "");
					}
				});
				
				Listcell celda1 = new Listcell(evaluacionxmicro.getTbMicEvaluacion().getVrDescripcion());
				item.appendChild(celda1);
				Listcell celda2 = new Listcell(Integer.toString(evaluacionxmicro.getNbPorcentaje()));
				item.appendChild(celda2);
				Listcell celda3 = new Listcell(evaluacionxmicro.getDtFechaestimada().toString());
				item.appendChild(celda3);
				listaEvaluaciones.appendChild(item);
				
				listaEvaluacionesxMicroGuardar.add(evaluacionxmicro);
				
			}
//			System.out.println("evaluaciones");
//			for(TbMicEvaluacionxmicro evaluacion: listaEvaluacionesxMicroGuardar){
//				System.out.println(evaluacion.getNbId());
//			}
		}
	}
	
	/**
	 * Atiende a los eventos de doble click en las listas que corresponden al borrado de items
	 * El metodo revisa la lista que hizo el llamado y procede a borrar en cascada (y/o) borrar item
	 * @param item fila a borrar en la lista
	 * @param clave identificacion del objeto borrado no siempre es enviado
	 */
	private void eliminaListItem(Listitem item, String clave){
		if(item.getParent().getId().toString().equals("listaUnidades")){
			quitarUnidad(item);
			eliminaCascadaUnidad(item, clave.toUpperCase());
			item.detach();
			recargarCombosUnidades(listaUnidades);
		} else if (item.getParent().getId().toString().equals("listaTemas")){
			quitarTema(item);
			eliminaCascadaTema(item, clave.toUpperCase());
			item.detach();
			recargarCombosTemas(listaTemas);
		} else if(item.getParent().getId().toString().equals("listaSubtemas")){
			quitarSubtema(item);
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaEvaluaciones")){
			quitarEvaluacion(item);
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			porcentajeEvaluacion = porcentajeEvaluacion - Integer.parseInt(celdaPorcentaje.getLabel());
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaBibliografia")){
			quitarBibliografia(item);
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaCibergrafia")){
			quitarCibergrafia(item);
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaObjetivosEspecificos")){
			quitarObjetivo(item);
			item.detach();
		}
	}
	
	/**
	 * Ante el borrado de un item en bibliografia, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista bibliografias
	 */
	public void quitarBibliografia(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(1);
		String nombreBibliografia = celda.getLabel();
		
		/**
		 * Busca en la lista de temas el item borrado
		 */
		
		TbMicBiblioxunidad bibliografiaBorrar = null;
		if(listaBibliosxUnidadGuardar != null){
			for(TbMicBiblioxunidad bibliografia: listaBibliosxUnidadGuardar){
				if(bibliografia.getTbMicBibliografia().getVrNombre().equals(nombreBibliografia)){
					bibliografiaBorrar = bibliografia;
				}
			}
		}
		
		if(bibliografiaBorrar != null){
			
			/**
			 * actualiza en las listas el subtema a quitar
			 */
			
			listaBibliosxUnidadGuardar.remove(bibliografiaBorrar);
			listaBibliosxUnidadBorrar.add(bibliografiaBorrar);
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicBiblioxunidad cibergrafia: listaBibliosxUnidadGuardar){
//			System.out.println(cibergrafia.getNbId());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicBiblioxunidad cibergrafia: listaBibliosxUnidadBorrar){
//			System.out.println(cibergrafia.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un item en bibliografia, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista cibergrafias
	 */
	public void quitarCibergrafia(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(2);
		String nombreCibergrafia = celda.getLabel();
		
		/**
		 * Busca en la lista de temas el item borrado
		 */
		
		TbMicBiblioxunidad cibergrafiaBorrar = null;
		if(listaBibliosxUnidadGuardar != null){
			for(TbMicBiblioxunidad cibergrafia: listaBibliosxUnidadGuardar){
				if(cibergrafia.getTbMicBibliografia().getVrSitioweb() != null){
					if(cibergrafia.getTbMicBibliografia().getVrSitioweb().equals(nombreCibergrafia)){
						cibergrafiaBorrar = cibergrafia;
					}
				}
			}
		}
		
		if(cibergrafiaBorrar != null){
			
			/**
			 * actualiza en las listas el subtema a quitar
			 */
			
			listaBibliosxUnidadGuardar.remove(cibergrafiaBorrar);
			listaBibliosxUnidadBorrar.add(cibergrafiaBorrar);
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicBiblioxunidad cibergrafia: listaBibliosxUnidadGuardar){
//			System.out.println(cibergrafia.getNbId());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicBiblioxunidad cibergrafia: listaBibliosxUnidadBorrar){
//			System.out.println(cibergrafia.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un item en evaluacion, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista evaluaciones
	 */
	public void quitarEvaluacion(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(0);
		String nombreEvaluacion = celda.getLabel();
		
		/**
		 * Busca en la lista de temas el item borrado
		 */
		
		TbMicEvaluacionxmicro evaluacionBorrar = null;
		if(listaEvaluacionesxMicroGuardar != null){
			for(TbMicEvaluacionxmicro evaluacion: listaEvaluacionesxMicroGuardar){
				if(evaluacion.getTbMicEvaluacion().getVrDescripcion().equals(nombreEvaluacion)){
					evaluacionBorrar = evaluacion;
				}
			}
		}
		
		if(evaluacionBorrar != null){
			
			/**
			 * actualiza en las listas el subtema a quitar
			 */
			
			listaEvaluacionesxMicroGuardar.remove(evaluacionBorrar);
			listaEvaluacionesxMicroBorrar.add(evaluacionBorrar);
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicEvaluacionxmicro evaluacion: listaEvaluacionesxMicroGuardar){
//			System.out.println(evaluacion.getNbId());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicEvaluacionxmicro evaluacion: listaEvaluacionesxMicroBorrar){
//			System.out.println(evaluacion.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un item en subtemas, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista subtemas
	 */
	public void quitarSubtema(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(2);
		String nombreSubtema = celda.getLabel();
		
		/**
		 * Busca en la lista de temas el item borrado
		 */
		
		TbMicSubtemaxtema subtemaBorrar = null;
		if(listaSubtemasxTemaGuardar != null){
			for(TbMicSubtemaxtema subtema: listaSubtemasxTemaGuardar){
				if(subtema.getTbMicSubtema().getVrDescripcion().equals(nombreSubtema)){
					subtemaBorrar = subtema;
				}
			}
		}
		
		if(subtemaBorrar != null){
			
			/**
			 * actualiza en las listas el subtema a quitar
			 */
			
			listaSubtemasxTemaGuardar.remove(subtemaBorrar);
			listaSubtemasxTemaBorrar.add(subtemaBorrar);
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicSubtemaxtema subtema: listaSubtemasxTemaGuardar){
//			System.out.println(subtema.getNbid());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicSubtemaxtema subtema: listaSubtemasxTemaBorrar){
//			System.out.println(subtema.getNbid());
//		}
	}
	
	/**
	 * Ante el borrado de un item en temas, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista temas
	 */
	public void quitarTema(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(1);
		String nombreTema = celda.getLabel();
		
		/**
		 * Busca en la lista de temas el item borrado
		 */
		
		TbMicTemaxunidad temaBorrar = null;
		if(listaObjetivosxMicroGuardar != null){
			for(TbMicTemaxunidad tema: listaTemasxUnidadGuardar){
				if(tema.getTbMicTema().getVrDescripcion().equals(nombreTema)){
					temaBorrar = tema;
				}
			}
		}
		
		if(temaBorrar != null){
			
			/**
			 * invoca el metodo que procede a borrar subtemas asociados al subtema a borrar
			 */
			quitarCascadaSubtemas(temaBorrar.getTbMicTema().getNbIdtema());
			
			/**
			 * actualiza en las listas el tema a quitar
			 */
			
			listaTemasxUnidadGuardar.remove(temaBorrar);
			listaTemasxUnidadBorrar.add(temaBorrar);
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicTemaxunidad tema: listaTemasxUnidadGuardar){
//			System.out.println(tema.getNbId());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicTemaxunidad tema: listaTemasxUnidadGuardar){
//			System.out.println(tema.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un item en objetivos, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista objetivos especificos
	 */
	public void quitarObjetivo(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(0);
		String nombreObjetivo = celda.getLabel();
		
		/**
		 * Busca en la lista de objetivos el item borrado
		 */
		
		TbMicObjetivoxmicro objetivoBorrar = null;
		if(listaObjetivosxMicroGuardar != null){
			for(TbMicObjetivoxmicro objetivo: listaObjetivosxMicroGuardar){
				if(objetivo.getTbMicObjetivo().getVrDescripcion().equals(nombreObjetivo)){
					objetivoBorrar = objetivo;
				}
			}
		}
		
		if(objetivoBorrar != null){
			/**
			 * actualiza en las listas el objetivo a quitar
			 */
			
			listaObjetivosxMicroGuardar.remove(objetivoBorrar);
			listaObjetivosxMicroBorrar.add(objetivoBorrar);
		}
//		System.out.println("objetivos despues de borrar");
//		for(TbMicObjetivoxmicro objetivo: listaObjetivosxMicroGuardar){
//			System.out.println(objetivo.getNbId());
//		}
//		System.out.println("--objetivos a borrar--");
//		for(TbMicObjetivoxmicro objetivo: listaObjetivosxMicroBorrar){
//			System.out.println(objetivo.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un item en unidades, se procede a identificar el item borrado
	 * para registrarlo en una lista para ser borrado en base de datos
	 * @param item elemento de lista unidades
	 */
	public void quitarUnidad(Listitem item){
		/**
		 * Estracción de datos del item que llega por parametro
		 */
		
		Listcell celda = (Listcell) item.getChildren().get(1);
		String nombreUnidad = celda.getLabel();
		
		/**
		 * Busca en la lista de unidades el item borrado
		 */
		
		TbMicUnidadxmicro unidadBorrar = null;
		if(listaUnidadesxMicroGuardar != null){
			for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroGuardar){
				if(unidadxMicro.getTbMicUnidad().getVrNombre().equals(nombreUnidad)){
					unidadBorrar = unidadxMicro;
				}
			}
		}
		
		if(unidadBorrar != null){
			/**
			 * invoca el metodo de borrado en cascada asociado a la unidad
			 */
			quitarCascadaTemas(unidadBorrar.getTbMicUnidad().getNbIdunidad());
			
			quitarCascadaBibliografía(unidadBorrar.getTbMicUnidad().getNbIdunidad());
			
			/**
			 * actualiza en las listas la unidad a quitar
			 */
			
			listaUnidadesxMicroGuardar.remove(unidadBorrar);
			listaUnidadesxMicroBorrar.add(unidadBorrar);
		}
//		System.out.println("unidades despues de borrar");
//		for(TbMicUnidadxmicro unidad: listaUnidadesxMicroGuardar){
//			System.out.println(unidad.getNbId());
//		}
//		System.out.println("--unidades a borrar--");
//		for(TbMicUnidadxmicro unidad: listaUnidadesxMicroBorrar){
//			System.out.println(unidad.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de unidades, el metodo borra en cascada los temas asociados a la unidad
	 * borrada
	 * @param idUnidad identidad de la unidad borrada
	 */
	public void quitarCascadaTemas(int idUnidad){
		
		/**
		 * El dato booleno permite que se permanezca borrando temas hasta que no hayan más
		 * asociados
		 */
		
		boolean seguirBorrando = true;
		while(seguirBorrando){
			seguirBorrando = false;
			TbMicTemaxunidad temaxUnidadBorrar = null;
			
			/**
			 * Busca en la lista los temas asociados a borrar
			 */
			
			if(listaTemasxUnidadGuardar != null){
				for(TbMicTemaxunidad temaxUnidad: listaTemasxUnidadGuardar){
					if(temaxUnidad.getTbMicUnidad().getNbIdunidad() == idUnidad){
						temaxUnidadBorrar = temaxUnidad;
						seguirBorrando = true;
					}
				}
			}
				
			/**
			 * procede a borrar en los listados el tema
			 */
			
			if(temaxUnidadBorrar != null){
				/**
				 * invoca el metodo que procede a borrar subtemas asociados al subtema a borrar
				 */
				quitarCascadaSubtemas(temaxUnidadBorrar.getTbMicTema().getNbIdtema());
				
				listaTemasxUnidadGuardar.remove(temaxUnidadBorrar);
				listaTemasxUnidadBorrar.add(temaxUnidadBorrar);
			}
		}
//		System.out.println("temas despues de borrar");
//		for(TbMicTemaxunidad tema: listaTemasxUnidadGuardar){
//			System.out.println(tema.getNbId());
//		}
//		System.out.println("--temas a borrar--");
//		for(TbMicTemaxunidad tema: listaTemasxUnidadBorrar){
//			System.out.println(tema.getNbId());
//		}
	}
	
	/**
	 * Ante el borrado de un tema, el metodo procede a borrar de los listados los
	 * subtemas asociados
	 * @param idTema identificación de tema borrado
	 */
	public void quitarCascadaSubtemas(int idTema){
		
		/**
		 * Variable boolena que indica cuando parar de borrar subtemas,
		 * cuando ya no hay subtemas asociados
		 */
		
		boolean seguirBorrando = true;
		while(seguirBorrando){
			seguirBorrando = false;
			
			/**
			 * Busca en todos los subtemas si alguno tiene asociación con el tema
			 */
			
			TbMicSubtemaxtema subtemaxtemaBorrar = null;
			if(listaSubtemasxTemaGuardar != null){
				for(TbMicSubtemaxtema subtemaxTema: listaSubtemasxTemaGuardar){
					if(subtemaxTema.getTbMicTema().getNbIdtema() == idTema){
						subtemaxtemaBorrar = subtemaxTema;
						seguirBorrando = true;
					}
				}
			}
			if(subtemaxtemaBorrar != null){
				listaSubtemasxTemaGuardar.remove(subtemaxtemaBorrar);
				listaSubtemasxTemaBorrar.add(subtemaxtemaBorrar);
			}
		}
//		System.out.println("subtemas despues de borrar");
//		for(TbMicSubtemaxtema subtema: listaSubtemasxTemaGuardar){
//			System.out.println(subtema.getNbid());
//		}
//		System.out.println("--subtemas a borrar--");
//		for(TbMicSubtemaxtema subtema: listaSubtemasxTemaBorrar){
//			System.out.println(subtema.getNbid());
//		}
	}
	
	/**
	 * Ante el borrado de unidades, el metodo borra en cascada las bibliografias asociadas a la unidad
	 * borrada
	 * @param idUnidad identidad de la unidad borrada
	 */
	public void quitarCascadaBibliografía(int idUnidad){
		
		/**
		 * El dato booleno permite que se permanezca borrando temas hasta que no hayan más
		 * asociados
		 */
		
		boolean seguirBorrando = true;
		while(seguirBorrando){
			seguirBorrando = false;
			TbMicBiblioxunidad BiblioxUnidadBorrar = null;
			
			/**
			 * Busca en la lista los temas asociados a borrar
			 */
			
			if(listaBibliosxUnidadGuardar != null){
				for(TbMicBiblioxunidad biblioxUnidad: listaBibliosxUnidadGuardar){
					if(biblioxUnidad.getTbMicUnidad().getNbIdunidad() == idUnidad){
						BiblioxUnidadBorrar = biblioxUnidad;
						seguirBorrando = true;
					}
				}
			}
				
			/**
			 * procede a borrar en los listados la bibliografia
			 */
			
			if(BiblioxUnidadBorrar != null){
				listaBibliosxUnidadGuardar.remove(BiblioxUnidadBorrar);
				listaBibliosxUnidadBorrar.add(BiblioxUnidadBorrar);
			}
		}
//		System.out.println("bibliografias despues de borrar");
//		for(TbMicBiblioxunidad tema: listaBibliosxUnidadGuardar){
//			System.out.println(tema.getNbId());
//		}
//		System.out.println("--biblio a borrar--");
//		for(TbMicBiblioxunidad tema: listaBibliosxUnidadBorrar){
//			System.out.println(tema.getNbId());
//		}
	}
	
	/**
	 * Elimina todos los subtemas asociados al tema que se borrará para que no queden sueltos
	 * sin refencia de alguno
	 * @param item fila a eliminar
	 * @param clave identificacion de tema
	 */
	private void eliminaCascadaTema(Listitem item, String clave){
		Listcell celda = (Listcell)item.getChildren().get(1);
		clave = celda.getLabel().toUpperCase();
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemSubtema.getChildren().get(1);
				if(clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
	}
	
	/**
	 * Hace la carga de los combos de los temas actuales, para facilitar la eleccion del usuario
	 * @param lista objeto lista de temas a llenar
	 */
	private void recargarCombosTemas(Listbox lista){
		cmbListaTemas.getItems().clear();
		
		if(lista.getItems().size() > 0){
			for(int i=1; i<= lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(1);
				Comboitem item = new Comboitem(celda.getLabel());
				cmbListaTemas.appendChild(item);
			}
		}
	}
	
	/**
	 * Elimina en cascada los items asociados a la Unidad a borrar, para que no queden
	 * referencias sueltas
	 * @param item objeto fila a borrar
	 * @param clave identificacion de unidad a borrar
	 */
	private void eliminaCascadaUnidad(Listitem item, String clave){
		if (listaBibliografia.getItems().size() > 0){
			for (int i=1; i<=listaBibliografia.getItems().size(); i++){
				Listitem itemBiblio = (Listitem)listaBibliografia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemBiblio.getChildren().get(0);
				if (clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemBiblio.detach();
					i--;
				}				
			}
		}
		
		if (listaCibergrafia.getItems().size() > 0){
			for(int i=1; i<=listaCibergrafia.getItems().size(); i++){
				Listitem itemCiber = (Listitem)listaCibergrafia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemCiber.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemCiber.detach();
					i--;
				}
			}
		}
		
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemSubtema.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
		if (listaTemas.getItems().size() > 0){
			for(int i=1;i<=listaTemas.getItems().size(); i++){
				Listitem itemTema = (Listitem)listaTemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemTema.getChildren().get(0);
				if (clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemTema.detach();
					i--;
				}
			}
		}
	}
	
	/**
	 * Hace la carga de unidades existentes en los combobox de busqueda para
	 * facilitar la eleccion del usuario
	 * @param lista objeto listado de unidades a recargar en los combobox
	 */
	private void recargarCombosUnidades(Listbox lista){
		cmbIdUnidad.getItems().clear();
		cmbListaUnidades.getItems().clear();
		cmbListaUnidadBiblio.getItems().clear();
		cmbListaTemas.getItems().clear();

		if (lista.getItems().size() > 0){
			for (int i=1; i <= lista.getItems().size(); i++ ){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(1);

				Comboitem itemUnidadTema = new Comboitem(celda.getLabel());
				cmbIdUnidad.appendChild(itemUnidadTema);
				Comboitem item2 = new Comboitem(celda.getLabel());
				cmbListaUnidades.appendChild(item2); 
				Comboitem item3 = new Comboitem(celda.getLabel());
				cmbListaUnidadBiblio.appendChild(item3);
			}	
		}	
	}
	
//	/**
//	 * Ante el evento click en el botón de reinicio de duplicado, procede a
//	 * llamar el metodo que reinicia el duplicado
//	 */
//	public void onClick$tool_modifica_otro(){
//		ReiniciarBusqueda();
//	}
	
	/**
	 * Boton btnAddTemas Evento onClick
	 * 
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validación de contenido existente.
	 * 
	 * @param event
	 */
	public void onClick$btnAddTemas(Event event){		
		validarCamposTemas(txtNombreTema.getValue().toUpperCase());
					
	}
	
	/**
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validación de contenido existente.
	 * 
	 */
	private void validarCamposTemas(String nombreTema){
		if(cmbIdUnidad.getValue().trim().length() > 0)
			if (txtNombreTema.getValue().trim().length() > 0 && (!"".equals(txtNombreTema.getValue())))
				if(txtNumeroSemanas.longValue() > 0){
					
					llenarListaTemas(nombreTema);
					cmbListaUnidades.setSelectedIndex(-1);
					cmbListaUnidades.setValue("");
				}else{
					Messagebox.show("Se requiere información en el campo <Tiempo (Semanas)>");
					txtNumeroSemanas.focus();
				}
			else{
				Messagebox.show("Se requiere información en el campo <Nombre Tema>");
				txtNombreTema.focus();
			}
		else{
			Messagebox.show("Se requiere información en el campo <Nombre Unidad>");
			cmbIdUnidad.focus();
		}
	}
	
	/**
	 * El metodo valida que no exista y agrega nuevos temas al listbox cmbListaTemas
	 * @param tema objeto tema con parametros definidos para ser ubicado junto a los otros temas existentes en la lista
	 */
	public void llenarListaTemas(String tema){
		final Listitem listaItem = new Listitem();
		final String tmpTema = tema.toUpperCase().trim();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem, tmpTema);
			}
		});
		
		if (!existeTema(tmpTema)){
			Listcell celdaUnidad = new Listcell(cmbIdUnidad.getValue());
			Listcell celdaTema = new Listcell(txtNombreTema.getValue().toUpperCase());		
			Listcell celdaTiempo = new Listcell(txtNumeroSemanas.getValue().toString());		
			listaItem.appendChild(celdaUnidad);
			listaItem.appendChild(celdaTema);
			listaItem.appendChild(celdaTiempo);
			
			Comboitem item = new Comboitem(txtNombreTema.getValue().toUpperCase());		
			cmbListaTemas.appendChild(item);
			
			/**
			 * Encapsulado de tema en la lista de objetos a guardar en base de datos
			 */
			
			TbMicTema temaGuardar = new TbMicTema(txtNombreTema.getValue().toUpperCase(), "SYSTEM", new Date());
			int Semanas = Integer.parseInt(txtNumeroSemanas.getValue().toString());
			TbMicUnidad unidadGuardar = null;
			for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroGuardar ){
				if(cmbIdUnidad.getValue().toString().equals(unidadxMicro.getTbMicUnidad().getVrNombre())){
					unidadGuardar = unidadxMicro.getTbMicUnidad();
				}
			}
			if(unidadGuardar != null){
				TbMicTemaxunidad temaxUnidadGuardar = new TbMicTemaxunidad(unidadGuardar, temaGuardar, Semanas, "SYSTEM", new Date());
				listaTemasxUnidadGuardar.add(temaxUnidadGuardar);
				
				listaTemas.appendChild(listaItem);
				cmbIdUnidad.setValue("");
				txtNombreTema.setValue("");
				txtNumeroSemanas.setValue(null);
			}else{
				Messagebox.show("Error en guardar tema");
			}
			
		} else{
			Messagebox.show("El Tema a Ingresar ya Existe.");
		}
	}
	
	/**
	 * Metodo de validación si el tema existe
	 * @param tema variable objeto que contiene el nombre del tema a verificar
	 * @return true si el tema existe o sino retorna falso indicando que no existe tema con dicho nombre
	 */
	private boolean existeTema(String tema){
		boolean estado = false;
		for(int i=1; i<=listaTemas.getItems().size(); i++){
			Listitem item = (Listitem)listaTemas.getChildren().get(i);
			Listcell celdaTema = (Listcell)item.getChildren().get(1);
			if (tema.equals(celdaTema.getLabel().trim().toUpperCase())){
				estado = true;
				break;
			}
		}
		return estado;
	}
	
	/**
	 * Metodo a la espera de click en el boton agregar unidad y procede a enviar a metodo
	 * que agrega la unidad si cumple los parametros de guardado
	 * @param event
	 */
	public void onClick$btnAddUnidad(Event event){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	/**
	 * Procede a verificar si la unidad cumple con los parametros de guardado y la grega a la lista de
	 * unidades existentes
	 * @param nombreUnidad nombre de la unidad a agregar en la lista de unidades
	 */
	private void llenarListaUnidades(String nombreUnidad){
		nombreUnidad = nombreUnidad.toUpperCase();
		if(!("".equals(nombreUnidad)) && (nombreUnidad.trim().length() > 0)){			
			final Listitem listaItem = new Listitem();
			final String tmpUnidad = nombreUnidad;
			
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem, tmpUnidad);					
				}
			});
			if (!existeUnidad(tmpUnidad)){
				Listcell celdaVacia = new Listcell("");
				listaItem.appendChild(celdaVacia);
				Listcell celdaUnidad = new Listcell(nombreUnidad);
				listaItem.appendChild(celdaUnidad);
				llenarCombosUnidades(nombreUnidad);
				/**
				 * encapsulamiento para agregar a la lista de objetos unidades x micro
				 */
				TbMicUnidad unidadGuardar = new TbMicUnidad(nombreUnidad, "SYSTEM", new Date());
				TbMicUnidadxmicro unidadxMicroGuardar = new TbMicUnidadxmicro(unidadGuardar, microcurriculoGuardar, "SYSTEM", new Date());
				listaUnidadesxMicroGuardar.add(unidadxMicroGuardar);
				
				listaUnidades.appendChild(listaItem);
				txtNombreUnidad.setValue("");
				txtNombreUnidad.setFocus(true);
			}else
				Messagebox.show("Existe un unidad con el mismo nombre.");
			
		} else
			if (listaUnidades.getItems().size() > 0)
				cmbIdUnidad.focus();
			else
				Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
	}
	
	/**
	 * Verifica si existe la unidad a guardar
	 * @param unidad nombre de unidad a verificar
	 * @return true si la unidad ya existe y false si no existe con ese nombre
	 */
	private boolean existeUnidad(String unidad){
		boolean estado = false;
		for (int i=1;i<=listaUnidades.getItems().size(); i++){
			Listitem item = (Listitem)listaUnidades.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)item.getChildren().get(1);
			if (unidad.toUpperCase().equals(celdaUnidad.getLabel())){
				estado = true;
				break;
			}	
		}
		return estado;
	}
	
	/**
	 * El metodo agrega la unidad nueva a los combobox
	 * @param unidad nombre de unidad a agregar en los combobox
	 */
	private void llenarCombosUnidades(String unidad){
		Comboitem item = new Comboitem(unidad);		
		cmbIdUnidad.appendChild(item);
		Comboitem item2 = new Comboitem(unidad);
		cmbListaUnidades.appendChild(item2);
		Comboitem item3 = new Comboitem(unidad);
		cmbListaUnidadBiblio.appendChild(item3);
	}
	
	public void onClick$btnAddSubTema(Event event){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
	}
	
	private void validarCamposSubtemas(String listaUnidades, String listaTemas, String subTema){
		if (cmbListaUnidades.getValue() != null && (cmbListaUnidades.getValue().trim().length() > 0)){
			if (cmbListaTemas.getValue() != null && (cmbListaTemas.getValue().trim().length() > 0)){
				if (txtSubTemas.getValue() != null && (txtSubTemas.getValue().trim().length() > 0)){
					llenarListaSubTemas();
					cmbListaTemas.getItems().clear();
					cmbListaTemas.setValue("");
					cmbListaUnidades.focus();
				} else
					Messagebox.show("Se Requiere información en el Campo <Subtema>");
			} else
				Messagebox.show("Se Requiere información en el Campo <Tema>");			
		} else
			Messagebox.show("Se Requiere información en el Campo <Unidad>");
	}
	
	private void llenarListaSubTemas(){
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});			
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidades.getValue());
		Listcell celdaTema = new Listcell(cmbListaTemas.getValue());
		Listcell celdaSubtema = new Listcell(txtSubTemas.getValue());
		/**
		 * Encapsulado de subtema en la lista de objetos a guardar en base de datos
		 */
		TbMicSubtema subtemaGuardar = new TbMicSubtema(txtSubTemas.getValue().toString(), "SYSTEM", new Date());
		TbMicTema temaGuardar = null;
		for(TbMicTemaxunidad temaxUnidad: listaTemasxUnidadGuardar ){
			if(cmbListaTemas.getValue().toUpperCase().equals(temaxUnidad.getTbMicTema().getVrDescripcion())){
				temaGuardar = temaxUnidad.getTbMicTema();
			}
		}
		if(temaGuardar != null){
			TbMicSubtemaxtema subtemaxTemaGuardar = new TbMicSubtemaxtema(temaGuardar, subtemaGuardar, "SYSTEM", new Date());
			listaSubtemasxTemaGuardar.add(subtemaxTemaGuardar);
			
			listaItem.appendChild(celdaUnidad);
			listaItem.appendChild(celdaTema);
			listaItem.appendChild(celdaSubtema);
			
			listaSubtemas.appendChild(listaItem);
			txtSubTemas.setValue("");
		}else{
			Messagebox.show("Error en guardar subtema");
		}
		
	}
	
	/**
	 * Este metodo de encarga de Cargar, en el ComboBox de Temas de la pestaña Subtemas, los datos hallados de acuerdo a la unidad Seleccionada.
	 * 
	 * @param lista.  Recibe el ListBox de donde se Extraeran los registros.
	 * @param unidad. Es el valor que se utilizará para comparar.
	 */
	private void cargarTemasEnSubtemas(Listbox lista, String unidad){
		
		cmbListaTemas.getItems().clear();
		if (lista.getItemCount() > 0){
			for(int i=1;i<=lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celdaTema = (Listcell)listaItem.getChildren().get(1);
				Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
				Comboitem itemTema = new Comboitem(celdaTema.getLabel());
				
				if (unidad.equals(celdaUnidad.getLabel()))
					cmbListaTemas.appendChild(itemTema);
			}
		}		
	}
	
	private void verificarCamposBibliografia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtReferenciaBiblio.getValue() != null && (txtReferenciaBiblio.getValue().trim().length() > 0)){
				if (txtAutorBiblio.getValue() != null && (txtAutorBiblio.getValue().trim().length() > 0)){
					if (txtISBNBiblio.getValue() != null && (txtISBNBiblio.getValue().trim().length() > 0)){
						if (cmbTipoBibliografia.getValue() != null && (cmbTipoBibliografia.getValue().trim().length() > 0)){
							llenarListaBibliografia();
						} else
							Messagebox.show("Se Requiere información en el Campo <Tipo Bibliografia>");					
					} else
						Messagebox.show("Se Requiere información en el Campo <ISBN>");
				} else
					Messagebox.show("Se Requiere información en el Campo <Autor>");				
			} else
				Messagebox.show("Se Requiere información en el Campo <Referencia Bibliografica>");
		} else 
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
	}
	
	private void llenarListaBibliografia(){
		final Listitem listaItem = new Listitem();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaReferencia = new Listcell(txtReferenciaBiblio.getValue());
		Listcell celdaAutor = new Listcell(txtAutorBiblio.getValue().toUpperCase());
		Listcell celdaISBN = new Listcell(txtISBNBiblio.getValue().toUpperCase());
		Listcell celdaTipo = new Listcell(cmbTipoBibliografia.getValue().toUpperCase());
		
		/**
		 * Encapsulado de bibliografia en la lista de objetos a guardar en base de datos
		 */
		char tipo;
		if(cmbTipoBibliografia.getSelectedIndex() == 0){
			tipo = '0';
		}else{
			tipo = '1';
		}
		TbMicBibliografia biblioGuardar = new TbMicBibliografia(txtReferenciaBiblio.getValue().toString(), null, txtISBNBiblio.getValue().toUpperCase(), txtAutorBiblio.getValue().toUpperCase(), tipo, "SYSTEM", new Date());
		TbMicUnidad unidadGuardar = null;
		for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroGuardar ){
			if(cmbListaUnidadBiblio.getValue().toString().equals(unidadxMicro.getTbMicUnidad().getVrNombre())){
				unidadGuardar = unidadxMicro.getTbMicUnidad();
			}
		}
		if(unidadGuardar != null){
			TbMicBiblioxunidad biblioxUnidadGuardar = new TbMicBiblioxunidad(biblioGuardar, unidadGuardar, "SYSTEM", new Date());
			listaBibliosxUnidadGuardar.add(biblioxUnidadGuardar);
			
			listaItem.appendChild(celdaUnidad);
			listaItem.appendChild(celdaReferencia);
			listaItem.appendChild(celdaAutor);
			listaItem.appendChild(celdaISBN);
			listaItem.appendChild(celdaTipo);
			listaBibliografia.appendChild(listaItem);		
			
			limpiarCamposBibliografia();
			txtReferenciaBiblio.focus();
		}else{
			Messagebox.show("Error en guardar bibliografia");
		}
		
	}
	
	private void limpiarCamposBibliografia(){
		txtReferenciaBiblio.setValue("");
		txtAutorBiblio.setValue("");
		txtISBNBiblio.setValue("");
		cmbTipoBibliografia.setValue("");
	}
	
	public void onClick$btnAddEvaluacion(Event event){
		verificarCamposEvaluacion();
	}
	
	private void verificarCamposEvaluacion(){
		if (txtActividadMicro.getValue() != null && (txtActividadMicro.getValue().trim().length() > 0)){
			if (txtPorcentajeActividad.getValue() != null && (txtPorcentajeActividad.getValue() > 0)){
				if (dtFechaEvaluacion.getValue() != null) {
					llenarListaActividades();
				} else{
					Messagebox.show("La Información del Campo <fecha> no es válida");
					dtFechaEvaluacion.setFocus(true);
				}					
			} else{
				Messagebox.show("Se Requiere información en el Campo <Porcentaje>");
				txtPorcentajeActividad.setFocus(true);
			}	
		} else {
			Messagebox.show("Se Requiere información en el Campo <Actividad>");
			txtActividadMicro.setFocus(true);
		}			
	}
	
	public void llenarListaActividades() {
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaActividad = new Listcell(txtActividadMicro.getValue());
		Listcell celdaPorcentaje = new Listcell(txtPorcentajeActividad.getValue().toString());
		String tmpFecha = formatoFecha.format(dtFechaEvaluacion.getValue());
		Listcell celdaFecha = new Listcell(tmpFecha);
		
		porcentajeEvaluacion = calcularPorcentaje();
		if (porcentajeEvaluacion > 100){
			Messagebox.show("No es posible agregar el registro a la lista. El porcentaje de las Evaluaciones supera el 100%. " +
					"\n Por favor verifique los valores.");			
		} else {
			listaItem.appendChild(celdaActividad);
			listaItem.appendChild(celdaPorcentaje);
			listaItem.appendChild(celdaFecha);
			/**
			 * Encapsulado de subtema en la lista de objetos a guardar en base de datos
			 */
			TbMicEvaluacion evaluacionGuardar = new TbMicEvaluacion(txtActividadMicro.getValue().toString(), "SYSTEM", new Date());
			
			int porcentaje = Integer.parseInt(txtPorcentajeActividad.getValue().toString());
			TbMicEvaluacionxmicro evaluacionxmicroGuardar = new TbMicEvaluacionxmicro(evaluacionGuardar, microcurriculoGuardar, porcentaje, dtFechaEvaluacion.getValue(), "SYSTEM", new Date());
			listaEvaluacionesxMicroGuardar.add(evaluacionxmicroGuardar);
			
			listaEvaluaciones.appendChild(listaItem);
			txtActividadMicro.setValue("");
			txtPorcentajeActividad.setValue(null);
			dtFechaEvaluacion.setValue(null);
			txtActividadMicro.focus();
			
		}
	}
	
	private int calcularPorcentaje(){
		int porcentaje = Integer.parseInt(txtPorcentajeActividad.getValue().toString());
		for (int i=1; i <= listaEvaluaciones.getItems().size();i++){
			Listitem item = (Listitem) listaEvaluaciones.getChildren().get(i);
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			porcentaje = porcentaje + Integer.parseInt(celdaPorcentaje.getLabel());
		}
		
		return porcentaje;
	}
	
	private void verificarCamposCibergrafia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtNombreSitioCiber.getValue() != null && (txtNombreSitioCiber.getValue().trim().length() > 0)){
				if (!"".equals(txtURLSitioCiber.getValue())){
					if (!"".equals(cmbTipoCibergrafia.getValue())){
						llenarListaCibergrafia();
					} else {
						Messagebox.show("Se Requiere información en el Campo <Tipo Cibergrafía>");
					}
				} else {
					Messagebox.show("Se Requiere información en el Campo <URL Sitio>");
				}
			} else {
				Messagebox.show("Se Requiere información en el Campo <Nombre Sitio>");
			}				
		} else {
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
		}
	}
	
	/**
	 * Este Metodo se encarga de llenar 
	 */
	private void llenarListaCibergrafia(){
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem, "");
			}
		});
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaSitio = new Listcell(txtNombreSitioCiber.getValue());
		Listcell celdaURL = new Listcell(txtURLSitioCiber.getValue());
		Listcell celdaTipo = new Listcell(cmbTipoCibergrafia.getValue());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaSitio);
		listaItem.appendChild(celdaURL);
		listaItem.appendChild(celdaTipo);
		/**
		 * Encapsulado de cibergrafias en la lista de objetos a guardar en base de datos
		 */
		char tipo;
		if(cmbTipoCibergrafia.getSelectedIndex() == 0){
			tipo = '0';
		}else{
			tipo = '1';
		}
		TbMicBibliografia biblioGuardar = new TbMicBibliografia(txtNombreSitioCiber.getValue().toString(), txtURLSitioCiber.getValue().toString(), null, null, tipo, "SYSTEM", new Date());
		TbMicUnidad unidadGuardar = null;
		for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroGuardar ){
			if(cmbListaUnidadBiblio.getValue().toString().equals(unidadxMicro.getTbMicUnidad().getVrNombre())){
				unidadGuardar = unidadxMicro.getTbMicUnidad();
			}
		}
		if(unidadGuardar != null){
			TbMicBiblioxunidad biblioxUnidadGuardar = new TbMicBiblioxunidad(biblioGuardar, unidadGuardar, "SYSTEM", new Date());
			listaBibliosxUnidadGuardar.add(biblioxUnidadGuardar);
			
			listaCibergrafia.appendChild(listaItem);
			txtNombreSitioCiber.setValue("");
			txtURLSitioCiber.setValue("");
			txtNombreSitioCiber.focus();
		}else{
			Messagebox.show("Error en guardar bibliografia");
		}
		
	}
	
//	private String mostrarNombreDocente(String idDocente){
//		String nombre = "";
//		TbAdmPersona persona = null;
//	
//		try {
//			persona = personaNGC.obtenerPersona(idDocente);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
////			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//		
//		if (persona != null){
//			nombre = persona.getVrApellidos()+" "+persona.getVrNombres();
//		}	
//		return nombre;
//	}
	
	/**
	 * Este evento ocurre cuando se hace click en sobre el boton <AddCibergrafia>.
	 * 
	 * Captura y valora los valores y los adiciona al ListBox Listacibergrafia a traves del método llenarListaCibergrafia
	 * 
	 * @param event
	 */
	public void onClick$btnAddCibergrafia(Event event){
		verificarCamposCibergrafia();
	}
	
	/**
	 * Eventos durante edicion
	 */
	
	public void onOK$cmbListaUnidadBiblio(){
		txtReferenciaBiblio.focus();
	}
	
	public void onOK$txtReferenciaBiblio(){
		txtAutorBiblio.focus();
	}
	
	public void onOK$txtAutorBiblio(){
		txtISBNBiblio.focus();
	}
	
	public void onOK$txtISBNBiblio(){
		cmbTipoBibliografia.focus();
	}
	
	public void onOK$cmbTipoBibliografia(){
		verificarCamposBibliografia();
	}
		
	public void onClick$btnAddBibliografia(Event event){
		verificarCamposBibliografia();
	}
	
	public void onOK$txtNombreSitioCiber(){
		txtURLSitioCiber.focus();
	}
	
	public void onOK$txtURLSitioCiber(){
		cmbTipoCibergrafia.focus();
	}
	
	public void onOK$cmbTipoCibergrafia(){
		verificarCamposCibergrafia();
	}
	
	public void onOK$cmbIdUnidad(){
		txtNombreTema.setFocus(true);
	}
	
	public void onOK$txtNombreTema(){
		txtNumeroSemanas.focus();
	}
	
	public void onOK$txtNumeroSemanas(){
		validarCamposTemas(txtNombreTema.getValue());
		cmbIdUnidad.setFocus(true);
	}
		
	public void onOK$txtSubTemas(){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
		cmbListaUnidades.setFocus(true);
	}
	
	public void onOK$txtActividadMicro(){
		txtPorcentajeActividad.focus();
	}
	
	public void onOK$txtPorcentajeActividad(){
		dtFechaEvaluacion.focus();
	}
	
	public void onOK$dtFechaEvaluacion(){
		verificarCamposEvaluacion();
	}
	
	public void onSelect$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	public void onOK$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	
//	public void onSelect$cmbDocente(){
//		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
//	}
	
//	public void onOK$cmbDocente(){
//		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
//		if (!(lblNombreDocente.getValue().equals("") && (lblNombreDocente.getValue().trim().length() > 0)))
//			cmbSemestre.focus();				
//	}
	
	public void onOK$txtNombreUnidad(){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	public void onOK$cmbListaUnidades(){		
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
		cmbListaTemas.focus();
	}
	
	public void onSelect$cmbListaUnidades(){
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
	}
	
	public void onSelect$fichaContenidos(){
		Tabpanel tabpanels = (Tabpanel)fichaContenidos.getSelectedPanel();
		int indice = tabpanels.getIndex();
		if (indice == 0){
			cmbDocente.focus();
		}else if (indice == 1){
			if(txtPropositoMicro != null){
				txtPropositoMicro.focus();
			}
		}else if (indice == 2){
			if(txtNombreUnidad != null){
				txtNombreUnidad.focus();
			}
		}else if (indice == 3){
			if(cmbListaUnidades != null){
				cmbListaUnidades.focus();
			}
		}else if (indice == 4){
			if(txtActividadMicro != null){
				txtActividadMicro.focus();
			}
		}else if (indice == 5){
			if(cmbListaUnidadBiblio != null){
				cmbListaUnidadBiblio.focus();
			}
		}
	}
	
	public void onClick$btnGuardar(){
		
		actualizarMicro();
		generarHistoricos();
		actualizarLote();
		
	}
	
	public void onClick$tool_save(){
		
		actualizarMicro();
		generarHistoricos();
		actualizarLote();
		
	}
	
	public void reiniciarEntorno(){
		reiniciarListas();
		cargarDocentes();
		cargarEstados();
//		llenarDatos(microcurriculoGuardar.getVrIdmicrocurriculo());
	}
	
	public void generarHistoricos(){
		/**
		 * Verificación si hubo cambios en los objetivos del microcurriculo
		 */
		if((listaObjetivosxMicroBorrar != null)||(listaObjetivosxMicroGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar objetivos", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		
		/**
		 * Verificación si hubo cambios en los subtemas del microcurriculo
		 */
		if((listaSubtemasxTemaBorrar != null)||(listaSubtemasxTemaGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar subtemas", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		
		/**
		 * Verificación si hubo cambios en los temas del microcurriculo
		 */
		if((listaTemasxUnidadBorrar != null)||(listaTemasxUnidadGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar temas", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		
		/**
		 * Verificación si hubo cambios en las evaluaciones del microcurriculo
		 */
		if((listaEvaluacionesxMicroBorrar != null)||(listaEvaluacionesxMicroGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar evaluaciones", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		
		/**
		 * Verificación si hubo cambios en las bibliografias del microcurriculo
		 */
		if((listaBibliosxUnidadBorrar != null)||(listaBibliosxUnidadGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar bibliografias", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		
		/**
		 * Verificación si hubo cambios en las unidades del microcurriculo
		 */
		if((listaUnidadesxMicroBorrar != null)||(listaUnidadesxMicroGuardar != null)){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar bibliografias", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
	}
	
	public void actualizarLote(){
		try{
			guardarMicrocurriculoNGC.modificarMicroxlotes(microcurriculoGuardar, microxEstadoGuardar,
					listaObjetivosxMicroBorrar, listaSubtemasxTemaBorrar, listaTemasxUnidadBorrar,
					listaEvaluacionesxMicroBorrar, listaBibliosxUnidadBorrar, listaUnidadesxMicroBorrar,
					listaObjetivosxMicroGuardar, listaUnidadesxMicroGuardar, listaBibliosxUnidadGuardar,
					listaEvaluacionesxMicroGuardar, listaTemasxUnidadGuardar, listaSubtemasxTemaGuardar, listaHistoricos);
			reiniciarEntorno();
			Messagebox.show("Se actualizó correctamente el microcurriculo","INFORMACIÓN", Messagebox.OK,Messagebox.INFORMATION);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("Ocurrió un error, no se pudo actualizar el microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	public void guardarBibliografias(){
		for(TbMicBiblioxunidad biblioxUnidad: listaBibliosxUnidadGuardar){
			TbMicBibliografia bibliografia = biblioxUnidad.getTbMicBibliografia();
			
			try {
				bibliografiaNGC.guardarBibliografia(bibliografia);
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
			
			try {
				biblioxUnidadNGC.guardarBiblioxUnidad(biblioxUnidad);
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
	}
	
	public void borrarBibliografias(){
		for(TbMicBiblioxunidad biblioxUnidad: listaBibliosxUnidadBorrar){
			TbMicBibliografia bibliografia = biblioxUnidad.getTbMicBibliografia();
			
			try {
				biblioxUnidadNGC.eliminarBiblioxUnidad(biblioxUnidad);
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
			
			try {
				bibliografiaNGC.eliminarBibliografia(bibliografia);
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
	}
	
	public void guardarEvaluaciones(){
		for(TbMicEvaluacionxmicro evaluacionxMicro: listaEvaluacionesxMicroGuardar){
			TbMicEvaluacion evaluacion = evaluacionxMicro.getTbMicEvaluacion();
			
			try {
				evaluacionNGC.guardarEvaluacion(evaluacion);;
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
			
			try {
				evaluacionxMicroNGC.guardarEvaluacionxmicro(evaluacionxMicro);
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
	}
	
	public void borrarEvaluaciones(){
		for(TbMicEvaluacionxmicro evaluacionxMicro: listaEvaluacionesxMicroBorrar){
			TbMicEvaluacion evaluacion = evaluacionxMicro.getTbMicEvaluacion();
			
			try {
				evaluacionxMicroNGC.eliminarEvaluacionxmicro(evaluacionxMicro);
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
			
			try {
				evaluacionNGC.eliminarEvaluacion(evaluacion);
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
	}
	
	public void guardarSubtemas(){
		for(TbMicSubtemaxtema subtemaxTema: listaSubtemasxTemaGuardar){
			TbMicSubtema subtema = subtemaxTema.getTbMicSubtema();
			
			try {
				subtemaNGC.guardarSubtemas(subtema);
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
			
			try {
				subtemaxTemaNGC.guardar(subtemaxTema);
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
	}
	
	public void borrarSubtemas(){
		for(TbMicSubtemaxtema subtemaxTema: listaSubtemasxTemaBorrar){
			TbMicSubtema subtema = subtemaxTema.getTbMicSubtema();
			
			try {
				subtemaxTemaNGC.eliminarSubtemaxtema(subtemaxTema);
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
			
			try {
				subtemaNGC.eliminarSubtema(subtema);
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
	}
	
	public void guardarTemas(){
		for(TbMicTemaxunidad temaxUnidad: listaTemasxUnidadGuardar){
			TbMicTema tema = temaxUnidad.getTbMicTema();
			
			try {
				temaNGC.guardarTemas(tema);
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
			
			try {
				temaxUnidadNGC.guardarTemasxUnidad(temaxUnidad);
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
	}
	
	public void borrarTemas(){
		for(TbMicTemaxunidad temaxUnidad: listaTemasxUnidadBorrar){
			TbMicTema tema = temaxUnidad.getTbMicTema();
			
			try {
				temaxUnidadNGC.eliminarTemaxUnidad(temaxUnidad);
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
			
			try {
				temaNGC.eliminarTema(tema);
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
	}
	
	public void guardarUnidades(){
		for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroGuardar){
			TbMicUnidad unidad = unidadxMicro.getTbMicUnidad();
			
			try {
				unidadNGC.guardarUnidades(unidad);
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
			
			try {
				unidadxMicroNGC.guardarUnidadXmicro(unidadxMicro);
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
	}
	
	public void borrarUnidades(){
		for(TbMicUnidadxmicro unidadxMicro: listaUnidadesxMicroBorrar){
			TbMicUnidad unidad = unidadxMicro.getTbMicUnidad();
			
			try {
				unidadxMicroNGC.eliminarUnidadxmicro(unidadxMicro);
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
			
			try {
				unidadNGC.eliminarUnidad(unidad);
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
	}
	
	public void guardarObjetivos(){
		for(TbMicObjetivoxmicro objetivoxMicro: listaObjetivosxMicroGuardar){
			TbMicObjetivo objetivo = objetivoxMicro.getTbMicObjetivo();
			
			try {
				objetivoNGC.guardarObjetivo(objetivo);
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
			
			try {
				objetivoxMicroNGC.guardarObjetivosxMicro(objetivoxMicro);
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
	}
	
	public void borrarObjetivos(){
		for(TbMicObjetivoxmicro objetivoxMicro: listaObjetivosxMicroBorrar){
			TbMicObjetivo objetivo = objetivoxMicro.getTbMicObjetivo();
			
			try {
				objetivoxMicroNGC.eliminarObjetivoxMicro(objetivoxMicro);
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
			
			try {
				objetivoNGC.eliminarObjetivo(objetivo);
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
	}
	
	public void actualizarMicro(){		
		TbAdmPersona responsable = listaDocentes.get(cmbDocente.getSelectedIndex()-1);
		TbMicEstado estadoGuardar = listaEstados.get(cmbEstado.getSelectedIndex()+1);
		if(microcurriculoGuardar.getTbMicEstado().getNbIdestado() != estadoGuardar.getNbIdestado()){
			microxEstadoGuardar = new TbMicMicroxestado(estadoGuardar, new Date(), microcurriculoGuardar, responsable, "SYSTEM", new Date());
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar a estado: "+estadoGuardar.getVrDescripcion(), "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		microcurriculoGuardar.setTbMicEstado(estadoGuardar);
		if(!microcurriculoGuardar.getTbAdmPersona().getVrIdpersona().equals(responsable.getVrIdpersona())){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar responsable: "+responsable.getVrNombres()+" "+responsable.getVrApellidos(), "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		microcurriculoGuardar.setTbAdmPersona(responsable);
		String propositoNuevo = txtPropositoMicro.getValue().toString();
		String justificacionNueva = txtJustificacionMicro.getValue().toString();
		String resumenNuevo = txtResumenMicro.getValue().toString();
		if((!microcurriculoGuardar.getVrProposito().equals(propositoNuevo))||(!microcurriculoGuardar.getVrJustificacion().equals(justificacionNueva))||(!microcurriculoGuardar.getVrProposito().equals(resumenNuevo))){
			TbAdmHistorico historicoNuevo = new TbAdmHistorico(new Date(), microcurriculoGuardar, "Cambiar datos complementarios", "SYSTEM", "SYSTEM", new Date());
			listaHistoricos.add(historicoNuevo);
		}
		microcurriculoGuardar.setVrProposito(propositoNuevo);
		microcurriculoGuardar.setVrJustificacion(justificacionNueva);
		microcurriculoGuardar.setVrResumen(resumenNuevo);
		microcurriculoGuardar.setDtModfecha(new Date());
		microcurriculoGuardar.setVrModusuario("SYSTEM");
		
		boolean sinObjetivoGeneral = true;
		for(TbMicObjetivoxmicro objetivoxMicroGeneral: listaObjetivosxMicroGuardar){
			if(objetivoxMicroGeneral.getBlTipo() == '1'){
				objetivoxMicroGeneral.getTbMicObjetivo().setVrDescripcion(txtObjetivoGeneral.getValue().toString());
				sinObjetivoGeneral = false;
			}
		}
		
		if(sinObjetivoGeneral){
			TbMicObjetivo objetivoGeneralGuardar = new TbMicObjetivo(txtObjetivoGeneral.getValue().toString(), "SYSTEM", new Date());
			TbMicObjetivoxmicro objetivoxMicroAdicionar = new TbMicObjetivoxmicro(objetivoGeneralGuardar, microcurriculoGuardar, '1', "SYSTEM", new Date());
			listaObjetivosxMicroGuardar.add(objetivoxMicroAdicionar);
		}
		
	}
	
	private void extraerInformacion(){
		TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuario");
//		persona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		rol = rolxUsuario.getTbAdmRol().getNbId();
		
		rolPersona = rolxUsuario.getTbAdmRol();
		docenteSession = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblFechaActual.setValue(s4);
		
		idPersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrIdpersona();
		nombrePersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrNombres();
		apellidoPersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrApellidos();
		userName = rolxUsuario.getTbAdmUsuario().getVrLogin();
		lblUsuarioLogin.setValue(userName);
		blyModificarMicro.setVisible(true);
	}
	
	/**
	 * Verifica si el microcurriculo es modificable por la persona logueada
	 * de lo contrario será enviado solo a verlo
	 */
	private void verificarModificabilidad(){
//		String idMicrocurriculo = (String) Executions.getCurrent().getSession().getAttribute("idMicro");
//		if(idMicrocurriculo != null && (!idMicrocurriculo.endsWith(""))){
			TbMicMicrocurriculo microcurriculo = (TbMicMicrocurriculo)Executions.getCurrent().getSession().getAttribute("microcurriculo");
			
//			try {
//				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
//			}catch(ExcepcionesDAO expDAO){
//				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expDAO.getMsjTecnico());
//			}catch(ExcepcionesLogica expNgs){
//				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expNgs.getMsjTecnico());
//			}catch(Exception exp){
////				Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(exp);
//			}
			if(microcurriculo != null){
				int estado = microcurriculo.getTbMicEstado().getNbIdestado(); 
				switch (estado) {
				case 1:
					if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				case 2:
					if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
					}else{
						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				case 3:
					if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
					}else{
						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				case 4:
					if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				case 5:
					if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				case 6:
					if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
					}else{
						Executions.getCurrent().getSession().removeAttribute("idMicro");
						blyModificarMicro.setVisible(true);
						divSeleccionaMicrocurriculo.setVisible(true);
						cargarMicrocurriculos("");
					}
					break;
				default:
					Executions.getCurrent().sendRedirect("/index.zul");
					break;
			}
			}
				
//				switch (rol) {
//				case 1:
//					
//					break;
//				case 2:
//					
//					break;
//				case 3:
//					switch (microcurriculo.getTbMicEstado().getNbIdestado()) {
//					case 1:
//						Executions.getCurrent().getSession().removeAttribute("idMicro");
//						blyModificarMicro.setVisible(true);
//						divSeleccionaMicrocurriculo.setVisible(true);
//						cargarMicrocurriculos("");
//						break;
//					case 2:
//						
//						break;
//					case 3:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					case 4:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					case 5:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					case 6:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					default:
//						Executions.getCurrent().sendRedirect("/index.zul");
//						break;
//				}
//					break;
//				case 4:
//					switch (microcurriculo.getTbMicEstado().getNbIdestado()) {
//						case 1:
//							if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						case 2:
//							if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//							}else{
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						case 3:
//							if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//							}else{
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						case 4:
//							if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						case 5:
//							if(!microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						case 6:
//							if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(idPersona)){
//								Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//							}else{
//								Executions.getCurrent().getSession().removeAttribute("idMicro");
//								blyModificarMicro.setVisible(true);
//								divSeleccionaMicrocurriculo.setVisible(true);
//								cargarMicrocurriculos("");
//							}
//							break;
//						default:
//							Executions.getCurrent().sendRedirect("/index.zul");
//							break;
//					}
//					break;
//				case 7:
//					switch (microcurriculo.getTbMicEstado().getNbIdestado()) {
//					case 1:
//						Executions.getCurrent().getSession().removeAttribute("idMicro");
//						blyModificarMicro.setVisible(true);
//						divSeleccionaMicrocurriculo.setVisible(true);
//						cargarMicrocurriculos("");
//						break;
//					case 2:
//						Executions.getCurrent().getSession().removeAttribute("idMicro");
//						blyModificarMicro.setVisible(true);
//						divSeleccionaMicrocurriculo.setVisible(true);
//						cargarMicrocurriculos("");
//						break;
//					case 3:
//						
//						break;
//					case 4:
//						Executions.getCurrent().getSession().removeAttribute("idMicro");
//						blyModificarMicro.setVisible(true);
//						divSeleccionaMicrocurriculo.setVisible(true);
//						cargarMicrocurriculos("");
//						break;
//					case 5:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					case 6:
//						Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
//						break;
//					default:
//						Executions.getCurrent().sendRedirect("/index.zul");
//						break;
//				}
//					break;
//				default:
//					Executions.getCurrent().sendRedirect("/index.zul");
//					break;
//			}
//				
//			}else{
//				Executions.getCurrent().getSession().removeAttribute("idMicro");
//				blyModificarMicro.setVisible(true);
//				divSeleccionaMicrocurriculo.setVisible(true);
//				cargarMicrocurriculos("");
//			}
			
//		}else{
//			Executions.getCurrent().getSession().removeAttribute("idMicro");
////			Executions.getCurrent().sendRedirect("/_ambientes/_docente/modificarMicro.zul");
//			blyModificarMicro.setVisible(false);
//			divSeleccionaMicrocurriculo.setVisible(true);
//			cargarMicrocurriculos("");
//		}
	}
	
	private void permisos(){
		if(Executions.getCurrent().getSession().hasAttribute("microcurriculo")){
			verificarModificabilidad();
//			panelModificarMicro.setVisible(false);
			divContenido.setVisible(true);
//			String idMicro = (String)Executions.getCurrent().getSession().getAttribute("idMicro");
			TbMicMicrocurriculo microcurriculo = (TbMicMicrocurriculo)Executions.getCurrent().getSession().getAttribute("microcurriculo");
			reiniciarListas();
			cargarDocentes();
			cargarEstados();
			llenarDatos(microcurriculo);
			
		}else{
			blyModificarMicro.setVisible(true);
			divSeleccionaMicrocurriculo.setVisible(true);
			cargarMicrocurriculos("");
		}
		
//		switch (rol) {
//			case 1:
//				break;
//			case 2:
//				Executions.getCurrent().sendRedirect("./_ambientes/_admin/inicioAdmin.zul");
//				break;
//			case 3:
//				if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
//					System.out.println("MIcrocurriculo: "+Executions.getCurrent().getSession().hasAttribute("idMicro"));
////					panelModificarMicro.setVisible(false);
//					divContenido.setVisible(true);
//					String idMicro = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
//					reiniciarListas();
//					cargarDocentes();
//					cargarEstados();
//					llenarDatos(idMicro);
//				}else{
//					blyModificarMicro.setVisible(true);
//					divSeleccionaMicrocurriculo.setVisible(true);
//					cargarMicrocurriculos("");
//				}
//				break;
//			case 4:
//				if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
//					verificarModificabilidad();
////					panelModificarMicro.setVisible(false);
//					divContenido.setVisible(true);
//					String idMicro = (String)Executions.getCurrent().getSession().getAttribute("idMicro");
//					reiniciarListas();
//					cargarDocentes();
//					cargarEstados();
//					llenarDatos(idMicro);
//				}else{
//					blyModificarMicro.setVisible(true);
//					divSeleccionaMicrocurriculo.setVisible(true);
//					cargarMicrocurriculos("");
//				}
//				break;
//			case 7:
//				if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
////					panelModificarMicro.setVisible(false);
//					divContenido.setVisible(true);
//					String idMicro = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
//					reiniciarListas();
//					cargarDocentes();
//					cargarEstados();
//					llenarDatos(idMicro);
//				}else{
//					blyModificarMicro.setVisible(true);
//					divSeleccionaMicrocurriculo.setVisible(true);
//					cargarMicrocurriculos("");
//				}
//				break;
//			default:
//				Executions.getCurrent().sendRedirect("/index.zul");
//				break;
//		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		
		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuario")){
			extraerInformacion();
			permisos();
		}else{
			Executions.getCurrent().sendRedirect("/index.zul");
		}
		
	}
	
}