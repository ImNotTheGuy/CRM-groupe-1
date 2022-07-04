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


@WebServlet("/detailsClient")
public class DetailsClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDao clientDao;
	private OrdersDao ordersDao;  
    
    public DetailsClient() {
        super();
        
        clientDao = DaoFactory.getInstance().getClientDao();
        ordersDao = DaoFactory.getInstance().getOrdersDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			request.setAttribute("clients", clientDao.trouver(id));
			request.setAttribute("orders", ordersDao.trouverByClientId(id));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsClient.jsp").forward(request, response);
	}
}