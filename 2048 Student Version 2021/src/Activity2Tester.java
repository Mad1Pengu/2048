
public class Activity2Tester {

	public static void main(String[] args) {
		//Create a Board object
		Board lol = new Board();
		//call the populateOne method and print out the board each time
		//does it fill a random location? How about if the board is almost
		//full? Does it still work?
		lol.populateOne();
		lol.populateOne();
		lol.populateOne();
		lol.populateOne();
		lol.populateOne();
		lol.populateOne();
		System.out.println(lol);
		System.out.println(" ");
		lol.slideLeft();
		lol.combineLeft();
		System.out.println(lol);
	}

}
