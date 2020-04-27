package artvault;

public class Sculpture extends Artwork{
	private Artist artist;
	private String material;
	private double weight;
	public Sculpture(String name, String style,Artist artist,String material,double weight) {
		super(name, style);
		this.artist=artist;
		this.material=material;
		this.weight=weight;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Object object, int num) { 
		int result=0;
		if(object instanceof Sculpture) {
			 if(num==1) {
				 String name1=this.getName();//Sculpture name1
				 String name2=((Sculpture) object).getName(); //Sculpture name2
				    for (int i = 0; i<name1.length() && i<name2.length(); i++){
				        int a = name1.charAt(i);
				        int b = name2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;
				        }
				        else if(a > b){
				        	result= 1;
				            break;
				        }
				    }
				    return result;
			 }
			 else if(num==2) {
				 String style1=this.getStyle();//Sculpture style1
				 String style2=((Sculpture) object).getStyle();//Sculpture style2
				    for (int i = 0; i<style1.length() && i<style2.length(); i++){
				        int a = style1.charAt(i);
				        int b = style2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;
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
				 String a_name2=((Sculpture) object).getArtist().getName();//artist name2
				    for (int i = 0; i<a_name1.length() && i<a_name2.length(); i++){
				        int a = a_name1.charAt(i);
				        int b = a_name2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;
				        }
				        else if(a > b){
				        	result= 1;
				            break;
				        }
				    }
				    return result;
			 }
			 else if(num==4) {
				 String material1=this.getMaterial();//material1
				 String material2=((Sculpture) object).getMaterial();//material2
				    for (int i = 0; i<material.length() && i<material2.length(); i++){
				        int a = material1.charAt(i);
				        int b = material2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;
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
	public void printInfo() {// prints result info of search operation
		System.out.println("Sculpture:");
		System.out.println("Name: "+this.getName());
		System.out.println("Artist: "+this.getArtist().getName());
		System.out.println("Style: "+this.getStyle());
		System.out.println("Material: "+this.getMaterial());
		System.out.println("Weight: "+this.getWeight()+"kg\n");
	}
	@Override
	public void search(String value) {//Checks whether given string matches with any of attributes in the objects
			String name=this.getName();
			String style=this.getStyle();
			String artist=this.getArtist().getName();
			String material=this.getMaterial();
			if(name.equals(value) || style.equals(value) || artist.equals(value)||material.equals(value)) {
				this.printInfo();
			}
		
		
	}
	
	@Override
	public void calculateCost() {//calculates cost of the paintings
		double price=0;
			if(this.getMaterial().equals("Marble")) {
				price=this.getWeight()*15;
			}
			else if(this.getMaterial().equals("Bronze")) {
				price=this.getWeight()*180;
			}
		this.setCost(price);		
	}
	@Override
	public boolean isTradable() {//checks if it is tradable
		if(this.getStyle().equals("Baroque")) {
			return false;
		}
		return true;
	}
	@Override
	public void tradeToBuyer(Buyer buyer, Seller seller, Artwork artwork) {//trade operation
		if(artwork.isTradable()) {
			buyer.buy(artwork);
			seller.sell(artwork);
		}
		else {
			System.out.println("This item can is not tradable");
		}
	}
	@Override
	public void printForTrade() {//Prints infos for trade
		System.out.println("Scuplture:");
		System.out.println("		Name: "+this.getName());
		System.out.println("		Price: "+this.getCost());
		
	}
	

}
