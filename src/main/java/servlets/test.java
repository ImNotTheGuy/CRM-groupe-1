package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		ClientDao clientDao = DaoFactory.getInstance().getClientDao();
		
		List<Client> listClients = new ArrayList<>();
		
		try {
			listClients = clientDao.lister();
<<<<<<< HEAD

			System.out.println(listClients);
=======
			
>>>>>>> c1ab364299cfd34d80743714f378e0ae18f17796
		} catch (DaoException daoEx) {
			System.out.println("Error listing clients: " + daoEx);
		}
		
		

<<<<<<< HEAD
		this.getServletContext().getRequestDispatcher("WEB-INF/formClient.jsp").forward(request, response);
=======
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsClient.jsp").forward(request, response);
>>>>>>> c1ab364299cfd34d80743714f378e0ae18f17796
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
