package artvault;

public class Architect extends Person{

	public Architect(String name, String  birthdate, String  deathdate, String nationality) {
		super(name, birthdate, deathdate, nationality);
	}
	public Architect(String name) {
		super(name);
	}
	@Override
	public int compareTo(Object object, int num) {
		int result=0;
		if(object instanceof Architect) {
			 if(num==1) {
				 String name1=this.getName();//architect name1
				 String name2=((Architect) object).getName();//architect name2
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
				 int date1=Integer.parseInt(this.getBirthdate());//architect 1 born date
				 int date2=Integer.parseInt(((Architect) object).getBirthdate());//architect2 born date
				    	if(date1 < date2){
				            result = -1;
				        }
				        else if(date1 > date2){
				        	result= 1;
				        }
				    return result;
			 }
			 else if(num==3) {
				 String nationality1=this.getNationality();//architect nationality1
				 String nationality2=((Architect) object).getNationality();//architect nationality2
				    for (int i = 0; i<nationality1.length() && i<nationality2.length(); i++){
				        int a = nationality1.charAt(i);
				        int b = nationality2.charAt(i);
				        if(a < b){//compare integer values of chars
				            result = -1;
				            break;				        }
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
	public void printInfo() { //prints result info of search operation
		System.out.println("\narchitect:");
		System.out.println("Name: "+this.getName());
		System.out.println("Born date: "+this.getBirthdate());
		System.out.println("Death date: "+this.getDeathdate());
		System.out.println("Nationality: "+this.getNationality()+"\n");
	}
	@Override
	public void search(String value) {//Checks whether given string matches with any of attributes in the objects
			String name=this.getName();
			String born=this.getBirthdate();
			String died=this.getDeathdate();
			String nationality=this.getNationality();
			if(name.equals(value) || born.equals(value) || died.equals(value) || value.equals(nationality)){
				this.printInfo();
			}
	
	}

}
