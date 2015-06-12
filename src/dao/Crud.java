/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import model.User;

/**
 *
 * @author Ciprian
 */
public interface Crud {
    
        public  abstract int Login(String username,String password) throws ClassNotFoundException, SQLException;
	public  abstract User selectID(int ID) throws  SQLException, ClassNotFoundException;
	public abstract void Add( User user) throws ClassNotFoundException, SQLException;
	public abstract void Remove(String user_nume, String user_prenume) throws SQLException;
    
}
