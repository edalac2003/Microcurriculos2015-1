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
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
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
	
	private static Logger logger = Logger.getLogger(BorrarMicroCtrl.class);
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Objetos de la Vista
	 */
	Listbox listaMicrocurriculo;
	Label lblFechaActual;
	Label lblNombreDocente;
	Label lblUsuarioLogin;
	
	/*
	 * Variables locales
	 */
	List<TbMicMicrocurriculo> listadoMicrocurriculo = null;
	private static Date fechaActual = new Date();
	String userName;
	String nombrePersona;
	String apellidoPersona;
	
	
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
	
	private void cargarDatosEncabezado(){
		lblFechaActual.setValue(fechaActual.toString());
//		userName = Executions.getCurrent().getSession().getAttribute("userName").toString();
//		nombrePersona = Executions.getCurrent().getSession().getAttribute("nombrePersona").toString();
//		apellidoPersona = Executions.getCurrent().getSession().getAttribute("apellidoPersona").toString();
		
		lblNombreDocente.setValue(nombrePersona+" "+apellidoPersona);
		lblUsuarioLogin.setValue(userName);
	}
	
	private void listarMicrocurriculos(){		
		try {
			listadoMicrocurriculo = microcurriculoNGC.listarMicrocurriculosPorResponsable("92532121");
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private static void mostrarMicrocurriculo(TbMicMicrocurriculo microcurriculo){
		if((microcurriculo.getTbMicEstado().getNbIdestado() == 1)||(microcurriculo.getTbMicEstado().getNbIdestado() == 4)||(microcurriculo.getTbMicEstado().getNbIdestado() == 5)){
			Executions.getCurrent().getSession().setAttribute("idMicro", microcurriculo.getVrIdmicrocurriculo());
			Executions.getCurrent().sendRedirect("/microcurriculo/ModificarMic.zul");
		}else{
			Executions.getCurrent().getSession().setAttribute("idMicro", microcurriculo.getVrIdmicrocurriculo());
			Executions.getCurrent().sendRedirect("/microcurriculo/detallesMic.zul");
		}
	}
	
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
		
		boolean ocurrioError = false;
		try{
			guardarMicrocurriculoNGC.eliminarMicrocurridulo(microcurriculo, microsxEstado, subtemasxTema, temasxUnidad, unidadesxMicro, objetivosxMicro, bibliosxUnidad, evaluacionesxMicro);
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
			Messagebox.show("No se puso eliminar el Microcurriculo","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
//		cargarDatosEncabezado();
		listarMicrocurriculos();
	}
}
