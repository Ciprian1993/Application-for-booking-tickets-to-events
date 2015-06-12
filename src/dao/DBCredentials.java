/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author Ciprian
 */
public class DBCredentials {
    
    public final static String URL="jdbc:mysql://localhost:3306/eventdb";
	public final static String USERNAME="root";
	public final static String PASSWORD="E@gl3x";
	
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	} 
    
}
