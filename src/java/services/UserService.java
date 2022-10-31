package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Phi N
 */
public class UserService {

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public String insert(String email, String firstname, String lastname, String password, String role) throws Exception {
        String insertMessage;
        int roleID;
        switch (role) {
            case "system admin":
                roleID = 1;
                break;
            case "regular user":
                roleID = 2;
                break;
            default:
                return "";
        }
        User user = new User(email, firstname, lastname, password, new Role(roleID, role));
        UserDB userDB = new UserDB();
        insertMessage = userDB.insertUser(user);
        return insertMessage;
    }

    public void update(String email, String firstname, String lastname, String password, String role) throws Exception {
        int roleID;
        switch (role) {
            case "system admin":
                roleID = 1;
                break;
            case "regular user":
                roleID = 2;
                break;
            default:
                return;
        }     
        User user = new User(email, firstname, lastname, password, new Role(roleID, role));
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
