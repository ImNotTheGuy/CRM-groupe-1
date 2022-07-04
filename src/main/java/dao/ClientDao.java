package dao;

import java.util.List;

import model.Client;

public interface ClientDao {

	void         creer( Client client ) throws DaoException;

	Client       trouver( long id ) throws DaoException;
	
    List<Client> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void         update( Client client ) throws DaoException;
   
}