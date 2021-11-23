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

		Alimento alimento = new AlimentoBusiness().pesquisarPorId(codigo);

		codAlimento = alimento.getCodAlimento();

		request.setAttribute("alimento", alimento);

		// ARRUMAR JSP: edit-food.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit-food.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Alimento alimento = new Alimento();
			alimento.setCodAlimento(codAlimento);
			alimento.setNomeAlimento(request.getParameter("nome-alimento"));
			alimento.setDataHoraAlimento(request.getParameter("hora-inicio"));
			alimento.setEnergiaKcalAlimento(Double.valueOf(request.getParameter("calorias-alimento")));
			alimento.setDescricaoAlimento(request.getParameter("descricao-alimento"));

			AlimentoBusiness a = new AlimentoBusiness();
			a.editar(alimento);

			List<Alimento> listaAlimento = a.listarTodos();

			request.setAttribute("listaAlimento", listaAlimento);
			RequestDispatcher rd = request.getRequestDispatcher("food-table.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}