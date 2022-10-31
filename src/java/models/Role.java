package models;

import java.io.Serializable;

/**
 *
 * @author Phi N
 */
public class Role implements Serializable{
    private int roleID;
    private String roleName;
    
    /**
     * Constructor
     */
    public Role() {}
    
    /**
     * Constructor
     * @param roleID
     * @param roleName 
     */
    public Role(int roleID, String roleName){
        this.roleID = roleID;
        this.roleName = roleName;
    }
    
    /**
     * Getter method
     * @return roleID
     */
    public int getRoleID(){
        return roleID;
    }
    
    /**
     * Setter method
     * @param roleID 
     */
    public void setRoleID(int roleID){
        this.roleID = roleID;
    }
    
    /**
     * Getter method
     * @return roleName
     */
    public String getRoleName(){
        return roleName;
    }
    
    /**
     * Setter method
     * @param roleName 
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
}