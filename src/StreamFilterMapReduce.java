import java.util.stream.IntStream;

public class StreamFilterMapReduce {

	public static void main(String[] args) {
		
		System.out.printf("Sum of the triples of the even ints %nfrom 2 to 10 is: %n%d%n",
						   IntStream.rangeClosed(1,10) //our data source
									.filter(x -> x % 2 == 0) //intermediate operation - returns the elements that satisfy the condition when true (predicate)
									.map(x -> x * 3) //intermediate - lazy - only if necessary
									.sum()); //terminal - eager - perform when called

	}

}
