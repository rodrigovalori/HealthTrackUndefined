package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.healthtrack.model.Alimento;
import br.com.fiap.healthtrack.model.AtividadeFisica;
import br.com.fiap.healthtrack.model.Peso;
import br.com.fiap.healthtrack.model.PressaoArterial;
import br.com.fiap.healthtrack.model.Usuario;

public class UsuarioDAO implements IDataHandler<Usuario> {

	@Override
	public int add(Usuario usuario) {

		DAO dao = new DAO();

		try {
			Connection conexao = dao.getConnection();
			System.out.println("conn: " + conexao);
			PreparedStatement stmt = conexao.prepareStatement(
					"INSERT INTO T_USUARIO(CD_USUARIO, NM_USUARIO, DT_NASCIMENTO, DS_EMAIL, DS_SENHA) VALUES (CD_USUARIO.NEXTVAL, ?, ?, ?, ?)");
			stmt.setString(1, usuario.getNome());
			java.sql.Date dataNascimento = new java.sql.Date(usuario.getDataNascimento().getTimeInMillis());
			System.out.println("teste: " + dataNascimento);
			stmt.setDate(2, dataNascimento);
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(AtividadeFisica obj, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Alimento obj, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Peso obj, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(PressaoArterial obj, int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario getIdByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}