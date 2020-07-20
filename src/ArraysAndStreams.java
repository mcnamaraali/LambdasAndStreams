import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams {

	public static void main(String[] args) {
		Integer[] values = {2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.printf("Original values %s%n", Arrays.asList(values));
		
		System.out.printf("Sorted values: %s%n",
					Arrays.stream(values)
						  .sorted()
						  .collect(Collectors.toList())); //note this is CollectorS not Collector
		
		System.out.printf("filtered values: %s%n",
				Arrays.stream(values)
					  .filter(value -> value > 4)
					  .collect(Collectors.toList())); 

	}

}
