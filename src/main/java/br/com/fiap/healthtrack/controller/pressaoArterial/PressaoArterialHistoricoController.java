package br.com.fiap.healthtrack.controller.pressaoArterial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.pressaoarterial.PressaoArterialBusiness;
import br.com.fiap.healthtrack.model.PressaoArterial;

@WebServlet("/historicoPressaoArterial")
public class PressaoArterialHistoricoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PressaoArterialHistoricoController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PressaoArterialBusiness pressaoArterialBusiness = new PressaoArterialBusiness();
		List<PressaoArterial> listaPressoes = pressaoArterialBusiness.listarTodos();

		request.setAttribute("listaPressoes", listaPressoes);
		RequestDispatcher rd = request.getRequestDispatcher("pressure-table.jsp");
		rd.forward(request, response);
	}
}