package artvault;

import java.util.ArrayList;

public class Seller {
	private Wallet wallet;
	private PrivateCollections collection;
	public Seller(ArrayList<Artwork> artworks) {
		wallet=new Wallet(0);//set seller money as 0
		collection=new PrivateCollections(artworks);
		collection.calculateArtworkCost();
	}
	public double getWallet() {
		return wallet.getMoney();
	}
	public void sell(Artwork artwork) {//Sell given item
		collection.removeItem(artwork);//remove it from the collection of artwork
		wallet.setMoney(wallet.getMoney()+artwork.getCost());//add money to wallet
	}
	public Artwork artworkToSell() {//Chooses which artwork to sell
		return collection.randomArtwork();
	}
	
}
