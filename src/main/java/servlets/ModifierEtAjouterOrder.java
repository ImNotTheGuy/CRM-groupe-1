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
import dao.OrdersDao;
import model.Client;
import model.Orders;

/**
 * Servlet implementation class ModifierEtAjouterCommande
 */
@WebServlet("/modifierEtAjouterOrder")
public class ModifierEtAjouterOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDao clientDao;
	private OrdersDao ordersDao;


    public ModifierEtAjouterOrder() {
        super();

		clientDao = DaoFactory.getInstance().getClientDao();
		ordersDao = DaoFactory.getInstance().getOrdersDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String modify = request.getParameter("id");
		
		if (modify == null) {

			try {
				List<Client> listeClients = clientDao.lister();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("No id was given, sending to add Orders form.");

			List<Client> listeClients;
			try {
				listeClients = clientDao.lister();
				request.setAttribute("listeClients", listeClients);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterOrder.jsp").forward(request, response);
			return;
		}

		long id;
		try {
			id = Long.parseLong(modify);
		} catch (NumberFormatException nfExc) {
			System.out.println("Input value is not a number, sending to add Orders form: " + nfExc);

			List<Client> listeClients;
			try {
				listeClients = clientDao.lister();
				request.setAttribute("listeClients", listeClients);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("addOrUpdate", "Ajouter");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterOrder.jsp").forward(request, response);
			return;
		}
			
		try {
			Orders order = ordersDao.trouver(id);
			List<Client> listeClients = clientDao.lister();

			request.setAttribute("addOrUpdate", "Modifier");
			request.setAttribute("orders", order);
			request.setAttribute("listeClients", listeClients);
			
		} catch (DaoException e) {
			System.out.println("Error retrieving id" + id);
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtAjouterOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//TODO: Controls
		
		Controls controls = new Controls();
		
		long clientId = Long.parseLong(request.getParameter("clientId"));
		Client client;

		String typePresta = request.getParameter("typePresta");
		String designation = request.getParameter("designation");
		

		controls.checkRestriction("typePresta", typePresta);
		controls.checkRestriction("designation", designation);
		controls.checkRestriction("nbDays", request.getParameter("nbDays"));
		controls.checkRestriction("unitPrice", request.getParameter("unitPrice"));
		controls.checkRestriction("orderState", request.getParameter("state"));
		
		List<String> errorMessages = controls.getErrorMessages();
		
		if (errorMessages.size() > 0) {
			//TODO: redirect to error page
			System.out.println(errorMessages.toString());
		}
		
		int nbDays = Integer.parseInt(request.getParameter("nbDays"));
		float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
		int state = Integer.parseInt(request.getParameter("state"));
		
		
		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			try {
				client = clientDao.trouver(clientId);
				Orders orderToAdd = new Orders();
				orderToAdd.setClient(client);
				orderToAdd.setTypePresta(typePresta);
				orderToAdd.setDesignation(designation);
				orderToAdd.setNbDays(nbDays);
				orderToAdd.setUnitPrice(unitPrice);
				orderToAdd.setState(state);
				
				System.out.println("Commande à ajouter: " + orderToAdd);
				ordersDao.creer(orderToAdd);
			} catch (DaoException e) {

				e.printStackTrace();
			}
		} else {
			
			try {
				
				client = clientDao.trouver(clientId);
				long id = Long.parseLong(request.getParameter("id"));
				Orders orderToModify = ordersDao.trouver(id);
				System.out.println("Commande à modifier: " + orderToModify);
				orderToModify.setClient(client);
				orderToModify.setTypePresta(typePresta);
				orderToModify.setDesignation(designation);
				orderToModify.setNbDays(nbDays);
				orderToModify.setUnitPrice(unitPrice);
				orderToModify.setState(state);

				ordersDao.update(orderToModify);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

		response.sendRedirect(request.getContextPath() + "/listeOrders");
	}

}
