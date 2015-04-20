package com.udea.proint1.microcurriculo.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;

/**
 * Este Controlador se encarga de Realizar las validaciones de los datos antes de guardarlos
 * 
 * @author eacosta
 *
 */
public class ValidarDatosCtrl extends GenericForwardComposer{
	
//	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
//	private static String modUsuario = "SYSTEM";
//	private static Date modFecha = new Date();
//	private static Date fechaEstimada = null;
//	private static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	//Declaracion de Variables globales requeridas.  Las listas se llenan de forma secundaria mediante un metodo primario.
	//Por Ejemplo: listadoUnidadesxMicro se llenar cuando se estan empaquetando las Unidades, a este metodo solo se le pasa un objeto de tipo
	//Microcurriculo.
	
//	private static List<TbMicUnidadxmicro> listadoUnidadesxMicro;
//	private static List<TbMicTemaxunidad> listadoTemasxUnidad;
//	private static List<TbMicEvaluacionxmicro> listadoEvaluacionesxMicro;
//	private static List<TbMicObjetivoxmicro> listadoObjetivosxMicro;
//	private static List<TbMicBiblioxunidad> listadoBibliografiaxUnidad;
//	private static List<TbMicSubtemaxtema> listadoSubtemaxTema;
	
//	private static List<TbMicUnidad> listadoUnidades;
//	private static List<TbMicObjetivo> listadoObjetivos;
//	private static List<TbMicEvaluacion> listadoEvaluaciones;
//	private static List<TbMicTema> listadoTemas;
//	private static List<TbMicSubtema> listadoSubtemas;
//	private static List<TbMicBibliografia> listadoBibliografia;
		
	
	Toolbarbutton tool_home;
	Toolbarbutton tool_new;
//	Toolbarbutton tool_save;
	Toolbarbutton tool_print;
	Toolbarbutton tool_close;
	
	
	Combobox cmbSemestre;
	Combobox cmbNucleo;
	Combobox cmbDocente;
	Combobox cmbMateria;
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbReferenciaBiblio;
	Combobox cmbEstado;
	
	//Estos los traje de CargaDatosFormas por si los llego a necesitar
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
//	Combobox cmbNucleo;
//	Combobox cmbSemestre;
//	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
//	Combobox cmbDocente;
//	Combobox cmbEstado;
	Combobox cmbPaisBiblio;
	
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

	//Objetos de Tipo NGC que se requieren para las validaciones.
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivoNGC objetivoNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	UnidadNGC unidadNGC;
	EstadoNGC estadoNGC;
	TemaNGC temaNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	EvaluacionNGC evaluacionNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	SubtemaNGC subtemaNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	BibliografiaNGC bibliografiaNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	MicrocurriculoNGC microcurriculoNGC;
	MicroxEstadoNGC microxEstadoNGC;
	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;

	/*
	 * Definici�n de Metodos Setter de Objetos de Negocio.
	 */

	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	public void setObjetivoNGC(ObjetivoNGC objetivoNGC) {
		this.objetivoNGC = objetivoNGC;
	}

	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	public void setUnidadNGC(UnidadNGC unidadNGC) {
		this.unidadNGC = unidadNGC;
	}

	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}

	public void setTemaNGC(TemaNGC temaNGC) {
		this.temaNGC = temaNGC;
	}

	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	public void setEvaluacionNGC(EvaluacionNGC evaluacionNGC) {
		this.evaluacionNGC = evaluacionNGC;
	}

	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	public void setSubtemaNGC(SubtemaNGC subtemaNGC) {
		this.subtemaNGC = subtemaNGC;
	}

	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	public void setBibliografiaNGC(BibliografiaNGC bibliografiaNGC) {
		this.bibliografiaNGC = bibliografiaNGC;
	}

	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}

	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	public void setGuardarMicrocurriculoNGC(GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
	}

	
	/**
	 * Evento onClick del Boton Guardar Microcurriculo
	 * 
	 * Aqui se inicia el proceso de la validacion de los Datos
	 * 
	 * @param event
	 */
	
	
