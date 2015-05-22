package com.udea.proint1.microcurriculo.ctrl;

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
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class InicioSesionCtrl extends GenericForwardComposer {
	
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

	
	private void verificarCredenciales(String login){
//		try {
//			usuario = usuarioNGC.obtenerUsuarios(login);
//		} catch (ExcepcionesLogica e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		if(usuario != null){
			persona = usuario.getTbAdmPersona();
			int rolUsuario = 4;
			Executions.getCurrent().getSession().setAttribute("userName", usuario.getVrLogin());
			Executions.getCurrent().getSession().setAttribute("nombrePersona", persona.getVrNombres());
			Executions.getCurrent().getSession().setAttribute("apellidoPersona", persona.getVrApellidos());
			if(rolUsuario == 4){
				Executions.getCurrent().sendRedirect("./_ambientes/_docente/inicioDocente.zul");
			}
			
		}else{
			Messagebox.show("Usuario o Contraseña Incorrectos");
		}
	}
	
	public void onClick$btnAceptar(){
		if(!"".equals(txtNombreUsuario.getValue())){
			verificarCredenciales(txtNombreUsuario.getValue().toString().toUpperCase());
		} else {
			Messagebox.show("El Usuario no puede ser vacia.","INCOMPLETO",Messagebox.OK,Messagebox.ERROR);
		}
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
}
