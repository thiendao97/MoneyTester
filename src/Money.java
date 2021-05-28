
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
	
	public Money add (Money m) {	
		Money newMoney = new Money();
		int totalCents = m.getCents() + cents;
		newMoney.setCents(getRemainderFromCentsOver100(totalCents));
		newMoney.setDollars(dollars + m.getDollars() + getQuotientFromCentsOver100(totalCents));
		return newMoney;
	}
	
	public String toString () {
		String dollarsAsString = null;
		String centsAsString = null;
		dollarsAsString = dollarsAsString.valueOf(dollars); // String.valueOf(int i). built in java library. converts integer i into a string and returns it as a string.
		centsAsString = centsAsString.valueOf(cents);
		return (dollarsAsString + "." + centsAsString);
	}
	
	// This function takes in a multiplier of int m and returns a new Money object multipled by the multiplier
	public Money multiply (int multiplier) { 		
		Money newMoney = new Money();
		int totalCents = cents * multiplier;
		int totalDollars = dollars * multiplier + getQuotientFromCentsOver100(totalCents);
		newMoney.setCents(getRemainderFromCentsOver100(totalCents));
		newMoney.setDollars(totalDollars);
		return newMoney;
	
	}
	
	// This function takes in cents as c. And returns the remainder after % 100.
	public int getRemainderFromCentsOver100 (int c) {
		int remainder = c % 100;
		return remainder;
	}
	
	// This function takes in cents as c. And returns the result of c / 100;
	public int getQuotientFromCentsOver100 (int c) {
		return c / 100;
	}
	
}
