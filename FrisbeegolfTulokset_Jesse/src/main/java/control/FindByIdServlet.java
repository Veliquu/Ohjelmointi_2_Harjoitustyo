package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;

import database.TulosDao;
import database.TulosJdbcDao;
import model.Tulokset;

@WebServlet("/findbyid")
public class FindByIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TulosDao tulosdao = new TulosJdbcDao();
		Tulokset olemassa = tulosdao.findById(id);
		
		request.setAttribute("tulokset", olemassa);
		RequestDispatcher rd = request.getRequestDispatcher("MuokkaaTulosServlet");
		rd.forward(request, response);
	}
}
