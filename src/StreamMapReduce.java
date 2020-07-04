import java.util.stream.IntStream;

public class StreamMapReduce {

	public static void main(String[] args) {
		
		System.out.printf("Sum of the even ints %nfrom 2 to 20 is: %n%d%n",
				   IntStream.rangeClosed(1,20)  
							.map(x -> x * 2)
							.sum());
		


	}

}
