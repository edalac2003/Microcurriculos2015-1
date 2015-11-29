package com.udea.proint1.microcurriculo.dao.hibernate;

//import java.util.ArrayList;
import java.util.List;

//import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
//import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
//import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmRol;
import com.udea.proint1.microcurriculo.dto.TbAdmRolxUsuario;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuario;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class RolxUsuarioDAOHibernate extends HibernateDaoSupport implements RolxUsuarioDAO {

	public RolxUsuarioDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarRolxUsuario() throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmRolxUsuario obtenerRolxUsuario(TbAdmUsuario usuario) throws ExcepcionesDAO {
		TbAdmRolxUsuario rolxUsuario = null;
		Session session = null;
		
		try{
			session = getSession();
        	Query query = session.createQuery("from TbAdmRolxUsuario where tbAdmUsuario = :usuario");
        	query.setEntity("usuario", usuario);
        	rolxUsuario = (TbAdmRolxUsuario) query.list().get(0);
		} catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Rol x Usuario");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
		
		return rolxUsuario;
	}

	@Override
	public List<TbAdmRolxUsuario> obtenerRolxUsuarioxRol(TbAdmRol rol) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmRolxUsuario> usuariosxRol = null;
       
        try{
        	session = getSession();
        	Query query = session.createQuery("from TbAdmRolxUsuario where tbAdmRol = :rol");
        	query.setEntity("rol", rol);
        	usuariosxRol = query.list();
        } catch (Exception e) {
			ExcepcionesDAO expDAO = new ExcepcionesDAO();
			expDAO.setMsjUsuario("Error al intentar obtener Roles x Usuario filtrados por Rol");
			expDAO.setMsjTecnico(e.getMessage());
			expDAO.setOrigen(e);
			
			throw expDAO;
		} finally{
			session.close();
		}
        return usuariosxRol;
	}

}
