package artvault;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	private ArrayList<String> p_artists=new ArrayList<String>(); //this list keeps name of artist of a painting
	private ArrayList<String> s_artists=new ArrayList<String>();//this list keeps name of artist of a sculpture
	private Architect architect;
	
	public void fillPaintingsWithArtist(ArrayList<Artist> artists,ArrayList<Painting> paintings) {//artists names of paintings are stored in p_artists,then they found from artists arraylist and their object setted in painting.
		for(int i=0;i<p_artists.size();i++) {
			for(Artist artist:artists) {
				if(artist.getName().equals(p_artists.get(i))) {
					paintings.get(i).setArtist(artist);
					break;
				}
			}
		}
	}
	public void fillSculpturesWithArtist(ArrayList<Artist> artists,ArrayList<Sculpture> sculptures) {//artists name of sculptures are stored in s_artist,then they found from sculptures arraylist and their object setted in sculpture
		for(int i=0;i<s_artists.size();i++) {
			for(Artist artist:artists) {
				if(artist.getName().equals(s_artists.get(i))) {
					sculptures.get(i).setArtist(artist);
					break;
				}
			}
		}
	}
	public void setArchitectsInfo(ArrayList<Architect> architects,ArrayList<Architecture> architectures) {
		for(Architect architect:architects) {
			for(Architecture architecture:architectures) {
				architecture.setExistingArchitect(architect);
			}
		}
	}
	public void readCsv(ArrayList<Painting> paintings,ArrayList<Sculpture> sculptures,ArrayList<Architecture> architectures,ArrayList<Artist> artists,ArrayList<Architect> architects,ArrayList<Artwork> artworks) { 
		 File file =new File("CENG211_HW2_ArtVaultData.csv");
		 String[] values;
		 try {
				Scanner inputStream=new Scanner(file);
				while(inputStream.hasNext()) {
					String data=inputStream.nextLine(); 
					values=data.split(",");// the line is splitted
					if(Integer.parseInt(values[0])==1) {
						Painting painting=new Painting(values[1],values[2],null,Integer.parseInt(values[4]),Integer.parseInt(values[5]));
						paintings.add(painting);
						artworks.add(painting);
						p_artists.add(values[3]);
					}
					else if(Integer.parseInt(values[0])==2) {
						Sculpture sculpture=new Sculpture(values[1],values[2],null,values[4],Double.parseDouble(values[5]));
						sculptures.add(sculpture);
						artworks.add(sculpture);// we should keep the list of artworks
						s_artists.add(values[3]);//artist names in sculptures should be kept
					}
					else if(Integer.parseInt(values[0])==3) {
						Architecture architecture=new Architecture(values[1],values[2],Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5]));
						architectures.add(architecture);
						artworks.add(architecture);
						for(int i=6;i<values.length;i++){ //after 5th element of line the rest are architect info
							architect = new Architect(values[i]);//new architect object created by using name
							architecture.addArchitect(architect);//architectures stored in a arraylist
						}

					}
					else if(Integer.parseInt(values[0])==4) {
						Artist artist=new Artist(values[1],values[2],values[3],values[4]);
						artists.add(artist);
						for(int i=5;i<values.length;i++) {//after 4th element of line the rest are period info and they will be stored in arraylist in artist object.
							artist.addPeriod(values[i]);
						}
					}
					else if(Integer.parseInt(values[0])==5) {
						String name=values[1];
						String  birthdate=values[2];
						String  deathdate=values[3];
						String nationality=values[4];
						architect=new Architect(name,birthdate,deathdate,nationality);
						architects.add(architect);
					}

				} 
				inputStream.close();
				fillPaintingsWithArtist(artists,paintings);
				fillSculpturesWithArtist(artists,sculptures);
				setArchitectsInfo(architects,architectures);
		 }
		 
		 catch (FileNotFoundException e) {
					e.printStackTrace();
		}
		
		 
			
	}

}
