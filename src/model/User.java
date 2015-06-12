/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.security.MessageDigest;

/**
 *
 * @author Ciprian
 */
public class User {
    
        private int id;
	private String firstname;
	private String lastname;
	private String phone;
        private String email;
	private String username;
	private String password;
	private Role userRole;

    public User() {
        this.id = 0;
        this.firstname = "firstname";
        this.lastname = "lastname";
        this.phone = "phone";
        this.email = "email";
        this.username = "username";
        this.password = "password";
        this.userRole = Role.USER;
    }

    public User(int id, String firstname, String lastname, String phone, String email, String username, String password, Role userRole) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return this.id+ "  "+this.firstname+ "  "+this.lastname+ "  "+this.phone+ "  "+this.email;
    }
        
    private String md5(char[] c){
        try{
            MessageDigest msg = MessageDigest.getInstance("MD5");
            msg.update(new String(c).getBytes("UTF8"));
            String str = new String(msg.digest());
            
            return str;
        }
        catch(Exception ex){
            return "";
        }
    }     
    
}
