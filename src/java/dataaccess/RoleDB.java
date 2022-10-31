package dataaccess;

/**
 *
 * @author Phi N
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import models.Role;

public class RoleDB {

    public Role getRole(int roleNumber) throws SQLException, NamingException {
        Role role = new Role();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        
        Connection connect = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
        String SQL_script = "SELECT * FROM ROLE WHERE ROLE_ID = ? ";
         
        preparedStatement = connect.prepareStatement(SQL_script);
        preparedStatement.setInt(1, roleNumber);
        resultSet = preparedStatement.executeQuery();
       
        if(resultSet.next()) {
            String roleName = resultSet.getString(2);
            role = new Role(roleNumber, roleName);
        }

        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(preparedStatement);
        connectionPool.freeConnection(connect);
        
        return role;
    }
}
