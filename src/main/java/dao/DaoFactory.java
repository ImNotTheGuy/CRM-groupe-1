package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
 
	 private String url;
	 private String username;
	 private String passwd;
	 private Connection con = null;
	
	 private static DaoFactory instanceSingleton = null;
 
	 // Constructeur priv� (usage limit� � la classe elle m�me : Cf. "getInstance()")
	 private DaoFactory(String url, String username, String passwd) {
		this.url = url;
		this.username = username;
		this.passwd = passwd;
	}
	
	 
	public static DaoFactory getInstance() {
		if ( DaoFactory.instanceSingleton == null ) {
			try {
			      Class.forName("org.postgresql.Driver");
			      DaoFactory.instanceSingleton = new DaoFactory("jdbc:postgresql://localhost/biblio","postgres","12345");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return DaoFactory.instanceSingleton;
	}
	
	
	public AuteurDao getClientDao() {
		return new AuteurDaoImpl( this );
	}
	
	public LivreDao getCommandeDao() {
		return new LivreDaoImpl( this );
	}

	Connection getConnection() throws SQLException {
		if ( this.con == null ) {
	      this.con = DriverManager.getConnection(url,username,passwd);
		}
		return this.con;
	}
	
	// cette m�thode prend une connection en parametre en pr�sagent que l'on pourrait en utiliser plusieurs
	// mais par construction actuellement la seule connection existante est stock�e dans "this.con"
	void releaseConnection( Connection connectionRendue ) {
		if (this.con==null) {
			return;
		}
		try {
			if ( ! this.con.isValid(10) ) {
				this.con.close();
				this.con = null;
			}
		} catch (SQLException e) {
			this.con = null;
		}
	}

}
