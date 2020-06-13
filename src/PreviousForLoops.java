
public class PreviousForLoops {

	public static void main(String[] args) {
		int total = 0;
		
		for (int number = 1; number <=10; number++) { //external iteration
			total += number;
		}
		
		/*error-prone
		initialise total
		initialise number
		wrong loop-continuation condition
		increment control wrong
		incorrectly add each value of number to the total
		--- harder to read, debug and modify - more likely to contain errors. 
		*/
		System.out.printf("this is the total %d", total);

	}

}
