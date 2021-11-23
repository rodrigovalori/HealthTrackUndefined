package br.com.fiap.healthtrack.business.alimento;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.healthtrack.dao.AlimentoDAO;
import br.com.fiap.healthtrack.model.Alimento;

public class AlimentoBusiness {

	public void cadastrar(Alimento a) {
		AlimentoDAO adao = new AlimentoDAO();
		adao.add(a);
	}

	public List<Alimento> listarTodos() {

		List<Alimento> listaAlimentos = new ArrayList<Alimento>();

		AlimentoDAO adao = new AlimentoDAO();
		listaAlimentos = adao.getAll();

		return listaAlimentos;
	}

	public Alimento pesquisarPorId(int codigo) {

		Alimento alimento = new Alimento();
		AlimentoDAO adao = new AlimentoDAO();
		alimento = adao.getById(codigo);

		return alimento;
	}

	public void editar(Alimento a) {

		AlimentoDAO adao = new AlimentoDAO();
		adao.update(a);
	}

	public void excluir(int codigo) {

		AlimentoDAO adao = new AlimentoDAO();
		adao.delete(codigo);
	}

}
