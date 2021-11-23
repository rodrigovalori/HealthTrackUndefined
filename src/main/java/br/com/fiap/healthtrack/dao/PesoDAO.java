package br.com.fiap.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.model.Peso;

public class PesoDAO {

	public List<Peso> getAll() {

		DAO dao = new DAO();
		List<Peso> listaPeso = new ArrayList<Peso>();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_PESO");
			ResultSet result = null;
			result = dao.getData(stmt);

			while (result.next()) {
				int codPesagem = result.getInt("CD_PESAGEM");
				java.sql.Date date = result.getDate("DT_PESAGEM");
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar ca = Calendar.getInstance();
				ca.setTimeInMillis(date.getTime());
				String dataHoraPeso = df.format(date.getTime());
				Double numeroPeso = result.getDouble("NR_PESO");

				Peso peso = new Peso(codPesagem, dataHoraPeso, numeroPeso);
				listaPeso.add(peso);
			}
			dao.closeConnectionGetAll();
			return listaPeso;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int add(Peso obj) {

		DAO dao = new DAO();

		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"INSERT INTO T_PESO(CD_PESAGEM, DT_PESAGEM, NR_PESO, CD_USUARIO) VALUES (CD_PESAGEM.NEXTVAL,?,?,?)");
			stmt.setDate(1, data);
			stmt.setDouble(2, obj.getPeso());
			stmt.setInt(3, 1);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Peso getById(int id) {

		DAO dao = new DAO();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_PESO WHERE CD_PESAGEM = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			while (result.next()) {
				int codPesagem = result.getInt("CD_PESAGEM");

				java.sql.Date date = result.getDate("DT_PESAGEM");
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar ca = Calendar.getInstance();
				ca.setTimeInMillis(date.getTime());
				String dataHoraPesagem = df.format(date.getTime());

				Double numeroPeso = result.getDouble("NR_PESO");

				Peso peso = new Peso(codPesagem, dataHoraPesagem, numeroPeso);

				return peso;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int delete(int id) {
		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement("DELETE FROM T_PESO WHERE CD_PESAGEM = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Peso obj) {
		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"UPDATE T_PESO SET DT_PESAGEM = ?, NR_PESO = ?, CD_USUARIO = ? WHERE CD_PESAGEM = ?");
			java.sql.Date dataHoraPesagem = new java.sql.Date(obj.getDataPesagem().getTimeInMillis());
			stmt.setDate(1, dataHoraPesagem);
			stmt.setDouble(2, obj.getPeso());
			stmt.setInt(3, 1);
			stmt.setInt(4, obj.getCodPesagem());

			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
