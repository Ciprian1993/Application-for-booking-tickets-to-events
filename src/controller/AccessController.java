/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.UserDAO;
import java.sql.SQLException;
import model.Role;
import model.User;

/**
 *
 * @author Ciprian
 */
public class AccessController {
    
     private static  UserDAO user=new UserDAO();
		

	public static User getUser(String username,String password) throws SQLException, ClassNotFoundException{
		
		User temp=null;
                int id = user.Login(username, password);
         if(id!=-1) temp=user.selectID(id);
		
		return temp;
	}
        
	public static void setUser(int user_id , String user_firstnume, String user_lastname,String user_phone ,String user_email, String username ,String password, Role role) throws ClassNotFoundException, SQLException{
		
		User temp=new User();
		temp.setId(user_id); 
		temp.setFirstname(user_firstnume);
		temp.setLastname(user_lastname);
		temp.setPhone(user_phone);
		temp.setEmail(user_email);
		temp.setUsername(username);
                temp.setPassword(password); 
		temp.setUserRole(role);
		System.out.println(temp.toString());
		user.Add(temp);
	}
	
	public static void deleteUser(String user_nume, String user_prenume) throws SQLException{
		
		user.Remove(user_nume, user_prenume);
	}
    
    
}
