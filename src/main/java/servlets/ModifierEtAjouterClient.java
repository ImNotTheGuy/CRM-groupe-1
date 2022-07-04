package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Client;

@WebServlet("/ModifierEtAjouterClient")
public class ModifierEtAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDao clientDao;

    public ModifierEtAjouterClient() {
        super();
        clientDao = DaoFactory.getInstance().getClientDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String modify = request.getParameter("id");
		
		if (modify == null) {
			System.out.println("No id was given, sending to add Client form.");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
			return;
		}

		long id;
		try {
			id = Long.parseLong(modify);
		} catch (NumberFormatException nfExc) {
			System.out.println("Input value is not a number, sending to add Client form: " + nfExc);
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
			return;
		}
			
		clientDao = DaoFactory.getInstance().getClientDao();
		
		try {
			Client client = clientDao.trouver(id);
			System.out.println(client);
			request.setAttribute("client", client);
			
		} catch (DaoException e) {
			System.out.println("Error retrieving id" + id);
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		clientDao = DaoFactory.getInstance().getClientDao();
		Client clientToModify;
		try {
			int clientId = Integer.parseInt(request.getParameter("id"));

			String companyName = request.getParameter("companyName");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String zipCode = request.getParameter("zipCode");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			int state = Integer.parseInt(request.getParameter("state"));
			
			clientToModify = clientDao.trouver(clientId);

			clientToModify.setCompanyName(companyName);
			clientToModify.setFirstName(firstName);
			clientToModify.setLastName(lastName);
			clientToModify.setEmail(email);
			clientToModify.setPhone(phone);
			clientToModify.setZipCode(zipCode);
			clientToModify.setCity(city);
			clientToModify.setCountry(country);
			clientToModify.setState(state);
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException nfExc) {
			System.out.println("Invalid id type given");
		}
		
		
		
		
		
		
		doGet(request, response);
	}
}