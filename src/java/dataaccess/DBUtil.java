package dataaccess;

/**
 *
 * @author Phi N
 */
import java.sql.*;

public class DBUtil {
    public static void closePreparedStatement(Statement statement) throws SQLException {      
        if (statement != null) statement.close();     
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();              
    }
}