//	public void onClick$tool_save2(){
//		//Aqui se va a empaquetar todo.
//
//		
//		TbMicMicrocurriculo microcurriculo = empaquetarMicrocurriculo();
//		if (microcurriculo != null){
//			TbMicMicroxestado microxEstado = empaquetarMicroxEstado(microcurriculo);
//			empaquetarObjetivos(microcurriculo);
//			if (listaUnidades.getItems().size() > 0)
//				empaquetarUnidades(microcurriculo);
//			if (listaTemas.getItems().size() > 0)
//				empaquetarTemas(listadoUnidades);
//			if (listaEvaluaciones.getItems().size() > 0)
//				empaquetarEvaluaciones(microcurriculo);
//			if (listaSubtemas.getItems().size() >0 )
//				empaquetarSubtemas(listadoTemas);
//			if(listaBibliografia.getItems().size() > 0)
//				empaquetarBibliografias(listadoUnidades);			
////					listadoAutores = new ArrayList<TbMicAutor>();
////					listadoAutorxBiblio = new ArrayList<TbMicAutorxbiblio>();
//		
//			if( !(existeMicrocurriculo(microcurriculo.getVrIdmicrocurriculo()))){
//				try {
//					guardarMicrocurriculoNGC.guardarMicroxlotes(microcurriculo, microxEstado, listadoTemas, listadoSubtemas, listadoSubtemaxTema, listadoTemasxUnidad, 
//											listadoUnidades, listadoUnidadesxMicro, listadoObjetivos, listadoObjetivosxMicro, listadoBibliografia, listadoBibliografiaxUnidad, 
//											listadoEvaluaciones, listadoEvaluacionesxMicro);
//					
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
//				if (verificarCampos() == 1){
//					cmbEstado.setDisabled(false);
//					Messagebox.show("El Microcurriculo se ha guardado correctamente. Puede Cambiar el estado del Microcurriculo cuando lo desee.");
//				} else if (verificarCampos() == 0){
//					Messagebox.show("El Microcurriculo se ha guardado correctamente. Su estado inicial es <Borrador>. \n Para cambiar el estado, el Microcurriculo "+
//							"debe estar completamente Diligenciado.", "REGISTRO ALMACENADO", Messagebox.OK,Messagebox.INFORMATION);
//				} else{
//					Messagebox.show("Errores al guardar.  Revise la informaci�n.");
//				}				
//			} else {
//				Messagebox.show("El Microcurriculo que desea crear coincide con un Registro en la Base de Datos. \n Por favor verifique la informaci�n ingresada.","Advertencia",Messagebox.OK,Messagebox.INFORMATION);
//			}
//		} else{
//			Messagebox.show("El formulario no cumple con la informaci�n minina necesaria para crear un Microcurriculo. \n Por favor verifique los campos e intentelo nuevamente.","ERROR",Messagebox.OK,Messagebox.ERROR);
//		}
//	}
	
//	private boolean existeMicrocurriculo(String idMicrocurriculo){
//		TbMicMicrocurriculo micro = null;
//		boolean estado = false;
//		
//		try {
//			micro = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
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
//		if (micro != null)
//			estado = true;
//		
//		return estado;
//		
//	}
	
