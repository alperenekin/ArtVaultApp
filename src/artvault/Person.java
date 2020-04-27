package artvault;

public abstract class Person implements IComparable,ISearchable{
	private String name;
	private String birthdate;
	private String deathdate;
	private String nationality;
	public Person(String name,String birthdate,String deathdate,String nationality){
		this.name=name;
		this.birthdate=birthdate;
		this.deathdate=deathdate;
		this.nationality=nationality;
	}
	public Person(String name) {
		this.name=name;
		this.birthdate=null;
		this.deathdate= null;
		this.nationality=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String  birthdate) {
		this.birthdate = birthdate;
	}
	public String  getDeathdate() {
		return deathdate;
	}
	public void setDeathdate(String  deathdate) {
		this.deathdate = deathdate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
