import java.util.Arrays;

public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board help = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		int[] plsHelp = {2, 0, 0, 0};
		//invoke the slideRight method on the array 
		help.slideLeft(plsHelp);
		
		//print out the array to see if slideRight
		//worked
		System.out.println(Arrays.toString(plsHelp));
		
	}

}
