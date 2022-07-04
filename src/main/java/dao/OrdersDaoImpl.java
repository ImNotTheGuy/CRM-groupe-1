package dao;

import java.util.ArrayList;
import java.util.List;

import model.Orders;

public class OrdersDaoImpl implements OrdersDao {

	private static final String SQL_INSERT = "INSERT INTO ORDERS(id_auteur, titre, nb_pages, categorie) VALUES(?,?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM livre ORDER BY id";
	private static final String SQL_SELECT_BY_ID = "SELECT id, id_auteur, titre, nb_pages, categorie FROM livre WHERE id = ?";
	private static final String SQL_SELECT_BY_CLIENT_ID = "SELECT id, id_auteur, titre, nb_pages, categorie FROM livre WHERE id_auteur = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM livre WHERE id = ? ";
	private static final String SQL_DELETE_BY_CLIENT_ID = "DELETE FROM livre WHERE id = ? ";

	private static final String SQL_UPDATE = "UPDATE livre SET id_auteur=?, titre=?, nb_pages=?, categorie=? WHERE id = ?";

	private DaoFactory factory;

	public OrdersDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	public void creer(Orders order) throws DaoException {
		return;
	}

	public Orders trouver(long id) throws DaoException {
		return new Orders();
	}

	public Orders trouverByClientId(long idClient) throws DaoException {
		return new Orders();

	}

	public List<Orders> lister() throws DaoException {

		Orders orders = new Orders();
		List<Orders> listOrders = new ArrayList<>();
		listOrders.add(orders);
		return listOrders;

	}

	public void supprimer(long id) throws DaoException {

	}

	public void supprimerByClientId(long idClient) throws DaoException {

	}

	public void update(Orders Orders) throws DaoException {

	}

}
