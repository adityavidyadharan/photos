package com.example.photosandroid.model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * class to store all users and to save data across sessions
 * @author Varsini Dhinakaran
 * @author Mehraaj Tawa
 */
public class Admin implements Serializable{
	/**
	 *  string of view directory path
	 */
	public static final String storeDir = "src/view";
	/**
	 *  string of admin data file path
	 */
	public static final String storeFile = "admin.dat" ;
	/**
	 * name of admin object
	 */
	private String name = "admin";
	/**
	 *  list of all current users
	 */
	private List<User> users = new ArrayList<User>();

	/**
	 * admin constructor to set Stock user
	 */
	public Admin() {
		users.add(new User("Stock", true));
	}

	/**
	 * returns user based on username
	 * @param username string parameter to check against user arrayList
	 * @return returns user that has the same name as string username parameter
	 */
	public User getUser(String username){
		username = username.trim();
		for(User b: users){
			if (b.name.equals(username))
				return b;
		}
		return null;
	}

	/**
	 * returns number of current users
	 * @return returns integer of number of current users
	 */
	public int getNumberofUsers(){
		return users.size();
	}

	/**
	 * returns observable list of all current users
	 * @return returns observable list of all current users
	 */
	public ObservableList<User> getListofUsers(){
		ObservableList<User> listofusers = new ObservableArrayList<>();
		for(int i = 0; i < users.size(); i++){
    		listofusers.add(users.get(i));
    	}
		return listofusers;
	}

	/**
	 * adds new user
	 * @param name string to create new user and add to user array list
	 */
	public void addUser(String name){
		users.add(new User(name.trim()));
	}

	/**
	 * deletes selected user
	 * @param user string to identify and delete existing user and remove from user array list
	 */
	public void deleteUser(User user)
	{
		User userToRemove = getUser(user.name);
		int index = users.indexOf(userToRemove);
		//System.out.println(index);
		users.remove(index);
	}

}