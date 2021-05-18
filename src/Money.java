
public class Money {
	private int dollars;
	private int cents;
	
	Money () {
		dollars = 0;
		cents = 0;
	}
	
	Money (int a, int b) {
		dollars = a;
		cents = b;
	}
	
	// getters
	public int getDollars () {
		return dollars;
	}
	
	public int getCents () {
		return cents;
	}
	
	// setters 
	public void setDollars (int d) {
		dollars = d;
	}
	
	public void setCents (int c) {
		cents = c;
	}
	
	
	// other methods
	public boolean equals(Money m) {
		if (m.getDollars() == dollars && m.getCents() == cents) {
			return true;
		}
		return false;
	}
	
	// TODO need to figure this one out
	public Money add (Money m) {
		
		Money newMoney = new Money();
		
		newMoney.setDollars(dollars + m.getDollars());
		newMoney.setCents(cents + m.getCents());
		
		return newMoney;
	}
	
	public String toString () {
		String dollarsAsString = null;
		String centsAsString = null;
		dollarsAsString = dollarsAsString.valueOf(dollars); // String.valueOf(int i). built in java library. converts integer i into a string and returns it as a string.
		centsAsString = centsAsString.valueOf(cents);
		
		return (dollarsAsString + "." + centsAsString);
	
	}

}
