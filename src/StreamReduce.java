import java.util.stream.IntStream;

public class StreamReduce {

	public static void main(String[] args) {

		System.out.printf("For the stream of int values in the range 1 to 10, calculate the sum %d",
				IntStream.rangeClosed(1, 10)
						 .sum());

	}

}
