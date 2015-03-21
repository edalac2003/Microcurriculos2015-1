package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
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
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Contiene los metodos de control para la vista de duplicar microcurriculos asociados a eventos
 * @author Elmer Urrea & Edwin Acosta
 *
 */

public class ModificarMicro extends GenericForwardComposer{
	
	private static Logger logger = Logger.getLogger(ModificarMicro.class);
	
	Button btnAddObjetivo;
	
	Include panelDuplicarMicro;
	
	Borderlayout blyDuplicarMicro;
	Borderlayout blyConsultarMicro;
	
	Tabbox fichaContenidos;
	
	Panel panelSemestre;
	Panel panelBuscarMicro;
	
	Combobox cmbSemestre2;
	Combobox cmbDocente;
	Combobox cmbSemestre;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbMateria;
	
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
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtResumenMicro;
	Textbox txtObjetivoEspecifico;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	Toolbarbutton tool_save;
	Toolbarbutton tool_print;
	Toolbarbutton tool_duplica_otro;
	Toolbarbutton tool_consulta_otro;
	
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

	/**
	 * Listados para destionar los datos del nuevo microcurriculo a duplicar, dejandolos listos para el
	 * guardado en la base de datos
	 */
	
	List<TbMicObjetivo> objetivosGuardar = new ArrayList<TbMicObjetivo>();
	List<TbMicUnidad> unidadesGuardar = new ArrayList<TbMicUnidad>();
	List<TbMicTemaxunidad> temasxUnidadGuardar = new ArrayList<TbMicTemaxunidad>();
	List<TbMicTema> temasGuardar = new ArrayList<TbMicTema>();
	List<TbMicSubtemaxtema> subtemasxTemaGuardar = new ArrayList<TbMicSubtemaxtema>();
	List<TbMicSubtema> subtemasGuardar = new ArrayList<TbMicSubtema>();
	List<TbMicEvaluacion> evaluacionesGuardar = new ArrayList<TbMicEvaluacion>();
	List<TbMicBiblioxunidad> bibliosxUnidadGuardar = new ArrayList<TbMicBiblioxunidad>();
	List<TbMicBibliografia> bibliosGuardar = new ArrayList<TbMicBibliografia>();
	
	/**
	 * Solicita de la capa del negocio todos los semestres disponibles para ese tipo de microcurriculos
	 * se tiene en cuanta la materia asociada para saber en que semestres no se ha registrado y se llenan
	 * en el combobox cmbSemestre
	 * @param idMicrocurriculo cadena de caracteres con identificacion del microcurriculo
	 */
	public void cargarSemestres(String idMicrocurriculo){
		TbMicMicrocurriculo microcurriculo = null;
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria();
		
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
		}
		
		List<TbAdmSemestre> semestres = null;
		try {
			semestres = semestreNGC.listarSemestres();
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listarSemestres de la clase SemestreNGC "+e);
		}
		
		cmbSemestre2.getItems().clear();
		cmbSemestre2.appendChild(new Comboitem("[Seleccione]"));
		
		if(semestres != null){
			for(TbAdmSemestre semestre: semestres){
				
				/**
				 * se verifica en los microcurriculos asociado a la materia si el semestre ya fue registrado
				 */
				
				boolean semestreOcupado = false;
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microRecorer: listaMicrocurriculos){
						if(idMateria.equals(microRecorer.getTbAdmMateria().getVrIdmateria())&&(semestre.getVrIdsemestre().equals(microRecorer.getTbAdmSemestre().getVrIdsemestre()))){
							semestreOcupado = true;
						}
					}
				}
				
				/**
				 * se verifica si el semestre no esta ocupado para agregarlo al combobox cmbSemestre
				 */
				
