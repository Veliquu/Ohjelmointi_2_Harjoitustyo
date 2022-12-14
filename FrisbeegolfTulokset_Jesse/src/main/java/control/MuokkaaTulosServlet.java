package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TulosDao;
import database.TulosJdbcDao;
import model.Tulokset;

@WebServlet("/muokkaa-tulos")
public class MuokkaaTulosServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/muokkaatulos.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			boolean paivitysOnnistui = false;
			// Sijoitetaan muuttujaan pyynnön parametrina tullut tuloksen id-arvo
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			Tulokset tulokset = new Tulokset(id);
			
			// Pyydetään lomakkeella syötetyn asiakkaan tiedot
			String paivaSTR = request.getParameter("paiva");
			// Muutetaan paivaSTR sql date formaattiin
			Date paiva = java.sql.Date.valueOf(paivaSTR);
			String rata = request.getParameter("rata");
			String tuuli = request.getParameter("tuuli");
			String tulosStr = request.getParameter("tulos");
			int tulos = Integer.parseInt(tulosStr);
			// Luodaan uusi Tulokset luokan olio edellisillä parametreillä
			tulokset = new Tulokset(id, paiva, rata, tuuli, tulos);
			TulosDao tulosdao = new TulosJdbcDao();
			// Tallennetaan tiedot tietokantaan
			paivitysOnnistui = tulosdao.updateTulos(tulokset);
			if (paivitysOnnistui) {
				// uudelleenohjataan tulosten listaamiseen
				response.sendRedirect("/");
			} else {
				request.setAttribute("viesti", "Tuloksen muokkauksessa tapahtui virhe.");
				// servlet kutsuu jsp:tä
				request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("viesti", "Syötetyt tiedot eivät olleet kelvolliset.");
			request.getRequestDispatcher("WEB-INF/tapahtumaraportti.jsp").forward(request, response);
				
		}
	}

}
