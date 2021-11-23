package br.com.fiap.healthtrack.controller.atividadeFisica;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.atividadefisica.AtividadeFisicaBusiness;
import br.com.fiap.healthtrack.model.AtividadeFisica;

@WebServlet("/editarAtividadeFisica")
public class AtividadeFisicaEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtividadeFisicaEditarController() {
		super();
	}

	int codAtividadeFisica;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		AtividadeFisica atividadeFisica = new AtividadeFisicaBusiness().pesquisarPorId(codigo);

		codAtividadeFisica = codigo;

		request.setAttribute("atividadeFisica", atividadeFisica);

		RequestDispatcher rd = request.getRequestDispatcher("edit-exercise.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AtividadeFisica atividadeFisica = new AtividadeFisica();
		atividadeFisica.setCodAtividadeFisica(codAtividadeFisica);
		atividadeFisica.setEnergiaKcalAtividadeFisica(Double.valueOf(request.getParameter("calorias-gastas")));

		SimpleDateFormat formatInicio = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar dataHoraInicioAtividadeFisica = Calendar.getInstance();
		try {
			dataHoraInicioAtividadeFisica
					.setTime(formatInicio.parse(request.getParameter("hora-inicio")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atividadeFisica.setDataHoraInicioAtividadeFisica(dataHoraInicioAtividadeFisica);

		SimpleDateFormat formatTermino = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar dataHoraTerminoAtividadeFisica = Calendar.getInstance();
		try {
			dataHoraTerminoAtividadeFisica
					.setTime(formatTermino.parse(request.getParameter("hora-termino")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		atividadeFisica.setDataHoraTerminoAtividadeFisica(dataHoraTerminoAtividadeFisica);
		atividadeFisica.setDescricaoAtividadeFisica(request.getParameter("descricao-atividade"));

		AtividadeFisicaBusiness ab = new AtividadeFisicaBusiness();
		ab.editar(atividadeFisica);

		AtividadeFisicaBusiness atividadeFisicaBusiness = new AtividadeFisicaBusiness();
		List<AtividadeFisica> listaAtividadeFisica = atividadeFisicaBusiness.listarTodos();

		request.setAttribute("listaAtividadeFisica", listaAtividadeFisica);
		RequestDispatcher rd = request.getRequestDispatcher("exercises-table.jsp");
		rd.forward(request, response);

	}
}