package artvault;

public class Wallet {
	private double money;
	public Wallet(double money) {
		this.setMoney(money);
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
