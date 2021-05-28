
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
	
	public Money multiply (Money m) { //need to fix multiply method
		
		Money newNewMoney = new Money();
		newNewMoney.setCents(cents * m.getCents());
		//newNewMoney.setDollars(dollars * m.getDollars());
		
		return newNewMoney;
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