//	private TbMicMicroxestado empaquetarMicroxEstado(TbMicMicrocurriculo microcurriculo){
//		TbMicMicroxestado microxEstado = null;
//		int registro = 0;
//		TbMicEstado estado = null;
//		TbAdmPersona responsable = null;
//		
////		try {
////			registro = microxEstadoNGC.contarRegistros();			
////		} catch (ExcepcionesLogica e) {
////			logger.error("Error al intentar recuperar el numero de Registros de la Tabla Microcurriculo x Estado."+e);
////		}
//		
//		try {
//			estado = estadoNGC.obtenerEstados(1);
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
//		try {
//			responsable = personaNGC.obtenerPersona(cmbDocente.getValue());
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
//		if(estado != null){
//			microxEstado = new TbMicMicroxestado(estado, modFecha, microcurriculo, responsable, modUsuario, modFecha);
//		}		
//		return microxEstado;
//	}
//	
//			
//	private void empaquetarEvaluaciones(TbMicMicrocurriculo microcurriculo){
//		TbMicEvaluacion evaluacion = null;
//		TbMicEvaluacionxmicro evaluacionxMicro = null;
//		
//		listadoEvaluaciones = new ArrayList<TbMicEvaluacion>();
//		listadoEvaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
//				
//		for(int i=1;i<=listaEvaluaciones.getItemCount();i++){
//			Listitem listaitem = (Listitem)listaEvaluaciones.getChildren().get(i);
//			Listcell celdaEvaluacion = (Listcell)listaitem.getChildren().get(0);
//			Listcell celdaPorcentaje = (Listcell)listaitem.getChildren().get(1);
//			Listcell celdaFecha = (Listcell)listaitem.getChildren().get(2);
//			String tmpFecha = celdaFecha.getLabel().toString();			
//			try {
//				fechaEstimada = df.parse(tmpFecha);
//			} catch (ParseException e) {
//				logger.error("Error en le Formato de Fecha.");
//			}
//
//			evaluacion = new TbMicEvaluacion(celdaEvaluacion.getLabel(), modUsuario, modFecha);
//			listadoEvaluaciones.add(evaluacion);
//			evaluacionxMicro = new TbMicEvaluacionxmicro(evaluacion, microcurriculo, Integer.parseInt(celdaPorcentaje.getLabel()), fechaEstimada, modUsuario, modFecha);
//			listadoEvaluacionesxMicro.add(evaluacionxMicro);
//		}
//	}
//	
//	
//	private void empaquetarTemas(List<TbMicUnidad> listadoUnidades){
//		TbMicTema tema = null;
//		TbMicTemaxunidad temaxUnidad = null;
//		TbMicUnidad unidad = null;
//		listadoTemas = new ArrayList<TbMicTema>();
//		listadoTemasxUnidad = new ArrayList<TbMicTemaxunidad>();
//				
//		for (int i=1;i<=listaTemas.getItems().size(); i++){
//			Listitem listaitem = (Listitem)listaTemas.getChildren().get(i);
//			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
//			Listcell celdaNombreTema = (Listcell)listaitem.getChildren().get(1);
//			Listcell celdaSemanas = (Listcell)listaitem.getChildren().get(2);
//			
//			unidad = obtenerUnidad(listadoUnidades, celdaUnidad.getLabel());
//			String descripcion = celdaNombreTema.getLabel();
//			tema = new TbMicTema(descripcion, modUsuario, modFecha);
//			listadoTemas.add(tema);
//			temaxUnidad = new TbMicTemaxunidad(unidad, tema, Integer.parseInt(celdaSemanas.getLabel()), modUsuario, modFecha);
//			listadoTemasxUnidad.add(temaxUnidad);
//		}		
//	}
//	
//	
//	
//	private void empaquetarSubtemas(List<TbMicTema> lista){
//		TbMicTema tema = null;
//		TbMicSubtema subtema = null;
//		TbMicSubtemaxtema subtemaxTema = null;	
//		listadoSubtemas = new ArrayList<TbMicSubtema>();
//		listadoSubtemaxTema = new ArrayList<TbMicSubtemaxtema>();
//		
//		for(int i=1; i<=listaSubtemas.getItems().size(); i++){
//			Listitem listaitem = (Listitem)listaSubtemas.getChildren().get(i);
//			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
//			Listcell celdaSubtema = (Listcell)listaitem.getChildren().get(2);
//			String nombreTema = celdaTemas.getLabel().toString();
//			
//			tema = obtenerTema(lista, nombreTema);
//						
//			if (tema != null){
//				subtema = new TbMicSubtema(celdaSubtema.getLabel().toString(), modUsuario, modFecha);
//				listadoSubtemas.add(subtema);
//				subtemaxTema = new TbMicSubtemaxtema(tema, subtema, modUsuario, modFecha);
//				listadoSubtemaxTema.add(subtemaxTema);
//			} 
//		}		
//	}
//	
//	
//	
//	private void empaquetarBibliografias(List<TbMicUnidad> lista){
//		TbMicBibliografia bibliografia = null;
//		TbMicBiblioxunidad biblioxUnidad = null;
//		char tipoBibliografia;
//		listadoBibliografia = new ArrayList<TbMicBibliografia>();
//		listadoBibliografiaxUnidad = new ArrayList<TbMicBiblioxunidad>();
//		
//		for(int i=1; i<=listaBibliografia.getItems().size(); i++){
//			Listitem listaitem = (Listitem)listaBibliografia.getChildren().get(i);
//			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
//			Listcell celdaReferencia = (Listcell)listaitem.getChildren().get(1);
//			Listcell celdaAutor = (Listcell)listaitem.getChildren().get(2);
//			Listcell celdaISBN = (Listcell)listaitem.getChildren().get(3);
//			Listcell celdaTipo = (Listcell)listaitem.getChildren().get(4);
//			String strReferencia = celdaReferencia.getLabel().toString();
//			String strAutor = celdaAutor.getLabel().toString();
//			String strISBN = celdaISBN.getLabel().toString();
//			
//			if ("BASICA".equals(celdaTipo.getLabel().toUpperCase()))
//				tipoBibliografia = '1';
//			else 
//				tipoBibliografia = '0';
//						
//			bibliografia = new TbMicBibliografia(strReferencia, null, strISBN, strAutor, tipoBibliografia, modUsuario, modFecha);
//			listadoBibliografia.add(bibliografia);			
//			TbMicUnidad unidad = obtenerUnidad(lista, celdaUnidad.getLabel().toString().toUpperCase());
//			biblioxUnidad = new TbMicBiblioxunidad(bibliografia, unidad, modUsuario, modFecha);
//			listadoBibliografiaxUnidad.add(biblioxUnidad);
//		}
//		
//		for(int i=0; i<listaCibergrafia.getItemCount();i++){
//			Listitem listaItem = (Listitem)listaCibergrafia.getChildren().get(i+1);
//			Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
//			Listcell celdaReferencia = (Listcell)listaItem.getChildren().get(1);
//			Listcell celdaSitio = (Listcell)listaItem.getChildren().get(2);
//			Listcell celdaTipo = (Listcell)listaItem.getChildren().get(3);
//			String strReferencia = celdaReferencia.getLabel().toString();
//			String strSitio = celdaSitio.getLabel().toString();
//			
//			if ("BASICA".equals(celdaTipo.getLabel().toUpperCase()))
//				tipoBibliografia = '1';
//			else 
//				tipoBibliografia = '0';
//			
//			TbMicUnidad unidad = obtenerUnidad(lista, celdaUnidad.getLabel().toString().toUpperCase());
//			
//			bibliografia = new TbMicBibliografia(strReferencia, strSitio, null, null, tipoBibliografia, modUsuario, modFecha);
//			
//			biblioxUnidad = new TbMicBiblioxunidad(bibliografia, unidad, modUsuario, modFecha);
//			listadoBibliografia.add(bibliografia);
//			listadoBibliografiaxUnidad.add(biblioxUnidad);			
//		}	
//	}
	
	/**
	 * 
	 * @param lista
	 * @param nombre
	 * @return
	 */
