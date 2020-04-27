package artvault;

import java.util.ArrayList;

public class Artist extends Person{
	private ArrayList<String> periods;
	public Artist(String name, String birthdate, String deathdate, String nationality) {
		super(name, birthdate, deathdate, nationality);
		periods=new  ArrayList<String>();
	}

public void addPeriod(String Period) {
	periods.add(Period);
}
public void printPeriods() {
	for(String period:periods) {
		System.out.print(period+",");
	}
}

@Override
public int compareTo(Object object, int num) {
	int result=0;
	if(object instanceof Artist) {
		 if(num==1) {
			 String name1=this.getName();
			 String name2=((Artist) object).getName();
			    for (int i = 0; i<name1.length() && i<name2.length(); i++){
			        int a = name1.charAt(i);
			        int b = name2.charAt(i);
			        if(a < b){
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
			 int date1=Integer.parseInt(this.getBirthdate());
			 int date2=Integer.parseInt(((Artist) object).getBirthdate());
			        if(date1 < date2){
			            result = -1;
			        }
			        else if(date1 > date2){
			        	result= 1;
			        }
			    return result;
		 }
		 else if(num==3) {
			 String nationality1=this.getNationality();
			 String nationality2=((Artist) object).getNationality();
			    for (int i = 0; i<nationality1.length() && i<nationality2.length(); i++){
			        int a = nationality1.charAt(i);
			        int b = nationality2.charAt(i);
			        if(a < b){
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
public void printInfo() {//prints necassary info for search operation
	System.out.println("Artist:");
	System.out.println("Name: "+this.getName());
	System.out.println("Born date: "+this.getBirthdate());
	System.out.println("Death date: "+this.getDeathdate());
	System.out.println("Nationality: "+this.getNationality());
	System.out.print("Periods:");
	this.printPeriods();
	System.out.println();
	System.out.println();
}
@Override
public void search(String value) {//Checks whether given string matches with any of attributes in the objects
		String name=this.getName();
		String born=this.getBirthdate();
		String died=this.getDeathdate();
		String nationality=this.getNationality();
		if(name.equals(value) || born.equals(value) || died.equals(value) || nationality.equals(value)){
			this.printInfo();
		}
		for (String period:periods) {
			if(period.equals(value)) {
				this.printInfo();
			}
		}
}

}
