package dao;

import java.util.List;

import model.Orders;

public class OrdersDaoImpl implements OrdersDao {

	void         creer( Orders order ) throws DaoException;

	Orders       trouver( long id ) throws DaoException;
	
	Orders 		 trouverByClientId (long idClient) throws DaoException;
	
    List<Orders> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
	
    void         supprimerByClientId( long idClient ) throws DaoException;
    
    void         update( Orders Orders ) throws DaoException;
   

}
