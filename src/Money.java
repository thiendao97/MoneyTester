
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
		newMoney.setCents(m.getCents() + cents);
		newMoney.setDollars(m.getDollars() + dollars);
		return normalize(newMoney);
	}
	
	public String toString () {
		String dollarsAsString = null;
		String centsAsString = null;
		dollarsAsString = dollarsAsString.valueOf(dollars); // String.valueOf(int i). built in java library. converts integer i into a string and returns it as a string.
		centsAsString = centsAsString.valueOf(cents);
		
		if (cents < 10) {
			return dollarsAsString + ".0" + centsAsString;
		}
		else {
			return (dollarsAsString + "." + centsAsString);
		}
	}
	
	// This function takes in a multiplier of int m and returns a new Money object multipled by the multiplier
	public Money multiply (int multiplier) { 		
		Money newMoney = new Money();
		newMoney.setCents(cents * multiplier);
		newMoney.setDollars(dollars * multiplier);
		return normalize(newMoney);
	}
	
	public static Money [] multiply (Money [] moneyArray, int multiplier) {
		int arrayLength = moneyArray.length;
		Money newMoneyArray [] = new Money[arrayLength];	
		for(int i = 0; i < arrayLength; i++) {
			newMoneyArray[i] = moneyArray[i].multiply(multiplier);
		}
		return newMoneyArray;
	}
	
	// This function makes cents normal. Because cents have to be less than 100. Anything in excess gets added to dollars.
	private Money normalize (Money m) {
		m.setDollars(m.getDollars() + m.cents / 100);
		m.setCents(m.getCents() % 100);
		return m;
	}
}
