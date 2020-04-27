package artvault;
public class Painting extends Artwork{
	private Artist artist;
	private double width;
	private double length;
	public Painting(String name, String style,Artist artist,double width,double length) {
		super(name, style);
		this.artist=artist;
		this.width=width;
		this.length=length;
	}
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public int compareTo(Object object, int num) {
		int result=0;
		if(object instanceof Painting) {
			 if(num==1) {
				 String name1=this.getName();//painting name1
				 String name2=((Painting) object).getName();//painting name2
				    for (int i = 0; i<name1.length() && i<name2.length(); i++){//it should check in the larger string length
				        int a = name1.charAt(i);
				        int b = name2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;//stop if you find a result
				        }
				        else if(a > b){
				        	result= 1;
				            break;
				        }
				    }
				    return result;
			 }
			 else if(num==2) {
				 String style1=this.getStyle();//painting style1
				 String style2=((Painting) object).getStyle();//painting style2
				    for (int i = 0; i<style1.length() && i<style2.length(); i++){
				        int a = style1.charAt(i);
				        int b = style2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;//stop if you find a result
				        }
				        else if(a > b){
				        	result= 1;
				            break;		            
				        }
				    }
				    return result;
			 }
			 else if(num==3) {
				 String a_name1=this.getArtist().getName();//artist name1
				 String a_name2=((Painting) object).getArtist().getName();//artist name2
				    for (int i = 0; i<a_name1.length() && i<a_name2.length(); i++){//it should check in the larger string length
				        int a = a_name1.charAt(i);
				        int b = a_name2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;//stop if you find a result
				        }
				        else if(a > b){
				        	result= 1;
				            break;
				        }
				    }
				    return result;
			 }
			 
		}
		return result;
	}
	public void printInfo() {//prints result info of search operation
		System.out.println("Painting:");
		System.out.println("Name: "+this.getName());
		System.out.println("Style: "+this.getStyle());
		System.out.println("artist: "+this.getArtist().getName());
		System.out.println("Dimensions: "+this.getLength()+"cm x " +this.getWidth()+"cm"+"\n");
	}
	@Override
	public void search(String value) {//Checks whether given string matches with any of attributes in the objects
			String name=this.getName();
			String style=this.getStyle();
			String artist=this.getArtist().getName();
			if(name.equals(value) || style.equals(value) || artist.equals(value)) {
				this.printInfo();
			}
	}

	@Override
	public void calculateCost() {//calculates cost of the paintings
		double size=this.getLength()*this.getWidth();
		double price=0;
			if(this.getStyle().equals("Renaissance")) {
				price=size*7;
			}
			else if(this.getStyle().equals("Baroque")) {
				price=size*5.5;
			}
			else {
				price=size*4.5;
			}
		this.setCost(price);
	}
	@Override
	public boolean isTradable() {//checks if it is tradable
		if(this.getStyle().equals("Gothic")) {
			return false;
		}
		return true;
	}
	@Override
	public void tradeToBuyer(Buyer buyer,Seller seller,Artwork artwork) {
		if(artwork.isTradable()) {
			buyer.buy(artwork);
			seller.sell(artwork);
		}
		else {
			System.out.println("This item can is not tradable");
		}
	}
	@Override
	public void printForTrade() {//prints necessary infos for trade operation
		System.out.println("Painting:");
		System.out.println("		Name: "+this.getName());
		System.out.println("		Price: "+this.getCost());
		
	}
	
	
}
