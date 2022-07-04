package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDao;
import dao.DaoFactory;

/**
 * Servlet implementation class ModifierEtAjouterClient
 */
@WebServlet("/ModifierEtAjouterClient")
public class ModifierEtAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDao clientDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEtAjouterClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		clientDao = DaoFactory.getInstance().getClientDao();
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/formClient.jsp").forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
