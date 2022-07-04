package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.Orders;

public class OrdersDaoImpl implements OrdersDao {

	private static final String SQL_INSERT = "INSERT INTO ORDERS(clientid, typepresta, designation, nbdays, unitprice, state) VALUES(?,?,?,?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM orders ORDER BY id";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM orders WHERE id = ?";
	private static final String SQL_SELECT_BY_CLIENT_ID = "SELECT * FROM orders WHERE clientid = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM orders WHERE id = ? ";
	private static final String SQL_DELETE_BY_CLIENT_ID = "DELETE FROM orders WHERE clientid = ? ";

	private static final String SQL_UPDATE = "UPDATE orders SET clientid=?, typepresta=?, designation=?, nbdays=?, unitprice=?, state=?  WHERE id = ?";

	private DaoFactory factory;

	public OrdersDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void creer(Orders order) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pst.setLong(1, order.getClient().getId());
			pst.setString(2, order.getTypePresta());
			pst.setString(3, order.getDesignation());
			pst.setInt(4, order.getNbDays());
			pst.setFloat(5, order.getUnitPrice());
			pst.setInt(6, order.getState());

			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec création order (aucun ajout)");
			}
			ResultSet rsKeys = pst.getGeneratedKeys();
			if (rsKeys.next()) {
				order.setId(rsKeys.getLong(1));
			} else {
				throw new DaoException("Echec création order (ID non retourné)");
			}
			rsKeys.close();
			pst.close();

		} catch (SQLException ex) {
			throw new DaoException("Echec création order", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public Orders trouver(long id) throws DaoException {
		Orders order = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				order = map(rs);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de recherche BDD client", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return order;
	}

	@Override
	public List<Orders> trouverByClientId(long idClient) throws DaoException {
		
		List<Orders> listOrders = new ArrayList<>();
		Orders order = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_SELECT_BY_CLIENT_ID);
			pst.setLong(1, idClient);
			rs = pst.executeQuery();
			while (rs.next()) {
				order = map(rs);
				listOrders.add(order);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de recherche BDD client", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return listOrders;

	}

	@Override
	public List<Orders> lister() throws DaoException {

		
		Connection con = null;
		List<Orders> listOrders = new ArrayList<>();
		
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				listOrders.add(map(rs));
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de lecture BDD Orders", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return listOrders;

	}

	@Override
	public void supprimer(long id) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_DELETE_BY_ID);
			pst.setLong(1, id);
			int statut = pst.executeUpdate();
			if (statut == 0) {
				throw new DaoException("Erreur de suppression Orders(" + id + ")");
			}
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de suppression BDD Orders", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public void supprimerByClientId(long idClient) throws DaoException {
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_DELETE_BY_CLIENT_ID );
			  pst.setLong(1, idClient);
			  int statut = pst.executeUpdate();
			  if ( statut == 0 ) {
				  throw new DaoException("Erreur de suppression Livre("+idClient+")");
			  }
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de suppression BDD Livre", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}

	@Override
	public void update(Orders order) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);

			pst.setLong(1, order.getClient().getId());
			pst.setString(2, order.getTypePresta());
			pst.setString(3, order.getDesignation());
			pst.setInt(4, order.getNbDays());
			pst.setFloat(5, order.getUnitPrice());
			pst.setInt(6, order.getState());
			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec modification Order");
			}
			pst.close();

		} catch (SQLException ex) {
			throw new DaoException("Echec BDD modification Order", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}
	
	
	private static Orders map(ResultSet resultSet) throws SQLException {
		
		Orders a = new Orders();
		ClientDao clientDao = DaoFactory.getInstance().getClientDao();
		a.setId(resultSet.getLong("id"));
		try {
		a.setClient(clientDao.trouver(resultSet.getLong("clientid")));
		} catch (DaoException daoExc) {
			daoExc.printStackTrace();
		}
		a.setTypePresta(resultSet.getString("typepresta"));
		a.setDesignation(resultSet.getString("designation"));
		a.setUnitPrice(resultSet.getFloat("unitprice"));
		a.setDesignation(resultSet.getString("designation"));
		a.setNbDays(resultSet.getInt("nbdays"));
		a.setTotalExcludeTaxe(resultSet.getFloat("totalexcludetaxe"));
		a.setTotalWithTaxe(resultSet.getFloat("totalwithtaxe"));

		return a;
	}

}
