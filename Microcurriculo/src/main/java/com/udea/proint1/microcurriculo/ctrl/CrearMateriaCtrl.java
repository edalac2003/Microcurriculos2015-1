package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.expr.NewArray;

import org.apache.log4j.Logger;
import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.ext.Selectable;

import com.udea.proint1.microcurriculo.dto.TbAdmArea;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
//import com.udea.proint1.microcurriculo.dto.TbMicEstado;
//import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
//import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.AreaNGC;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.SemestreNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
//import com.udea.proint1.microcurriculo.util.exception.Validaciones;

@SuppressWarnings({ "serial", "unused", "rawtypes" })
public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Toolbarbutton tool_update;
	Toolbarbutton tool_new;
	Toolbarbutton tool_save;
	
	Textbox txtFiltrarMateria;
	Textbox txtCodigo;
	Textbox txtNombreMateria;
	
	Intbox txtHt;
	Intbox txtHp;
	Intbox txtHtp;
	
	Checkbox ckbHabilitable;
	Checkbox ckbValidable;
	Checkbox ckbClasificable;
	
	Combobox cmbSemestre;
	Combobox cmbCreditos;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbArea;
	Combobox txtAliasMateria;
	Combobox cmbPrerrequisito;
	Combobox cmbCorrequisito;
	
	Label lblUnidadAcademica;
	Label lblNucleo;
	Label lblDependencia;
	Label lblCodigo;
	Label lblNombreMateria;
	Label lblSemestre;
	Label lblCreditos;
	Label lblHabilitable;
	Label lblClasificable;
	Label lblValidable;
	Label lblHp;
	Label lblHt;
	Label lblHtp;
	Label lblEncabezadoMateria;
	Label lblFechaActual;
	Label lblUsuarioLogin;
	
	Listbox listBoxMaterias;
	Listbox listaPrerrequisito;
//	Listbox listPrerrequisito2;
	Listbox listaCorrequisito;
//	Listbox listCorrequisito2;
	
//	Row rowPrerrequisitos;
//	Row rowCorrequisitos;
//	
	/**
	 * Listados para manejar las consultas
	 */

	public static List<TbAdmUnidadAcademica> listadoUnidadAcademica;
	public static List<TbAdmDependencia> listadoDependencias;
	public static List<TbAdmNucleo> listadoNucleos;
	public static List<TbAdmArea> ListadoAreas;
//	public static List<TbAdmMateria> listadoMaterias2;
	public static List<TbAdmMateria> listadoMaterias3;
//	public static List<TbAdmPersona> listadoDocentes;
	public static List<TbAdmSemestre> listadoSemestre;
	public static List<TbAdmMateria> listadoPrerrequisito;
	public static List<TbAdmMateria> listadoCorrequisito;
