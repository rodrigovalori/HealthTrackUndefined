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
import br.com.fiap.healthtrack.model.AtividadeFisica;
import br.com.fiap.healthtrack.model.Peso;
import br.com.fiap.healthtrack.model.PressaoArterial;
import br.com.fiap.healthtrack.model.Usuario;

public class PressaoArterialDAO implements IDataHandler<PressaoArterial> {

	@Override
	public List<PressaoArterial> getAll() {

		DAO dao = new DAO();
		List<PressaoArterial> listaPressao = new ArrayList<PressaoArterial>();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_PRESSAO_ARTERIAL");
			ResultSet result = null;
			result = dao.getData(stmt);

			while (result.next()) {
				int codMedicao = result.getInt("CD_MEDICAO");
				java.sql.Date date = result.getDate("DT_MEDICAO");
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar ca = Calendar.getInstance();
				ca.setTimeInMillis(date.getTime());
				String dataHoraPressao = df.format(date.getTime());
				int pressaoSistolica = result.getInt("NR_SISTOLICA");
				int pressaoDiastolica = result.getInt("NR_DIASTOLICA");

				PressaoArterial pressaoArterial = new PressaoArterial(codMedicao, dataHoraPressao, pressaoSistolica,
						pressaoDiastolica);
				listaPressao.add(pressaoArterial);
			}
			dao.closeConnectionGetAll();
			return listaPressao;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int add(PressaoArterial obj) {

		DAO dao = new DAO();

		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"INSERT INTO T_PRESSAO_ARTERIAL(CD_MEDICAO, DT_MEDICAO, NR_SISTOLICA, NR_DIASTOLICA, CD_USUARIO) VALUES (CD_MEDICAO.NEXTVAL,?,?,?,?)");
			stmt.setDate(1, data);
			stmt.setInt(2, obj.getPressaoSistolica());
			stmt.setInt(3, obj.getPressaoDiastolica());
			stmt.setInt(4, 1);
			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public PressaoArterial getById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;

		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM T_PRESSAO_ARTERIAL WHERE CD_MEDICAO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.getData(stmt);
			while (result.next()) {
				PressaoArterial pressaoArterial = new PressaoArterial();
				pressaoArterial.setCodMedicao(result.getInt("CD_MEDICAO"));

				java.sql.Date date = result.getDate("DT_MEDICAO");
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Calendar ca = Calendar.getInstance();
				ca.setTimeInMillis(date.getTime());
				String dataHoraMedicao = df.format(date.getTime());

				pressaoArterial.setPressaoSistolica(result.getInt("NR_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(result.getInt("NR_DIASTOLICA"));
				return pressaoArterial;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(int id) {

		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection()
					.prepareStatement("DELETE FROM T_PRESSAO_ARTERIAL WHERE CD_MEDICAO = ?");
			stmt.setInt(1, id);
			return dao.executeCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(PressaoArterial obj) {
		DAO dao = new DAO();

		try {
			PreparedStatement stmt = dao.getConnection().prepareStatement(
					"UPDATE T_PRESSAO_ARTERIAL SET DT_MEDICAO = ?, NR_SISTOLICA = ?, NR_DIASTOLICA = ?, CD_USUARIO = ? WHERE CD_MEDICAO = ?");
			java.sql.Date dataHoraPesagem = new java.sql.Date(obj.getDataMedicao().getTimeInMillis());
			stmt.setDate(1, dataHoraPesagem);
			stmt.setDouble(2, obj.getPressaoSistolica());
			stmt.setInt(3, obj.getPressaoDiastolica());
			stmt.setInt(4, 1);
			stmt.setInt(5, obj.getCodMedicao());

			return dao.executeCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
