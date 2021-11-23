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

@WebServlet("/editarPeso")
public class PesoEditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PesoEditarController() {
		super();
	}

	int codPesagem;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codigo = Integer.parseInt(request.getParameter("id"));

		Peso peso = new PesoBusiness().pesquisarPorId(codigo);

		codPesagem = peso.getCodPesagem();

		request.setAttribute("peso", peso);

		// ARRUMAR JSP: edit-weight.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit-weight.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Peso peso = new Peso();
			peso.setCodPesagem(codPesagem);
			peso.setDataPesagem(request.getParameter("data-pesagem"));
			peso.setPeso(Double.valueOf(request.getParameter("peso")));

			PesoBusiness p = new PesoBusiness();
			p.editar(peso);

			List<Peso> listaPeso = p.listarTodos();

			request.setAttribute("listaPeso", listaPeso);
			RequestDispatcher rd = request.getRequestDispatcher("weight-table.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}