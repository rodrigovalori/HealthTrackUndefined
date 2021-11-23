package br.com.fiap.healthtrack.business.pressaoarterial;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.dao.PressaoArterialDAO;
import br.com.fiap.healthtrack.model.PressaoArterial;

public class PressaoArterialBusiness {

	public void cadastrar(PressaoArterial pa) {
		PressaoArterialDAO paDao = new PressaoArterialDAO();
		paDao.add(pa);
	}

	public List<PressaoArterial> listarTodos() {

		List<PressaoArterial> listaPressaoArteriais = new ArrayList<PressaoArterial>();

		PressaoArterialDAO padao = new PressaoArterialDAO();
		listaPressaoArteriais = padao.getAll();

		return listaPressaoArteriais;
	}

	public PressaoArterial pesquisarPorId(int codigo) {

		PressaoArterial pressaoArterial = new PressaoArterial();
		PressaoArterialDAO padao = new PressaoArterialDAO();
		pressaoArterial = padao.getById(codigo);

		return pressaoArterial;
	}

	public void editar(PressaoArterial pa) {

		PressaoArterialDAO padao = new PressaoArterialDAO();
		padao.update(pa);
	}

	public void excluir(int codigo) {

		PressaoArterialDAO padao = new PressaoArterialDAO();
		padao.delete(codigo);
	}

}
