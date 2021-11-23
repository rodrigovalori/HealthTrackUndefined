package br.com.fiap.healthtrack.business.usuario;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.dao.UsuarioDAO;
import br.com.fiap.healthtrack.model.Usuario;

public class UsuarioBusiness {

	public void cadastrar(Usuario u) {
		UsuarioDAO udao = new UsuarioDAO();
		udao.add(u);
	}

	public List<Usuario> listarTodos() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		UsuarioDAO udao = new UsuarioDAO();
		listaUsuarios = udao.getAll();

		return listaUsuarios;
	}

	public Usuario pesquisarPorId(int codigo) {

		Usuario Usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		Usuario = udao.getById(codigo);

		return Usuario;
	}
	
	public Usuario pesquisarIdPorEmail(String email) {

		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		usuario = udao.getIdByEmail(email);

		return usuario;
	}

	public void editar(Usuario u) {

		UsuarioDAO udao = new UsuarioDAO();
		udao.update(u);
	}

	public void excluir(int codigo) {

		UsuarioDAO udao = new UsuarioDAO();
		udao.delete(codigo);
	}

	public Usuario validarEmailESenha(String email, String senha) {
		Boolean loginPermitido = false;
		Usuario usuario = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		usuario = udao.getIdByEmailAndPassword(email, senha);
		System.out.println("BUSCA: " + usuario);
		
		return usuario;
	}

}
