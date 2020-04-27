package artvault;

import java.util.ArrayList;

public class Vault {
	private ArrayList<Painting> paintings=new ArrayList<Painting>();
	private ArrayList<Sculpture> sculptures=new ArrayList<Sculpture>();
	private ArrayList<Architecture> architectures=new ArrayList<Architecture>();
	private ArrayList<Artist> artists=new ArrayList<Artist>();
	private ArrayList<Architect> architects=new ArrayList<Architect>();
	private ArrayList<Artwork> artworks=new ArrayList<Artwork>();
	private SelectionSort selectionsort=new SelectionSort();
	public Vault() {
		FileIO reader=new FileIO();
		reader.readCsv(paintings,sculptures,architectures,artists,architects,artworks);
	}
	public ArrayList<Artwork> getArtworksList() {
		  return new ArrayList<Artwork>(artworks);
	}
	public void defaultSort() { //sort everything by name
		selectionsort.sort(artists, artists.size(),1);
		selectionsort.sort(architects, architects.size(),1);
		selectionsort.sort(paintings, paintings.size(),1);
		selectionsort.sort(sculptures, sculptures.size(),1);
		selectionsort.sort(architectures, architectures.size(),1);
	}
	public void sortArtists(int input) { //for artist in sort 1 means by name,2 means birthday 3 means nationality
		if(input==1) {
			selectionsort.sort(artists, artists.size(),1);
		}
		else if(input==2) {
			selectionsort.sort(artists, artists.size(),2);
		}
		else if(input==3) {
			selectionsort.sort(artists, artists.size(),3);
		}
		for(Artist artist:artists) {
			artist.printInfo();
		}
	}
	public void sortArchitects(int input) { //for archtiects sort 1 means by name,2 means birthday,3means nationality
		if(input==1) {
			selectionsort.sort(architects, architects.size(),1);
		}
		else if(input==2) {
			selectionsort.sort(architects, architects.size(),2);
		}
		else if(input==3) {
			selectionsort.sort(architects, architects.size(),3);
		}
		for(Architect architect:architects) {
			architect.printInfo();
		}
	}
	public void sortPaintings(int input) {//for paintings sort 1 means by name,2 means style,3 means artist
		if(input==1) {
			selectionsort.sort(paintings, paintings.size(),1);
		}
		else if(input==2) {
			selectionsort.sort(paintings, paintings.size(),2);
		}
		else if(input==3) {
			selectionsort.sort(paintings, paintings.size(),3);
		}
		for(Painting painting:paintings) {
			painting.printInfo();
		}
	}
	public void sortSculptures(int input) {//for sculptures sort 1 means by name, 2 means by style, 3 means by artist ,4 means material
		if(input==1) {
			selectionsort.sort(sculptures, sculptures.size(),1); 
		}
		else if(input==2) {
			selectionsort.sort(sculptures, sculptures.size(),2);
		}
		else if(input==3) {
			selectionsort.sort(sculptures, sculptures.size(),1);
		}
		else if(input==4) {
			selectionsort.sort(sculptures, sculptures.size(),4);
		}
		for(Sculpture sculpture:sculptures) {
			sculpture.printInfo();
		}
	}
	public void sortArchitectures(int input) { // for architectures sort 1 means by name,2 means stlye 
		if(input==1) {
			selectionsort.sort(architectures, architectures.size(),1);
		}
		else if(input==2) {
			selectionsort.sort(architectures, architectures.size(),2);
		}
		for(Architecture architecture:architectures) {
			architecture.printInfo();
		}
	}
	public void searchKeyword(String keyword) {//searches given key in every information
		for(Architecture architecture:architectures) {
			architecture.search(keyword);
		}
		for(Sculpture sculpture:sculptures) {
			sculpture.search(keyword);
		}
		for(Artist artist:artists) {
			artist.search(keyword);
		}
		for(Architect architect:architects) {
			architect.search(keyword);
		}
		for(Painting painting:paintings) {
			painting.search(keyword);
		}
	}
}
