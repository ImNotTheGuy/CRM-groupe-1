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

@WebServlet("/modifierEtAjouterClient")
public class ModifierEtAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDao clientDao;

    public ModifierEtAjouterClient() {
        super();

		clientDao = DaoFactory.getInstance().getClientDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String modify = request.getParameter("id");
		
		if (modify == null) {
			System.out.println("No id was given, sending to add Client form.");
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
			return;
		}

		long id;
		try {
			id = Long.parseLong(modify);
		} catch (NumberFormatException nfExc) {
			System.out.println("Input value is not a number, sending to add Client form: " + nfExc);
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
			return;
		}
			
		try {
			Client client = clientDao.trouver(id);
			System.out.println(client);
			request.setAttribute("client", client);
			request.setAttribute("addOrUpdate", "Modifier");
			
		} catch (DaoException e) {
			System.out.println("Error retrieving id" + id);
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO: Controls
		
		
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
		
		
		
		if (request.getParameter("id") == null) {
			try {

				Client clientToAdd = new Client();

				clientToAdd.setCompanyName(companyName);
				clientToAdd.setFirstName(firstName);
				clientToAdd.setLastName(lastName);
				clientToAdd.setEmail(email);
				clientToAdd.setPhone(phone);
				clientToAdd.setAddress(address);
				clientToAdd.setZipCode(zipCode);
				clientToAdd.setCity(city);
				clientToAdd.setCountry(country);
				clientToAdd.setState(state);
				System.out.println("Client à ajouter: " + clientToAdd);
				clientDao.creer(clientToAdd);
			} catch (DaoException e) {
				
				e.printStackTrace();
			}
		} else {
			
			try {
				long clientId = Long.parseLong(request.getParameter("id"));
				Client clientToModify = clientDao.trouver(clientId);

				System.out.println("Client à modifier: " + clientToModify);
				clientToModify.setCompanyName(companyName);
				clientToModify.setFirstName(firstName);
				clientToModify.setLastName(lastName);
				clientToModify.setEmail(email);
				clientToModify.setPhone(phone);
				clientToModify.setAddress(address);
				clientToModify.setZipCode(zipCode);
				clientToModify.setCity(city);
				clientToModify.setCountry(country);
				clientToModify.setState(state);
				
				System.out.println("Client aveec modif: " + clientToModify);

				clientDao.update(clientToModify);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		response.sendRedirect(request.getContextPath() + "/listeClients");
	}
}