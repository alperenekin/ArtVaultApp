package artvault;

import java.util.ArrayList;

public class Architecture extends Artwork{
	private ArrayList<Architect> architects;
	private double length;
	private double height;
	private double width;
	public Architecture(String name, String style,double length, double height,double width) {
		super(name, style);
		architects=new ArrayList<Architect>();
		this.length=length;
		this.height=height;
		this.width=width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void addArchitect(Architect arcname) {
		architects.add(arcname);
	}
	public void printarchitects() { //we need architects an architecture to print
		for(int i=0;i<architects.size();i++) {
			System.out.print(architects.get(i).getName()+",");
		}
	}
	public void setExistingArchitect(Architect otherarchitect) {
		for(int i=0;i<architects.size();i++) {
			if(architects.get(i).getName().equals(otherarchitect.getName())) {
				architects.get(i).setBirthdate(otherarchitect.getBirthdate());
				architects.get(i).setDeathdate(otherarchitect.getDeathdate());
				architects.get(i).setNationality(otherarchitect.getNationality());
			}
		}
	}
	public String getelement(int i) {
		String architect_name=architects.get(i).getName();
		return architect_name;
	}
	public int getNumberOfarchitect() {
		return architects.size();
	}
	@Override
	public int compareTo(Object object, int num) {
		int result=0;
		if(object instanceof Architecture) {
			 if(num==1) {
				 String name1=this.getName();//architecture name1
				 String name2=((Architecture) object).getName();//architecture name2
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
				 String style1=this.getStyle();//architecture style1
				 String style2=((Architecture) object).getStyle();//architecture style2
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
			 
		}
		return result;
	}
	public void printInfo() {// prints result info of search operation
		System.out.println("Architecture:");
		System.out.println("Name: "+this.getName());
		System.out.println("Style: "+this.getStyle());
		System.out.print("architects: ");
		this.printarchitects();
		System.out.println("\nDimensions: "+this.getLength()+"cm x " +this.getWidth()+"cm"+this.getHeight()+"cm");
		System.out.println();
	}
	@Override
	public void search(String value) {//Checks whether given string matches with any of attributes in the objects
			String name=this.getName();
			String style=this.getStyle();
			if(name.equals(value) || style.equals(value)){
				this.printInfo();
			}
			for(int i=0;i<this.getNumberOfarchitect();i++) { //checks list of architect seperately
				String architect=this.getelement(i);
				if(architect.equals(value)){
					this.printInfo();
				}
			}		
	}
	
	@Override
	public void calculateCost() { // calculates cost of the archtiecture
		double size=this.getLength()*this.getWidth()*this.getHeight();
		double price=0;
			if(this.getStyle().equals("Gothic")) {
				price=size*1;
			}
			else if(this.getStyle().equals("Baroque")) {
				price=size*0.8;
			}
			else {
				price=size*0.6;
			}
		this.setCost(price);
	}
	@Override
	public boolean isTradable() { // checks if it is tradable
		if(this.getStyle().equals("Rennaissance")) {
			return false;
		}
		return true;
	}
	@Override
	public void tradeToBuyer(Buyer buyer, Seller seller, Artwork artwork) { //Trade operation starts here
		if(artwork.isTradable()) {
			buyer.buy(artwork);
			seller.sell(artwork);
		}
		else {
			System.out.println("This item can is not tradable");
		}
	}
	@Override
	public void printForTrade() {//prints necessary info after trade
		System.out.println("Architecture:");
		System.out.println("		Name: "+this.getName());
		System.out.println("		Price: "+this.getCost());	
	}
}
