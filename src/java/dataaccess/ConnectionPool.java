package dataaccess;

/**
 *
 * @author Phi N
 */
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() throws NamingException {      
        InitialContext initContext = new InitialContext();
        dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/userdb");   
    }

    public static synchronized ConnectionPool getInstance() throws NamingException {
        if (pool == null) pool = new ConnectionPool();        
        return pool;
    }

    public Connection getConnection() throws SQLException {      
        return dataSource.getConnection();    
    }

    public void freeConnection(Connection c) throws SQLException {
        c.close();   
    } 
}
