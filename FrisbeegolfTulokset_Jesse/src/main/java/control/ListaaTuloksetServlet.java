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

@WebServlet("/listaa-tulos")
public class ListaaTuloksetServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			// Haetaan tulokset tietokannasta
			TulosDao tulosdao = new TulosJdbcDao();	
			List<Tulokset> tulokset = tulosdao.findAll();
			
			// tulokset-lista .jsp:n saataville
			request.setAttribute("tulokset", tulokset);
			// pyynnön eteenpäin lähetys tulos.jsp:lle
			request.getRequestDispatcher("/WEB-INF/tuloksetlista.jsp").forward(request, response);
	
		}
		
	

}
