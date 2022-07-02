package dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 5268445984582596463L;

    public DaoException( String message ) {
        super( message );
    }

    public DaoException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DaoException( Throwable cause ) {
        super( cause );
    }

}
