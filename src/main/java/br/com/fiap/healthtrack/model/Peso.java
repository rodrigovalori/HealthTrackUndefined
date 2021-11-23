package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que abstrai o atributo Peso
 * 
 * @author Dionney Saraiva, Jorge Zarlenga, Maria Eduarda e Rodrigo Valori
 * @version 1.0
 */

public class Peso implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos:

	private int codPesagem;
	private Calendar dataPesagem;
	private double peso;
	private String dataHoraString;

	// Construtor vazio:

	public Peso() {

	}

	// Construtor que recebe todos os parametros:

	public Peso(int codPesagem, String dataHoraString, double peso) {
		this.codPesagem = codPesagem;
		this.dataHoraString = dataHoraString;
		this.peso = peso;
	}

	// Metodos getters and setters:

	public int getCodPesagem() {
		return codPesagem;
	}

	public void setCodPesagem(int codPesagem) {
		this.codPesagem = codPesagem;
	}

	public Calendar getDataPesagem() {
		return dataPesagem;
	}

	public void setDataPesagem(Calendar dataPesagem) {
		this.dataPesagem = dataPesagem;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDataHoraString() {
		return dataHoraString;
	}

	public void setDataHoraString(String dataHoraString) {
		this.dataHoraString = dataHoraString;
	}

	@Override
	public String toString() {
		return "Peso: codPesagem=" + codPesagem + ", dataPesagem=" + dataPesagem + ", peso=" + peso + "\n";
	}
}
