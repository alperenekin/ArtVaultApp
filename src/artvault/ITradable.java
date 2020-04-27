package artvault;

public interface ITradable {
	public boolean isTradable();
	public void tradeToBuyer(Buyer buyer,Seller seller,Artwork artwork);
	public void printForTrade();
}
