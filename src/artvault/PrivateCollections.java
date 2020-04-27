package artvault;

import java.util.ArrayList;

public class PrivateCollections {
	private ArrayList<Artwork> artworks;
	public PrivateCollections() {
		artworks=new ArrayList<Artwork>();
	}
	public PrivateCollections(ArrayList<Artwork> artworks){
		this.artworks=artworks;
	}
	public void addItem(Artwork artwork) {
		artworks.add(artwork);
	}
	public void removeItem(Artwork artwork) {
		artworks.remove(artwork);
	}
	public void calculateArtworkCost() {
		for(Artwork artwork:artworks) {
			artwork.calculateCost();
		}
	}
	public Artwork randomArtwork(){// to choose random artwork from artworks
		boolean tradable=false;
		int randomInt=0;
		while(tradable==false) {
			double randomDouble = Math.random();
			randomDouble = randomDouble * artworks.size()-1 ;
			randomInt = (int) randomDouble;
			if(artworks.get(randomInt).isTradable()) {
				tradable=true;
			}
		}
		return artworks.get(randomInt);
	}
}