//	public static List<TbMicEstado> listadoEstados;
//	public static List<TbMicMicrocurriculo> listadoMicrocurriculos;
	
	MateriaNGCImpl materiaNGC;
	NucleoNGCImpl nucleoNGC;
	SemestreNGCImpl semestreNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	CorrequisitoNGC correquisitoNGC;
	AreaNGC areaNGC;
	
	/**
	 * Metodo set para inyeccion de dependencia spring para materias en la capa del negocio
	 * @param materiaNGC objeto instaciado de capa de negocio
	 */
	public void setMateriaNGC(MateriaNGCImpl materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	/**
	 * Metodo set para inyeccion de dependencia spring para nucleos en la capa del negocio
	 * @param nucleoNGC objeto instaciado de capa de negocio
	 */
	public void setNucleoNGC(NucleoNGCImpl nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	/**
	 * Metodo set para inyeccion de dependencia spring para semestres en la capa del negocio
	 * @param semestreNGC objeto instaciado de capa de negocio
	 */
	public void setSemestreNGC(SemestreNGCImpl semestreNGC) {
		this.semestreNGC = semestreNGC;
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
	 * Metodo set para inyeccion de dependencia spring para prerrequisitos en la capa del negocio
	 * @param prerrequisitoNGC objeto instaciado de capa de negocio
	 */
	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	/**
	 * Metodo set para inyeccion de dependencia spring para correquisitos en la capa del negocio
	 * @param correquisitoNGC objeto instaciado de capa de negocio
	 */
	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	
	public void setAreaNGC(AreaNGC areaNGC) {
		this.areaNGC = areaNGC;
	}



	/**
	 * Array list para el manejo de correquisitos, prerrequisitos y materias
	 */
	private List<TbAdmMateria> listaPrerrequisitos = new ArrayList<TbAdmMateria>();
	private List<TbAdmMateria> listaCorrequisitos = new ArrayList<TbAdmMateria>();
	private List<TbAdmMateria> listaMaterias;
	
	private void cargarMaterias() throws ExcepcionesLogica {
		try {
			this.listaMaterias = materiaNGC.listarMaterias();
			listBoxMaterias.setModel(new ListModelList<TbAdmMateria>(this.listaMaterias));
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de materias");
		}
	}
	
	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 * Si existe el combobox cmbUnidadAcademica se procede a llenar dicho elemento tambien
	 */
	public void cargarUnidadesAcademicas(){
		try {
			listadoUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
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
		
		if (listadoUnidadAcademica != null){			
			cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmUnidadAcademica unidad : listadoUnidadAcademica){
//				Comboitem item = new Comboitem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
//				cmbUnidadAcademica.appendChild(item);
				cmbUnidadAcademica.appendItem(unidad.getVrIdunidad()+" - "+ unidad.getVrNombre());
			}
			cmbUnidadAcademica.setValue("[Seleccione]");
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
				listadoDependencias = dependenciaNGC.buscarDepedencias(unidad);
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
				listadoDependencias = dependenciaNGC.listarDependencias();
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
		if (listadoDependencias != null){
			cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmDependencia dependencia : listadoDependencias){
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
				listadoNucleos = nucleoNGC.buscarNucleos(dependencia);
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
				listadoNucleos = nucleoNGC.listarNucleos();
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
		if (listadoNucleos != null){
			cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
			for(TbAdmNucleo nucleo : listadoNucleos){
				Comboitem item = new Comboitem(nucleo.getVrIdnucleo()+" - "+nucleo.getVrNombre());
				cmbNucleo.appendChild(item);
			}
			cmbNucleo.setValue("[Seleccione]");
		}
			
	}
	
	private void cargarAreas(String nucleo){
		ListadoAreas = null;
		if (!"".equals(nucleo)){
			nucleo = nucleo + "%";
			try {
				ListadoAreas = areaNGC.listarAreasPorNucleo(nucleo);
			} catch (ExcepcionesLogica expDAO) {
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			} catch (ExcepcionesDAO expNgs) {
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}
			
		}else{
			try {
				ListadoAreas = areaNGC.listarAreas();
			}catch (ExcepcionesLogica expDAO) {
				Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expDAO.getMsjTecnico());
			} catch (ExcepcionesDAO expNgs) {
				Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
				logger.error(expNgs.getMsjTecnico());
			}			
		}
		
		cmbArea.getItems().clear();
		if (ListadoAreas != null){
			for (TbAdmArea area:ListadoAreas){
				cmbArea.appendItem(area.getVrIdArea() +" - "+ area.getVrNombre());
			}
			cmbArea.setValue("[Seleccione]");
		}
	}
	
//	public void cargarCoPrerrequisitos(){
//		try{
//			listadoMaterias3 = materiaNGC.listarMaterias();
//			cmbPrerrequisito.getItems().clear();
//			cmbCorrequisito.getItems().clear();
//			
//			if(listadoMaterias3 != null){
//				cmbPrerrequisito.appendChild(new Comboitem("[Seleccione]"));
//				cmbCorrequisito.appendChild(new Comboitem("[Seleccione]"));
//				for(TbAdmMateria materia: listadoMaterias3){
//					Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
//					cmbPrerrequisito.appendChild(item);
//					
//					Comboitem item2 = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
//					cmbCorrequisito.appendChild(item2);
//				}
//				cmbPrerrequisito.setValue("[Seleccione]");
//				cmbCorrequisito.setValue("[Seleccione]");
//			}else{
//				
//			}
//			
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
	
	private void cargarPrerrequisitos(String nucleo){
		List<TbAdmMateria> listadoPrerrequisito = null;
		
		try {
			listadoPrerrequisito = materiaNGC.listarMateriasxNucleo(nucleo);
		} catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(listadoPrerrequisito != null){
			for (TbAdmMateria materia : listadoPrerrequisito){
				cmbPrerrequisito.appendItem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
			}
		}
	}
	
	private void cargarCorrequisitos(String nucleo){
		List<TbAdmMateria> listadoCorrequisito = null;
		
		try {
			listadoCorrequisito = materiaNGC.listarMateriasxNucleo(nucleo);
		} catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
//			Messagebox.show("","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(listadoCorrequisito != null){
			for (TbAdmMateria materia : listadoCorrequisito){
				cmbCorrequisito.appendItem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
			}
		}
	}
	
	
	public void cargarSemestres(){
		for(int i=0;i<=10;i++){
			Comboitem item = new Comboitem(Integer.toString(i));
			cmbSemestre.appendChild(item);
		}
		cmbSemestre.setValue("[Seleccione]");
	}
	
	public void cargarCreditos(){
		for(int i=0;i<=8;i++){
			Comboitem item = new Comboitem(Integer.toString(i));
			cmbCreditos.appendChild(item);
		}
		cmbCreditos.setValue("[Seleccione]");
	}
	
	public void onSelect$cmbUnidadAcademica(){
		if(cmbUnidadAcademica.getSelectedIndex() != 0){
			TbAdmUnidadAcademica unidad = listadoUnidadAcademica.get(cmbUnidadAcademica.getSelectedIndex()-1);
			cargarDependencias(unidad.getVrIdunidad());
			cargarNucleos(unidad.getVrIdunidad());
			recargarIdMateria(unidad.getVrIdunidad());
		}else{
			cargarDependencias("");
			cargarNucleos("");
		}
	}
	
	public void onSelect$cmbDependencia(){
		if(cmbDependencia.getSelectedIndex() != 0){
			TbAdmDependencia dependencia = listadoDependencias.get(cmbDependencia.getSelectedIndex()-1); 
			cargarNucleos(dependencia.getVrIddependencia());
			recargarIdMateria(dependencia.getVrIddependencia());
		}else{
			cargarNucleos("");
		}
	}
	
	public void onSelect$cmbNucleo(){
		if(cmbNucleo.getSelectedIndex() != 0){
			TbAdmNucleo nucleo = listadoNucleos.get(cmbNucleo.getSelectedIndex()-1);
			txtCodigo.setText(nucleo.getVrIdnucleo());
			recargarIdMateria(nucleo.getVrIdnucleo());
			cargarPrerrequisitos(nucleo.getVrIdnucleo());
			cargarCorrequisitos(nucleo.getVrIdnucleo());
		}
	}
	
		
	public void onSelect$cmbPrerrequisito(){
		if(cmbPrerrequisito.getSelectedIndex()>0)
			verificarPrerrequisito();
	}
	
	public void verificarPrerrequisito(){
		TbAdmMateria materiaAgregar = listadoMaterias3.get(cmbPrerrequisito.getSelectedIndex()-1);
		boolean materiaNoExiste = true;
		for(TbAdmMateria materia:listaPrerrequisitos){
			if(materia.getVrIdmateria().equals(materiaAgregar.getVrIdmateria())){
				Messagebox.show("Materia ya fue agregada como prerrequisito");
				materiaNoExiste = false;
			}
		}
		if(materiaNoExiste){
			listaPrerrequisitos.add(materiaAgregar);
			agregarPrerrequisito(materiaAgregar);
		}
		cmbPrerrequisito.setSelectedIndex(0);
	}
	
	public void agregarPrerrequisito(TbAdmMateria materiaAgregar){
		
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem);
			}
		});
		
		Listcell celda = new Listcell(materiaAgregar.getVrIdmateria());
		listaItem.appendChild(celda);
		Listcell celda2 = new Listcell(materiaAgregar.getVrNombre());
		listaItem.appendChild(celda2);			
		listaPrerrequisito.appendChild(listaItem);
	}
	
	public void onSelect$cmbCorrequisito(){
		if(cmbCorrequisito.getSelectedIndex()>0)
			verificarCorrequisito();
	}
	
	public void verificarCorrequisito(){
		TbAdmMateria materiaAgregar = listadoMaterias3.get(cmbCorrequisito.getSelectedIndex()-1);
		boolean materiaNoExiste = true;
		for(TbAdmMateria materia:listaCorrequisitos){
			if(materia.getVrIdmateria().equals(materiaAgregar.getVrIdmateria())){
				Messagebox.show("Materia ya fue agregada como correquisito");
				materiaNoExiste = false;
			}
		}
		if(materiaNoExiste){
			listaCorrequisitos.add(materiaAgregar);
			agregarCorrequisito(materiaAgregar);
		}
		cmbCorrequisito.setSelectedIndex(0);
		
//		TbAdmMateria materiaAgregar;
//		String idMateria = cmbCorrequisito.getValue().toString();
//		boolean materiaNoExiste = true;
//		for(TbAdmMateria materia:listaCorrequisitos){
//			if(materia.getVrIdmateria().equals(idMateria)){
//				Messagebox.show("Materia ya fue agregada como correquisito");
//				materiaNoExiste = false;
//			}
//		}
//		if(materiaNoExiste){
//			try{
//				materiaAgregar = materiaNGC.obtenerMateria(idMateria);
//				if(materiaAgregar != null){
//					listaCorrequisitos.add(materiaAgregar);
//					agregarCorrequisito(materiaAgregar);
//				}else{
//					Messagebox.show("Materia a agregar como correquisito no existe");
//				}
//			}catch(ExcepcionesLogica e){
//				
//			}
//		}
//		cmbCorrequisito.setValue("[Seleccione]");
	}
	
	public void agregarCorrequisito(TbAdmMateria materiaAgregar){
		
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem);
			}
		});
		
		Listcell celda = new Listcell(materiaAgregar.getVrIdmateria());
		listaItem.appendChild(celda);
		Listcell celda2 = new Listcell(materiaAgregar.getVrNombre());
		listaItem.appendChild(celda2);			
		listaCorrequisito.appendChild(listaItem);
	}
	
	public void eliminaListItem(Listitem item){
		if(item.getParent().getId().toString().equals("listPrerrequisito")){
			
			int contador = 0;
			int objeto = -1;
			for(TbAdmMateria prerrequisito: listaPrerrequisitos){
				Listcell celdaPre = (Listcell)item.getChildren().get(0);
				String cadenaPre = celdaPre.getLabel();
				if(prerrequisito.getVrIdmateria().equals(cadenaPre)){
					objeto = contador;
				}
				contador++;
			}
			if(objeto != -1){
				listaPrerrequisitos.remove(objeto);
				item.detach();
			}
			
		}else if(item.getParent().getId().toString().equals("listCorrequisito")){
			int contador = 0;
			int objeto = -1;
			for(TbAdmMateria correquisito: listaCorrequisitos){
				Listcell celdaPre = (Listcell)item.getChildren().get(0);
				String cadenaPre = celdaPre.getLabel();
				if(correquisito.getVrIdmateria().equals(cadenaPre)){
					objeto = contador;
				}
				contador++;
			}
			if(objeto != -1){
				listaCorrequisitos.remove(objeto);
				item.detach();
			}
			
		}
	}
	
	public void recargarIdMateria(String id){
//		txtCodigo.setValue(new Long(Long.parseLong(id)));
//		verificarCodigo();
	}
	
	public void recargarDepartamentos(String buscaDepartamentos){
		try {
			buscaDepartamentos = buscaDepartamentos + "%";
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.buscarDepedencias(buscaDepartamentos);
			cmbDependencia.getItems().clear();
			cmbDependencia.setValue("[Seleccione]");
			
			if(listaDependencias != null){
				for(TbAdmDependencia dependencia: listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
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
	
	public void recargarNucleos(String buscaNucleos){
		try {
			buscaNucleos = buscaNucleos+"%";
			List<TbAdmNucleo> listaNucleos = nucleoNGC.buscarNucleos(buscaNucleos);
			cmbNucleo.getItems().clear();
			cmbNucleo.setValue("[Seleccione]");
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
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
	
	public void onChange$txtCodigo(){
		verificarCodigo();
	}
	
	public boolean verificarCodigo(){
		Boolean estado = false;
		
		if(txtCodigo.getText().trim().length() <=6){
			estado=true;			
		}
		return estado;
	}
	
	/**
	 * Metodo que permite filtrar la lista rapida de materias
	 */
	public void onChange$txtFiltrarMateria() {
		List<TbAdmMateria> listaFiltrada = new ArrayList<TbAdmMateria>();
		String filtro = this.txtFiltrarMateria.getValue().toLowerCase();
		for (TbAdmMateria materia : this.listaMaterias) {
			if (materia.getVrNombre().toLowerCase().contains(filtro)){
				listaFiltrada.add(materia);
			}
		}
		this.listBoxMaterias.setModel(new ListModelList<TbAdmMateria>(listaFiltrada));
	}
	
	public void onSelect$listBoxMaterias(){
		Set<TbAdmMateria> selection = ((Selectable<TbAdmMateria>)listBoxMaterias.getModel()).getSelection();
		TbAdmMateria materia = selection.iterator().next();
		
		/**
		 * Variable de session materia para más acciones
		 */
		
		Executions.getCurrent().getSession().setAttribute("materia", materia.getVrIdmateria());
//		llenarDatos(materia);
	}
	
//	private void limpiarCampos() {
//		
//		cmbUnidadAcademica.setVisible(true);
//		cmbUnidadAcademica.setValue("[Seleccione]");
//		lblUnidadAcademica.setValue("");
//		cmbDependencia.setVisible(true);
//		cmbDependencia.setValue("[Seleccione]");
//		lblDependencia.setValue("");
//		cmbNucleo.setVisible(true);
//		cmbNucleo.setValue("[Seleccione]");
//		lblNucleo.setValue("");
//		txtCodigo.setVisible(true);
//		txtCodigo.setConstraint("");
//		txtCodigo.setVisible(true);
//		txtCodigo.setValue(null);
//		lblCodigo.setValue("");
//		txtNombreMateria.setVisible(true);
//		txtNombreMateria.setConstraint("");
//		txtNombreMateria.setValue(null);
//		lblNombreMateria.setValue("");
//		cmbSemestre.setVisible(true);
//		cmbSemestre.setValue("[Seleccione]");
//		lblSemestre.setValue("");
//		cmbCreditos.setVisible(true);
//		cmbCreditos.setValue("[Seleccione]");
//		lblCreditos.setValue("");
//		ckbHabilitable.setVisible(true);
//		ckbHabilitable.setChecked(false);
//		lblHabilitable.setValue("");
//		ckbValidable.setVisible(true);
//		ckbValidable.setChecked(false);
//		lblValidable.setValue("");
//		ckbClasificable.setVisible(true);
//		ckbClasificable.setChecked(false);
//		lblClasificable.setValue("");
//		txtHp.setVisible(true);
//		txtHp.setConstraint("");
//		txtHp.setValue(null);
//		lblHp.setValue("");
//		txtHt.setVisible(true);
//		txtHt.setConstraint("");
//		txtHt.setValue(null);
//		lblHt.setValue("");
//		txtHtp.setVisible(true);
//		txtHtp.setConstraint("");
//		txtHtp.setText(null);
//		lblHtp.setValue("");
//		cmbCorrequisito.setVisible(true);
//		cmbCorrequisito.setValue("[Seleccione]");
////		listCorrequisito2.setVisible(false);
////		rowCorrequisitos.setVisible(true);
//		listaCorrequisito.getItems().clear();
//		listaCorrequisitos.clear();
//		cmbPrerrequisito.setVisible(true);
//		cmbPrerrequisito.setValue("[Seleccione]");
////		listPrerrequisito2.setVisible(false);
////		rowPrerrequisitos.setVisible(true);
//		listaPrerrequisito.getItems().clear();
//		listaPrerrequisitos.clear();
//		
//	}
	
	/**
	 * Metodo para limpiar campo TextBox con Constraint
	 * @param textbox
	 */
	private void limpiarCampoConstraint(Textbox textbox){
		if (textbox.getConstraint() != null){
			Constraint c = textbox.getConstraint();
			textbox.setConstraint((String)null);
			textbox.setText("");
			textbox.setConstraint(c);
		}
	}

//	private void llenarDatos(TbAdmMateria materia) {
//		
//		limpiarCampos();
//		
//		cmbUnidadAcademica.setVisible(false);
//		lblUnidadAcademica.setValue("["+materia.getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad()+"] "+materia.getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
//		cmbDependencia.setVisible(false);
//		lblDependencia.setValue("["+materia.getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia()+"] "+materia.getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
//		cmbNucleo.setVisible(false);
//		lblNucleo.setValue("["+materia.getTbAdmNucleo().getVrIdnucleo()+"] "+materia.getTbAdmNucleo().getVrNombre());
//		txtCodigo.setVisible(false);
//		lblCodigo.setValue(materia.getVrIdmateria());
//		txtNombreMateria.setVisible(false);
//		lblNombreMateria.setValue(materia.getVrNombre());
//		cmbSemestre.setVisible(false);
//		lblSemestre.setValue(Integer.toString(materia.getNbSemestre()));
//		cmbCreditos.setVisible(false);
//		lblCreditos.setValue(Integer.toString(materia.getNbCreditos()));
//		ckbHabilitable.setVisible(false);
//		if(materia.getBlHabilitable()==1){
//			lblHabilitable.setValue("Si");
//		}else{
//			lblHabilitable.setValue("No");
//		}
//		ckbValidable.setVisible(false);
//		if(materia.getBlValidable()==1){
//			lblValidable.setValue("Si");
//		}else{
//			lblValidable.setValue("No");
//		}
//		ckbClasificable.setVisible(false);
//		if(materia.getBlClasificable()==1){
//			lblClasificable.setValue("Si");
//		}else{
//			lblClasificable.setValue("No");
//		}
//		txtHp.setVisible(false);
//		lblHp.setValue(Integer.toString(materia.getNbHp()));
//		txtHt.setVisible(false);
//		lblHt.setValue(Integer.toString(materia.getNbHt()));
//		txtHtp.setVisible(false);
//		lblHtp.setValue(Integer.toString(materia.getNbHtp()));
//		
//		cmbPrerrequisito.setVisible(false);
//		cmbCorrequisito.setVisible(false);
//		listCorrequisito2.setVisible(true);
//		listPrerrequisito2.setVisible(true);
//		rowCorrequisitos.setVisible(false);
//		rowPrerrequisitos.setVisible(false);
//		
//		listPrerrequisito2.getItems().clear();
//		listCorrequisito2.getItems().clear();
//		
//		try {
//			List<TbAdmPrerrequisito> prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(materia.getVrIdmateria());
//			
//			for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
//				Listitem listaItem = new Listitem();
//				
//				Listcell celda = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria());
//				listaItem.appendChild(celda);
//				Listcell celda2 = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
//				listaItem.appendChild(celda2);			
//				listPrerrequisito2.appendChild(listaItem);
//			}
//			
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
//		try {
//			List<TbAdmCorrequisito> correquisitos = correquisitoNGC.listarCorrequisitosxMateria(materia.getVrIdmateria());
//			
//			for(TbAdmCorrequisito correquisito: correquisitos){
//				Listitem listaItem = new Listitem();
//				
//				Listcell celda = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria());
//				listaItem.appendChild(celda);
//				Listcell celda2 = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
//				listaItem.appendChild(celda2);			
//				listCorrequisito2.appendChild(listaItem);
//			}
//			
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
//		tool_save.setVisible(false);
//		lblEncabezadoMateria.setValue("Materia Consultada");
//		
//	}
	
	public void onClick$tool_new(){
		tool_save.setVisible(true);
		lblEncabezadoMateria.setValue("Crear Materia");
//		limpiarCampos();
	}
	
	public void onClick$tool_save() throws ExcepcionesLogica{
		TbAdmMateria materiaGuardar = empaquetarMateria();
		if(materiaGuardar != null)
			guardarMateria(materiaGuardar);
	}
	
	private TbAdmMateria empaquetarMateria(){
		TbAdmMateria materia = null;
		if (cmbNucleo.getSelectedIndex() > 0){
//			if (cmbArea.getSelectedIndex() > 0){
				if (!"".equals(txtCodigo.getText())){
					if (!"".equals(txtNombreMateria.getText())){
						if (cmbCreditos.getSelectedIndex() > 0){
							if (cmbSemestre.getSelectedIndex() > 0){
								materia = new TbAdmMateria();
								materia.setVrIdmateria(txtCodigo.getText());
								materia.setVrNombre(txtNombreMateria.getText());
								materia.setVrAlias(txtAliasMateria.getText());
								materia.setNbSemestre(Integer.parseInt(cmbSemestre.getText()));
								materia.setNbCreditos(Integer.parseInt(cmbCreditos.getText()));
								materia.setTbAdmArea(ListadoAreas.get(cmbArea.getSelectedIndex()));
								materia.setTbAdmNucleo(listadoNucleos.get(cmbNucleo.getSelectedIndex()));
								materia.setBlEstado(1);
								if (ckbHabilitable.isChecked())
									materia.setBlHabilitable(1);
								else
									materia.setBlHabilitable(0);
								if(ckbValidable.isChecked())
									materia.setBlValidable(1);
								else
									materia.setBlHabilitable(0);
								if(ckbClasificable.isChecked())
									materia.setBlClasificable(1);
								else
									materia.setBlClasificable(0);
								if(txtHt.getValue() > 0)
									materia.setNbHt(txtHt.getValue());
								else
									materia.setNbHt(0);
								if(txtHp.getValue() > 0)
									materia.setNbHp(txtHp.getValue());
								else
									materia.setNbHp(0);
								if(txtHtp.getValue() > 0)
									materia.setNbHtp(txtHtp.getValue());
								else
									materia.setNbHtp(0);								
							}
						}
					}
				}
//			}
		}
		
		return materia;
	}
	
	private List<TbAdmMateria> empaquetarPrerrequisitos(){
		List<TbAdmMateria> prerrequisitos = null;
		if(listaPrerrequisito.getItems().size()>0){
			for(int i=0;i<listaPrerrequisito.getItems().size();i++){
				
			}
		}
		
		return prerrequisitos;
	}
	
	
//	public TbAdmMateria verificarDatos(){
//		TbAdmMateria materiaNueva = new TbAdmMateria();
//		if((!"[Seleccione]".equals(cmbNucleo.getValue().toString())) && (cmbNucleo.getValue() != null) && (cmbNucleo.getValue().trim().length() > 0)){
//			TbAdmNucleo nucleo = listaNucleos.get(cmbNucleo.getSelectedIndex()-1);
//			if(nucleo == null){
//				Messagebox.show("El nucleo a asociar con la meteria no existe");
//				return null;
//			}else{
//				materiaNueva.setTbAdmNucleo(nucleo);
//				if(txtCodigo.getValue() != null){
//					if(txtCodigo.getValue().toString().length()>6){
//					materiaNueva.setVrIdmateria(txtCodigo.getValue().toString());
//						if(!"".equals(txtNombreMateria.getValue())){
//							materiaNueva.setVrNombre(txtNombreMateria.getValue().toString().toUpperCase());
//							if(!"[Seleccione]".equals(cmbSemestre.getValue().toString()) && (!"".equals(cmbSemestre.getValue().toString()))){
//								materiaNueva.setNbSemestre(Integer.parseInt(cmbSemestre.getValue().toString()));
//								if(!"[Seleccione]".equals(cmbCreditos.getValue().toString()) && !"".equals(cmbCreditos.getValue())){
//									
//									materiaNueva.setNbCreditos(Integer.parseInt(cmbCreditos.getValue().toString()));
//									
//									if(ckbHabilitable.isChecked()){
//										materiaNueva.setBlHabilitable(1);
//									}else{
//										materiaNueva.setBlHabilitable(0);
//									}
//									
//									if(ckbValidable.isChecked()){
//										materiaNueva.setBlValidable(1);
//									}else{
//										materiaNueva.setBlValidable(0);
//									}
//									
//									if(ckbClasificable.isChecked()){
//										materiaNueva.setBlClasificable(1);
//									}else{
//										materiaNueva.setBlClasificable(0);
//									}
//									
//									materiaNueva.setNbHp(Integer.parseInt(txtHp.getValue().toString()));
//									materiaNueva.setNbHt(Integer.parseInt(txtHt.getValue().toString()));
//									materiaNueva.setNbHtp(Integer.parseInt(txtHtp.getValue().toString()));
//									materiaNueva.setBlEstado(1);
//									materiaNueva.setVrModusuario("SYSTEM");
//									materiaNueva.setDtModfecha(new Date());
//									
//									return materiaNueva;
//								}else{
//									Messagebox.show("Se requiere información del campo <Creditos>","ERROR",Messagebox.OK,Messagebox.ERROR);
//									return null;
//								}
//							}else{
//								Messagebox.show("Se requiere información del campo <Nivel o Semestre>","ERROR",Messagebox.OK,Messagebox.ERROR);
//								return null;
//							}
//						}else{
//							Messagebox.show("Se requiere información del campo <Nombre Materia>","ERROR",Messagebox.OK,Messagebox.ERROR);
//							return null;
//						}
//					}else{
//						Messagebox.show("Se requiere completar información del campo <Código Materia>","ERROR",Messagebox.OK,Messagebox.ERROR);
//						return null;
//					}
//					
//				}else{
//					Messagebox.show("Se requiere información del campo <Código Materia>","ERROR",Messagebox.OK,Messagebox.ERROR);
//					return null;
//				}
//			}
//		}else{
//			Messagebox.show("Se requiere información del campo <Núcleo>","ERROR",Messagebox.OK,Messagebox.ERROR);
//			return null;
//		}
//	}
	

	public void guardarMateria(TbAdmMateria materiaGuardar) throws ExcepcionesLogica{
		/**
		 * Guardando materia
		 */
		try{
			materiaNGC.guardarMateria(materiaGuardar);
			Messagebox.show("Se guardó exitosamente la materia","Información",Messagebox.OK,Messagebox.INFORMATION);
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
		 * Guarda los listados de prerrequisitos
		 */
		
		try{
			for(TbAdmMateria prerrequisito: listaPrerrequisitos){
				TbAdmPrerrequisito nuevoPrerrequisito = new TbAdmPrerrequisito(materiaGuardar, prerrequisito, "SYSTEM", new Date());
				prerrequisitoNGC.guardarPrerrequisito(nuevoPrerrequisito);
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
		
		/**
		 * Guarda los listados de correquisitos
		 */
		
		try{
			for(TbAdmMateria correquisito: listaCorrequisitos){
				TbAdmCorrequisito nuevoCorrequisito = new TbAdmCorrequisito(materiaGuardar, correquisito, "SYSTEM", new Date());
				correquisitoNGC.guardarCorrequisito(nuevoCorrequisito);
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
		cargarMaterias();
//		limpiarCampos();
	}
	
	public void actualizarMateria(TbAdmMateria materiaActualizar)throws ExcepcionesLogica{
		try{
			materiaNGC.actualizarMateria(materiaActualizar);
			Messagebox.show("Se actualizó materia exitosamente");
			cargarMaterias();
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
	 * Eventos de teclado
	 */
	
	public void onOK$cmbUnidadAcademica(){
		recargarIdMateria(cmbUnidadAcademica.getValue().toString());
		cmbDependencia.focus();
	}
	
	public void onOK$cmbDependencia(){
		recargarIdMateria(cmbDependencia.getValue().toString());
		cmbNucleo.focus();
	}
	
	public void onOK$cmbNucleo(){
		
		if(cmbNucleo.getSelectedIndex() != 0){
			TbAdmNucleo nucleo = listadoNucleos.get(cmbNucleo.getSelectedIndex()-1);
			txtCodigo.setText(nucleo.getVrIdnucleo());
			recargarIdMateria(nucleo.getVrIdnucleo());
			cargarPrerrequisitos(nucleo.getVrIdnucleo());
			cargarCorrequisitos(nucleo.getVrIdnucleo());
			recargarIdMateria(cmbNucleo.getValue().toString());
			cmbArea.focus();
		}
		
	}
	
	public void onOK$cmbArea(){
		txtCodigo.focus();
	}
	
	public void onOK$txtCodigo(){
		if (verificarCodigo())
			lblCodigo.setValue("¡Complete codigo!");
		else
			txtNombreMateria.focus();
	}
	
	public void onOK$txtNombreMateria(){
		if (txtNombreMateria.getText().trim().length() > 0){
			txtNombreMateria.setText(txtNombreMateria.getText().toUpperCase());
			txtAliasMateria.setText("");
			txtAliasMateria.focus();
		}
	}
	
	
	public void onOK$txtAliasMateria(){
		cmbSemestre.focus();
	}
	
	public void onOK$cmbSemestre(){
		cmbCreditos.focus();
	}
	
	public void onOK$cmbCreditos(){
		ckbHabilitable.focus();
	}
	
	public void onOK$ckbHabilitable(){
		ckbValidable.focus();
	}
	
	public void onOK$ckbValidable(){
		ckbClasificable.focus();
	}
	
	public void onOK$ckbClasificable(){
		txtHt.focus();
	}
	
	public void onOK$txtHt(){
		txtHp.focus();
	}
	
	public void onOK$txtHp(){
		txtHtp.focus();
	}
	
	public void onOK$txtHtp(){
		cmbPrerrequisito.focus();
	}
	
	public void onOK$cmbPrerrequisito(){
		verificarPrerrequisito();
		cmbCorrequisito.focus();
	}
	
	public void onOK$cmbCorrequisito(){
		verificarCorrequisito();
	}
	
	
	
	private void extraerInformacion(){
		TbAdmRolxUsuario rolxUsuario = (TbAdmRolxUsuario) Executions.getCurrent().getSession().getAttribute("rolxUsuario");
		Date now = new Date();
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s4 = df4.format(now);
		lblFechaActual.setValue(s4);
		TbAdmPersona docenteSession = rolxUsuario.getTbAdmUsuario().getTbAdmPersona();
		String userName = docenteSession.getVrNombres()+" "+docenteSession.getVrApellidos();
		lblUsuarioLogin.setValue(userName);
	}
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
//		if(Executions.getCurrent().getSession().hasAttribute("rolxUsuario")){
//			extraerInformacion();
			cargarUnidadesAcademicas();
			cargarDependencias("");
			cargarNucleos("");
			cargarAreas("");
			cargarMaterias();
//			cargarCoPrerrequisitos();
			cargarSemestres();
			cargarCreditos();
//		}else{
//			Executions.getCurrent().sendRedirect("/index.zul");
//		}
		
	}
}

