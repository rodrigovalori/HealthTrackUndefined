package br.com.fiap.healthtrack.dao;

import java.util.List;

import br.com.fiap.healthtrack.model.Alimento;
import br.com.fiap.healthtrack.model.AtividadeFisica;
import br.com.fiap.healthtrack.model.Peso;
import br.com.fiap.healthtrack.model.PressaoArterial;
import br.com.fiap.healthtrack.model.Usuario;

public interface IDataHandler<T> {

	public List<T> getAll();

	public int add(T obj);

	public T getById(int id);

	public int delete(int id);

	public int update(T obj);

	Usuario getByEmail(String email);

	Usuario getIdByEmail(String email);

	int add(AtividadeFisica obj, int userId);

	int add(Alimento obj, int userId);

	int add(Peso obj, int userId);

	int add(PressaoArterial obj, int userId);

	Usuario getIdByEmailAndPassword(String email, String password);

}
