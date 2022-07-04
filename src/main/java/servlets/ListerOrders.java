package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoException;
import dao.DaoFactory;
import dao.OrdersDao;
import model.Orders;

/**
 * Servlet implementation class ListerOrders
 */
@WebServlet("/listeOrders")
public class ListerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	private OrdersDao ordersDao;
	
	
	
    public ListerOrders() {
        super();
        ordersDao = DaoFactory.getInstance().getOrdersDao();

    }

    
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {

			
			request.setAttribute( "listeOrders", ordersDao.lister());
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeOrders.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}



}
