package artvault;


public class Trade {
	private Seller seller;
	private Buyer buyer1;
	private Buyer buyer2;
	private Buyer buyer3;
	private Buyer buyer4;
	private Artwork artwork;
	private Artwork artwork2;
	private Artwork artwork3;
	private Artwork artwork4;
	private Vault vault;

	public Trade() {
		vault=new Vault();
		seller=new Seller(vault.getArtworksList());//give artworks to seller
		buyer1=new Buyer();
		buyer2=new Buyer();
		buyer3=new Buyer();
		buyer4=new Buyer();
		artwork=seller.artworkToSell();
		artwork2=seller.artworkToSell();
		artwork3=seller.artworkToSell();
		artwork4=seller.artworkToSell();
	}
	public void startTrade() {
		System.out.println("Seller's money: "+seller.getWallet());
		System.out.println("Buyer 1's money: "+buyer1.getWallet());
		System.out.println("Buyer 2's money: "+buyer2.getWallet());
		System.out.println("Buyer 3's money: "+buyer3.getWallet());
		System.out.println("Buyer 4's money: "+buyer4.getWallet()+"\nTrade started:");
		artwork.tradeToBuyer(buyer1, seller, artwork);
		System.out.println("Buyer 1 bought:");
		artwork.printForTrade();
		System.out.println("Buyer 2 bought:");
		artwork2.tradeToBuyer(buyer2, seller, artwork2);
		artwork2.printForTrade();
		System.out.println("Buyer 3 bought:");
		artwork3.tradeToBuyer(buyer3, seller, artwork3);
		artwork3.printForTrade();
		System.out.println("Buyer 4 bought:");
		artwork4.tradeToBuyer(buyer4, seller, artwork4);
		artwork4.printForTrade();
		System.out.println("Trade Completed:");
		System.out.println("Seller's money: "+seller.getWallet());
		System.out.println("Buyer 1's money: "+buyer1.getWallet());
		System.out.println("Buyer 2's money: "+buyer2.getWallet());
		System.out.println("Buyer 3's money: "+buyer3.getWallet());
		System.out.println("Buyer 4's money: "+buyer4.getWallet());
	}
}
