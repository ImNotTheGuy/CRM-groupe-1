package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoException;
import dao.DaoFactory;
import dao.OrdersDao;

/* Servlet implementation class SupprimerOrder */
@WebServlet("/supprimerOrder")
public class SupprimerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrdersDao ordersDao;
	
    /* @see HttpServlet#HttpServlet() */
    public SupprimerOrder() {
        super();  
        ordersDao = DaoFactory.getInstance().getOrdersDao();
    }

	/* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			ordersDao.supprimer(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/listeOrders");
	}
}	