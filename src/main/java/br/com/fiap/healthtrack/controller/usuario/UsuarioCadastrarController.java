package br.com.fiap.healthtrack.controller.usuario;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.business.usuario.UsuarioBusiness;
import br.com.fiap.healthtrack.model.Usuario;

@WebServlet("/cadastrarUsuario")
public class UsuarioCadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioCadastrarController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nomeUsuario = request.getParameter("nome-usuario");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataNascimento = Calendar.getInstance();
		try {
			dataNascimento.setTime(format.parse(request.getParameter("data-nascimento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String email = request.getParameter("email");
		String senha =  request.getParameter("senha");
		
		Usuario usuario = new Usuario(nomeUsuario, dataNascimento, email, senha);
	
		UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
	    usuarioBusiness.cadastrar(usuario);

		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}
}
