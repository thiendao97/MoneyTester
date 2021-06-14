
public class Money { // attributes of the money class which has dollars and cents
	private int dollars; // one of the attributes in the money class which should all have dollars
	private int cents; // one of the attributes in the money class which should all have cents
	
	Money () {
		dollars = 0; // initial value of dollars starts at 0 in the beginning
		cents = 0; // initial value of cents starts at 0 in the beginning
	}
	
	Money (int a, int b) { // how the parameters are defined in the tester so that we can manipulate it
		dollars = a;
		cents = b;
	}
	
	public int getDollars () { // retrieves the current dollars
		return dollars;
	}
	
	public int getCents () { // retrieves the current cents
		return cents;
	}
	
	public void setDollars (int d) { // sets in the new value of dollars from getDollars
		dollars = d;
	}
	
	public void setCents (int c) { // sets in the new value of cents from getCents
		cents = c;
	}
	
	public boolean equals(Money m) { // compares a money object with another money object, in this case how the object is written is m1, m2, etc..
		if (m.getDollars() == dollars && m.getCents() == cents) { // if whatever m object's current dollar and current cents is equal to the other objects dollars and cents, example is take the dollar from m2 which is 5 and dollar from m1 which is 8 and see if they are the same
			return true; // if dollars and cents are the same return true
		}
		return false; // if dollars and cents are not the same return false
	}
	
	public Money add (Money m) {
		Money newMoney = new Money(); //creates a new object consisting of the sum of the objects we added
		newMoney.setCents(m.getCents() + cents); // sets the new object's cents as the sum from a money object and another money object
		newMoney.setDollars(m.getDollars() + dollars);// sets the new objects's dollars as the sum from a money object and another money object
		return normalize(newMoney); // returns the correct dollars and cents, for example 1 dollar and 109 cents is wrong, it should be 2 dollars and 9 cents
	}
	
	public Money subtract (Money m) {
		Money newMoney = new Money(); //creates a new object consisting of the results from subtracting two objects 
		newMoney.setCents(cents - m.getCents()); // sets the new object's cents from the result of subtracting a money object from another money object
		newMoney.setDollars(dollars - m.getDollars()); // sets the new object's dollars from the result of subtracting a money object from another money object
		return normalize(newMoney); // returns the correct dollars and cents, for example 1 dollar and 109 cents is wrong, it should be 2 dollars and 9 cents
	}
	
	public String toString () {
		String dollarsAsString = null; //not assigning string to anything yet
		String centsAsString = null; // not assigning string to anything yet
		dollarsAsString = dollarsAsString.valueOf(dollars); // String.valueOf(int i). built in java library. converts integer i into a string and returns it as a string.
		centsAsString = centsAsString.valueOf(cents); // returns cents as a string
		if (cents < 10) {
			return dollarsAsString + ".0" + centsAsString; // if cents is 9 cents this would return .09 cents
		}
		else {
			return (dollarsAsString + "." + centsAsString); // for other cases like 12 cents would just return .12
		}
	}
	
	public Money multiply (int multiplier) { // This function takes in a multiplier of int m and returns a new Money object multipled by the multiplier		
		Money newMoney = new Money(); // creates a new object consisting of an object multiplied by a number
		newMoney.setCents(cents * multiplier); // sets the new object's cents from the result of an objects cents multiplied by a number
		newMoney.setDollars(dollars * multiplier); // sets the new object's dollars from the result of an objects cents multiplied by a number
		return normalize(newMoney); // returns the correct dollars and cents, for example 1 dollar and 109 cents is wrong, it should be 2 dollars and 9 cents
	}
	
	public static Money [] multiply (Money [] moneyArray, int multiplier) { // this function multiplies numbers in the array by a multiplier, for example everything in the array multiplied by 2
		int arrayLength = moneyArray.length; // assigned a name the the length of the array
		Money newMoneyArray [] = new Money[arrayLength]; // create an object that will store the result of the array after multiplying with the multiplier	
		for(int i = 0; i < arrayLength; i++) { // goes through everything in the array
			newMoneyArray[i] = moneyArray[i].multiply(multiplier); // goes through each array starting from 0 and multiplies it with the multiplier
		}
		return newMoneyArray; // return the new array after multiplying with the multiplier
	}
	
	private Money normalize (Money m) { // This function makes cents normal. Because cents have to be less than 100. Anything in excess gets added to dollars.
		m.setDollars(m.getDollars() + m.cents / 100); // this sets the new dollars by using the original dollars and dividing it by 100 which then will add the number of times we diviided by 100 to the new dollars amount
		m.setCents(m.getCents() % 100); // this sets the new cents by taking the remainder of dividing by 100 and setting that as the new cents
		
		// This logic below is for subtraction
		if (m.getCents() < 0) { // if the amount of cents is for example -.12
			m.setCents(m.getCents() * -1); // make the new cents be positive
		}
		return m; //return the objects dollars and cents after conversion
	}
}
