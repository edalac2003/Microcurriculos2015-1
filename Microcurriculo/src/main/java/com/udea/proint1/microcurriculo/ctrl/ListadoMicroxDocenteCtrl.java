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
import org.zkoss.zul.A;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentexDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmHistorico;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.DocentexDependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.HistoricoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class ListadoMicroxDocenteCtrl extends GenericForwardComposer{
	
	private static Logger logger = Logger.getLogger(ListadoMicroxDocenteCtrl.class);
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Objetos de la Vista
	 */
	Borderlayout contenidoCargando;
	Borderlayout contenidoInicioDocente;
	
	Listbox listaMicrocurriculo;
	
	Label lblFechaActual;
	Label lblNombreDocente;
	Label lblUsuarioLogin;
	Label lblRol;
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependenciaAcademica;
	
	A nlcSalir;
	
	/*
	 * Variables locales
	 */
	List<TbMicMicrocurriculo> listadoMicrocurriculo = null;
	List<TbAdmDocentexDependencia> dependenciasDocente = null;
	List<TbAdmDocentexDependencia> dependenciasDocenteAuxiliar = null;
	List<TbAdmUnidadAcademica> unidadesxDocente = new ArrayList<TbAdmUnidadAcademica>();
	
	String userName;
	String nombrePersona;
	String apellidoPersona;
	TbAdmPersona persona;
	int rol;
	TbAdmDependencia dependenciaUsuario;
	
	/**
	 * Objeto docente logueado en session.
	 */
	TbAdmPersona docenteSession = null;
	
	/*
	 * Clases Relacionadas
	 */
	MicrocurriculoNGC microcurriculoNGC;
	MateriaNGC materiaNGC;
	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	MicroxEstadoNGC microxEstadoNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	HistoricoNGC historicoNGC;
	DocentexDependenciaNGC docentexDependenciaNGC;
	
	public void setDocentexDependenciaNGC(
			DocentexDependenciaNGC docentexDependenciaNGC) {
		this.docentexDependenciaNGC = docentexDependenciaNGC;
	}

	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	public void setGuardarMicrocurriculoNGC(
			GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
	}

	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}

	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	public void setHistoricoNGC(HistoricoNGC historicoNGC) {
		this.historicoNGC = historicoNGC;
	}

	/**
	 * Definición de listados para guardar info
	 */
	public static List<TbMicBiblioxunidad> bibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
	public static List<TbMicEvaluacionxmicro> evaluacionesxMicro;
	public static List<TbMicMicroxestado> microsxEstado;
	public static List<TbMicObjetivoxmicro> objetivosxMicro;
	public static List<TbMicUnidadxmicro> unidadesxMicro;
	public static List<TbMicSubtemaxtema> subtemasxTema = new ArrayList<TbMicSubtemaxtema>();
	public static List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
	public static List<TbAdmHistorico> historicos = new ArrayList<TbAdmHistorico>();
	
	private void cargarDatosEncabezadoDocente(){
		
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblRol.setValue("Docente : ");
		lblFechaActual.setValue(s4);
		lblNombreDocente.setValue(nombrePersona+" "+apellidoPersona);
	}
	
	private void cargarDatosEncabezadoComite(){
		
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblRol.setValue("Jefe del Comité : ");
		lblFechaActual.setValue(s4);
		lblNombreDocente.setValue(nombrePersona+" "+apellidoPersona);
	}
	
	private void cargarDatosEncabezadoCoordinador(){
		
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblRol.setValue("Coordinador : ");
		lblFechaActual.setValue(s4);
		lblNombreDocente.setValue(nombrePersona+" "+apellidoPersona);
	}
	
	private void listarMicrocurriculos(){		
		try {
//			List<TbMicMicrocurriculo> microcurriculos;
			List<TbAdmDocentexDependencia> dependenciasDocente = docentexDependenciaNGC.listarDependenciasxDocente(persona);
			listadoMicrocurriculo = null;
			for(TbAdmDocentexDependencia dependenciaDocente: dependenciasDocente){
				List<TbMicMicrocurriculo> microcurriculos = microcurriculoNGC.listarMicrocurriculosPorDependencia(dependenciaDocente.getTbAdmDependencia());
				if(microcurriculos != null){
					agregarMicrocurriculos(microcurriculos);
				}
			}
//			switch (rol) {
//				case 1:
//					break;
//				case 2:
//					Executions.getCurrent().sendRedirect("./_ambientes/_admin/inicioAdmin.zul");
//					break;
//				case 3:
//					for(TbAdmDocentexDependencia dependenciaDocente: dependenciasDocente){
//						microcurriculos = microcurriculoNGC.listarMicrocurriculosPorDependencia(dependenciaDocente.getTbAdmDependencia());
//						if(microcurriculos != null){
//							agregarMicrocurriculos((List<TbMicMicrocurriculo>)microcurriculos);
//						}
//					}
//					break;
//				case 4:
//					listadoMicrocurriculo = microcurriculoNGC.listarMicrocurriculosPorResponsable(persona.getVrIdpersona());
//					break;
//				case 5:
//					break;
//				case 7:
//					for(TbAdmDocentexDependencia dependenciaDocente: dependenciasDocente){
//						microcurriculos = microcurriculoNGC.listarMicrocurriculosPorDependencia(dependenciaDocente.getTbAdmDependencia());
//						if(microcurriculos != null){
//							agregarMicrocurriculos((List<TbMicMicrocurriculo>)microcurriculos);
//						}
//					}
//					break;
//			}
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("Error al intentar cargar microcurriculos","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if ((listadoMicrocurriculo != null)){
			listaMicrocurriculo.getItems().clear();
			
			for(TbMicMicrocurriculo micro : listadoMicrocurriculo){
				final Listitem listaItem = new Listitem();
				listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {						
						mostrarMicrocurriculo(listadoMicrocurriculo.get(listaMicrocurriculo.getSelectedIndex()));
					}
				});
				listaItem.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						asignarVariableSession(listadoMicrocurriculo.get(listaMicrocurriculo.getSelectedIndex()));
					}
				});
				Listcell celdaNucleo = null;
				Listcell celdaMateria = null;
				Listcell celdaID = new Listcell(micro.getVrIdmicrocurriculo());
				if (micro.getTbAdmMateria().getTbAdmNucleo().getVrAlias() != null)
					celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrAlias());
				else
					celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
				
				if(micro.getTbAdmMateria().getVrAlias() != null)
					celdaMateria = new Listcell(micro.getTbAdmMateria().getVrAlias());
				else
					celdaMateria = new Listcell(micro.getTbAdmMateria().getVrNombre());
				
				Listcell celdaEliminar = null;
			
				if(micro.getTbMicEstado().getNbIdestado() == 1){
					celdaEliminar = new Listcell();
					celdaEliminar.setImage("/_img/icons/32x32/delete.png");
					celdaEliminar.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
						@Override
						public void onEvent(Event arg0) throws Exception {						
							eliminarMicrocurriculo(listadoMicrocurriculo.get(listaMicrocurriculo.getSelectedIndex()));
						}
					});
				}
				Listcell celdaEstado = new Listcell(micro.getTbMicEstado().getVrDescripcion());				
				listaItem.appendChild(celdaID);
				listaItem.appendChild(celdaNucleo);
				listaItem.appendChild(celdaMateria);
				listaItem.appendChild(celdaEstado);
				if(celdaEliminar != null){
					listaItem.appendChild(celdaEliminar);
				}else{
					listaItem.appendChild(new Listcell(""));
				}
				listaMicrocurriculo.appendChild(listaItem);
			}
		}
	}
	
	/**
	 * El metodo agrega en una lista los metodos que no esten repetidos
	 * @param microcurriculos a agregar en la lista
	 */
	private void agregarMicrocurriculos(List<TbMicMicrocurriculo> microcurriculos){
		
		boolean encontrado = false;
		for(TbMicMicrocurriculo microcurriculo: microcurriculos){
			if(listadoMicrocurriculo != null){
				encontrado = false;
				for(TbMicMicrocurriculo microcurriculo2: listadoMicrocurriculo){
					if(microcurriculo2.getVrIdmicrocurriculo().equals(microcurriculo.getVrIdmicrocurriculo())){
						encontrado = true;
					}
				}
			} else {
				listadoMicrocurriculo = new ArrayList<TbMicMicrocurriculo>();
			}
			if(!encontrado){
				listadoMicrocurriculo.add(microcurriculo);
			}
		}
	}
	
	private static void mostrarMicrocurriculo(TbMicMicrocurriculo microcurriculo){
		asignarVariableSession(microcurriculo);
		if((microcurriculo.getTbMicEstado().getNbIdestado() == 1)||(microcurriculo.getTbMicEstado().getNbIdestado() == 4)||(microcurriculo.getTbMicEstado().getNbIdestado() == 5)){
			
			Executions.getCurrent().sendRedirect("/_ambientes/_docente/modificarMic.zul");
		}else{
//			asignarVariableSession(microcurriculo);
			Executions.getCurrent().sendRedirect("/_ambientes/_docente/detallesMic.zul");
		}
	}
	
	private static void asignarVariableSession(TbMicMicrocurriculo microcurriculo){
		Executions.getCurrent().getSession().setAttribute("microcurriculo", microcurriculo);
//		Executions.getCurrent().getSession().setAttribute("idMicro", microcurriculo.getVrIdmicrocurriculo());
//		if((microcurriculo.getTbMicEstado().getNbIdestado() == 1)||(microcurriculo.getTbMicEstado().getNbIdestado() == 4)||(microcurriculo.getTbMicEstado().getNbIdestado() == 5)){
//			Executions.getCurrent().getSession().setAttribute("idMicro", microcurriculo.getVrIdmicrocurriculo());			
//		}else{
//			Executions.getCurrent().getSession().setAttribute("idMicro", microcurriculo.getVrIdmicrocurriculo());			
//		}
	}
	
	@SuppressWarnings("unused")
	public void eliminarMicrocurriculo(TbMicMicrocurriculo microcurriculo){
		System.out.println("llegó aqui "+microcurriculo.getVrIdmicrocurriculo());
		
		if(microcurriculo != null){
			if(microcurriculo.getTbMicEstado().getNbIdestado() != 1){
				Messagebox.show("No se puede eliminar un microcurriculo con estado \""+microcurriculo.getTbMicEstado().getVrDescripcion().toString()+"\", solo se puede en \"BORRADOR\".","ERROR", Messagebox.OK,Messagebox.ERROR);
			}else{
				confirmarEliminacion(microcurriculo);
			}
		}else{
			Messagebox.show("Hubo un error, o el Microcurriculo a eliminar no existe","ERROR", Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void confirmarEliminacion(final TbMicMicrocurriculo microcurriculo){
		Messagebox.show("Está seguro de eliminar el microcurriculo con Id "+microcurriculo.getVrIdmicrocurriculo()+"?", "ADVERTENCIA", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			public void onEvent(Event evt) throws InterruptedException {
				if (evt.getName().equals("onOK")) {
					eliminarMicrocurriculoConfirmado(microcurriculo);
				} else if (evt.getName().equals("onCancel")) {
					Executions.getCurrent().getSession().removeAttribute("idPersona");
					Messagebox.show("Persona no fue eliminada","INFORMACION", Messagebox.OK,Messagebox.INFORMATION);
				}
			}
		});
	}
	
	private void eliminarMicrocurriculoConfirmado(TbMicMicrocurriculo microcurriculo){
		
		cargarListasObjetivos(microcurriculo.getVrIdmicrocurriculo());
		cargarListasUnidadesTemasSubtemas(microcurriculo.getVrIdmicrocurriculo());
		cargarListasEstados(microcurriculo.getVrIdmicrocurriculo());
		cargarListasEvaluaciones(microcurriculo.getVrIdmicrocurriculo());
		cargarListasHistoricos(microcurriculo);
		
		boolean ocurrioError = false;
		try{
			guardarMicrocurriculoNGC.eliminarMicrocurridulo(microcurriculo, microsxEstado, subtemasxTema,
					temasxUnidad, unidadesxMicro, objetivosxMicro, bibliosxUnidad, evaluacionesxMicro, historicos);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
			ocurrioError = true;
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
			ocurrioError = true;
		}catch(Exception exp){
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
			ocurrioError = true;
		}
		if(!ocurrioError){
			Messagebox.show("Se eliminó microcurriculo con exito","INFORMACION", Messagebox.OK,Messagebox.INFORMATION);
		}
	}
	
	private void cargarListasHistoricos(TbMicMicrocurriculo microcurriculo){
		try{
			historicos = historicoNGC.obtenerHistoricosxMicrocurriculo(microcurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	private void cargarListasObjetivos(String idMicrocurriculo){
		try{
			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(idMicrocurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	private void cargarListasUnidadesTemasSubtemas(String idMicrocurriculo){
		try{
			unidadesxMicro = unidadxMicroNGC.listarUnidadesXMicroxMicro(idMicrocurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		if(unidadesxMicro != null){
			for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
				
				List<TbMicBiblioxunidad> bibliosxUnidadConsultar = null;
				try{
					bibliosxUnidadConsultar = biblioxUnidadNGC.listadoBiblioxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
				}catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidadConsultar){
					bibliosxUnidad.add(biblioxUnidad);
				}
				
				List<TbMicTemaxunidad> temasxUnidadConsultar = null;
				try{
					temasxUnidadConsultar = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
				}catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				if(temasxUnidadConsultar != null){
					for(TbMicTemaxunidad temaxUnidad: temasxUnidadConsultar){
						temasxUnidad.add(temaxUnidad);
						
						List<TbMicSubtemaxtema> subtemasxtemaConsultar = null;
						try{
							subtemasxtemaConsultar = subtemaxTemaNGC.listarSubtemaxTema_Tema(temaxUnidad.getTbMicTema().getNbIdtema());
						}catch(ExcepcionesDAO expDAO){
							Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
							logger.error(expDAO.getMsjTecnico());
						}catch(ExcepcionesLogica expNgs){
							Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
							logger.error(expNgs.getMsjTecnico());
						}catch(Exception exp){
							Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
							logger.error(exp);
						}
						for(TbMicSubtemaxtema subtemaxTema: subtemasxtemaConsultar){
							subtemasxTema.add(subtemaxTema);
						}
					}
				}
			}
		}
	}
	
	private void cargarListasEstados(String idMicrocurriculo){
		try{
			microsxEstado = microxEstadoNGC.listarMicrosxestadoxMicrocurriculo(idMicrocurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	private void cargarListasEvaluaciones(String idMicrocurriculo){
		try{
			evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(idMicrocurriculo);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se pudo eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	/**
	 * El metodo elimina la sessión actual y procede a redireccionar al index
	 */
	public void onClick$nlcSalir(){
		
		Executions.getCurrent().getSession().removeAttribute("rolxUsuarioLogin");
		Executions.getCurrent().sendRedirect("/index.zul");
		
	}
	
	private void verificarDependencias(TbAdmPersona docente){
		try{
			dependenciasDocente = docentexDependenciaNGC.listarDependenciasxDocente(docente);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se pudo listar dependencias x docente","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		dependenciasDocenteAuxiliar = dependenciasDocente;
		if(dependenciasDocente != null){
			if(dependenciasDocente.size()<=0){
				cmbUnidadAcademica.setDisabled(true);
				cmbDependenciaAcademica.setDisabled(true);
			}else if(dependenciasDocente.size()==1){
				Comboitem itemUnidad = new Comboitem(dependenciasDocente.get(0).getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad()+" - "+dependenciasDocente.get(0).getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
				cmbUnidadAcademica.appendChild(itemUnidad);
				cmbUnidadAcademica.setSelectedIndex(0);
				Comboitem itemDependencia = new Comboitem(dependenciasDocente.get(0).getTbAdmDependencia().getVrIddependencia()+" - "+dependenciasDocente.get(0).getTbAdmDependencia().getVrNombre());
				cmbDependenciaAcademica.appendChild(itemDependencia);
				cmbDependenciaAcademica.setSelectedIndex(0);
				cmbUnidadAcademica.setDisabled(true);
				cmbDependenciaAcademica.setDisabled(true);
			}else{
				llenarUnidades();
				if(unidadesxDocente != null){
					if((unidadesxDocente.size()<=0)){
						cmbUnidadAcademica.setDisabled(true);
						llenarComboboxDependencias();
					}else if((unidadesxDocente.size()==1)){
						Comboitem item = new Comboitem(unidadesxDocente.get(0).getVrIdunidad()+" - "+unidadesxDocente.get(0).getVrNombre());
						cmbUnidadAcademica.appendChild(item);
						cmbUnidadAcademica.setSelectedIndex(0);
						cmbUnidadAcademica.setDisabled(true);
						llenarComboboxDependencias();
					}else{
						llenarComboboxDependencias();
						llenarComboboxUnidades();
					}
				}
			}
		}
	}
	
	private void llenarComboboxDependencias(){
		cmbDependenciaAcademica.getItems().clear();
		
		if(dependenciasDocente != null){
			cmbDependenciaAcademica.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDocentexDependencia dependencia: dependenciasDocente){
				Comboitem item = new Comboitem(dependencia.getTbAdmDependencia().getVrIddependencia()+" - "+dependencia.getTbAdmDependencia().getVrNombre());
				cmbDependenciaAcademica.appendChild(item);
			}
			cmbDependenciaAcademica.setSelectedIndex(0);
		}
	}  
	
	private void llenarComboboxUnidades(){
		cmbUnidadAcademica.getItems().clear();
		
		if(unidadesxDocente != null){
			cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmUnidadAcademica unidad: unidadesxDocente){
				Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+unidad.getVrNombre());
				cmbUnidadAcademica.appendChild(item);
			}
		}
		cmbUnidadAcademica.setSelectedIndex(0);
	}
	
	private void llenarUnidades(){
		if(dependenciasDocente != null){
			for(TbAdmDocentexDependencia dependenciaxDocente: dependenciasDocente){
				if(unidadesxDocente==null){
					unidadesxDocente.add(dependenciaxDocente.getTbAdmDependencia().getTbAdmUnidadAcademica());
				}else{
					boolean encontrado = false;
					for(TbAdmUnidadAcademica unidad: unidadesxDocente){
						if(unidad.getVrIdunidad().equals(dependenciaxDocente.getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad())){
							encontrado = true;
						}
					}
					if(!encontrado){
						unidadesxDocente.add(dependenciaxDocente.getTbAdmDependencia().getTbAdmUnidadAcademica());
					}
				}
			}
		}
	}
	
	private void recargarDependenciaPorUnidadAcademica(TbAdmUnidadAcademica unidad){
		cmbDependenciaAcademica.getItems().clear();
		
		try{
			dependenciasDocente = docentexDependenciaNGC.listarDependenciasxDocentexUnidad(docenteSession, unidad);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se pudo listar dependencias x docente","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(dependenciasDocente != null){
			cmbDependenciaAcademica.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDocentexDependencia dependencia: dependenciasDocente){
				Comboitem item = new Comboitem(dependencia.getTbAdmDependencia().getVrIddependencia()+" - "+dependencia.getTbAdmDependencia().getVrNombre());
				cmbDependenciaAcademica.appendChild(item);
			}
		}
	}
	
	public void onSelect$cmbUnidadAcademica(){
		if(cmbUnidadAcademica.getSelectedIndex() > 0){
			TbAdmUnidadAcademica unidad = unidadesxDocente.get(cmbUnidadAcademica.getSelectedIndex()-1);
			buscarMicrocurriculos(unidad);
			recargarDependenciaPorUnidadAcademica(unidad);
		}else{
			dependenciasDocente = dependenciasDocenteAuxiliar;
			llenarComboboxDependencias();
		}
	}
	
	public void onSelect$cmbDependenciaAcademica(){
		if(cmbDependenciaAcademica.getSelectedIndex() > 0){
			TbAdmDocentexDependencia dependencia = dependenciasDocente.get(cmbDependenciaAcademica.getSelectedIndex()-1);
			buscarMicrocurriculos(dependencia.getTbAdmDependencia());
		}
		
//		TE COMENTO PORQUE NO SE SI REALMENTE ERES NECESARIO.....
//		else{
//			if(cmbUnidadAcademica.getSelectedIndex() > 0){
//				TbAdmUnidadAcademica unidad = unidadesxDocente.get(cmbUnidadAcademica.getSelectedIndex()-1);
//				buscarMicrocurriculos(unidad);
//				recargarDependenciaPorUnidadAcademica(unidad);
//			}else{
//				dependenciasDocente = dependenciasDocenteAuxiliar;
//				llenarComboboxDependencias();
//			}
//		}
	}
	
	private void buscarMicrocurriculos(TbAdmUnidadAcademica unidad){
		try{
			listadoMicrocurriculo = microcurriculoNGC.listarMicrocurriculosxResponsablexUnidad(docenteSession.getVrIdpersona(), unidad.getVrIdunidad());
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se pudo listar dependencias x docente","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		listarMicrocurriculos();
	}
	
	private void buscarMicrocurriculos(TbAdmDependencia dependencia){
		try{
			listadoMicrocurriculo = microcurriculoNGC.listarMicrocurriculosxResponsablexDependencia(docenteSession.getVrIdpersona(), dependencia.getVrIddependencia());
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("No se pudo listar dependencias x docente","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		listarMicrocurriculos();
	}
	
	private void extraerInformacion(){
		TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuario");
		persona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		nombrePersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrNombres();
		apellidoPersona = rolxUsuario.getTbAdmUsuario().getTbAdmPersona().getVrApellidos();
		userName = rolxUsuario.getTbAdmUsuario().getVrLogin();
		lblUsuarioLogin.setValue(userName);
		docenteSession = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		rol = rolxUsuario.getTbAdmRol().getNbId();
	}
	
	private void permisos(){
		
		switch (rol) {
			case 1:
				break;
			case 2:
				Executions.getCurrent().sendRedirect("./_ambientes/_admin/inicioAdmin.zul");
				break;
			case 3:
				verificarDependencias(docenteSession);
				listarMicrocurriculos();
				cargarDatosEncabezadoCoordinador();
				contenidoInicioDocente.setVisible(true);
				break;
			case 4:
				verificarDependencias(docenteSession);
				listarMicrocurriculos();
				cargarDatosEncabezadoDocente();
				contenidoInicioDocente.setVisible(true);
				break;
			case 7:
				verificarDependencias(docenteSession);
				listarMicrocurriculos();
				cargarDatosEncabezadoComite();
				contenidoInicioDocente.setVisible(true);
				break;
			default:
				Executions.getCurrent().sendRedirect("/index.zul");
				break;
		}
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
