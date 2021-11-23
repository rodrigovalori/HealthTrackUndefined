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

@WebServlet("/excluirAtividadeFisica")
public class AtividadeFisicaExcluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtividadeFisicaExcluirController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		AtividadeFisicaBusiness atividadeFisica = new AtividadeFisicaBusiness();
		atividadeFisica.excluir(codigo);

		AtividadeFisicaBusiness atividadeFisicaBusiness = new AtividadeFisicaBusiness();
		List<AtividadeFisica> listaAtividadeFisica = atividadeFisicaBusiness.listarTodos();

		request.setAttribute("listaAtividadeFisica", listaAtividadeFisica);

		RequestDispatcher rd = request.getRequestDispatcher("exercises-table.jsp");
		rd.forward(request, response);
	}

}