package com.example.photosandroid.model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * album class to store list of photos, album date range and album name
 * @author Varsini Dhinakaran
 * @author Mehraaj Tawa
 */
public class Album implements Serializable{
	/**
	 *  list of all photo objects in album
	 */
	private List<Photo> Photos = new ArrayList<Photo>();
	/**
	 *  name of the album
	 */
	protected String title; 
	/**
	 *  date of album
	 */
	protected String date; 
	/**
	 *  date of earliest photo
	 */
	private String smallestDate; 
	/**
	 *  date of latest photo
	 */
	private String LargestDate;
	
	/**
	 * constructor also creates stock album with 5 default photos
	 * @param albumname create new album with albumname as it's name field
	 */
	public Album(String albumname) {
		title = albumname.trim(); 
		if(albumname.equals("Stock")){
			Photo s1 = new Photo(1);
			Photo s2 = new Photo(2);
			Photo s3 = new Photo(3);
			Photo s4 = new Photo(4);
			Photo s5 = new Photo(5);
			Photos.add(s1);
			Photos.add(s2);
			Photos.add(s3);
			Photos.add(s4);
			Photos.add(s5);
		}
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    date = formatter.format(currentDate); 
	    this.smallestDate = "99/99/9999 99:99:99";
	    this.LargestDate = "00/00/0000 00:00:00";
	}
	/**
	 * populates photo array list
	 * @param photo copies photo into photo array list of album
	 */
	public void populatePhotoList(ArrayList<Photo> photo){
		this.Photos = photo;
	}
	
	/**
	 * returns name of album
	 * @return returns name of the album
	 */
	public String getName(){
		return this.title; 
	}
	
	/**
	 * get image from file object
	 * @param picture file passed to determine which photo to return
	 * @return returns photo object based on if the parameter picture matches the photo object's file
	 */
	public Photo getPhoto(File picture){
		for(Photo b : Photos){
			if ( picture.equals(b.getFile()))
				return b;
		}
		return null; 
	}
	
	/**
	 * gets image using path
	 * @param path string path to identify which photo object to return
	 * @return returns photo object that has a file with a path equal to parameter path
	 */
	public Photo getPhotoByPath(String path){
		for(Photo b : Photos){
			if ( path != null && path.equals(b.getpath()))
				return b;
		}
		return null; 
	}
	
	/**
	 * returns photo array size
	 * @return returns size of photo array list
	 */
	public int getNumberofphotos(){
		return Photos.size();
	}
	
	/**
	 * returns observable list of photos
	 * @return returns observable list of photos that has been converted from photo array list
	 */
	public ObservableList<Photo> getListofPhotos(){
		ObservableList<Photo> listofphotos = new ObservableArrayList<>();
		for(int i = 0; i < Photos.size(); i++){
    		listofphotos.add(Photos.get(i));
    	}
		return listofphotos; 
	} 
	
	/**
	 * adds photo to photo array
	 * @param photo add photo object into photo array list of album
	 */
	public void addPhoto(Photo photo){
		Photos.add(photo);
	}
	
	/**
	 * deletes photo from photo array
	 * @param photo deletes photo object from photo array list of album
	 */
	public void deletePhoto(Photo photo){
		Photos.remove(photo);
	}
	
	/**
	 * returns earliest photo date
	 * @return returns string of the smallest date of a photo in the album
	 */
	public String getSmallestDate() {
		return this.smallestDate;
	}
	
	/**
	 * returns latest photo date
	 * @return returns string of the largest date of a photo in the album
	 */
	public String getLargestDate() {
		return this.LargestDate;
	}
	
	/**
	 * sets earliest photo date
	 * @param date sets string date as the smallest date of a photo in the album
	 */
	public void setSmallestDate(String date) {
		this.smallestDate = date;
	}
	
	/**
	 * sets latest photo date
	 * @param date sets string date as the largest date of a photo in the album
	 */
	public void setLargestDate(String date) {
		this.LargestDate = date;
	}
	
}