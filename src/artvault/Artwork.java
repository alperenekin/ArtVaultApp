package artvault;
/* Alperen Ekin-230201010 
 * Berk Bildirici-230201049
 * 
 * */
public abstract class Artwork implements IComparable,ISearchable,ITradable{
	private String name;
	private String style;
	private double cost;
	public Artwork(String name,String style) {
		this.setName(name);
		this.setStyle(style);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public abstract void calculateCost();
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
