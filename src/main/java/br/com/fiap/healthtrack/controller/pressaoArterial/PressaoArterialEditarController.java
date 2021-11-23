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

@WebServlet("/editarPressaoArterial")
public class PressaoArterialEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PressaoArterialEditarController() {
		super();
	}

	int codMedicao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		PressaoArterial pressaoArterial = new PressaoArterialBusiness().pesquisarPorId(codigo);

		codMedicao = pressaoArterial.getCodMedicao();

		request.setAttribute("pressaoArterial", pressaoArterial);

		// ARRUMAR JSP: edit-pressure.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit-pressure.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PressaoArterial pressaoArterial = new PressaoArterial();
			pressaoArterial.setCodMedicao(codMedicao);
			pressaoArterial.setDataMedicao(request.getParameter("data-medicao"));
			pressaoArterial.setPressaoSistolica(Integer.parseInt(request.getParameter("pressao-sistolica")));
			pressaoArterial.setPressaoDiastolica(Integer.parseInt(request.getParameter("pressao-diastolica")));

			PressaoArterialBusiness pa = new PressaoArterialBusiness();
			pa.editar(pressaoArterial);

			List<PressaoArterial> listaPressaoArterial = pa.listarTodos();

			request.setAttribute("listaPressaoArterial", listaPressaoArterial);
			RequestDispatcher rd = request.getRequestDispatcher("pressure-table.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}