//package com.udea.proint1.microcurriculo.ctrl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.zkoss.zk.ui.Component;
//import org.zkoss.zk.ui.Executions;
//import org.zkoss.zk.ui.event.Event;
//import org.zkoss.zk.ui.util.GenericForwardComposer;
//import org.zkoss.zul.Button;
//import org.zkoss.zul.Combobox;
//import org.zkoss.zul.Comboitem;
//import org.zkoss.zul.Messagebox;
//
//import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
//import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
//import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
//import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicEstado;
//import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
//import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
//import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
//import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
//import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
//import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
//import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
//import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
//import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
//import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
//import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
//import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
//import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
//import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
//import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
//import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
//import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
//import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
//import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
//import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
//import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
//import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
//import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
//import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
//
//public class BorrarMicroCtrl extends GenericForwardComposer {
//	
//	private static Logger logger = Logger.getLogger(BorrarMicroCtrl.class);
//	
//	Combobox cmbUnidadAcademica;
//	Combobox cmbDependencia;
//	Combobox cmbNucleo;
//	Combobox cmbMateria;
//	Combobox cmbSemestre;
//	Combobox cmbDocente;
//	Combobox cmbMicrocurriculo;
//	
//	Button btnBorrar;
//	
//	/**
//	 * Listados para manejar las consultas
//	 */
//
//	public static List<TbAdmUnidadAcademica> listaUnidadAcademica;
//	public static List<TbAdmDependencia> listaDependencias;
//	public static List<TbAdmNucleo> listaNucleos;
//	public static List<TbAdmMateria> listaMaterias;
//	public static List<TbAdmPersona> listaDocentes;
//	public static List<TbAdmSemestre> listaSemestre;
//	public static List<TbMicEstado> listaEstados;
//	public static List<TbMicMicrocurriculo> listaMicrocurriculos;
//	
//	public static List<TbMicBiblioxunidad> bibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
//	public static List<TbMicEvaluacionxmicro> evaluacionesxMicro;
//	public static List<TbMicMicroxestado> microsxEstado;
//	public static List<TbMicObjetivoxmicro> objetivosxMicro;
//	public static List<TbMicUnidadxmicro> unidadesxMicro;
//	public static List<TbMicSubtemaxtema> subtemasxTema = new ArrayList<TbMicSubtemaxtema>();
//	public static List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
//	
//	/**
//	 * Variables de capa NGC y settters para inyección de dependencias
//	 */
//	
//	UnidadAcademicaNGC unidadAcademicaNGC;
//	DependenciaNGC dependenciaNGC;
//	NucleoNGC nucleoNGC;
//	MateriaNGC materiaNGC;
//	SemestreNGC semestreNGC;
//	PersonaNGC personaNGC;
//	MicrocurriculoNGC microcurriculoNGC;
//	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;
//	ObjetivoxMicroNGC objetivoxMicroNGC;
//	UnidadxMicroNGC unidadxMicroNGC;
//	TemaxUnidadNGC temaxUnidadNGC;
//	SubtemaxTemaNGC subtemaxTemaNGC;
//	EvaluacionxMicroNGC evaluacionxMicroNGC;
//	BiblioxunidadNGC biblioxUnidadNGC;
//	MicroxEstadoNGC microxEstadoNGC;
//	RolxUsuarioNGC rolxUsuarioNGC;
//	
//	public void setRolxUsuarioNGC(RolxUsuarioNGC rolxUsuarioNGC) {
//		this.rolxUsuarioNGC = rolxUsuarioNGC;
//	}
//
//	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
//		this.microxEstadoNGC = microxEstadoNGC;
//	}
//
//	public static void setUnidadesxMicro(List<TbMicUnidadxmicro> unidadesxMicro) {
//		BorrarMicroCtrl.unidadesxMicro = unidadesxMicro;
//	}
//
//	public static void setTemasxUnidad(List<TbMicTemaxunidad> temasxUnidad) {
//		BorrarMicroCtrl.temasxUnidad = temasxUnidad;
//	}
//
//	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
//		this.objetivoxMicroNGC = objetivoxMicroNGC;
//	}
//
//	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
//		this.unidadxMicroNGC = unidadxMicroNGC;
//	}
//
//	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
//		this.temaxUnidadNGC = temaxUnidadNGC;
//	}
//
//	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
//		this.subtemaxTemaNGC = subtemaxTemaNGC;
//	}
//
//	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
//		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
//	}
//
//	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
//		this.biblioxUnidadNGC = biblioxUnidadNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para unidades academicas en la capa del negocio
//	 * @param unidadAcademicaNGC objeto instaciado de capa de negocio
//	 */
//	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
//		this.unidadAcademicaNGC = unidadAcademicaNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para dependencias en la capa del negocio
//	 * @param dependenciaNGC objeto instaciado de capa de negocio
//	 */
//	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
//		this.dependenciaNGC = dependenciaNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para nucleos en la capa del negocio
//	 * @param nucleoNGC objeto instaciado de capa de negocio
//	 */
//	public void setNucleoNGC(NucleoNGC nucleoNGC) {
//		this.nucleoNGC = nucleoNGC;
//	}
//	
//	/**
//	 * Metodo set para inyeccion de dependencia spring para materias en la capa del negocio
//	 * @param materiaNGC objeto instaciado de capa de negocio
//	 */
//	public void setMateriaNGC(MateriaNGC materiaNGC) {
//		this.materiaNGC = materiaNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para semestres en la capa del negocio
//	 * @param semestreNGC objeto instaciado de capa de negocio
//	 */
//	public void setSemestreNGC(SemestreNGC semestreNGC) {
//		this.semestreNGC = semestreNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para personas en la capa del negocio
//	 * @param personaNGC objeto instaciado de capa de negocio
//	 */
//	public void setPersonaNGC(PersonaNGC personaNGC) {
//		this.personaNGC = personaNGC;
//	}
//
//	/**
//	 * Metodo set para inyeccion de dependencia spring para microcurriculos en la capa del negocio
//	 * @param microcurriculoNGC objeto instaciado de capa de negocio
//	 */
//	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
//		this.microcurriculoNGC = microcurriculoNGC;
//	}
//	
//	/**
//	 * Metodo set para inyeccion de dependencia spring para microcurriculos en la capa del negocio
//	 * @param guardarMicrocurriculoNGC objeto instaciado de capa de negocio
//	 */
//	public void setGuardarMicrocurriculoNGC(
//			GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
//		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
//	}
//	
//	/***************************************************************************
//	 * Llenado de datos
//	 * *************************************************************************
//	 */
//
//	/**
//	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
//	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
//	 */
//	private void cargarUnidades(){
//		try {
//			listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
//			if (listaUnidadAcademica != null){			
//				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
//				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
//					Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
//					cmbUnidadAcademica.appendChild(item);
//				}
//				cmbUnidadAcademica.setValue("[Seleccione]");
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
//		}		
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todas las dependencias existentes y las ubica en el combobox cmbDependencia
//	 * Si existe el combobox cmbDependencia2 se procede a llenar dicho elemento tambien
//	 */
//	private void cargarDependencias(String unidad){
//		if(!"".equals(unidad)){
//			try {
//				unidad = unidad + "%";
//				listaDependencias = dependenciaNGC.buscarDepedencias(unidad);
//			}catch(ExcepcionesDAO expDAO){
//				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expDAO.getMsjTecnico());
//			}catch(ExcepcionesLogica expNgs){
//				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(expNgs.getMsjTecnico());
//			}catch(Exception exp){
//				Messagebox.show("Se presentaron errores al buscar registros de Dependencias","ERROR", Messagebox.OK,Messagebox.ERROR);
//				logger.error(exp);
//			}
//		}else{
//			
//			try {
//				listaDependencias = dependenciaNGC.listarDependencias();
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
//			
//		}
//
//		cmbDependencia.getItems().clear();
//		if (listaDependencias != null){
//			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
//			for(TbAdmDependencia dependencia : listaDependencias){
//				Comboitem item = new Comboitem(dependencia.getVrIddependencia()+" - "+dependencia.getVrNombre());
//				cmbDependencia.appendChild(item);
//			}
//			cmbDependencia.setValue("[Seleccione]");
//		}
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todas los nucleos existentes y las ubica en el combobox cmbNucleo
//	 * Si existe el combobox cmbNucleo2 se procede a llenar dicho elemento tambien
//	 */
//	private void cargarNucleos(String dependencia){
//		if(!"".equals(dependencia)){
//			
//			try {
//				dependencia = dependencia + "%";
//				listaNucleos = nucleoNGC.buscarNucleos(dependencia);
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
//			
//		}else{
//			
//			try {
//				listaNucleos = nucleoNGC.listarNucleos();
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
//			
//		}
//		
//		cmbNucleo.getItems().clear();
//		if (listaNucleos != null){
//			cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
//			for(TbAdmNucleo nucleo : listaNucleos){
//				Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+nucleo.getVrNombre());
//				cmbNucleo.appendChild(item);
//			}
//			cmbNucleo.setValue("[Seleccione]");
//		}
//			
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todas las materias existentes y las ubica en el combobox cmbMateria
//	 * Si existe el combobox cmbMateria2 se procede a llenar dicho elemento tambien
//	 */
//	public void cargarMaterias(String nucleo){
//		if (!nucleo.equals("") && (nucleo.length() > 1)){
//			
//			try {
//				nucleo = nucleo + "%";
//				listaMaterias = materiaNGC.buscarMaterias(nucleo);
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
//			
//		} else {
//			
//			try {
//				listaMaterias = materiaNGC.listarMaterias();
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
//			
//		}
//				
//		cmbMateria.getItems().clear();
//		if(listaMaterias != null){
//			cmbMateria.appendChild(new Comboitem("[Seleccione]"));
//			for(TbAdmMateria materia : listaMaterias){
//				Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
//				cmbMateria.appendChild(item);
//			}
//			cmbMateria.setValue("[Seleccione]");
//		}
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
//	 */
//	private void cargarDocentes(){
//		cmbDocente.getItems().clear();
//		
//		try {
//			List<TbAdmRolxUsuario> listaRolesxUsuario = rolxUsuarioNGC.listarDocentes();
//			for(TbAdmRolxUsuario rolxUsuario: listaRolesxUsuario){
//				listaDocentes.add(rolxUsuario.getTbAdmUsuario().getTbAdmPersona());
//			}			
//			if (listaDocentes != null){
//				cmbDocente.appendChild(new Comboitem("[Seleccione]"));
//				for(TbAdmPersona docente : listaDocentes){
//					Comboitem item = new Comboitem(docente.getVrIdpersona()+" - "+ docente.getVrApellidos()+" "+docente.getVrNombres());
//					cmbDocente.appendChild(item);
//				}
//			} else
//				Messagebox.show("No Se Hallaron Registros de Docentes");
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
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todos los semestres existentes y los ubica en el combobox cmbSemestre
//	 */
//	private void cargarSemestres(){
//		
//		try {
//			listaSemestre = semestreNGC.listarSemestres();
//			cmbSemestre.getItems().clear();
//			if (listaSemestre != null){
//				cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
//				for (TbAdmSemestre semestre : listaSemestre){
//					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
//					cmbSemestre.appendChild(item);
//				}
//				cmbSemestre.setValue("[Seleccione]");
//			} else
//				Messagebox.show("No se Encontraron Registros de Semestres");
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
//	}
//	
//	/**
//	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo
//	 */
//	private void cargarMicrocurriculos(String buscaMicro){
//		if(cmbMicrocurriculo != null){
//			if (!buscaMicro.equals("")){
//				
//				try {
//					buscaMicro = buscaMicro + "%";
//					listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicro);
//				}catch(ExcepcionesDAO expDAO){
//					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expDAO.getMsjTecnico());
//				}catch(ExcepcionesLogica expNgs){
//					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expNgs.getMsjTecnico());
//				}catch(Exception exp){
////					Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(exp);
//				}
//				
//			} else {
//				
//				try {
//					listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
//				}catch(ExcepcionesDAO expDAO){
//					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expDAO.getMsjTecnico());
//				}catch(ExcepcionesLogica expNgs){
//					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expNgs.getMsjTecnico());
//				}catch(Exception exp){
////					Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(exp);
//				}
//				
//			}
//					
//			cmbMicrocurriculo.getItems().clear();
//			if(listaMaterias != null){
//				cmbMicrocurriculo.appendChild(new Comboitem("[Seleccione]"));
//				for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
//					if(microcurriculo.getTbMicEstado().getNbIdestado()==1){
//						Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
//						cmbMicrocurriculo.appendChild(item);
//					}
//					cmbMicrocurriculo.setValue("[Seleccione]");
//				}
//			}
//		}
//	}
//	
//	@SuppressWarnings("unchecked")
//	public void confirmarEliminacion(final String idMicrocurriculo){
//		Messagebox.show("Está seguro de eliminar el microcurriculo con Id "+idMicrocurriculo+"?", "ADVERTENCIA", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
//			public void onEvent(Event evt) throws InterruptedException {
//				if (evt.getName().equals("onOK")) {
//					eliminarMicrocurriculo(idMicrocurriculo);
//				} else if (evt.getName().equals("onCancel")) {
//					Executions.getCurrent().getSession().removeAttribute("idPersona");
//					Messagebox.show("Persona no fue eliminada","INFORMACION", Messagebox.OK,Messagebox.INFORMATION);
//					cargarUnidades();
//					cargarDependencias("");
//					cargarNucleos("");
//					cargarMaterias("");
//					cargarMicrocurriculos("");
//					cargarDocentes();
//					cargarSemestres();
//				}
//			}
//		});
//	}
//	
//	private void eliminarMicrocurriculo(String idMicrocurriculo){
//		
//		TbMicMicrocurriculo microcurriculo = null;
//		try{
//			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//		
//		cargarListasObjetivos(microcurriculo.getVrIdmicrocurriculo());
//		cargarListasUnidadesTemasSubtemas(microcurriculo.getVrIdmicrocurriculo());
//		cargarListasEstados(microcurriculo.getVrIdmicrocurriculo());
//		cargarListasEvaluaciones(microcurriculo.getVrIdmicrocurriculo());
//		
//		boolean ocurrioError = false;
//		try{
//			guardarMicrocurriculoNGC.eliminarMicrocurridulo(microcurriculo, microsxEstado, subtemasxTema, temasxUnidad, unidadesxMicro, objetivosxMicro, bibliosxUnidad, evaluacionesxMicro);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//			ocurrioError = true;
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//			ocurrioError = true;
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//			ocurrioError = true;
//		}
//		if(!ocurrioError){
//			Messagebox.show("Se eliminó microcurriculo con exito","INFORMACION", Messagebox.OK,Messagebox.INFORMATION);
//		}
//		
//		Executions.getCurrent().getSession().removeAttribute("idMicro");
//		cargarUnidades();
//		cargarDependencias("");
//		cargarNucleos("");
//		cargarMaterias("");
//		cargarMicrocurriculos("");
//		cargarDocentes();
//		cargarSemestres();
//	}
//	
//	private void cargarListasObjetivos(String idMicrocurriculo){
//		try{
//			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//	}
//	
//	private void cargarListasUnidadesTemasSubtemas(String idMicrocurriculo){
//		try{
//			unidadesxMicro = unidadxMicroNGC.listarUnidadesXMicroxMicro(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//		if(unidadesxMicro != null){
//			for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
//				
//				List<TbMicBiblioxunidad> bibliosxUnidadConsultar = null;
//				try{
//					bibliosxUnidadConsultar = biblioxUnidadNGC.listadoBiblioxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
//				}catch(ExcepcionesDAO expDAO){
//					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expDAO.getMsjTecnico());
//				}catch(ExcepcionesLogica expNgs){
//					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expNgs.getMsjTecnico());
//				}catch(Exception exp){
//					Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(exp);
//				}
//				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidadConsultar){
//					bibliosxUnidad.add(biblioxUnidad);
//				}
//				
//				List<TbMicTemaxunidad> temasxUnidadConsultar = null;
//				try{
//					temasxUnidadConsultar = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
//				}catch(ExcepcionesDAO expDAO){
//					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expDAO.getMsjTecnico());
//				}catch(ExcepcionesLogica expNgs){
//					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(expNgs.getMsjTecnico());
//				}catch(Exception exp){
//					Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//					logger.error(exp);
//				}
//				if(temasxUnidadConsultar != null){
//					for(TbMicTemaxunidad temaxUnidad: temasxUnidadConsultar){
//						temasxUnidad.add(temaxUnidad);
//						
//						List<TbMicSubtemaxtema> subtemasxtemaConsultar = null;
//						try{
//							subtemasxtemaConsultar = subtemaxTemaNGC.listarSubtemaxTema_Tema(temaxUnidad.getTbMicTema().getNbIdtema());
//						}catch(ExcepcionesDAO expDAO){
//							Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//							logger.error(expDAO.getMsjTecnico());
//						}catch(ExcepcionesLogica expNgs){
//							Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//							logger.error(expNgs.getMsjTecnico());
//						}catch(Exception exp){
//							Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//							logger.error(exp);
//						}
//						for(TbMicSubtemaxtema subtemaxTema: subtemasxtemaConsultar){
//							subtemasxTema.add(subtemaxTema);
//						}
//					}
//				}
//			}
//		}
//	}
//	
//	private void cargarListasEstados(String idMicrocurriculo){
//		try{
//			microsxEstado = microxEstadoNGC.listarMicrosxestadoxMicrocurriculo(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//	}
//	
//	private void cargarListasEvaluaciones(String idMicrocurriculo){
//		try{
//			evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
//			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//	}
//	
//	public void onSelect$cmbMicrocurriculo(){
//		if(cmbMicrocurriculo.getSelectedIndex() > 0 ){
//			String idMicro = cmbMicrocurriculo.getValue().toString();
//			Executions.getCurrent().getSession().setAttribute("idMicro", idMicro);
//		}
//	}
//	
//	public void confirmarMicro(String idMicrocurriculo){
//		TbMicMicrocurriculo microcurriculo = null;
//		try{
//			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
//		}catch(ExcepcionesDAO expDAO){
//			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expDAO.getMsjTecnico());
//		}catch(ExcepcionesLogica expNgs){
//			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(expNgs.getMsjTecnico());
//		}catch(Exception exp){
////			Messagebox.show("Error al intentar obtener microcurriculo a borrar","ERROR", Messagebox.OK,Messagebox.ERROR);
//			logger.error(exp);
//		}
//		if(microcurriculo != null){
//			if(microcurriculo.getTbMicEstado().getNbIdestado() != 1){
//				Messagebox.show("No se puede eliminar un microcurriculo con estado \""+microcurriculo.getTbMicEstado().getVrDescripcion().toString()+"\", solo se puede en \"BORRADOR\".","ERROR", Messagebox.OK,Messagebox.ERROR);
//			}else{
//				confirmarEliminacion(idMicrocurriculo);
//			}
//		}else{
//			Messagebox.show("Hubo un error, o el Microcurriculo a eliminar no existe","ERROR", Messagebox.OK,Messagebox.ERROR);
//		}
//	}
//	
//	public void llenarCombox(){
//		cargarUnidades();
//		cargarDependencias("");
//		cargarNucleos("");
//		cargarMaterias("");
//		cargarMicrocurriculos("");
//		cargarDocentes();
//		cargarSemestres();
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public void doAfterCompose(Component comp) throws Exception {
//		super.doAfterCompose(comp);
//		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
//			String idMicrocurriculo = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
//			confirmarMicro(idMicrocurriculo);
//			
//		}
//		llenarCombox();
//	}
//	
//}
