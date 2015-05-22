package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.RolxUsuarioDAO;
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
			
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally {
			session.close();
		}
		
		return rolxUsuario;
	}

	@Override
	public List<TbAdmRolxUsuario> listarRolxPersona() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
