/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Ciprian
 */
public enum Role {
 
    USER(1),
    ADMINISTRATOR(2);
    
    
    	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int id;
	
	Role(int id){
		this.id=id;
	}
	
	public static Role getById(int id){
		for(Role value:Role.values()){
			if(value.id==id){
				return value;
			}
		}
		return null;
	}
        
	public static int getByString(String rol){
		for(Role rol1:Role.values())
			if(rol1.toString().equals(rol))
				return rol1.id;
		return -1;
	}
    
}
