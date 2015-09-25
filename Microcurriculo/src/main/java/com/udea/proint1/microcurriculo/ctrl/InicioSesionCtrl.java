package com.udea.proint1.microcurriculo.ctrl;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.RolxUsuarioNGC;
import com.udea.proint1.microcurriculo.ngc.UsuarioNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings({ "rawtypes", "serial" })
public class InicioSesionCtrl extends GenericForwardComposer {
	
	/**
	 * Logger de registro de incidencias en la aplicación
	 */
	private static Logger logger = Logger.getLogger(InicioSesionCtrl.class);
	
	/*
	 * Objeto de la Clase que Invoca
	 */
	Textbox txtNombreUsuario;
	Textbox txtPassword;
	Button btnAceptar;
	Button btnOlvido;
	
	UsuarioNGC usuarioNGC;
	PersonaNGC personaNGC;
	RolxUsuarioNGC rolxUsuarioNGC;
	
	TbAdmUsuario usuario;
	TbAdmPersona persona;
	TbAdmRolxUsuario rolxUsuario;
	
	public void setUsuarioNGC(UsuarioNGC usuarioNGC) {
		this.usuarioNGC = usuarioNGC;
	}
		
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setRolxUsuarioNGC(RolxUsuarioNGC rolxUsuarioNGC) {
		this.rolxUsuarioNGC = rolxUsuarioNGC;
	}

	
	private void verificarCredenciales(String login, String password){
		try {
			usuario = usuarioNGC.obtenerUsuarios(login);
		}catch(ExcepcionesDAO expDAO){
			Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expDAO.getMsjTecnico());
		}catch(ExcepcionesLogica expNgs){
			Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(expNgs.getMsjTecnico());
		}catch(Exception exp){
			Messagebox.show("Error validando usuario.","ERROR", Messagebox.OK,Messagebox.ERROR);
			logger.error(exp);
		}
		
		if(usuario != null){
			if(usuario.getVrPassword().equals(password)){				
				try {
					rolxUsuario = rolxUsuarioNGC.obtenerRolxUsuario(usuario);
				}catch(ExcepcionesDAO expDAO){
					Messagebox.show(expDAO.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expDAO.getMsjTecnico());
				}catch(ExcepcionesLogica expNgs){
					Messagebox.show(expNgs.getMsjUsuario(),"ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(expNgs.getMsjTecnico());
				}catch(Exception exp){
					Messagebox.show("Error validando usuario.","ERROR", Messagebox.OK,Messagebox.ERROR);
					logger.error(exp);
				}
				
//				persona = usuario.getTbAdmPersona();
				if (rolxUsuario != null){
					int rol = rolxUsuario.getTbAdmRol().getNbId();
					
					switch (rol) {
						case 1: 	//Rol SUPERUSUARIO
							break;
						case 2:		// Rol ADMINISTRADOR
//							Executions.getCurrent().getSession().setAttribute("userName", usuario.getVrLogin());
							Executions.getCurrent().getSession().setAttribute("rolxUsuario", rolxUsuario);
							Executions.getCurrent().sendRedirect("./_ambientes/_admin/inicioAdmin.zul");
							break;
						case 3:		// Rol COORDINADOR
//							Executions.getCurrent().getSession().setAttribute("userName", usuario.getVrLogin());
							Executions.getCurrent().getSession().setAttribute("rolxUsuario", rolxUsuario);					
							Executions.getCurrent().sendRedirect("./_ambientes/_docente/inicioDocente.zul");
							break;
						case 4:		// Rol DOCENTE
//							Executions.getCurrent().getSession().setAttribute("userName", usuario.getVrLogin());
//							Executions.getCurrent().getSession().setAttribute("rolxUsuarioLogin", rolxUsuario);
							Executions.getCurrent().getSession().setAttribute("rolxUsuario", rolxUsuario);
							Executions.getCurrent().sendRedirect("./_ambientes/_docente/inicioDocente.zul");
							break;
						case 5:		// Rol Docente
							break;
						case 6:		// Rol Invitado
//							Executions.getCurrent().getSession().setAttribute("userName", usuario.getVrLogin());
//							Executions.getCurrent().getSession().setAttribute("rolxUsuarioLogin", rolxUsuario);					
//							Executions.getCurrent().sendRedirect("./_ambientes/_docente/inicioDocente.zul");
							break;
						default:
							Messagebox.show("No autorizado para ingresar.","NO AUTORIZADO",Messagebox.OK,Messagebox.ERROR);
							break;
					}
				}				
			}else{
				Messagebox.show("Usuario o Contraseña Incorrectos.","NO AUTORIZADO",Messagebox.OK,Messagebox.ERROR);
			}
		}else{
			Messagebox.show("Usuario o Contraseña Incorrectos.","NO AUTORIZADO",Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	public void onOK$txtPassword(){
		if(!"".equals(txtNombreUsuario.getValue())){
			verificarCredenciales(txtNombreUsuario.getValue().toString(), txtPassword.getValue().toString());
		} else {
			Messagebox.show("El Usuario no puede ser vacio.","INCOMPLETO",Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	public void onOK$txtNombreUsuario(){
		if(!"".equals(txtNombreUsuario.getValue())){
			txtPassword.setFocus(true);
		} else {
			Messagebox.show("El Usuario no puede ser vacio.","INCOMPLETO",Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	public void onClick$btnAceptar(){
		if(!"".equals(txtNombreUsuario.getValue())){
			verificarCredenciales(txtNombreUsuario.getValue().toString(), txtPassword.getValue().toString());
		} else {
			Messagebox.show("El Usuario no puede ser vacio.","INCOMPLETO",Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		txtNombreUsuario.setFocus(true);
	}
}