//	private TbMicUnidad obtenerUnidad(List<TbMicUnidad> lista, String nombre){
//		TbMicUnidad unidad = null;
//		for (TbMicUnidad un : lista){
//			if(nombre.equals(un.getVrNombre().trim())){
//				unidad = un;
//				break;
//			}				
//		}
//		return unidad;
//	}
//	
//	
//	private TbMicTema obtenerTema(List<TbMicTema> lista, String nombre){
//		TbMicTema tema = null;
//		for(TbMicTema tm : lista){
//			if (nombre.equals(tm.getVrDescripcion().trim())){
//				tema = tm;
//				break;
//			}
//		}
//		return tema;
//	}
//	
//	
//	private void empaquetarUnidades(TbMicMicrocurriculo microcurriculo){
//		TbMicUnidad unidad = null;
//		TbMicUnidadxmicro unidadxMicro = null;		
//		String nombreUnidad = "";
//		listadoUnidades = new ArrayList<TbMicUnidad>();
//		listadoUnidadesxMicro = new ArrayList<TbMicUnidadxmicro>();
//		
//		for (int i=1; i <= listaUnidades.getItems().size(); i++){
//			Listitem item = (Listitem)listaUnidades.getChildren().get(i);
//			Listcell celdaUnidad = (Listcell)item.getChildren().get(1);
//			nombreUnidad = celdaUnidad.getLabel();
//			unidad = new TbMicUnidad(nombreUnidad, modUsuario, modFecha);
//			listadoUnidades.add(unidad);
//			unidadxMicro = new TbMicUnidadxmicro(unidad, microcurriculo, modUsuario, modFecha);
//			listadoUnidadesxMicro.add(unidadxMicro);
//		}
//	}
//	
//	/**
//	 * Este metodo se encarga de tomar la informaci�n de la ListaObjetivosEspecificos y empaquetar ListaObjetivos y ListadoObjetivosxMicrocurriculo.
//	 * @param microcurriculo
//	 * @return Lista con objetos de Tipo Objetivos
//	 */
//	private void empaquetarObjetivos(TbMicMicrocurriculo microcurriculo){
//		TbMicObjetivo objetivo = null;
//		TbMicObjetivoxmicro objetivosxMicro = null;		
//		
//		
//		listadoObjetivos = new ArrayList<TbMicObjetivo>();
//		listadoObjetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
//		
//		if((txtObjetivoGeneral.getValue().trim().length() > 0) && !(txtObjetivoGeneral.equals(""))){
//			objetivo = new TbMicObjetivo(txtObjetivoGeneral.getValue(), modUsuario, modFecha);
//			listadoObjetivos.add(objetivo);
//			objetivosxMicro = new TbMicObjetivoxmicro(objetivo,microcurriculo,'1',modUsuario,modFecha);
//			listadoObjetivosxMicro.add(objetivosxMicro);
//			
//			for (int i=0; i<listaObjetivosEspecificos.getItems().size(); i++){
//				Listitem item = (Listitem)listaObjetivosEspecificos.getChildren().get(i);
//				Listcell celdaObjetivo = (Listcell)item.getChildren().get(0);
//				objetivo = new TbMicObjetivo(celdaObjetivo.getLabel(), modUsuario, modFecha);
//				listadoObjetivos.add(objetivo);
//				objetivosxMicro = new TbMicObjetivoxmicro(objetivo,microcurriculo,'0',modUsuario,modFecha);
//				listadoObjetivosxMicro.add(objetivosxMicro);
//			}
//		} else {
//			Messagebox.show("Sin Informaci�n en el Campo Objetivo General.");
//			txtObjetivoGeneral.setFocus(true);
//		}		
//	}
//	
//	
//	/*
//	 * Este m�todo se encarga de empaquetar la informaci�n y devolver un Objeto de tipo Microcurriculo
//	 *  
//	 * @return Objeto de Tipo Microcurriculo.
//	 */
//	private TbMicMicrocurriculo empaquetarMicrocurriculo(){
//		TbMicMicrocurriculo microcurriculo = null;;
//		String codigoMicrocurriculo = "";
//		TbAdmMateria materia = null;
//		TbAdmSemestre semestre = null;
//		TbAdmPersona responsable = null;
//		TbMicEstado estado = null;
//				
//		try {
//			materia = materiaNGC.obtenerMateria(cmbMateria.getValue());
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
//		try {
//			semestre = semestreNGC.obtenerSemestre(cmbSemestre.getValue());
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
//		try {
//			responsable = personaNGC.obtenerPersona(cmbDocente.getValue());
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
//		try {
//			estado = estadoNGC.obtenerEstados(1);
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
//		codigoMicrocurriculo = asignarIdMicrocurriculo(cmbSemestre.getValue().toString(), cmbMateria.getValue().toString());
//		
//		if ((codigoMicrocurriculo.length() > 0) && (!codigoMicrocurriculo.equals(""))){
//			if (materia != null){
//				if (semestre != null){
//					if (responsable != null){
//						microcurriculo = new TbMicMicrocurriculo(codigoMicrocurriculo, materia, semestre, txtPropositoMicro.getValue().toString(), 
//								txtJustificacionMicro.getValue().toString(), txtResumenMicro.getValue().toString(), responsable, estado, modUsuario, modFecha);
//						lblidMicrocurriculo.setValue(codigoMicrocurriculo.toString());
////						cmbEstado.setValue(obtenerEstado());
//					}
//				}
//			}
//		} else
//			Messagebox.show("No se pudo crear el objeto Microcurriculo");
//		return microcurriculo;
//	}
	
	
	
	/*
	 * Obtiene la Descripcion de un estado que se asignar� al Microcurriculo.
	 */
