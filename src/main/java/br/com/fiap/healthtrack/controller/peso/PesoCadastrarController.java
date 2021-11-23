package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.peso.PesoBusiness;
import br.com.fiap.healthtrack.model.Peso;

@WebServlet("/cadastrarPeso")
public class PesoCadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PesoCadastrarController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("weight.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Peso peso = new Peso();

		SimpleDateFormat formatPeso = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataPesagem = Calendar.getInstance();
		try {
			dataPesagem.setTime(formatPeso.parse(request.getParameter("data-pesagem")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		peso.setDataPesagem(dataPesagem);
		peso.setPeso(Double.valueOf(request.getParameter("peso")));

		PesoBusiness p = new PesoBusiness();
		p.cadastrar(peso);

		List<Peso> listaPesos = new ArrayList<Peso>();
		listaPesos = p.listarTodos();
		
		request.setAttribute("listaPesos", listaPesos);
		RequestDispatcher rd = request.getRequestDispatcher("weight-table.jsp");
		rd.forward(request, response);

	}
}