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

@WebServlet("/cadastrarPressaoArterial")
public class PressaoArterialCadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PressaoArterialCadastrarController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("pressure.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PressaoArterial pressaoArterial = new PressaoArterial();
		
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

		PressaoArterialBusiness pa = new PressaoArterialBusiness();
		pa.cadastrar(pressaoArterial);

		PressaoArterialBusiness pressureBusiness = new PressaoArterialBusiness();
		List<PressaoArterial> listaPressoes = pressureBusiness.listarTodos();

		request.setAttribute("listaPressoes", listaPressoes);
		RequestDispatcher rd = request.getRequestDispatcher("pressure-table.jsp");
		rd.forward(request, response);

	}
}