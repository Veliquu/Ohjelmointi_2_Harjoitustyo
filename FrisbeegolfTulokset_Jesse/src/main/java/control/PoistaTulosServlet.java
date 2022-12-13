package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TulosDao;
import database.TulosJdbcDao;

@WebServlet("/poista-tulos")
public class PoistaTulosServlet extends HttpServlet{
	
	// Vataanotetaan selaimelta tullut poistopyyntö
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
		// Sijoitetaan muuttujaan pyynnön parametrina tullut tuloksen id-arvo
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			
			// Luodaan tulosdao
			TulosDao tulosdao = new TulosJdbcDao();
			
			// Poistetaan tuloksen tiedot tietokannasta
			boolean poistoOnnistui = tulosdao.removeTulos(id);
			if (poistoOnnistui) {
				// Uudelleenohjataan tulosten listaukseen
				response.sendRedirect("/");
			} else {
				request.setAttribute("viesti", "Tuloksen poistossa tapahtui virhe");
				request.getRequestDispatcher("WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
	} catch (NumberFormatException e) {
		e.printStackTrace();
		request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
		request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
	}
	}
}
