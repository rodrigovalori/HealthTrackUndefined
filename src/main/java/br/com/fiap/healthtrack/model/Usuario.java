package br.com.fiap.healthtrack.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que abstrai um usuario
 * 
 * @author Dionney Saraiva, Jorge Zarlenga, Maria Eduarda e Rodrigo Valori
 * @version 1.0
 */

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos:

	private int codUsuario;
	private String nome;
	private Calendar dataNascimento;
	private String email;
	private String senha;

	// Construtor vazio:

	public Usuario() {

	}

	// Construtor que recebe todos parametros:

	public Usuario(String nome, Calendar dataNascimento, String email, String senha) {
		super();
		// this.codUsuario = codUsuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}

	// Metodos getters and setters:

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Calcula a idade do usuario
	 * 
	 * @param dataNascimento Data de nascimento do usuario
	 * @return idadeString
	 */

//	public String calcularIdade(GregorianCalendar dataNascimento) {
//
//		String idadeString;
//		int anoNascimento = dataNascimento.get(Calendar.YEAR);
//		int mesNascimento = dataNascimento.get(Calendar.MONTH);
//		int diaNascimento = dataNascimento.get(Calendar.DAY_OF_MONTH);
//
//		LocalDate dataNasc = LocalDate.of(anoNascimento, mesNascimento, diaNascimento); // Ano, mes e dia
//
//		// Captura a data atual
//		LocalDate agora = LocalDate.now();
//
//		// Calculo da diferenca entre as datas
//		Period diferenca = Period.between(dataNasc, agora);
//
//		// Concatenacao da frase para exibicao
//		idadeString = "\nIdade: " + diferenca.getYears() + " anos, " + diferenca.getMonths() + " meses e "
//				+ diferenca.getDays() + " dias.";
//
//		System.out.println(idadeString);
//
//		return idadeString;
//	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", senha=" + senha + "]";
	}

}
