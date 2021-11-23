package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.healthtrack.model.Usuario;

public class UsuarioDAO {

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

}