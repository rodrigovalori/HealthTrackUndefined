package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.peso.PesoBusiness;
import br.com.fiap.healthtrack.model.Peso;

@WebServlet("/excluirPeso")
public class PesoExcluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PesoExcluirController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		PesoBusiness peso = new PesoBusiness();
		peso.excluir(codigo);

		PesoBusiness pesoBusiness = new PesoBusiness();
		List<Peso> listaPesos = pesoBusiness.listarTodos();

		request.setAttribute("listaPesos", listaPesos);

		RequestDispatcher rd = request.getRequestDispatcher("weight-table.jsp");
		rd.forward(request, response);
	}
}