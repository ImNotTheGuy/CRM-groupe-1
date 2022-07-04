import java.util.ArrayList;
import java.util.List;

import dao.ClientDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Client;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientDao clientDao = DaoFactory.getInstance().getClientDao();
		
		List<Client> listClients = new ArrayList<>();
		
		try {
			listClients = clientDao.lister();
		} catch (DaoException daoEx) {
			System.out.println("Error listing clients: " + daoEx);
		}
		
		System.out.println(listClients);
		
		
	}

}
