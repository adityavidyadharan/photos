package com.example.photosandroid.model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * class to store image files, path of image, tags to correspond to each image, date of image, and the caption for each image
 * @author Varsini Dhinakaran
 * @author Mehraaj Tawa
 */
public class Photo implements Serializable{
	/**
	 * file containing image
	 */
	protected File image;
	/**
	 * string containing path of file object
	 */
	protected String path;
	/**
	 * all tags associated with the photo object
	 */
	private List<String> tags = new ArrayList<String>();
	/**
	 * 	last modified date of file object
	 */
	private String date;
	/**
	 * 	caption associated with photo object
	 */
	private String caption;

	/**
	 * constructor to create new photo object
	 *
	 * @param img sets new photo object file as img
	 * @param dte sets new photo object date as dte
	 * @param cap sets new photo object caption as cap
	 */
	public Photo(File img, String dte, String cap){
		this.image = img;
		this.date = dte;
		this.caption = cap;
	}
	/**
	 * no args constructor
	 */
	public Photo() {

	}

	/**
	 * Constructor for stock user default pictures
	 * @param x selects which default images are loaded
	 */
	public Photo(int x){
		switch (x) {
		case 1:
		image = new File("src/data/image1.jpg");
		path = image.getAbsolutePath();
		caption = "#1";
		SimpleDateFormat d = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    date = d.format(image.lastModified());
		break;
		case 2:
			image = new File("src/data/image2.jpg");
			path = image.getAbsolutePath();
			caption = "#2";
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    date = sdf.format(image.lastModified());
			break;
		case 3:
			image = new File("src/data/image3.png");
			path = image.getAbsolutePath();
			caption = "#3";
			SimpleDateFormat sdd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    date = sdd.format(image.lastModified());
			break;
		case 4:
			image = new File("src/data/image4.jpg");
			path = image.getAbsolutePath();
			caption = "#4";
			SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    date = s.format(image.lastModified());
			break;
		case 5:
			image = new File("src/data/image5.jpg");
			path = image.getAbsolutePath();
			caption = "#5";
			SimpleDateFormat sde = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    date = sde.format(image.lastModified());
			break;

		}

	}

	/**
	 * returns image file
	 * @return returns file object in photo object
	 */
	public File getFile(){
		return this.image;
	}

	/**
	 * adds tag to photo
	 * @param tag adds string tag to tag array list of photo
	 */
	public void addTag(String tag){
		String output = tag.substring(0, 1).toUpperCase() + tag.substring(1);
		tags.add(output);
	}

	/**
	 * clears selected tag from photo
	 * clears tag array lost of photo object
	 */
	public void clearTag(){
		tags = new ArrayList<String>();
	}

	/**
	 * set new image file to photo
	 * @param image sets photo object's file as a new file
	 */
	public void setFile(File image){
		this.image = image;
	}

	/**
	 * sets path of photo
	 * @param path sets photo object's path as new path
	 */
	public void setpath(String path){
		this.path = path;
	}

	/**
	 * returns path of photo
	 * @return returns path of file in photo object
	 */
	public String getpath(){
		return path;
	}

	/**
	 * sets date of photo object
	 * @param date sets date of photo object as new date
	 */
	public void setDate(String date){
		this.date = date;
	}

	/**
	 * returns data of photo object
	 * @return returns date of photo object
	 */
	public String getDate(){
		return date;
	}

	/**
	 * sets caption of photo object
	 * @param caption sets caption of photo object as new string caption
	 */
	public void setCaption(String caption){
		this.caption = caption;
	}

	/**
	 * returns caption of photo object
	 * @return returns caption of photo object
	 */
	public String getCaption(){
		return this.caption;
	}

	/**
	 * returns observable list of tags
	 * @return returns observable list after converting array list of tags into an observable list
	 */
	public ObservableList<String> getTags() {
		ObservableList<String> listoftypes = new ObservableArrayList<>();
		for(int i = 0; i < tags.size(); i++){
    		listoftypes.add(tags.get(i));
    	}
		return listoftypes;
	}

}
