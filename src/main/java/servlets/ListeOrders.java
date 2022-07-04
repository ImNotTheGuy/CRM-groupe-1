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

@WebServlet("/listeOrders")
public class ListeOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrdersDao ordersDao;
	
<<<<<<< HEAD:src/main/java/servlets/ListerOrders.java
    public ListerOrders() {
=======
	
	
    public ListeOrders() {
>>>>>>> origin/thomas:src/main/java/servlets/ListeOrders.java
        super();
        ordersDao = DaoFactory.getInstance().getOrdersDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD:src/main/java/servlets/ListerOrders.java
		try {
			request.setAttribute( "listeOrders", ordersDao.lister());
=======
		
		
		
		
		try {

			request.setAttribute( "Orders", ordersDao.lister());
			
>>>>>>> origin/thomas:src/main/java/servlets/ListeOrders.java
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD:src/main/java/servlets/ListerOrders.java
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeOrders.jsp").forward(request, response);
=======
		
		
			
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeOrders.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
>>>>>>> origin/thomas:src/main/java/servlets/ListeOrders.java
	}
}