import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomIntStream {

	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		
		System.out.printf("%-6s%s%n", "Face ","Frequency");
		
		rand.ints(10_000, 1, 7)
			.boxed()
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.forEach((face, frequency) -> System.out.printf("%-6d%d%n", face, frequency ));

		otherMethod();
	}
	
	
	public static void otherMethod() {
		System.out.println("other examples");
		
		IntStream.iterate(1, x -> x + 1)
				 .limit(10)
				 .forEach(System.out::println);
		
		System.out.println();
		
		IntStream.iterate(1, x -> x + 1)
				 .map(x -> x * x)
		 		 .limit(10)
		 		 .forEach(System.out::println);
	}
}
