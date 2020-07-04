import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandIntegers {

	public static void main(String[] args) {
		SecureRandom secureNumbers = new SecureRandom();
		
		System.out.println("Random numbers on separate lines");
		
					secureNumbers.ints(10, 1, 10) //data source up to but not including 7
					 	 		 .forEach(System.out::println); //terminal operation forEach
			//Method reference objectName::instanceMethodName
			//x -> System.out.println(x)
		
		String numbers =
					secureNumbers.ints(10, 1, 7)
								 .mapToObj(String::valueOf)
								 .collect(Collectors.joining(" "));
		
		System.out.printf("%nRandom numbers on one line: %s%n", numbers);
				

	}

}
