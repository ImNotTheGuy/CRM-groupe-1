package dao;

import java.util.List;

import model.Orders;

public interface OrdersDao {

	void         creer( Orders order ) throws DaoException;

	Orders       trouver( long id ) throws DaoException;
	
	List<Orders> 		 trouverByClientId (long idClient) throws DaoException;
	
    List<Orders> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
	
    void         supprimerByClientId( long idClient ) throws DaoException;
    
    void         update( Orders order ) throws DaoException;
   

}
