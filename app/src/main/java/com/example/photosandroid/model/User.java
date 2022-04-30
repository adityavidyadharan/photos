package com.example.photosandroid.model;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * class to store all of user's photos, albums of user and custom tags of user
 * @author Varsini Dhinakran
 * @author Mehraaj Tawa
 */
public class User implements Serializable {
	/**
	 * name of user object
	 */
	protected String name;
	/**
	 * list of all albums user has
	 */
	private List<Album> Albums = new ArrayList<Album>();
	/**
	 * 	list of all unique photos user has
	 */
	private List<Photo> allphotos = new ArrayList<Photo>();
	/**
	 * 	list of all custom tag categories
	 */
	private List<String> tagTypes = new ArrayList<String>();

	/**
	 * constructor to create new user with username name
	 * @param name name of user
	 */
	public User(String name) {
		this.name = name.trim();
		tagTypes.add("People");
		tagTypes.add("Location");
		tagTypes.add("Object");
	}

	/**
	 * constructor for stock user
	 * @param name name of user
	 * @param stock if the user is the stock account
	 */
	public User(String name, boolean stock){
		this.name = name.trim();
		Albums.add(new Album("Stock"));
		tagTypes.add("People");
		tagTypes.add("Location");
		tagTypes.add("Object");

		ObservableList<Photo> ListP = Albums.get(0).getListofPhotos();
		for(Photo p: ListP)
			allphotos.add(p);
	}

	/**
	 * returns name of user
	 * @return returns name of user object
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * returns selected album
	 * @param albumname parameter to identify which album to return
	 * @return returns album object that has the same name field as albumname
	 */
	public Album getAlbum(String albumname){
		for(Album b: Albums){
			if (b.title.equals(albumname))
				return b;
		}
		return null;
	}

	/**
	 * returns number of albums user object has
	 * @return returns integer of the number of albums the user object has
	 */
	public int getNumberofAlbums(){
		return Albums.size();
	}

	/**
	 * returns observable list of albums
	 * @return returns observable list of album objects after converting album array lists into observable lists
	 */
	public ObservableList<Album> getListofAlbums(){
		ObservableList<Album> listofalbums = new ObservableArrayList<>();
		for(int i = 0; i < Albums.size(); i++){
    		listofalbums.add(Albums.get(i));
    	}
		return listofalbums;
	}

	/**
	 * returns observable list of unique photos
	 * @return returns observable list of photo objects after converting array list of allphotos into an observable list
	 */
	public ObservableList<Photo> getListofPhotos(){
		ObservableList<Photo> listofphotos = new ObservableArrayList<>();
		for(int i = 0; i < allphotos.size(); i++){
    		listofphotos.add(allphotos.get(i));
    	}
		return listofphotos;
	}

	/**
	 * adds new album to user
	 * @param albumname creates a new album with a name albumname
	 */
	public void AddAlbum(String albumname) {
		Albums.add(new Album(albumname));
	}

	/**
	 * adds new photo to user
	 * @param photo identifies which photo object to add to array list allphotos
	 */
	public void AddPhoto(Photo photo) {
		allphotos.add(photo);
	}

	/**
	 * deletes photo from user
	 * @param photo identifies which photo object to remove from array list all photos
	 */
	public void deletePhoto(Photo photo) {
		allphotos.remove(photo);
	}

	/**
	 * renmaes selected album object
	 * @param oldAlbumName string of previous album name
	 * @param newAlbumName string for new album name
	 */
	public void renameAlbum(String oldAlbumName, String newAlbumName) {
		Album album = getAlbum(oldAlbumName);
		album.title = newAlbumName;
	}

	/**
	 * delete album object from user
	 * @param albumname identifies album to delete from user object
	 */
	public void DeleteAlbum(String albumname) {
		Album albumToRemove = getAlbum(albumname);
		int index = Albums.indexOf(albumToRemove);
		System.out.println(index);
		Albums.remove(index);
	}

	/**
	 * set custom tags
	 * @param type string to add to array list tag types for custom tag type names of user object
	 */
	public void setTagTypes(String type) {
		String output = type.substring(0, 1).toUpperCase() + type.substring(1);
		if(tagTypes.size() == 0) {
			tagTypes.add(output);
			return;
		}
			for( String s : tagTypes){
				if (s.equals(output))
					return;
			}
			tagTypes.add(output);
		}

	/**
	 * returns observable list of all custom tags
	 * @return returns observable list of tags after converting array list tagTypes to an observable list
	 */
	public ObservableList<String> getTagTypes() {
		ObservableList<String> listoftypes = new ObservableArrayList<>();
		for(int i = 0; i < tagTypes.size(); i++){
    		listoftypes.add(tagTypes.get(i));
    	}
		return listoftypes;
	}

	/**
	 * returns array list of all unique photos
	 * @return returns array list all photos
	 */
	public ArrayList<Photo> getAllPhotos(){
		ArrayList<Photo> all = (ArrayList<Photo>) this.allphotos;
		return all;
	}

}