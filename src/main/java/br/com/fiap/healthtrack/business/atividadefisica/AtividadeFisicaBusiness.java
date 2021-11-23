package br.com.fiap.healthtrack.business.atividadefisica;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.dao.AtividadeFisicaDAO;
import br.com.fiap.healthtrack.model.AtividadeFisica;

public class AtividadeFisicaBusiness {

	public void cadastrar(AtividadeFisica af) {
		AtividadeFisicaDAO afdao = new AtividadeFisicaDAO();
		afdao.add(af);
	}

	public List<AtividadeFisica> listarTodos() {

		List<AtividadeFisica> listaAtividadeFisicas = new ArrayList<AtividadeFisica>();

		AtividadeFisicaDAO afdao = new AtividadeFisicaDAO();
		listaAtividadeFisicas = afdao.getAll();

		return listaAtividadeFisicas;
	}

	public AtividadeFisica pesquisarPorId(int codigo) {

		AtividadeFisica atividadeFisica = new AtividadeFisica();
		AtividadeFisicaDAO afdao = new AtividadeFisicaDAO();
		atividadeFisica = afdao.getById(codigo);

		return atividadeFisica;
	}

	public void editar(AtividadeFisica af) {

		AtividadeFisicaDAO afdao = new AtividadeFisicaDAO();
		afdao.update(af);
	}

	public void excluir(int codigo) {

		AtividadeFisicaDAO afdao = new AtividadeFisicaDAO();
		afdao.delete(codigo);
	}

}
