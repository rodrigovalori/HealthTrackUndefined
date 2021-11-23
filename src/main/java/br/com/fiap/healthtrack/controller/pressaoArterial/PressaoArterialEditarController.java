package br.com.fiap.healthtrack.controller.pressaoArterial;

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

		RequestDispatcher rd = request.getRequestDispatcher("edit-pressure.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PressaoArterial pressaoArterial = new PressaoArterial();
		pressaoArterial.setCodMedicao(codMedicao);

		SimpleDateFormat formatPressao = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar dataHoraMedicao = Calendar.getInstance();
		try {
			dataHoraMedicao.setTime(formatPressao.parse(request.getParameter("data-hora-medicao")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pressaoArterial.setDataMedicao(dataHoraMedicao);

		pressaoArterial.setPressaoSistolica(Integer.parseInt(request.getParameter("pressao-sistolica")));
		pressaoArterial.setPressaoDiastolica(Integer.parseInt(request.getParameter("pressao-diastolica")));

		PressaoArterialBusiness pab = new PressaoArterialBusiness();
		pab.editar(pressaoArterial);
		
		PressaoArterialBusiness pressaoArterialBusiness = new PressaoArterialBusiness();
		List<PressaoArterial> listaPressoes = pressaoArterialBusiness.listarTodos();

		request.setAttribute("listaPressoes", listaPressoes);
		RequestDispatcher rd = request.getRequestDispatcher("pressure-table.jsp");
		rd.forward(request, response);

	}
}