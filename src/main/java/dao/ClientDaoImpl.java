package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDaoImpl implements ClientDao {

	private static final String SQL_INSERT = "INSERT INTO client(companyname, firstname,lastname,email,phone,address, zipcode, city, country, state) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM client ORDER BY id";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM client WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM client WHERE id = ? ";
	private static final String SQL_UPDATE = "UPDATE client SET companyname=?,firstname=?, lastname=?, email=?, phone=?, address=?, zipCode=?, city=?, country=?, state=?";

	private DaoFactory factory;

	public ClientDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void creer(Client client) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, client.getCompanyName());
			pst.setString(2, client.getFirstName());
			pst.setString(3, client.getFirstName());
			pst.setString(4, client.getEmail());
			pst.setString(5, client.getPhone());
			pst.setString(6, client.getAddress());
			pst.setString(7, client.getZipCode());
			pst.setString(8, client.getCity());
			pst.setString(9, client.getCountry());
			pst.setInt(10, client.getState());

			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec création client (aucun ajout)");
			}
			ResultSet rsKeys = pst.getGeneratedKeys();
			if (rsKeys.next()) {
				client.setId(rsKeys.getLong(1));
			} else {
				throw new DaoException("Echec création client (ID non retourné)");
			}
			rsKeys.close();
			pst.close();

		} catch (SQLException ex) {
			throw new DaoException("Echec création client", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public Client trouver(long id) throws DaoException {

		Client client = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				client = map(rs);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de recherche BDD client", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return client;
	}

	@Override
	public List<Client> lister() throws DaoException {

		List<Client> listeClients = new ArrayList<Client>();
		Connection con = null;
		try {
			con = factory.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				listeClients.add(map(rs));
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de lecture BDD Client", ex);
		} finally {
			factory.releaseConnection(con);
		}
		return listeClients;
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
				throw new DaoException("Erreur de suppression Client(" + id + ")");
			}
			pst.close();
		} catch (SQLException ex) {
			throw new DaoException("Erreur de suppression BDD Client", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}

	@Override
	public void update(Client client) throws DaoException {
		Connection con = null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);

			pst.setString(1, client.getCompanyName());
			pst.setString(2, client.getFirstName());
			pst.setString(3, client.getLastName());
			pst.setString(4, client.getEmail());
			pst.setString(5, client.getPhone());
			pst.setString(6, client.getAddress());
			pst.setString(7, client.getZipCode());
			pst.setString(8, client.getCity());
			pst.setString(9, client.getCountry());
			pst.setInt(10, client.getState());

			int statut = pst.executeUpdate();

			if (statut == 0) {
				throw new DaoException("Echec modification Client");
			}
			pst.close();

		} catch (SQLException ex) {
			throw new DaoException("Echec BDD modification Client", ex);
		} finally {
			factory.releaseConnection(con);
		}
	}

	private static Client map(ResultSet resultSet) throws SQLException {
		Client a = new Client();
		a.setId(resultSet.getLong("id"));
		a.setCompanyName(resultSet.getString("companyname"));
		a.setFirstName(resultSet.getString("firstname"));
		a.setLastName(resultSet.getString("lastname"));
		a.setEmail(resultSet.getString("email"));
		a.setPhone(resultSet.getString("phone"));
		a.setAddress(resultSet.getString("address"));
		a.setZipCode(resultSet.getString("zipcode"));
		a.setCity(resultSet.getString("city"));
		a.setCountry(resultSet.getString("country"));
		a.setState(resultSet.getInt("state"));

		return a;
	}
}