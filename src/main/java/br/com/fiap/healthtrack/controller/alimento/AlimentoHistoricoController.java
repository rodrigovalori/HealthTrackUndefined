package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.alimento.AlimentoBusiness;
import br.com.fiap.healthtrack.model.Alimento;

@WebServlet("/historicoAlimento")
public class AlimentoHistoricoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlimentoHistoricoController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AlimentoBusiness alimentoBusiness = new AlimentoBusiness();
		List<Alimento> listaAlimentos = alimentoBusiness.listarTodos();

		request.setAttribute("listaAlimentos", listaAlimentos);
		RequestDispatcher rd = request.getRequestDispatcher("food-table.jsp");
		rd.forward(request, response);
	}
}