package customFinalClass;

/*
 * This class is immutable
 * The internal variables are final and are read-only
 * 
 * After construction it cannot be changed and so it can be published over multiple threads
 * 
 */

public class ImmutableObjectExample {
	
	private final String currency;
	private final int money;
	
	ImmutableObjectExample(String currency, int money) {
		this.currency = currency;
		this.money = money;
	}
	
	public void printMoney() {
		System.out.println(currency + ", " + money);
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
	public int getMoney() {
		return this.money;
	}
	
}
