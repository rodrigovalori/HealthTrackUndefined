package br.com.fiap.healthtrack.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection connection;

	public DAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		openConnection();
		System.out.println("Conectado com sucesso: " + this.connection);
		return this.connection;
	}

	// Respons�vel por abrir a conex�o
	private void openConnection() {

		try {
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM87129",
					"060899");
			System.out.println("AA: " + this.connection );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {

		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Executa comandos SQL (insert, update, delete)
	public int executeCommand(PreparedStatement stmt) {

		int j = 0;

		try {
			j = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return j;
	}

	public ResultSet getData(PreparedStatement stmt) {

		ResultSet resultSet = null;

		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultSet;
	}

	public void closeConnectionGetAll() {
		closeConnection();
	}

}
