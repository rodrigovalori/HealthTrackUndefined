package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que abstrai o registro de atividade fisica
 * 
 * @author Dionney Saraiva, Jorge Zarlenga, Maria Eduarda e Rodrigo Valori
 * @version 1.0
 */

public class AtividadeFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos:

	private int codAtividadeFisica;
	private double energiaKcalAtividadeFisica;
	private Calendar dataHoraInicioAtividadeFisica;
	private Calendar dataHoraTerminoAtividadeFisica;
	private String descricaoAtividadeFisica;
	private String dataHoraStringInicio;
	private String dataHoraStringTermino;

	// Construtor vazio:

	public AtividadeFisica() {

	}

	// Construtor que recebe todos parametros:

	public AtividadeFisica(int codAtividadeFisica, double energiaKcalAtividadeFisica, String dataHoraStringInicio,
			String dataHoraStringTermino, String descricaoAtividadeFisica) {
		this.codAtividadeFisica = codAtividadeFisica;
		this.energiaKcalAtividadeFisica = energiaKcalAtividadeFisica;
		this.dataHoraStringInicio = dataHoraStringInicio;
		this.dataHoraStringTermino = dataHoraStringTermino;
		this.descricaoAtividadeFisica = descricaoAtividadeFisica;
	}

	// Construtor SQL:

	public AtividadeFisica(double energiaKcalAtividadeFisica, Calendar dataHoraInicioAtividadeFisica,
			Calendar dataHoraTerminoAtividadeFisica, String descricaoAtividadeFisica) {
		this.energiaKcalAtividadeFisica = energiaKcalAtividadeFisica;
		this.dataHoraInicioAtividadeFisica = dataHoraInicioAtividadeFisica;
		this.dataHoraTerminoAtividadeFisica = dataHoraTerminoAtividadeFisica;
		this.descricaoAtividadeFisica = descricaoAtividadeFisica;
	}

	// Metodos getters and setters:

	public int getCodAtividadeFisica() {
		return codAtividadeFisica;
	}

	public void setCodAtividadeFisica(int codAtividadeFisica) {
		this.codAtividadeFisica = codAtividadeFisica;
	}

	public double getEnergiaKcalAtividadeFisica() {
		return energiaKcalAtividadeFisica;
	}

	public void setEnergiaKcalAtividadeFisica(double energiaKcalAtividadeFisica) {
		this.energiaKcalAtividadeFisica = energiaKcalAtividadeFisica;
	}

	public Calendar getDataHoraInicioAtividadeFisica() {
		return dataHoraInicioAtividadeFisica;
	}

	public void setDataHoraInicioAtividadeFisica(Calendar dataHoraInicioAtividadeFisica) {
		this.dataHoraInicioAtividadeFisica = dataHoraInicioAtividadeFisica;
	}

	public Calendar getDataHoraTerminoAtividadeFisica() {
		return dataHoraTerminoAtividadeFisica;
	}

	public void setDataHoraTerminoAtividadeFisica(Calendar dataHoraTerminoAtividadeFisica) {
		this.dataHoraTerminoAtividadeFisica = dataHoraTerminoAtividadeFisica;
	}

	public String getDescricaoAtividadeFisica() {
		return descricaoAtividadeFisica;
	}

	public void setDescricaoAtividadeFisica(String descricaoAtividadeFisica) {
		this.descricaoAtividadeFisica = descricaoAtividadeFisica;
	}

	public String getDataHoraStringInicio() {
		return dataHoraStringInicio;
	}

	public void setDataHoraStringInicio(String dataHoraStringInicio) {
		this.dataHoraStringInicio = dataHoraStringInicio;
	}

	public String getDataHoraStringTermino() {
		return dataHoraStringTermino;
	}

	public void setDataHoraStringTermino(String dataHoraStringTermino) {
		this.dataHoraStringTermino = dataHoraStringTermino;
	}

	@Override
	public String toString() {
		return "AtividadeFisica: codAtividadeFisica=" + codAtividadeFisica + ", energiaKcalAtividadeFisica="
				+ energiaKcalAtividadeFisica + ", dataHoraInicioAtividadeFisica=" + dataHoraInicioAtividadeFisica
				+ ", dataHoraTerminoAtividadeFisica=" + dataHoraTerminoAtividadeFisica + ", descricaoAtividadeFisica="
				+ descricaoAtividadeFisica + "\n";
	}
}