				if(!semestreOcupado){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre2.appendChild(item);
				}
			}
		}
		cmbSemestre2.setValue("[Seleccione]");
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.obtenerDocentes();
			cmbDocente.getItems().clear();
			cmbDocente.appendChild(new Comboitem("[Seleccione]"));
			if (listaDocentes != null){
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					item.setDescription(docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
			cmbDocente.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listaDocentes de la clase PersonaNGC "+e);
		}
	}
	
	/**
	 * El Metodo gestiona el llenado de datos a duplicar en el nuevo microcurriculo
	 * @param idMicro cadena de caracteres con identificacion de microcurriculo
	 * @param idSemestre cadena de caracteres con identificacion de semestre
	 */
	public void llenarDatos(String idMicro, String idSemestre){
		
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!idMicro.equals("") && (!idMicro.equals(null))){
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
			}
			
			/**
			 * Verifica que el microcurriculo retornado no es nulo o si no reinicia busqueda para seleccionar nuevo
			 * microcurriculo a duplicar
			 */
			
			if(microcurriculo!= null){
				if(microcurriculo.getTbMicEstado().getNbIdestado() == 6){
					llenarDatosDependencias(microcurriculo);
					llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
					llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
					llenarDatosMateria(microcurriculo.getTbAdmMateria());
					llenarDatosComplementarios(microcurriculo);
					llenarUnidadesTemasBiblios(microcurriculo.getVrIdmicrocurriculo());
					cmbSemestre.setValue(idSemestre);
					cmbSemestre.setDisabled(true);
					lblIdMicrocurriculo.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria()+"-"+idSemestre);
					
				}else{
					ReiniciarBusqueda();
				}
			}else{
				ReiniciarBusqueda();
			}
		}
	}
	
	/**
	 * El Metodo gestiona el llenado de datos a consultar y son mostrados en la vista
	 * @param idMicro cadena de caracteres con identificacion de microcurriculo
	 */
	public void llenarDatos(String idMicro){
		
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!idMicro.equals("") && (!idMicro.equals(null))){
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
			}
			
			/**
			 * Verifica que el microcurriculo retornado no es nulo o si no reinicia busqueda para seleccionar nuevo
			 * microcurriculo a consultar
			 */
			
			if(microcurriculo!= null){
				llenarDatosDependencias(microcurriculo);
				llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarDatosMateria(microcurriculo.getTbAdmMateria());
				llenarDatosComplementarios(microcurriculo);
				llenarUnidadesTemasBiblios(microcurriculo.getVrIdmicrocurriculo());
				llenarEvaluaciones(microcurriculo.getVrIdmicrocurriculo());
				cmbSemestre.setValue(microcurriculo.getTbAdmSemestre().getVrIdsemestre());
				cmbSemestre.setDisabled(true);
				lblIdMicrocurriculo.setValue(microcurriculo.getVrIdmicrocurriculo());
				
				/**
				 * Ocultando campos de la vista consultar y poniendolos en modo label
				 */
				
				cmbDocente.setValue(microcurriculo.getTbAdmPersona().getVrIdpersona());
				cmbDocente.setDisabled(true);
				lblNombreDocente.setValue(microcurriculo.getTbAdmPersona().getVrNombres()+" "+microcurriculo.getTbAdmPersona().getVrApellidos());
				txtResumenMicro.setVisible(false);
				txtJustificacionMicro.setVisible(false);
				txtObjetivoGeneral.setVisible(false);
				txtPropositoMicro.setVisible(false);
				lblResumenMicro.setValue(microcurriculo.getVrResumen());
				lblJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
				lblPropositoMicro.setValue(microcurriculo.getVrProposito());
				
				
			}else{
				ReiniciarBusqueda2();
			}
		}
	}
	
	/**
	 * Para la vista duplicar, reinicia la busqueda de nuevo microcurriculo y semestre a duplicar
	 */
	public void ReiniciarBusqueda(){
		panelDuplicarMicro.setVisible(true);
		blyDuplicarMicro.setVisible(false);
		tool_print.setVisible(false);
		tool_save.setVisible(false);
		/**
		 * Remueve variables de sesion si existen
		 */
		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
		if(Executions.getCurrent().getSession().hasAttribute("semestre")){
			Executions.getCurrent().getSession().removeAttribute("semestre");
		}
	}
	
	/**
	 * Para la vista consultar, reinicia la busqueda del nuevo microcurriculo a consultar
	 */
	public void ReiniciarBusqueda2(){
		panelBuscarMicro.setVisible(true);
		blyConsultarMicro.setVisible(true);
		fichaContenidos.setVisible(false);
		tool_print.setVisible(false);
		tool_consulta_otro.setVisible(false);
		/**
		 * Remueve variables de sesion si existen
		 */
		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
		if(Executions.getCurrent().getSession().hasAttribute("semestre")){
			Executions.getCurrent().getSession().removeAttribute("semestre");
		}
	}
	
	/**
	 * Permite mostrar en la vista los datos asociados a las dependencias del microcurriculo y son controladas
	 * para evitar errores del usuario
	 * @param microcurriculo objeto con parametros definidos para microcurriculo
	 */
	public void llenarDatosDependencias(TbMicMicrocurriculo microcurriculo){
		
		cmbUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad());
		cmbUnidadAcademica.setDisabled(true);
		lblNombreUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
		cmbDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia());
		cmbDependencia.setDisabled(true);
		lblNombreDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
		cmbNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrIdnucleo());
		cmbNucleo.setDisabled(true);
		lblNombreNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
		cmbMateria.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria());
		cmbMateria.setDisabled(true);
		lblNombreMateria.setValue(microcurriculo.getTbAdmMateria().getVrNombre());
		
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
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listarCorrequisitosxMateria de la clase CorrequisitoNGC "+e);
		}
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera = true;
		for(TbAdmCorrequisito correquisito: correquisitos){
			if(bandera){
				listaCorrequisitos = correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre();
				bandera = false;
			}else{
				listaCorrequisitos = listaCorrequisitos + "\n"+(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
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
		} catch (ExcepcionesDAO e) {
			logger.error("problemas al invocar metodo listarPrerrequisitosxMateria de la clase PrerrequisitoNGC "+e);
		}
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera2 = true;
		for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
			if(bandera2){
				listaPrerrequisitos = prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre();
				bandera2 = false;
			}else{
				listaPrerrequisitos = listaPrerrequisitos + "\n"+(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
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
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo obtenerObjetivosxMicroxMicro de la clase ObjetivoxMicroNGC "+e);
		}
		
		for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
			if(objetivoxMicro.getBlTipo()=='1'){
				txtObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				if(lblObjetivoGeneral != null){
					lblObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				}
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
				
				objetivosGuardar.add(objetivoxMicro.getTbMicObjetivo());
			}
		}
	}
	
	/**
	 * 
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
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
			final Listitem item = new Listitem();
			item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(item,"");
				}
			});
			
			Listcell celda1 = new Listcell("");
			item.appendChild(celda1);
			Listcell celda2 = new Listcell(unidadxMicro.getTbMicUnidad().getVrNombre());
			item.appendChild(celda2);
			listaUnidades.appendChild(item);
			
			unidadesGuardar.add(unidadxMicro.getTbMicUnidad());
			
			List<TbMicTemaxunidad> temasxUnidad = null;
			try {
				temasxUnidad = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
			} catch (ExcepcionesLogica e) {
				logger.error(e);
			}
			if(temasxUnidad != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidad){
					Listitem itemTemas = new Listitem();
					
					Listcell celdaTemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
					itemTemas.appendChild(celdaTemas1);
					Listcell celdaTemas2 = new Listcell(temaxUnidad.getTbMicTema().getVrDescripcion());
					itemTemas.appendChild(celdaTemas2);
					Listcell celdaTemas3 = new Listcell(Integer.toString(temaxUnidad.getNbSemanasRequeridas()));
					itemTemas.appendChild(celdaTemas3);
					listaTemas.appendChild(itemTemas);
					
					temasGuardar.add(temaxUnidad.getTbMicTema());
					temasxUnidadGuardar.add(temaxUnidad);
					
					List<TbMicSubtemaxtema> subtemasxTema = null;
					try {
						subtemasxTema = subtemaxTemaNGC.listarSubtemaxTema_Tema(temaxUnidad.getTbMicTema().getNbIdtema());
					} catch (ExcepcionesLogica e) {
						logger.error(e);
					}
					if(subtemasxTema != null){
						for(TbMicSubtemaxtema subtemaxTema: subtemasxTema){
							Listitem itemSubTemas = new Listitem();
							
							Listcell celdaSubTemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
							itemSubTemas.appendChild(celdaSubTemas1);
							Listcell celdaSubTemas2 = new Listcell(subtemaxTema.getTbMicTema().getVrDescripcion());
							itemSubTemas.appendChild(celdaSubTemas2);
							Listcell celdaSubTemas3 = new Listcell(subtemaxTema.getTbMicSubtema().getVrDescripcion());
							itemSubTemas.appendChild(celdaSubTemas3);
							listaSubtemas.appendChild(itemSubTemas);
							
							subtemasGuardar.add(subtemaxTema.getTbMicSubtema());
							subtemasxTemaGuardar.add(subtemaxTema);
						}
					}
				}
			}
			
			List<TbMicBiblioxunidad> bibliosxUnidad = null;
			try {
				bibliosxUnidad = biblioxUnidadNGC.listadoBiblioxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
			} catch (ExcepcionesLogica e) {
				logger.error(e);
			}
			
			if(bibliosxUnidad!=null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidad){
					if(biblioxUnidad.getTbMicBibliografia().getVrSitioweb() == null){
						Listitem itemBiblio = new Listitem();
						
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
						
						bibliosGuardar.add(biblioxUnidad.getTbMicBibliografia());
						bibliosxUnidadGuardar.add(biblioxUnidad);
					}else{
						Listitem itemBiblio = new Listitem();
						
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
						
						bibliosGuardar.add(biblioxUnidad.getTbMicBibliografia());
						bibliosxUnidadGuardar.add(biblioxUnidad);
					}
				}
			}
		}
		
	}
	
	/**
	 * El metodo procede a llenar las evaluaciones encontradas del microcurriculo
	 * @param idMicrocurriculo cadena de caracteres con identificacion del microcurriculo
	 */
	public void llenarEvaluaciones(String idMicrocurriculo){
		List<TbMicEvaluacionxmicro> evaluacionesxMicro = null;
		try {
			evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		for(TbMicEvaluacionxmicro evaluacionxmicro: evaluacionesxMicro){
			Listitem item = new Listitem();
			
			Listcell celda1 = new Listcell(evaluacionxmicro.getTbMicEvaluacion().getVrDescripcion());
			item.appendChild(celda1);
			Listcell celda2 = new Listcell(Integer.toString(evaluacionxmicro.getNbPorcentaje()));
			item.appendChild(celda2);
			Listcell celda3 = new Listcell(evaluacionxmicro.getDtFechaestimada().toString());
			item.appendChild(celda3);
			listaEvaluaciones.appendChild(item);
			
			evaluacionesGuardar.add(evaluacionxmicro.getTbMicEvaluacion());
		}
	}
	
//	public void llenarComplementaria(TbMicMicrocurriculo microcurriculo){
//		
//		txtJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
//		txtPropositoMicro.setValue(microcurriculo.getVrProposito());
//		txtResumenMicro.setValue(microcurriculo.getVrResumen());
//		
//		List<TbMicObjetivoxmicro> objetivosxMicro = null;
//		try {
//			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(microcurriculo.getVrIdmicrocurriculo());
//		} catch (ExcepcionesLogica e) {
//			logger.error(e);
//		}
//		if(objetivosxMicro != null){
//			for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
//				if(objetivoxMicro.getBlTipo()=='1'){
//					txtObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
//				}else{
//					final Listitem listaItem = new Listitem();
//					listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
//						@Override
//						public void onEvent(Event arg0) throws Exception {
//							eliminaListItem(listaItem,"");
//						}
//					});
//					Listcell celda = new Listcell(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
//					listaItem.appendChild(celda);			
//					listaObjetivosEspecificos.appendChild(listaItem);
//				}
//			}
//		}
//	}
	
	private void eliminaListItem(Listitem item, String clave){		
		if(item.getParent().getId().toString().equals("listaUnidades")){
			eliminaCascadaUnidad(item, clave.toUpperCase());
			//quitarUnidad(item);
			item.detach();
			//recargarCombosUnidades(listaUnidades);
		} else if (item.getParent().getId().toString().equals("listaTemas")){
			eliminaCascadaTema(item, clave.toUpperCase());
			item.detach();
			//recargarCombosTemas(listaTemas);
		} else if(item.getParent().getId().toString().equals("listaSubtemas")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaEvaluaciones")){
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			//porcentajeEvaluacion = porcentajeEvaluacion - Integer.parseInt(celdaPorcentaje.getValue().toString());
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaBibliografia")){
			//quitarBibliografia(item);
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaCibergrafia")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaObjetivosEspecificos")){
			//quitarObjetivo(item);
			item.detach();
		}
	}
	
//	public void quitarBibliografia(Listitem item){
//		
//	}
//	
//	public void quitarUnidad(Listitem item){
//		Listcell celda = (Listcell) item.getChildren().get(1);
//		String nombreUnidad = celda.getLabel();
//		
//		TbMicUnidad unidadBorrar = null;
//		for(TbMicUnidad unidad: unidadesGuardar){
//			if(unidad.getVrNombre().equals(nombreUnidad)){
//				unidadBorrar = unidad;
//			}
//		}
//		quitarCascadaTemas(unidadBorrar.getNbIdunidad());
//		if(unidadBorrar != null){
//			unidadesGuardar.remove(unidadBorrar);
//		}
//		for(TbMicUnidad unidad: unidadesGuardar){
//			System.out.println(unidad.getVrNombre());
//		}
//	}
//	
//	public void quitarCascadaTemas(int idUnidad){
//		boolean seguirBorrando = true;
//		while(seguirBorrando){
//			seguirBorrando = false;
//			TbMicTemaxunidad temaxUnidadBorrar = null;
//			for(TbMicTemaxunidad temaxUnidad: temasxUnidadGuardar){
//				if(temaxUnidad.getTbMicUnidad().getNbIdunidad() == idUnidad){
//					temaxUnidadBorrar = temaxUnidad;
//					seguirBorrando = true;
//				}
//			}
//			if(temaxUnidadBorrar != null){
//				temasxUnidadGuardar.remove(temaxUnidadBorrar);
//			}
//			for(TbMicTemaxunidad temaxUnidad: temasxUnidadGuardar){
//				System.out.println(temaxUnidad.getNbId());
//			}
//			if(temaxUnidadBorrar != null){
//				TbMicTema temaBorrar = null;
//				for(TbMicTema tema: temasGuardar){
//					if(tema.getNbIdtema() == temaxUnidadBorrar.getTbMicTema().getNbIdtema()){
//						temaBorrar = tema;
//						seguirBorrando = true;
//					}
//				}
//				if(temaBorrar != null){
//					temasGuardar.remove(temaBorrar);
//				}
//				quitarCascadaSubtemas(temaxUnidadBorrar.getTbMicTema().getNbIdtema());
//			}
//			for(TbMicTema tema: temasGuardar){
//				System.out.println(tema.getVrDescripcion());
//			}
//		}
//	}
//	
//	public void quitarCascadaSubtemas(int idTema){
//		boolean seguirBorrando = true;
//		while(seguirBorrando){
//			seguirBorrando = false;
//			TbMicSubtemaxtema subtemaxtemaBorrar = null;
//			for(TbMicSubtemaxtema subtemaxTema: subtemasxTemaGuardar){
//				if(subtemaxTema.getTbMicTema().getNbIdtema() == idTema){
//					subtemaxtemaBorrar = subtemaxTema;
//					seguirBorrando = true;
//				}
//			}
//			if(subtemaxtemaBorrar != null){
//				subtemasxTemaGuardar.remove(subtemaxtemaBorrar);
//			}
//			for(TbMicSubtemaxtema subtemaxTema: subtemasxTemaGuardar){
//				System.out.println(subtemaxTema.getNbid());
//			}
//			if(subtemaxtemaBorrar != null){
//				TbMicSubtema subtemaBorrar = null;
//				for(TbMicSubtema subtema: subtemasGuardar){
//					if(subtema.getNbIdsubtema() == subtemaxtemaBorrar.getTbMicSubtema().getNbIdsubtema()){
//						subtemaBorrar = subtema;
//						seguirBorrando = true;
//					}
//				}
//				if(subtemaBorrar != null){
//					subtemasGuardar.remove(subtemaBorrar);
//				}
//			}
//			for(TbMicSubtema subtema: subtemasGuardar){
//				System.out.println(subtema.getVrDescripcion());
//			}
//		}
//	}
//	
//	public void quitarObjetivo(Listitem item){
//		Listcell celda = (Listcell) item.getChildren().get(0);
//		String nombreObjetivo = celda.getLabel();
//		
//		TbMicObjetivo objetivoBorrar = null;
//		for(TbMicObjetivo objetivo: objetivosGuardar){
//			if(objetivo.getVrDescripcion().equals(nombreObjetivo)){
//				objetivoBorrar = objetivo;
//			}
//		}
//		
//		if(objetivoBorrar != null){
//			objetivosGuardar.remove(objetivoBorrar);
//		}
////		for(TbMicObjetivo objetivo: objetivosGuardar){
////			System.out.println(objetivo.getVrDescripcion());
////		}
//	}
	
	private void eliminaCascadaTema(Listitem item, String clave){
		Listcell celda = (Listcell)item.getChildren().get(1);
		clave = celda.getLabel();
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
	
//	private void recargarCombosTemas(Listbox lista){
//		cmbListaTemas.getItems().clear();
//		
//		if(lista.getItems().size() > 0){
//			for(int i=1; i<= lista.getItemCount(); i++){
//				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
//				Listcell celda = (Listcell)listaItem.getChildren().get(0);
//				Comboitem item = new Comboitem(celda.getLabel());
//				cmbListaTemas.appendChild(item);
//			}
//		}
//	}
	
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
	
//	private void recargarCombosUnidades(Listbox lista){
//		cmbIdUnidad.getItems().clear();
//		cmbListaUnidades.getItems().clear();
//		cmbListaUnidadBiblio.getItems().clear();
//		cmbListaTemas.getItems().clear();
//
//		if (lista.getItems().size() > 0){
//			for (int i=1; i <= lista.getItems().size(); i++ ){
//				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
//				Listcell celda = (Listcell)listaItem.getChildren().get(1);
//
//				Comboitem itemUnidadTema = new Comboitem(celda.getLabel());
//				cmbIdUnidad.appendChild(itemUnidadTema);
//				Comboitem item2 = new Comboitem(celda.getLabel());
//				cmbListaUnidades.appendChild(item2); 
//				Comboitem item3 = new Comboitem(celda.getLabel());
//				cmbListaUnidadBiblio.appendChild(item3);
//			}	
//		}
//			
//	}
	
	public void onSelect$cmbSemestre2(){
		String semestreDuplicar = cmbSemestre2.getValue().toString();
		if(!semestreDuplicar.equals("[Seleccione]")&&(!semestreDuplicar.equals(""))){
//			session.setAttribute("semestre", semestreDuplicar);
			Executions.getCurrent().getSession().setAttribute("semestre", semestreDuplicar);
		}else{
			if(Executions.getCurrent().getSession().hasAttribute("semestre")){
//				session.removeAttribute("semestre");
				Executions.getCurrent().getSession().removeAttribute("semestre");
			}
		}
	}
	
	public void onClick$tool_duplica_otro(){
		ReiniciarBusqueda();
	}
	
	public void onClick$tool_consulta_otro(){
		ReiniciarBusqueda2();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if("formaDuplicarMicro".equals(comp.getParent().getId().toString())){
			
			if(Executions.getCurrent().getSession().hasAttribute("idMicro")&&(Executions.getCurrent().getSession().hasAttribute("semestre"))){
				panelDuplicarMicro.setVisible(false);
				blyDuplicarMicro.setVisible(true);
				panelSemestre.setVisible(false);
				fichaContenidos.setVisible(true);
				cargarDocentes();
				
				String idMicrocurriculo = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
				String idSemestre = Executions.getCurrent().getSession().getAttribute("semestre").toString();
				llenarDatos(idMicrocurriculo, idSemestre);
				
			}else if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
				panelDuplicarMicro.setVisible(false);
				blyDuplicarMicro.setVisible(true);
				panelSemestre.setVisible(true);
				fichaContenidos.setVisible(false);
				String idMicrocurriculo = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
				cargarSemestres(idMicrocurriculo);
				tool_print.setVisible(false);
				tool_save.setVisible(false);
			}else{
				panelDuplicarMicro.setVisible(true);
				blyDuplicarMicro.setVisible(false);
				tool_print.setVisible(false);
				tool_save.setVisible(false);
			}
		}else if("formaDetallesMicro".equals(comp.getParent().getId().toString())){
			if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
				panelBuscarMicro.setVisible(false);
				blyConsultarMicro.setVisible(true);
				fichaContenidos.setVisible(true);
				if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
					String idMicro = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
					llenarDatos(idMicro);
				}
			}else{
				panelBuscarMicro.setVisible(true);
				blyConsultarMicro.setVisible(true);
				fichaContenidos.setVisible(false);
				tool_print.setVisible(false);
				tool_consulta_otro.setVisible(false);
			}
		}
		
	}
}


