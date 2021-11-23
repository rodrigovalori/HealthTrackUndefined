package br.com.fiap.healthtrack.controller.atividadeFisica;

import java.io.IOException;
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

		codAtividadeFisica = atividadeFisica.getCodAtividadeFisica();

		request.setAttribute("atividadeFisica", atividadeFisica);

		// ARRUMAR JSP: edit-exercise.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit-exercise.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			AtividadeFisica atividadeFisica = new AtividadeFisica();
			atividadeFisica.setCodAtividadeFisica(codAtividadeFisica);
			atividadeFisica.setEnergiaKcalAtividadeFisica(Double.valueOf(request.getParameter("calorias-gastas")));
			atividadeFisica.setDataHoraInicioAtividadeFisica(request.getParameter("hora-inicio"));
			atividadeFisica.setDataHoraInicioAtividadeFisica(request.getParameter("hora-final"));
			atividadeFisica.setDescricaoAtividadeFisica(request.getParameter("descricao-atividade"));

			AtividadeFisicaBusiness ab = new AtividadeFisicaBusiness();
			ab.editar(atividadeFisica);

			List<AtividadeFisica> listaAtividadeFisica = ab.listarTodos();

			request.setAttribute("listaAtividadeFisica", listaAtividadeFisica);
			RequestDispatcher rd = request.getRequestDispatcher("exercises-table.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}