package br.com.fiap.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.model.Alimento;

public class AlimentoDAO {

	public List<Alimento> getAll() {

		DAO dao = new DAO();
		List<Alimento> listaAlimento = new ArrayList<Alimento>();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_ALIMENTO");
			ResultSet result = null;
			result = dao.getData(stmt);

			while (result.next()) {
				String nomeAlimento = result.getString("NM_ALIMENTO");
				int codAlimento = result.getInt("CD_ALIMENTO");
				java.sql.Date date = result.getDate("DT_ALIMENTO");
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar ca = Calendar.getInstance();
				ca.setTimeInMillis(date.getTime());
				String dataHoraAlimento = df.format(date.getTime());
				Double energiaKcalAlimento = result.getDouble("NR_KCAL");
				Double quantidadeAlimento = result.getDouble("NR_GRAMAS");

				Alimento alimento = new Alimento(codAlimento, dataHoraAlimento, nomeAlimento, energiaKcalAlimento,
						quantidadeAlimento);
				listaAlimento.add(alimento);

			}
			dao.closeConnectionGetAll();
			return listaAlimento;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int add(Alimento obj) {

		DAO dao = new DAO();

		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"INSERT INTO T_ALIMENTO(CD_ALIMENTO, DT_ALIMENTO, NM_ALIMENTO, NR_KCAL, NR_GRAMAS, CD_USUARIO) VALUES (CD_ALIMENTO.NEXTVAL,?,?,?,?,?)");
			stmt.setDate(1, data);
			stmt.setString(2, obj.getNomeAlimento());
			stmt.setDouble(3, obj.getEnergiaKcalAlimento());
			stmt.setDouble(4, obj.getQuantidadeAlimento());
			stmt.setInt(5, 1);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Alimento getById(int id) {

		DAO dao = new DAO();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_ALIMENTO WHERE CD_ALIMENTO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);

			String nomeAlimento = result.getString("NM_ALIMENTO");
			int codAlimento = result.getInt("CD_ALIMENTO");

			java.sql.Date date = result.getDate("DT_ALIMENTO");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Calendar ca = Calendar.getInstance();
			ca.setTimeInMillis(date.getTime());
			String dataHoraAlimento = df.format(date.getTime());

			Double energiaKcalAlimento = result.getDouble("NR_KCAL");
			Double quantidadeAlimento = result.getDouble("NR_GRAMAS");

			Alimento alimento = new Alimento(codAlimento, nomeAlimento, dataHoraAlimento, energiaKcalAlimento,
					quantidadeAlimento);
			return alimento;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int delete(int id) {

		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection()
					.prepareStatement("DELETE FROM T_ALIMENTO WHERE CD_ALIMENTO = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Alimento obj) {

		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"UPDATE T_ALIMENTO SET CD_ALIMENTO = ?, DT_ALIMENTO = ?, NM_ALIMENTO = ?, NR_KCAL = ?, NR_GRAMAS = ?, CD_USUARIO = ? WHERE CD_ALIMENTO = ?");
			stmt.setInt(1, obj.getCodAlimento());
			java.sql.Date dataHora = new java.sql.Date(obj.getDataHoraAlimento().getTimeInMillis());
			stmt.setDate(2, dataHora);
			stmt.setString(3, obj.getNomeAlimento());
			stmt.setDouble(4, obj.getEnergiaKcalAlimento());
			stmt.setDouble(5, obj.getQuantidadeAlimento());
			stmt.setInt(6, 1);
			stmt.setInt(7, obj.getCodAlimento());

			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
