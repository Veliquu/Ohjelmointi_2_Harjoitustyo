package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TulosDao;
import database.TulosJdbcDao;
import model.Tulokset;

@WebServlet("/muuta")
public class FindByIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Sijoitetaan muuttujaan pyynnön parametrina tullut tuloksen id-arvo
		int id = Integer.parseInt(request.getParameter("id"));
		// Luodaan uusi tulosdao ja lista
		TulosDao tulosdao = new TulosJdbcDao();
		List<Tulokset> tulosLista = tulosdao.findById(id);
		// Lähetetään lista MuokkaaTulosServletille
		request.setAttribute("tulosLista", tulosLista);
		request.getRequestDispatcher("/WEB-INF/muokkaatulos.jsp").forward(request, response);
	}
}
