package com.example.photosandroid.model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 

/**
 * class for methods used by all files
 * @author Varsini Dhinakaran
 * @author Mehraaj Tawa
 */
public class AppDatabase implements Serializable{
	
	/**
	 * stores directory of view package path
	 */
	public static final String storeDir = "photos44/src/view";
	/**
	 * stores path of data file admin.txt
	 */
	public static final String storeFile = "admin.txt" ;
	/**
	 * user object that identifies user currently using photos
	 */
	public static User currentuser;
	/**
	 * album object identifying current album open in photos
	 */
	public static Album currentalbum;
	/**
	 * admin that is running all users
	 */
	public static Admin admin;
	/**
	 * path of photo that is selected in photos
	 */
	public static String currentpath; 
	
	/**
	 * serializes data
	 * @throws ClassNotFoundException identifies class not found exceptions
	 * @throws IOException identifies input/output exceptions
	 */
	public static void start() throws ClassNotFoundException, IOException {
		//admin = new admin();
		// ******************** Uncomment line below and comment line above to activate serialization
		admin = readApp();  
	}
	
	/**
	 * serializes data
	 * @param admin passes admin object 
	 * @throws IOException identifies input/output exceptions
	 */
	public static void writeApp(Admin admin)
		throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storeDir + File.separator + storeFile));
		oos.writeObject(admin);
	}
	
	/**
	 * reads serialized data
	 * @return returns admin object after reading serializable data
	 * @throws IOException identifies input/output exceptions
	 * @throws ClassNotFoundException identifies class not found exceptions
	 */
	public static Admin readApp()
		throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(
		new FileInputStream(storeDir + File.separator + storeFile));
		Admin admin = (Admin)ois.readObject();
		return admin;
	}
	
	/**
	 * serializes data
	 * @throws IOException identifies input/output exceptions
	 */
	public static void save() throws IOException { 
		writeApp(admin);		
	}
	
	/**
	 * compares the date of new photo object with smallest and largest dates of album object
	 * @param albumName identifies album to compare smallest and largest dates
	 * @param date1 the new date that is being compared
	 * @throws ParseException identifies parse exceptions
	 */
	public static void compareDate(String albumName, String date1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Album a = AppDatabase.currentuser.getAlbum(albumName);
		Date smallest = sdf.parse(a.getSmallestDate());
		Date biggest = sdf.parse(a.getLargestDate());
		Date Date1 = sdf.parse(date1);
		if(smallest.compareTo(Date1) > 0) {
	        String date = sdf.format(Date1);
			a.setSmallestDate(date);
		}
		if(biggest.compareTo(Date1) < 0) {
	        String date = sdf.format(Date1);
			a.setLargestDate(date);
		}
	}

	/**
	 * sets the path of selected photos
	 * @param absolutePath path of photo that is selected
	 */
	public static void setcurrentpath(String absolutePath) {
		currentpath = absolutePath;
	}
		
}
	
