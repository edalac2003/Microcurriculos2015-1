package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.SemestreNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ModificarMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ModificarMateriaCtrl.class);
	
	Button btnBuscar;
	
	Toolbarbutton tool_new;
	Toolbarbutton tool_save;
	Toolbarbutton tool_back;
	
	Textbox txtFiltrarCodigo;
	Textbox txtFiltrarNombre;
	Textbox txtNombreMateria;
	Longbox txtHt;
	Longbox txtHp;
	Longbox txtHtp;
	
	Checkbox ckbHabilitable;
	Checkbox ckbValidable;
	Checkbox ckbClasificable;
	
	Combobox cmbSemestre;
	Combobox cmbCreditos;
	Combobox cmbPrerrequisito;
	Combobox cmbCorrequisito;
	
	Label lblCodigo;
	Label lblEncabezadoMateria;
	
	Listbox listBoxMaterias;
	Listbox listPrerrequisito;
	Listbox listCorrequisito;
	
	Hlayout hlaSectorModificar;
	Hlayout hlaSectorBuscar;
	
	/**
	 * Manejo lista de correquisitos y prerrequisitos
	 */
	public static List<TbAdmMateria> listaMaterias3;
	
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
	private List<TbAdmMateria> listaFiltradaCodigo = new ArrayList<TbAdmMateria>();
	private List<TbAdmMateria> listaFiltradaNombre = new ArrayList<TbAdmMateria>();
	private List<TbAdmMateria> listaMaterias;
	
	private void cargarMaterias(){
		try {
			listaMaterias = materiaNGC.listarMaterias();
			
			listarMaterias(listaMaterias);
			
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public void listarMaterias(List<TbAdmMateria> materiasMostrar){
		listBoxMaterias.getItems().clear();
		if(materiasMostrar != null){
			for(TbAdmMateria materia: materiasMostrar){
				final Listitem listaItem = new Listitem();
				
				listaItem.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						estraerMateria(listaItem);
					}
				});
				
				Listcell celda1 = new Listcell(materia.getVrIdmateria());
				listaItem.appendChild(celda1);
				Listcell celda2 = new Listcell(materia.getVrNombre());
				listaItem.appendChild(celda2);
				listBoxMaterias.appendChild(listaItem);
			}
		}
	}
	
	public void estraerMateria(Listitem item){
		hlaSectorBuscar.setVisible(false);
		hlaSectorModificar.setVisible(true);
		Listcell celda = (Listcell)item.getChildren().get(0);
		String idMateria = celda.getLabel();
		for(TbAdmMateria materia: listaMaterias){
			if(materia.getVrIdmateria().equals(idMateria)){
				llenarDatos(materia);
			}
		}
	}
	
	public TbAdmMateria estraerMateria(String idMateria){
		TbAdmMateria materia = null;
		try {
			materia = materiaNGC.obtenerMateria(idMateria);
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
		return materia;
	}
	
	public void cargarCoPrerrequisitos(){
		try{
			listaMaterias3 = materiaNGC.listarMaterias();
			cmbPrerrequisito.getItems().clear();
			cmbCorrequisito.getItems().clear();
			
			if(listaMaterias3 != null){
				cmbPrerrequisito.appendChild(new Comboitem("[Seleccione]"));
				cmbCorrequisito.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmMateria materia: listaMaterias3){
					Comboitem item = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
					cmbPrerrequisito.appendChild(item);
					
					Comboitem item2 = new Comboitem(materia.getVrIdmateria()+" - "+materia.getVrNombre());
					cmbCorrequisito.appendChild(item2);
				}
				cmbPrerrequisito.setValue("[Seleccione]");
				cmbCorrequisito.setValue("[Seleccione]");
			}else{
				
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
	
	public void onSelect$cmbPrerrequisito(){
		if(cmbPrerrequisito.getSelectedIndex()>0)
			verificarPrerrequisito();
	}
	
	public void verificarPrerrequisito(){
		TbAdmMateria materiaAgregar = listaMaterias3.get(cmbPrerrequisito.getSelectedIndex()-1);
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
		listPrerrequisito.appendChild(listaItem);
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
	
	public void onSelect$cmbCorrequisito(){
		if(cmbCorrequisito.getSelectedIndex()>0)
			verificarCorrequisito();
	}
	
	public void verificarCorrequisito(){
		TbAdmMateria materiaAgregar = listaMaterias3.get(cmbCorrequisito.getSelectedIndex()-1);
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
		
	}
	
	public void onClick$btnBuscar(){
		listaFiltradaCodigo.clear();
		listaFiltradaNombre.clear();
		
		if(listaMaterias != null){
			String filtroCodigo = txtFiltrarCodigo.getValue().toString();
			for(TbAdmMateria materia: listaMaterias){
				if(materia.getVrIdmateria().contains(filtroCodigo)){
					listaFiltradaCodigo.add(materia);
				}
			}
			String filtroNombre = txtFiltrarNombre.getValue().toLowerCase();
			for(TbAdmMateria materia: listaFiltradaCodigo){
				if(materia.getVrNombre().toLowerCase().contains(filtroNombre)){
					listaFiltradaNombre.add(materia);
				}
			}
		}
		listarMaterias(listaFiltradaNombre);
		
	}
	
	public void onClick$tool_back(){
		limpiarCampos();
		Executions.getCurrent().getSession().removeAttribute("materia");
		cargarMaterias();
		tool_back.setVisible(false);
		tool_save.setVisible(false);
		hlaSectorBuscar.setVisible(true);
		hlaSectorModificar.setVisible(false);
	}
	
	private void limpiarCampos() {
		
		lblCodigo.setValue("");
		txtNombreMateria.setConstraint("");
		txtNombreMateria.setValue(null);
		cmbSemestre.setValue("[Seleccione]");
		cmbCreditos.setValue("[Seleccione]");
		ckbHabilitable.setChecked(false);
		ckbValidable.setChecked(false);
		ckbClasificable.setChecked(false);
		txtHp.setConstraint("");
		txtHp.setValue(null);
		txtHt.setConstraint("");
		txtHt.setValue(null);
		txtHtp.setConstraint("");
		txtHtp.setText(null);
		cmbCorrequisito.setValue("[Seleccione]");
		listCorrequisito.getItems().clear();
		listaCorrequisitos.clear();
		cmbPrerrequisito.setValue("[Seleccione]");
		listPrerrequisito.getItems().clear();
		listaPrerrequisitos.clear();
		
	}
	
	/**
	 * Metodo para limpiar campo TextBox con Constraint
	 * @param textbox
	 */
//	private void limpiarCampoConstraint(Textbox textbox){
//		if (textbox.getConstraint() != null){
//			Constraint c = textbox.getConstraint();
//			textbox.setConstraint((String)null);
//			textbox.setText("");
//			textbox.setConstraint(c);
//		}
//	}

	private void llenarDatos(TbAdmMateria materia) {
		
		limpiarCampos();
		
		lblCodigo.setValue(materia.getVrIdmateria());
		txtNombreMateria.setValue(materia.getVrNombre());
		cmbSemestre.setValue(Integer.toString(materia.getNbSemestre()));
		cmbCreditos.setValue(Integer.toString(materia.getNbCreditos()));
		if(materia.getBlHabilitable()==1){
			ckbHabilitable.setChecked(true);
		}else{
			ckbHabilitable.setChecked(false);
		}
		if(materia.getBlValidable()==1){
			ckbValidable.setChecked(true);
		}else{
			ckbValidable.setChecked(false);
		}
		if(materia.getBlClasificable()==1){
			ckbClasificable.setChecked(true);
		}else{
			ckbClasificable.setChecked(false);
		}
		txtHp.setValue((long)materia.getNbHp());
		txtHt.setValue((long)materia.getNbHt());
		txtHtp.setValue((long)materia.getNbHtp());
		
		try {
			List<TbAdmPrerrequisito> prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(materia.getVrIdmateria());
			
			for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
				Listitem listaItem = new Listitem();
				
				Listcell celda = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria());
				listaItem.appendChild(celda);
				Listcell celda2 = new Listcell(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
				listaItem.appendChild(celda2);			
				listPrerrequisito.appendChild(listaItem);
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
		try {
			List<TbAdmCorrequisito> correquisitos = correquisitoNGC.listarCorrequisitosxMateria(materia.getVrIdmateria());
			
			for(TbAdmCorrequisito correquisito: correquisitos){
				Listitem listaItem = new Listitem();
				
				Listcell celda = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria());
				listaItem.appendChild(celda);
				Listcell celda2 = new Listcell(correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
				listaItem.appendChild(celda2);			
				listCorrequisito.appendChild(listaItem);
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
		
		tool_back.setVisible(true);
		tool_save.setVisible(true);
	}
	
	public void onClick$tool_update() throws ExcepcionesLogica{
		TbAdmMateria materiaActualizar = verificarDatos();
		actualizarMateria(materiaActualizar);
	}
	
	public TbAdmMateria verificarDatos(){
		TbAdmMateria materiaNueva = new TbAdmMateria();
		
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
					
	}

	public void guardarMateria(TbAdmMateria materiaGuardar) throws ExcepcionesLogica{
		try{
			materiaNGC.guardarMateria(materiaGuardar);
			Messagebox.show("Se guardó exitosamente la materia");
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
		limpiarCampos();
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
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		if(Executions.getCurrent().getSession().hasAttribute("materia")){
			tool_back.setVisible(true);
			tool_save.setVisible(true);
			hlaSectorBuscar.setVisible(false);
			hlaSectorModificar.setVisible(true);
			TbAdmMateria materia = estraerMateria(Executions.getCurrent().getSession().getAttribute("materia").toString());
			if(materia != null){
				llenarDatos(materia);
			}else{
				tool_back.setVisible(false);
				tool_save.setVisible(false);
				hlaSectorBuscar.setVisible(true);
				hlaSectorModificar.setVisible(false);
			}
		}
		cargarMaterias();
		cargarCoPrerrequisitos();
		cargarSemestres();
		cargarCreditos();
	}
}

