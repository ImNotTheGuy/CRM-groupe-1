package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoException;
import dao.DaoFactory;
import dao.ClientDao;
import dao.OrdersDao;

@WebServlet("/supprimerClient")
public class SupprimerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDao clientDao;
	private OrdersDao ordersDao;
    
    public SupprimerClient() {
        super();
       
        clientDao = DaoFactory.getInstance().getClientDao();
        ordersDao = DaoFactory.getInstance().getOrdersDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			clientDao.supprimer(id);
			ordersDao.supprimerByClientId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/listeClients");
	}
}