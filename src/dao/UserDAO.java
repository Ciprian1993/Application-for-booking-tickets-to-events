/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MD5;
import model.Role;
import model.User;

/**
 *
 * @author Ciprian
 */
public class UserDAO implements Crud{
    
    @Override
    public int Login(String username, String password) throws ClassNotFoundException, SQLException {
   
                Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection(DBCredentials.URL,DBCredentials.USERNAME,DBCredentials.PASSWORD);
	       
	        String sql="select l.id from Login l, Users u  where l.id=u.id and l.username=? and l.password=?;";
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setString(1, username);
                state.setString(2, MD5.getCode(password));

	        
	       ResultSet set = state.executeQuery();
	       if(set.next())
		return set.getInt(1);
	       else return -1;
        
    }

    @Override
    public User selectID(int ID) throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(DBCredentials.URL,DBCredentials.USERNAME,DBCredentials.PASSWORD);
       
        String sql="select * from Users where id=? ;";
        PreparedStatement state = con.prepareStatement(sql);
        state.setInt(1, ID);
        User user = new User();
        ResultSet set = state.executeQuery();
       
       if(set.next()){
    	   user = new User();
    	   user.setId(set.getInt("id"));
    	   user.setFirstname(set.getString("firstname"));
    	   user.setLastname(set.getString("lastname"));
    	   user.setPhone(set.getString("phone")); 
           user.setEmail(set.getString("email")); 
    	   user.setUserRole(Role.getById(set.getInt("idRole")));
    	   System.out.println(user.toString());
       }
   
        
        state.close();
        con.close();
        set.close();
      
 
		return user;
        
    }


    @Override
    public void Add(User user) throws ClassNotFoundException, SQLException {
      
        Class.forName("com.mysql.jdbc.Driver");        
        Connection con=DriverManager.getConnection(DBCredentials.URL,DBCredentials.USERNAME,DBCredentials.PASSWORD);     
	       
                String sql="insert into Login values ( ? ,? ,?);";
	        PreparedStatement state = con.prepareStatement(sql);
	        state.setInt(1, user.getId());
	        state.setString(2, user.getUsername());
	        state.setString(3, MD5.getCode(user.getPassword()));
	        state.execute();
                
	        sql = " insert into Users values(?,?,?,?,?,?)";
	        state = con.prepareStatement(sql);
	        state.setInt(1, user.getId());
	        state.setString(2,user.getFirstname());
	        state.setString(3,user.getLastname());
	        state.setString(4, user.getPhone());
	        state.setString(5, user.getEmail());
	        state.setInt(6, user.getUserRole().getId());
	        System.out.println(user.toString());
	        state.execute();
        
    }
    
    
     @Override
     public void Remove(String user_nume, String user_prenume) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
