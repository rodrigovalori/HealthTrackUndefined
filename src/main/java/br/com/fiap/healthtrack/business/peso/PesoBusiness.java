package br.com.fiap.healthtrack.business.peso;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.dao.PesoDAO;
import br.com.fiap.healthtrack.model.Peso;

public class PesoBusiness {

	public void cadastrar(Peso p) {
		PesoDAO pdao = new PesoDAO();
		pdao.add(p);
	}

	public List<Peso> listarTodos() {

		List<Peso> listaPesos = new ArrayList<Peso>();

		PesoDAO pdao = new PesoDAO();
		listaPesos = pdao.getAll();

		return listaPesos;
	}

	public Peso pesquisarPorId(int codigo) {

		Peso peso = new Peso();
		PesoDAO pdao = new PesoDAO();
		peso = pdao.getById(codigo);

		return peso;
	}

	public void editar(Peso p) {

		PesoDAO pdao = new PesoDAO();
		pdao.update(p);
	}

	public void excluir(int codigo) {

		PesoDAO pdao = new PesoDAO();
		pdao.delete(codigo);
	}

}