//	private String obtenerEstado(){
//		String estado = "";
//		try {
//			estado = estadoNGC.obtenerEstados(1).getVrDescripcion();
//		} catch (ExcepcionesLogica e) {
//			logger.info("El Registro Solicitado no fue Hallado en la Base de Datos.");
//		}
//		return estado;
//	}
	
	
	
//	private String asignarIdMicrocurriculo(String idsemestre, String idmateria){
//		String codigo = "";
//		TbAdmSemestre semestre = null;
//		TbAdmMateria materia = null;
//		
//		try {
//			semestre = semestreNGC.obtenerSemestre(idsemestre);			
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
//		try {
//			materia = materiaNGC.obtenerMateria(idmateria);
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
//		if (semestre != null){
//			if (materia != null){
//				codigo = materia.getVrIdmateria().toUpperCase() + "-" + semestre.getVrIdsemestre().toUpperCase();	
//			}else
//				Messagebox.show("No es posible generar el codigo del Microcurriculo porque el valor de la Materia es Incorrecto.");					
//		}else
//			Messagebox.show("No es posible generar el codigo del Microcurriculo porque el valor del semestre es Incorrecto.");
//		
//		return codigo;
//	}
	
	/**
	 * Este m�todo se encarga de validar la informaci�n ingresada y clasifica el estado en el que se guardar� el Microcurriculo.
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
	 * Este metodo verifica que los campos de la Pesta�a Informaci�n General no esten vacios.
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
		
//		if((cmbSemestre.getValue().trim().length() > 0) && !("".equals(cmbSemestre.getValue().toString()))){
//			if ((cmbNucleo.getValue().trim().length() > 0) && !("".equals(cmbNucleo.getValue().toString()))){
//				if ((cmbDocente.getValue().trim().length() > 0) && !("".equals(cmbDocente.getValue().toString()))){
//					if ((cmbMateria.getValue().trim().length() > 0) && !("".equals(cmbMateria.getValue().toString()))){
//						estado = true;
//					} else{
//						Messagebox.show("Falta Informacion en el Campo <Id Materia>");
//						cmbMateria.setFocus(true);
//					}					
//				} else{
//					Messagebox.show("Falta Informacion en el Campo <Id Responsable>");
//					cmbDocente.setFocus(true);
//				}
//			}else {
//				Messagebox.show("Falta Informacion en el Campo <Id Nucleo>");
//				cmbNucleo.setFocus(true);
//			}
//		}else {
//			Messagebox.show("Falta Informacion en el Campo <Id Semestre>");
//			cmbSemestre.setFocus(true);
//		}
		
		return estado;
	}
	
	
	/**
	 * Este metodo verifica que los Componentes de la Pesta�a Informaci�n Complementaria no esten vacios.
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
		
//		if (!("".equals(txtPropositoMicro.getValue().toString())) && (txtPropositoMicro.getValue().trim().length() > 0)){
//			if (!("".equals(txtJustificacionMicro.getValue().toString())) && (txtJustificacionMicro.getValue().trim().length() > 0)){
//				if (!("".equals(txtObjetivoGeneral.getValue().toString())) && (txtObjetivoGeneral.getValue().trim().length() > 0)){
//					if (listaObjetivosEspecificos.getItems().size() > 0){
//						if (!("".equals(txtResumenMicro.getValue().toString())) && (txtResumenMicro.getValue().trim().length() > 0)){
//							estado = true;
//						} else {
//							Messagebox.show("Falta Informacion en el Campo <Contenido Resumido>");
//						}
//					} else {
//						Messagebox.show("Falta Informacion en la lista <Objetivos Especificos>");
//						txtObjetivoEspecifico.setFocus(true);
//					}
//				} else {
//					Messagebox.show("Falta Informacion en el Campo <Objetivo General Microcurriculo>");
//					txtObjetivoGeneral.setFocus(true);
//				}
//			} else {
//				Messagebox.show("Falta Informacion en el Campo <Justificaci�n Microcurriculo>");
//				txtJustificacionMicro.setFocus(true);
//			}
//		} else {
//			Messagebox.show("Falta Informacion en el Campo <Proposito Microcurriculo>");
//			txtPropositoMicro.setFocus(true);
//		}
				
		return estado;
	}
	
	/**
	 * Este metodo verifica que los Componentes de la Pesta�a Unidades Detalladas no esten vacios.
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
		
		
//		if ((listaUnidades.getItemCount() > 0) && (listaUnidades != null)){
//			if ((listaTemas.getItemCount() > 0) && (listaTemas != null)){
//				if ((listaSubtemas.getItemCount() > 0) && (listaSubtemas != null)){
//					estado = true;
//				} 
//				else {
//					Messagebox.show("Falta Informacion en la lista <Subtemas por Temas>");
//					cmbListaUnidades.setFocus(true);
//				}
//			} 
//			else {
//				Messagebox.show("Falta Informacion en la lista <Temas por Unidades>");
//				cmbIdUnidad.setFocus(true);
//			}
//		} 
//		else {
//			Messagebox.show("Falta Informacion en la lista <Unidades>");
//			txtNombreUnidad.setFocus(true);
//		}
		return estado;
	}
	
	/**
	 * Este metodo verifica que los componentes de la Pesta�a Evaluaciones no esten vacios.
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
	 * Este metodo verifica que los componentes de la Pesta�a Bibliogr�ficas no esten vacios.
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
	}

}
