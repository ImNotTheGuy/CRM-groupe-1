package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;


import model.Client;

public class ClientDaoImpl implements ClientDao{
	
	private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String zipCode;
    private String country;
    private int state;
	
	private static final String SQL_INSERT       = "INSERT INTO client(firstName,lastName,email,phone,address, zipCode, country, state) VALUES(?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT       = "SELECT * FROM client ORDER BY id";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM client WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM client WHERE id = ? ";
	private static final String SQL_UPDATE 		 = "UPDATE client SET firstName=?, lastName=?, email=?, phone=?, address=?, zipCode=?, country=?, state=?";
	
	private DaoFactory factory;
	
	public ClientDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}
	
	@Override
	void creer( Client client ) throws DaoException{
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			pst.setString( 1, client.getfirstName() );
			pst.setString( 2, client.getEmail() );
			pst.setString( 3, client.getPhone() );
			pst.setString( 4, client.getAddress() );
			pst.setString( 5, client.getZipCode() );
			pst.setString( 6, client.getCountry() );
			pst.setInt( 7, client.getState() );
			
			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec création client (aucun ajout)" );
            }
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                client.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec création client (ID non retourné)" );
            }
            rsKeys.close();
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec création client",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}
	
	@Override
	Client trouver( long id ) throws DaoException{
		
		Client            client=null;
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id);
		      rs  = pst.executeQuery();
		      if ( rs.next() ) {
		    	  client = map(rs);
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD client", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return client;
	}
		
	}
	
	@Override
    List<Client> lister() throws DaoException{
		
		List<Client> listeClients = new ArrayList<Client>();
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_SELECT );
		      ResultSet         rs  = pst.executeQuery();
		      while ( rs.next() ) {
		    	  listeClients.add( map(rs) );
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de lecture BDD Client", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return listeClients;
	}
	}
	
	@Override
    void supprimer( long id ) throws DaoException;
    
	@Override
    void update( Client client ) throws DaoException;
	
}