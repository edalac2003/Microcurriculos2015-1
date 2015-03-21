package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javassist.expr.NewArray;

import org.apache.log4j.Logger;
import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
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

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMateriaxpensum;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.SemestreNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
import com.udea.proint1.microcurriculo.util.exception.Validaciones;

public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Toolbarbutton tool_update;
	Toolbarbutton tool_new;
	Toolbarbutton tool_save;
	
	Textbox txtFiltrarMateria;
	Longbox txtCodigo;
	Textbox txtNombreMateria;
	Longbox txtHt;
	Longbox txtHp;
	Longbox txtHtp;
	
	Checkbox ckbHabilitable;
	Checkbox ckbValidable;
	Checkbox ckbClasificable;
	
	Combobox cmbSemestre;
	Combobox cmbCreditos;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
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
	
	Listbox listBoxMaterias;
	Listbox listPrerrequisito;
	Listbox listPrerrequisito2;
	Listbox listCorrequisito;
	Listbox listCorrequisito2;
	
	Row rowPrerrequisitos;
	Row rowCorrequisitos;
	
	MateriaNGCImpl materiaNGC;
	NucleoNGCImpl nucleoNGC;
	SemestreNGCImpl semestreNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	CorrequisitoNGC correquisitoNGC;

	public void setMateriaNGC(MateriaNGCImpl materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setNucleoNGC(NucleoNGCImpl nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setSemestreNGC(SemestreNGCImpl semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

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
	
	public void cargarUnidadesAcademicas(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadesAca = unidadAcademicaNGC.listarUnidadAcademicas();
			cmbUnidadAcademica.getItems().clear();
			
			if(listaUnidadesAca != null){
				for(TbAdmUnidadAcademica unidad: listaUnidadesAca){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
					cmbUnidadAcademica.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron unidades academicas");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarDepartamentos(){
		try {
			List<TbAdmDependencia> listaDepartamentos = dependenciaNGC.listarDependencias();
			cmbDependencia.getItems().clear();
			
			if(listaDepartamentos != null){
				for(TbAdmDependencia departamento: listaDepartamentos){
					Comboitem item = new Comboitem(departamento.getVrIddependencia());
					item.setDescription(departamento.getVrNombre());
					cmbDependencia.appendChild(item);
					cmbDependencia.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
			}
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);	
				}
				cmbNucleo.setValue("[Seleccione]");
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarCoPrerrequisitos(){
		try{
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMaterias();
			cmbPrerrequisito.getItems().clear();
			cmbCorrequisito.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMateria materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbPrerrequisito.appendChild(item);
					
					Comboitem item2 = new Comboitem(materia.getVrIdmateria());
					item2.setDescription(materia.getVrNombre());
					cmbCorrequisito.appendChild(item2);
				}
				cmbPrerrequisito.setValue("[Seleccione]");
				cmbCorrequisito.setValue("[Seleccione]");
			}else{
				
			}
			
		}catch(ExcepcionesLogica e){
			
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
		String id = cmbUnidadAcademica.getValue().toString();
		try {
			TbAdmUnidadAcademica unidadAcademica = unidadAcademicaNGC.obtenerUnidadAcademica(id);
			lblUnidadAcademica.setValue(unidadAcademica.getVrNombre());
			recargarDepartamentos(id);
			recargarNucleos(id);
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbDependencia(){
		String id = cmbDependencia.getValue().toString();
		try {
			TbAdmDependencia departamento = dependenciaNGC.obtenerDependencia(id);
			lblDependencia.setValue(departamento.getVrNombre());
			recargarNucleos(id);
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbNucleo(){
		String id = cmbNucleo.getValue().toString();
		try {
			TbAdmNucleo nucleo = nucleoNGC.obtenerNucleo(id);
			lblNucleo.setValue(nucleo.getVrNombre());
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbPrerrequisito(){
		TbAdmMateria materiaAgregar;
		String idMateria = cmbPrerrequisito.getValue().toString();
		boolean materiaNoExiste = true;
		for(TbAdmMateria materia:listaPrerrequisitos){
			if(materia.getVrIdmateria().equals(idMateria)){
				Messagebox.show("Materia ya fue agregada como prerrequisito");
				materiaNoExiste = false;
			}
		}
		if(materiaNoExiste){
			try{
				materiaAgregar = materiaNGC.obtenerMateria(idMateria);
				if(materiaAgregar != null){
					listaPrerrequisitos.add(materiaAgregar);
					agregarPrerrequisito(materiaAgregar);
				}else{
					Messagebox.show("Materia a agregar como prerrequisito no existe");
				}
			}catch(ExcepcionesLogica e){
				
			}
		}
		cmbPrerrequisito.setValue("[Seleccione]");
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
		listPrerrequisito.appendChild(listaItem);
	}
	
	public void onSelect$cmbCorrequisito(){
		TbAdmMateria materiaAgregar;
		String idMateria = cmbCorrequisito.getValue().toString();
		boolean materiaNoExiste = true;
		for(TbAdmMateria materia:listaCorrequisitos){
			if(materia.getVrIdmateria().equals(idMateria)){
				Messagebox.show("Materia ya fue agregada como correquisito");
				materiaNoExiste = false;
			}
		}
		if(materiaNoExiste){
			try{
				materiaAgregar = materiaNGC.obtenerMateria(idMateria);
				if(materiaAgregar != null){
					listaCorrequisitos.add(materiaAgregar);
					agregarCorrequisito(materiaAgregar);
				}else{
					Messagebox.show("Materia a agregar como correquisito no existe");
				}
			}catch(ExcepcionesLogica e){
				
			}
		}
		cmbCorrequisito.setValue("[Seleccione]");
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
		listCorrequisito.appendChild(listaItem);
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
		txtCodigo.setValue(new Long(Long.parseLong(id)));
		verificarCodigo();
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
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
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
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onChange$txtCodigo(){
		verificarCodigo();
	}
	
	public void verificarCodigo(){
		String codigo = Long.toString(txtCodigo.getValue());
		if(codigo.length()<=6){
			lblCodigo.setValue("¡Complete codigo!");
		}else{
			lblCodigo.setValue("");
		}
	}
	
	/*public void onCreate() throws ExcepcionesLogica{
		this.cargarMaterias();
		this.cargarNucleos();
		this.cargarSemestres();
	}*/

	/*private void cargarSemestres() throws ExcepcionesLogica {
		try {
			this.listaSemestres = semestreNGC.listarSemestres();
			for (TbAdmSemestre semestre : listaSemestres) {
				ltbSemestre.appendChild(new Listitem(semestre.getVrIdsemestre(), semestre.getVrIdsemestre()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de semestres");
		}
	}*/

	/*private void cargarNucleos()throws ExcepcionesLogica{
		try {
			this.listaNucleos = nucleoNGC.listarNucleos();
			for (TbAdmNucleo nucleo : listaNucleos) {
				ltbNucleo.appendChild(new Listitem(nucleo.getVrNombre(), nucleo.getVrIdnucleo()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de núcleos");
		}
		
	}*/
	
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
		llenarDatos(materia);
	}
	
	/*public void onClick$imgAddNew()  {
		this.limpiarCampos();
	}*/
	
	private void limpiarCampos() {
		
		cmbUnidadAcademica.setVisible(true);
		cmbUnidadAcademica.setValue("[Seleccione]");
		lblUnidadAcademica.setValue("");
		cmbDependencia.setVisible(true);
		cmbDependencia.setValue("[Seleccione]");
		lblDependencia.setValue("");
		cmbNucleo.setVisible(true);
		cmbNucleo.setValue("[Seleccione]");
		lblNucleo.setValue("");
		txtCodigo.setVisible(true);
		txtCodigo.setConstraint("");
		txtCodigo.setVisible(true);
		txtCodigo.setValue(null);
		lblCodigo.setValue("");
		txtNombreMateria.setVisible(true);
		txtNombreMateria.setConstraint("");
		txtNombreMateria.setValue(null);
		lblNombreMateria.setValue("");
		cmbSemestre.setVisible(true);
		cmbSemestre.setValue("[Seleccione]");
		lblSemestre.setValue("");
		cmbCreditos.setVisible(true);
		cmbCreditos.setValue("[Seleccione]");
		lblCreditos.setValue("");
		ckbHabilitable.setVisible(true);
		ckbHabilitable.setChecked(false);
		lblHabilitable.setValue("");
		ckbValidable.setVisible(true);
		ckbValidable.setChecked(false);
		lblValidable.setValue("");
		ckbClasificable.setVisible(true);
		ckbClasificable.setChecked(false);
		lblClasificable.setValue("");
		txtHp.setVisible(true);
		txtHp.setConstraint("");
		txtHp.setValue(null);
		lblHp.setValue("");
		txtHt.setVisible(true);
		txtHt.setConstraint("");
		txtHt.setValue(null);
		lblHt.setValue("");
		txtHtp.setVisible(true);
		txtHtp.setConstraint("");
		txtHtp.setText(null);
		lblHtp.setValue("");
		cmbCorrequisito.setVisible(true);
		cmbCorrequisito.setValue("[Seleccione]");
		listCorrequisito2.setVisible(false);
		rowCorrequisitos.setVisible(true);
		listCorrequisito.getItems().clear();
		listaCorrequisitos.clear();
		cmbPrerrequisito.setVisible(true);
		cmbPrerrequisito.setValue("[Seleccione]");
		listPrerrequisito2.setVisible(false);
		rowPrerrequisitos.setVisible(true);
		listPrerrequisito.getItems().clear();
		listaPrerrequisitos.clear();
		
	}
	
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

	private void llenarDatos(TbAdmMateria materia) {
		
		limpiarCampos();
		
		cmbUnidadAcademica.setVisible(false);
		lblUnidadAcademica.setValue("["+materia.getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad()+"] "+materia.getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
		cmbDependencia.setVisible(false);
		lblDependencia.setValue("["+materia.getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia()+"] "+materia.getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
		cmbNucleo.setVisible(false);
		lblNucleo.setValue("["+materia.getTbAdmNucleo().getVrIdnucleo()+"] "+materia.getTbAdmNucleo().getVrNombre());
		txtCodigo.setVisible(false);
		lblCodigo.setValue(materia.getVrIdmateria());
		txtNombreMateria.setVisible(false);
		lblNombreMateria.setValue(materia.getVrNombre());
		cmbSemestre.setVisible(false);
		lblSemestre.setValue(Integer.toString(materia.getNbSemestre()));
		cmbCreditos.setVisible(false);
		lblCreditos.setValue(Integer.toString(materia.getNbCreditos()));
		ckbHabilitable.setVisible(false);
		if(materia.getBlHabilitable()==1){
			lblHabilitable.setValue("Si");
		}else{
			lblHabilitable.setValue("No");
		}
		ckbValidable.setVisible(false);
		if(materia.getBlValidable()==1){
			lblValidable.setValue("Si");
		}else{
			lblValidable.setValue("No");
		}
		ckbClasificable.setVisible(false);
		if(materia.getBlClasificable()==1){
			lblClasificable.setValue("Si");
		}else{
			lblClasificable.setValue("No");
		}
		txtHp.setVisible(false);
		lblHp.setValue(Integer.toString(materia.getNbHp()));
		txtHt.setVisible(false);
		lblHt.setValue(Integer.toString(materia.getNbHt()));
		txtHtp.setVisible(false);
		lblHtp.setValue(Integer.toString(materia.getNbHtp()));
		
		cmbPrerrequisito.setVisible(false);
		cmbCorrequisito.setVisible(false);
		listCorrequisito2.setVisible(true);
		listPrerrequisito2.setVisible(true);
		rowCorrequisitos.setVisible(false);
		rowPrerrequisitos.setVisible(false);
		
		listPrerrequisito2.getItems().clear();
		listCorrequisito2.getItems().clear();
		
		try {
			List<TbAdmPrerrequisito> prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(materia.getVrIdmateria());
			
			for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
				Listitem listaItem = new Listitem();
				
				Listcell celda = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria());
				listaItem.appendChild(celda);
				Listcell celda2 = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
				listaItem.appendChild(celda2);			
				listPrerrequisito2.appendChild(listaItem);
			}
			
		} catch (ExcepcionesDAO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<TbAdmCorrequisito> correquisitos = correquisitoNGC.listarCorrequisitosxMateria(materia.getVrIdmateria());
			
			for(TbAdmCorrequisito correquisito: correquisitos){
				Listitem listaItem = new Listitem();
				
				Listcell celda = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria());
				listaItem.appendChild(celda);
				Listcell celda2 = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
				listaItem.appendChild(celda2);			
				listCorrequisito2.appendChild(listaItem);
			}
			
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*this.txtNucleo.setVisible(true);
		this.ltbNucleo.setVisible(false);
		this.txtSemestre.setVisible(true);
		this.ltbSemestre.setVisible(false);
		this.txtCodigo.setText(materiaSeleccionada.getVrIdmateria());
		this.txtNucleo.setText(materiaSeleccionada.getTbAdmNucleo().getVrNombre());
		this.txtMateria.setText(materiaSeleccionada.getVrNombre());;
		this.txtSemestre.setText(materiaSeleccionada.getNbSemestre()+"");
		this.txtCreditos.setText(materiaSeleccionada.getNbCreditos()+"");
		this.txtHabilitable.setText(materiaSeleccionada.getBlHabilitable()== 1?"Si":"No");
		this.txtValidable.setText(materiaSeleccionada.getBlValidable()== 1?"Si":"No");
		this.txtClasificable.setText(materiaSeleccionada.getBlClasificable()== 1?"Si":"No");
		this.txtHt.setText(materiaSeleccionada.getNbHt()+"");
		this.txtHp.setText(materiaSeleccionada.getNbHp()+"");
		this.txtHtp.setText(materiaSeleccionada.getNbHtp()+"");
		this.txtEstado.setText(materiaSeleccionada.getBlEstado()==1?"Activa":"Inactiva");*/
		
		tool_save.setVisible(false);
		lblEncabezadoMateria.setValue("Materia Consultada");
		
	}
	
	public void onClick$tool_new(){
		tool_save.setVisible(true);
		lblEncabezadoMateria.setValue("Crear Materia");
		limpiarCampos();
	}
	
	public void onClick$tool_save() throws ExcepcionesLogica{
		TbAdmMateria materiaGuardar = verificarDatos();
		guardarMateria(materiaGuardar);
	}
	
	public TbAdmMateria verificarDatos(){
		TbAdmMateria materiaNueva = new TbAdmMateria();
		if((!"[Seleccione]".equals(cmbNucleo.getValue().toString())) && (cmbNucleo.getValue() != null) && (cmbNucleo.getValue().trim().length() > 0)){
			try{
				TbAdmNucleo nucleo = nucleoNGC.obtenerNucleo(cmbNucleo.getValue().toString());
				if(nucleo == null){
					Messagebox.show("El nucleo a asociar con la meteria no existe");
					return null;
				}else{
					materiaNueva.setTbAdmNucleo(nucleo);
					if(txtCodigo.getValue() != null){
						materiaNueva.setVrIdmateria(txtCodigo.getValue().toString());
						if(!"".equals(txtNombreMateria.getValue())){
							materiaNueva.setVrNombre(txtNombreMateria.getValue().toString().toUpperCase());
							if(!"[Seleccione]".equals(cmbSemestre.getValue().toString()) && (!"".equals(cmbSemestre.getValue().toString()))){
								materiaNueva.setNbSemestre(Integer.parseInt(cmbSemestre.getValue().toString()));
								if(!"[Seleccione]".equals(cmbCreditos.getValue().toString()) && !"".equals(cmbCreditos.getValue())){
									
									materiaNueva.setNbCreditos(Integer.parseInt(cmbCreditos.getValue().toString()));
									
									if(ckbHabilitable.isChecked()){
										materiaNueva.setBlHabilitable('1');
									}else{
										materiaNueva.setBlHabilitable('0');
									}
									
									if(ckbValidable.isChecked()){
										materiaNueva.setBlValidable('1');
									}else{
										materiaNueva.setBlValidable('0');
									}
									
									if(ckbClasificable.isChecked()){
										materiaNueva.setBlClasificable('1');
									}else{
										materiaNueva.setBlClasificable('0');
									}
									
									materiaNueva.setNbHp(Integer.parseInt(txtHp.getValue().toString()));
									
									materiaNueva.setNbHt(Integer.parseInt(txtHt.getValue().toString()));
									
									materiaNueva.setNbHtp(Integer.parseInt(txtHtp.getValue().toString()));
									
									materiaNueva.setBlEstado('1');
									
									return materiaNueva;
								}else{
									Messagebox.show("Se requiere información del campo <Creditos>");
									return null;
								}
							}else{
								Messagebox.show("Se requiere información del campo <Nivel o Semestre>");
								return null;
							}
						}else{
							Messagebox.show("Se requiere información del campo <Nombre Materia>");
							return null;
						}
					}else{
						Messagebox.show("Se requiere información del campo <Código Materia>");
						return null;
					}
				}
			}catch(ExcepcionesLogica e){
				Messagebox.show("error al intentar obtener Núcleo");
				return null;
			}
		}else{
			Messagebox.show("Se requiere información del campo <Núcleo>");
			return null;
		}
	}

	public void guardarMateria(TbAdmMateria materiaGuardar) throws ExcepcionesLogica{
		try{
			materiaNGC.guardarMateria(materiaGuardar);
			Messagebox.show("Se guardó exitosamente la materia");
		}catch(ExcepcionesLogica e){
			Messagebox.show("No se guardó la materia");
		}
		
		try{
			for(TbAdmMateria correquisito: listaCorrequisitos){
				TbAdmCorrequisito nuevoCorrequisito = new TbAdmCorrequisito();
				nuevoCorrequisito.setDtModfecha(new Date());
				nuevoCorrequisito.setVrModusuario("USER");
				nuevoCorrequisito.setTbAdmMateriasByVrCorrequisito(correquisito);
				nuevoCorrequisito.setTbAdmMateriasByVrMateria(materiaGuardar);
				nuevoCorrequisito.setNbId(0);
				correquisitoNGC.guardarCorrequisito(nuevoCorrequisito);
			}
			for(TbAdmMateria prerrequisito: listaPrerrequisitos){
				TbAdmPrerrequisito nuevoPrerrequisito = new TbAdmPrerrequisito();
				nuevoPrerrequisito.setDtModfecha(new Date());
				nuevoPrerrequisito.setVrModusuario("USER");
				nuevoPrerrequisito.setTbAdmMateriasByVrPrerrequisito(prerrequisito);
				nuevoPrerrequisito.setTbAdmMateriasByVrMateria(materiaGuardar);
				nuevoPrerrequisito.setNbId(0);
				prerrequisitoNGC.guardarPrerrequisito(nuevoPrerrequisito);
			}
		}catch(ExcepcionesLogica e){
			Messagebox.show("No se guardó la materia");
		}
		cargarMaterias();
		limpiarCampos();
	}
	
	public void actualizarMateria(TbAdmMateria materiaActualizar)throws ExcepcionesLogica{
		try{
			materiaNGC.actualizarMateria(materiaActualizar);
			Messagebox.show("Se actualizó materia exitosamente");
			cargarMaterias();
		}catch(ExcepcionesLogica e){
			Messagebox.show("No se pudo actualizar la Materia");
		}
	}
	
	/*public void onClick$btnGuardar() throws ExcepcionesLogica{
		if (!Validaciones.isTextoVacio(txtCodigo.getText())) {
			if (!Validaciones.validarSoloNumeros(txtCodigo.getText())){
				throw new WrongValueException(txtCodigo, Labels.getLabel("Formato incorrecto para el campo Código"));
			}
		}
		
		if (ltbNucleo.getSelectedItem() == null){
			throw new WrongValueException(ltbNucleo, Labels.getLabel("Por favor seleccione un núcleo"));
		}
		
		if (ltbSemestre.getSelectedItem() == null){
			throw new WrongValueException(ltbSemestre, Labels.getLabel("Por favor seleccione un sem
			
			estre"));
		}
		
		if (Validaciones.isTextoVacio(txtMateria.getText())) {
			throw new WrongValueException(txtMateria, Labels.getLabel("Por favor ingrese el nombre de la materia"));
		}
		
		TbAdmMateria materia = new TbAdmMateria();
		materia.setVrIdmateria(txtCodigo.getText());
		materia.setVrNombre(txtMateria.getText());
		TbAdmNucleo nucleo = new TbAdmNucleo(ltbNucleo.getSelectedItem().getValue().toString());
		materia.setTbAdmNucleo(nucleo);
		int nbSemestre = Integer.parseInt(ltbSemestre.getSelectedItem().getValue().toString());
		materia.setNbSemestre(nbSemestre);
		try{
			materiaNGC.guardarMateria(materia);	
			Messagebox.show("Materia grabada correctamente");
			this.cargarMaterias();
			this.limpiarCampos();
		}catch(ExcepcionesLogica e){
			Messagebox.show("No se pudo guardar la materia");
			this.limpiarCampos();
		}
	}*/
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargarUnidadesAcademicas();
		cargarDepartamentos();
		cargarNucleos();
		cargarMaterias();
		cargarCoPrerrequisitos();
		cargarSemestres();
		cargarCreditos();
	}
}

