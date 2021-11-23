package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que abstrai o atributo pressao arterial
 * 
 * @author Dionney Saraiva, Jorge Zarlenga, Maria Eduarda e Rodrigo Valori
 * @version 1.0
 */

public class PressaoArterial implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos:

	private int codMedicao;
	private Calendar dataMedicao;
	private int pressaoSistolica;
	private int pressaoDiastolica;
	private String dataHoraString;

	// Construtor vazio:

	public PressaoArterial() {

	}

	// Construtor que recebe todos parametros:

	public PressaoArterial(int codMedicao, String dataHoraString, int pressaoSistolica, int pressaoDiastolica) {
		this.codMedicao = codMedicao;
		this.dataHoraString = dataHoraString;
		this.pressaoSistolica = pressaoSistolica;
		this.pressaoDiastolica = pressaoDiastolica;
	}

	// Construtor SQL:

	public PressaoArterial(int pressaoSistolica, int pressaoDiastolica) {
		this.pressaoSistolica = pressaoSistolica;
		this.pressaoDiastolica = pressaoDiastolica;
	}

	// Metodos getters and setters:

	public int getCodMedicao() {
		return codMedicao;
	}

	public void setCodMedicao(int codMedicao) {
		this.codMedicao = codMedicao;
	}

	public Calendar getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(Calendar dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

	public int getPressaoSistolica() {
		return pressaoSistolica;
	}

	public void setPressaoSistolica(int pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}

	public int getPressaoDiastolica() {
		return pressaoDiastolica;
	}

	public void setPressaoDiastolica(int pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}

	public String getDataHoraString() {
		return dataHoraString;
	}

	public void setDataHoraString(String dataHoraString) {
		this.dataHoraString = dataHoraString;
	}

	@Override
	public String toString() {
		return "PressaoArterial: codMedicao=" + codMedicao + ", dataMedicao=" + dataMedicao + ", pressaoSistolica="
				+ pressaoSistolica + ", pressaoDiastolica=" + pressaoDiastolica + "\n";
	}
}
