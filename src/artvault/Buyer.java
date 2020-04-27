package artvault;

public class Buyer {
	private Wallet wallet;	
	private PrivateCollections collection;
	public Buyer(){
		wallet=new Wallet(5000000);
		collection=new PrivateCollections();
	}
	public void buy(Artwork artwork) { //when buyer buys something ,it should be added to collection and his wallet should be updated
		collection.addItem(artwork);
		wallet.setMoney(wallet.getMoney()-artwork.getCost());
	}
	public double getWallet() {
		return wallet.getMoney();
	}

}
