package models;

import java.io.Serializable;

/**
 *
 * @author Phi N
 */
public class User implements Serializable{
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    
    /**
     * Constructor
     */
    public User() {}
    
    /**
     * Constructor
     * @param email
     * @param firstName
     * @param lastName
     * @param password
     * @param role 
     */
    public User(String email, String firstName, String lastName, String password, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }
    
    /**
     * Getter method of Email. 
     * @return email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Setter method of Email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Getter method
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Getter method
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Setter method
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Getter method
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Setter method
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Getter method
     * @return role
     */
    public Role getRole() {
        return role;
    }
    
    /**
     * Setter method
     * @param role 
     */
    public void setRole(Role role) {
        this.role = role;
    } 
}
