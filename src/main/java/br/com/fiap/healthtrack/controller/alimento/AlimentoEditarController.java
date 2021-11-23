package br.com.fiap.healthtrack.controller.alimento;

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

import br.com.fiap.healthtrack.business.alimento.AlimentoBusiness;
import br.com.fiap.healthtrack.model.Alimento;

@WebServlet("/editarAlimento")
public class AlimentoEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlimentoEditarController() {
		super();
	}

	int codAlimento;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		Alimento Alimento = new AlimentoBusiness().pesquisarPorId(codigo);

		codAlimento = codigo;

		request.setAttribute("Alimento", Alimento);

		RequestDispatcher rd = request.getRequestDispatcher("edit-food.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Alimento alimento = new Alimento();
		alimento.setCodAlimento(codAlimento);
		alimento.setNomeAlimento(request.getParameter("nome-alimento"));

		SimpleDateFormat formatDataHoraAlimento = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Calendar dataHoraAlimento = Calendar.getInstance();
		try {
			dataHoraAlimento.setTime(formatDataHoraAlimento.parse(request.getParameter("hora-alimento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alimento.setDataHoraAlimento(dataHoraAlimento);

		alimento.setEnergiaKcalAlimento(Double.valueOf(request.getParameter("calorias-alimento")));
		alimento.setQuantidadeAlimento(Double.valueOf(request.getParameter("quantidade-alimento")));

		AlimentoBusiness ab = new AlimentoBusiness();
		ab.editar(alimento);

		AlimentoBusiness alimentoBusiness = new AlimentoBusiness();
		List<Alimento> listaAlimentos = alimentoBusiness.listarTodos();

		request.setAttribute("listaAlimentos", listaAlimentos);
		RequestDispatcher rd = request.getRequestDispatcher("food-table.jsp");
		rd.forward(request, response);

	}

}