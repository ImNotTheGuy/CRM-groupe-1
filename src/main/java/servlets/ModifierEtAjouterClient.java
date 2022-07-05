package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controls.Controls;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String modify = request.getParameter("id");

		if (modify == null) {
			System.out.println("No id was given, sending to add Client form.");
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request,
					response);
			return;
		}

		long id;
		try {
			id = Long.parseLong(modify);
		} catch (NumberFormatException nfExc) {
			System.out.println("Input value is not a number, sending to add Client form: " + nfExc);
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request,
					response);
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterClient.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Controls controls = new Controls();
		
		controls.checkRestriction("companyName",request.getParameter("companyName"));
		controls.checkRestriction("firstName",request.getParameter("firstName"));
		controls.checkRestriction("lastName",request.getParameter("lastName"));
		controls.checkRestriction("email",request.getParameter("email"));
		controls.checkRestriction("phone",request.getParameter("phone"));
		controls.checkRestriction("address",request.getParameter("address"));
		controls.checkRestriction("zipCode",request.getParameter("zipCode"));
		controls.checkRestriction("city",request.getParameter("city"));
		controls.checkRestriction("country",request.getParameter("country"));
		controls.checkRestriction("clientState",request.getParameter("state"));
		
		List<String> errorMessages = controls.getErrorMessages();
		
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			
			if (errorMessages.size() > 0) {

				System.out.println(errorMessages.toString());
				request.setAttribute("errorTitle", "ajouter client");
				request.setAttribute("errorMessages", errorMessages);
				request.setAttribute("redirectURL", "/listeClients");
				this.getServletContext().getRequestDispatcher("/WEB-INF/errorMessages.jsp").forward(request, response);
				return;
			}
			
			int state; // client state can be null and has 0 as default
			String companyName = request.getParameter("companyName");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String zipCode = request.getParameter("zipCode");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			try {
			state = Integer.parseInt(request.getParameter("state"));
			} catch (NumberFormatException nfExc) {
				System.out.println("No number passed for state, putting default value 0");
				state = 0;
			}
			
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
			
			if (errorMessages.size() > 0) {

				System.out.println(errorMessages.toString());
				request.setAttribute("errorTitle", "modifier client");
				request.setAttribute("errorMessages", errorMessages);
				request.setAttribute("redirectURL", "/listeClients");
				this.getServletContext().getRequestDispatcher("/WEB-INF/errorMessages.jsp").forward(request, response);
				return;
			}
			

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
			
			try {
				System.out.println("Line 102: " + request.getParameter("id"));
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