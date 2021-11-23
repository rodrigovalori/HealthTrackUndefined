package br.com.fiap.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.healthtrack.model.AtividadeFisica;

public class AtividadeFisicaDAO {

	public List<AtividadeFisica> getAll() {

		DAO dao = new DAO();
		List<AtividadeFisica> listAtividadeFisica = new ArrayList<AtividadeFisica>();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_ATIVIDADE_FISICA");
			ResultSet result = null;
			result = dao.getData(stmt);

			while (result.next()) {
				int codAtividadeFisica = result.getInt("CD_ATIVIDADE_FISICA");
				int energiaKcalAtividadeFisica = result.getInt("NR_GASTO_KCAL");

				java.sql.Date dateInicio = result.getDate("HR_INICIO");
				DateFormat dfInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar caInicio = Calendar.getInstance();
				caInicio.setTimeInMillis(dateInicio.getTime());
				String dataHoraAtividadeFisicaInicio = dfInicio.format(dateInicio.getTime());

				java.sql.Date dateTermino = result.getDate("HR_TERMINO");
				DateFormat dfTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar caTermino = Calendar.getInstance();
				caTermino.setTimeInMillis(dateTermino.getTime());
				String dataHoraAtividadeFisicaTermino = dfTermino.format(dateTermino.getTime());

				String descricaoAtividadeFisica = result.getString("DS_ATIVIDADE_FISICA");

				AtividadeFisica atividadeFisica = new AtividadeFisica(codAtividadeFisica, energiaKcalAtividadeFisica,
						dataHoraAtividadeFisicaInicio, dataHoraAtividadeFisicaTermino, descricaoAtividadeFisica);
				listAtividadeFisica.add(atividadeFisica);
			}
			dao.closeConnectionGetAll();
			return listAtividadeFisica;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int add(AtividadeFisica obj) {

		DAO dao = new DAO();

		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"INSERT INTO T_ATIVIDADE_FISICA(CD_ATIVIDADE_FISICA, NR_GASTO_KCAL, HR_INICIO, HR_TERMINO, DS_ATIVIDADE_FISICA, CD_USUARIO) VALUES (CD_ATIVIDADE_FISICA.NEXTVAL,?,?,?,?,?)");
			stmt.setDouble(1, obj.getEnergiaKcalAtividadeFisica());
			java.sql.Date dataHoraInicio = new java.sql.Date(obj.getDataHoraInicioAtividadeFisica().getTimeInMillis());
			System.out.println("teste: " + dataHoraInicio);
			stmt.setDate(2, dataHoraInicio);

			java.sql.Date dataHoraTermino = new java.sql.Date(
					obj.getDataHoraTerminoAtividadeFisica().getTimeInMillis());
			System.out.println("teste: " + dataHoraTermino);
			stmt.setDate(3, dataHoraTermino);
			stmt.setString(4, obj.getDescricaoAtividadeFisica());
			stmt.setInt(5, 1);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public AtividadeFisica getById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection()
					.prepareStatement("SELECT * FROM T_ATIVIDADE_FISICA WHERE CD_ATIVIDADE_FISICA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			int codAtividadeFisica = result.getInt("CD_ATIVIDADE_FISICA");
			int energiaKcalAtividadeFisica = result.getInt("NR_GASTO_KCAL");

			java.sql.Date dateInicio = result.getDate("HR_INICIO");
			DateFormat dfInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Calendar caInicio = Calendar.getInstance();
			caInicio.setTimeInMillis(dateInicio.getTime());
			String dataHoraAtividadeFisicaInicio = dfInicio.format(dateInicio.getTime());

			java.sql.Date dateTermino = result.getDate("HR_TERMINO");
			DateFormat dfTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Calendar caTermino = Calendar.getInstance();
			caTermino.setTimeInMillis(dateTermino.getTime());
			String dataHoraAtividadeFisicaTermino = dfTermino.format(dateTermino.getTime());

			String descricaoAtividadeFisica = result.getString("DS_ATIVIDADE_FISICA");

			AtividadeFisica atividadeFisica = new AtividadeFisica(codAtividadeFisica, energiaKcalAtividadeFisica,
					dataHoraAtividadeFisicaInicio, dataHoraAtividadeFisicaTermino, descricaoAtividadeFisica);
			return atividadeFisica;

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
					.prepareStatement("DELETE FROM T_ATIVIDADE_FISICA WHERE CD_ATIVIDADE_FISICA = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int update(AtividadeFisica obj) {
		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"UPDATE T_ATIVIDADE_FISICA SET NR_GASTO_KCAL = ?, HR_INICIO = ?, HR_TERMINO = ?, DS_ATIVIDADE_FISICA = ? WHERE CD_ATIVIDADE_FISICA = ?");
			stmt.setDouble(1, obj.getEnergiaKcalAtividadeFisica());
			java.sql.Date dataHoraInicio = new java.sql.Date(obj.getDataHoraInicioAtividadeFisica().getTimeInMillis());
			stmt.setDate(2, dataHoraInicio);
			java.sql.Date dataHoraTermino = new java.sql.Date(obj.getDataHoraInicioAtividadeFisica().getTimeInMillis());
			stmt.setDate(3, dataHoraTermino);
			stmt.setString(4, obj.getDescricaoAtividadeFisica());
			stmt.setInt(5, obj.getCodAtividadeFisica());

			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
