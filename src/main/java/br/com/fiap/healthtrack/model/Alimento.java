package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que abstrai o atributo alimento
 * 
 * @author Dionney Saraiva, Jorge Zarlenga, Maria Eduarda e Rodrigo Valori
 * @version 1.0
 */

public class Alimento implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos:

	private int codAlimento;
	private Calendar dataHoraAlimento;
	private String nomeAlimento;
	private double energiaKcalAlimento;
	private double quantidadeAlimento;
	private String dataHoraString;

	// Construtor vazio:

	public Alimento() {

	}

	// Construtor que recebe todos parametros:

	public Alimento(int codAlimento, String dataHoraString, String nomeAlimento, double energiaKcalAlimento,
			double quantidadeAlimento) {
		this.codAlimento = codAlimento;
		this.dataHoraString = dataHoraString;
		this.nomeAlimento = nomeAlimento;
		this.energiaKcalAlimento = energiaKcalAlimento;
		this.quantidadeAlimento = quantidadeAlimento;
	}

	// Metodos getters and setters:

	public int getCodAlimento() {
		return codAlimento;
	}

	public void setCodAlimento(int codAlimento) {
		this.codAlimento = codAlimento;
	}

	public Calendar getDataHoraAlimento() {
		return dataHoraAlimento;
	}

	public void setDataHoraAlimento(Calendar dataHoraAlimento) {
		this.dataHoraAlimento = dataHoraAlimento;
	}

	public String getNomeAlimento() {
		return nomeAlimento;
	}

	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}

	public double getEnergiaKcalAlimento() {
		return energiaKcalAlimento;
	}

	public void setEnergiaKcalAlimento(double gastoKcalAlimento) {
		this.energiaKcalAlimento = gastoKcalAlimento;
	}

	public double getQuantidadeAlimento() {
		return quantidadeAlimento;
	}

	public void setQuantidadeAlimento(double quantidadeAlimento) {
		this.quantidadeAlimento = quantidadeAlimento;
	}

	public String getDataHoraString() {
		return dataHoraString;
	}

	public void setDataHoraString(String dataHoraString) {
		this.dataHoraString = dataHoraString;
	}

	@Override
	public String toString() {
		return "Tabela Alimento: codAlimento=" + codAlimento + ", dataHoraAlimento=" + dataHoraAlimento
				+ ", nomeAlimento=" + nomeAlimento + ", energiaKcalAlimento=" + energiaKcalAlimento;
	}
}
