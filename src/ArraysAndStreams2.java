import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {

	public static void main(String[] args) {
		String[] colours = {"red", "blue", "white", "green", "white", "orange"};
		
		System.out.printf("Original strings: %s%n", Arrays.asList(colours));
		
		System.out.printf("strings in uppercase: %s%n",
				Arrays.stream(colours)
					  .map(String::toUpperCase)
					  .collect(Collectors.toList()));
		
		System.out.printf("strings in compare to ignore case: %s%n",
				Arrays.stream(colours)
					  .filter(s -> s.compareToIgnoreCase("z") < 0)
					  .sorted(String.CASE_INSENSITIVE_ORDER)
					  .collect(Collectors.toList()));
		
		System.out.printf("strings less than n sorted desc: %s%n",
				Arrays.stream(colours)
					  .filter(s -> s.compareToIgnoreCase("n") < 0)
					  .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
					  .collect(Collectors.toList()));

	}

}
