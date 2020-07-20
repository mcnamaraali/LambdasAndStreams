import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {

	public static void main(String[] args) {
		int[] values = {3, 3, 4, 5, 5, 6, 7, 8, 2, 1};
		
		System.out.print("Original values ");
		System.out.println(
				IntStream.of(values)
						 .mapToObj(String::valueOf)
						 .collect(Collectors.joining(" "))); //we cannot reuse this once it's processed
		
		System.out.printf("%nCount: %d%n", 
				IntStream.of(values)
						 .count());
		
		System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
		System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
		System.out.println(IntStream.of(values).summaryStatistics()); //better performance
		
		System.out.printf("%nSum via reduce method: %d%n", 
					IntStream.of(values)
							 .reduce(0, (x, y) -> x + y));
		
		System.out.printf("%nProduct via reduce method: %d%n", 
				IntStream.of(values)
						 .reduce((x, y) -> x * y).getAsInt());
		
		System.out.printf("%nSum via sum method: %d%n", 
				IntStream.of(values)
						 .map(x -> x * x)
						 .sum());
		
		System.out.printf("%nSum via collect method: %s%n", 
				IntStream.of(values)
						 .sorted()
						 .mapToObj(String::valueOf)
						 .collect(Collectors.joining(" ")));

	}

}
