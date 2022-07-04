package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Client;

@WebServlet("/listeClients")
public class ListerClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClientDao clientDao = DaoFactory.getInstance().getClientDao();
	List <Client> listeClients = null;
	
	try {
		listeClients = clientDao.lister();
	} catch (DaoException e) {
		e.printStackTrace();
	}
	request.setAttribute("listeClients", listeClients);
	
	this.getServletContext().getRequestDispatcher("/WEB-INF/listeClients.jsp").forward(request, response);

}