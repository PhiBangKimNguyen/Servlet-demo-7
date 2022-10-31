package dataaccess;

/**
 *
 * @author Phi N
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;
import services.RoleService;

public class UserDB {

    public List<User> getAll() throws Exception {
        List<User> useresultSet = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Connection connect = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        RoleService roleService = new RoleService();
        String SQL_script = "SELECT * FROM USER";

        preparedStatement = connect.prepareStatement(SQL_script);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String email = resultSet.getString(1);
            String firesultSettName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String password = resultSet.getString(4);
            Role role = roleService.getRole(resultSet.getInt(5));
            User user = new User(email, firesultSettName, lastName, password, role);
            useresultSet.add(user);
        }

        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(preparedStatement);
        connectionPool.freeConnection(connect);
        
        return useresultSet;
    }

    public String insertUser(User user) throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connect = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2;
        ResultSet resultSet;
        String email = user.getEmail();
                 
        String SQL_script = "INSERT INTO user (email, first_name, last_name, password, role) VALUES(?,?,?,?,?)";
        String query = "SELECT * FROM user WHERE email=?";
        if (email.contains("+")) {
            email = email.replace("+", "");
        }
        preparedStatement2 = connect.prepareStatement(query);
        preparedStatement2.setString(1, email);
        resultSet = preparedStatement2.executeQuery();
        int resultSetRowCount = 0;
        
        while (resultSet.next()) resultSetRowCount++;
            
        if (resultSetRowCount <= 1) {
            preparedStatement = connect.prepareStatement(SQL_script);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getRole().getRoleID());
            preparedStatement.executeUpdate();
        } 
           
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(preparedStatement);
        DBUtil.closePreparedStatement(preparedStatement2);
        connectionPool.freeConnection(connect);
        
        return "";
    }

    public User get(String email) throws Exception {
        User user = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        RoleService rService = new RoleService();
        String SQL_script = "SELECT * FROM user WHERE email=?";

        
        preparedStatement = con.prepareStatement(SQL_script);
        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String firesultSettName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String password = resultSet.getString(4);
            Role role = rService.getRole(resultSet.getInt(5));
            user = new User(email, firesultSettName, lastName, password, role);
        }

        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedStatement(preparedStatement);
        connectionPool.freeConnection(con);
       
        return user;
    }

    public void update(User user) throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        
        String SQL_script = "UPDATE USER SET first_name=?, last_name=?, password=?, role=? WHERE email=?";

        preparedStatement = con.prepareStatement(SQL_script);

        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setInt(4, user.getRole().getRoleID());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.executeUpdate();

        DBUtil.closePreparedStatement(preparedStatement);
        connectionPool.freeConnection(con);
        
    }

    public void delete(User user) throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        PreparedStatement preparedStatement;
        String SQL_script = "DELETE FROM USER WHERE EMAIL = ?";
        
        preparedStatement = con.prepareStatement(SQL_script);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.executeUpdate();

        DBUtil.closePreparedStatement(preparedStatement);
        connectionPool.freeConnection(con);
        
    }
}
