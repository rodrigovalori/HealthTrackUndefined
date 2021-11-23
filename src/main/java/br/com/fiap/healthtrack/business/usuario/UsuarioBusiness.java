package br.com.fiap.healthtrack.business.usuario;

import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.model.Usuario;

public class UsuarioBusiness {

	public void cadastrar(Usuario u) {
		UsuarioDAO udao = new UsuarioDAO();
		udao.add(u);
	}

}