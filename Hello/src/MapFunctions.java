// Java Program to Find Entry with largest Value in Map
// Using concept of Streams
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;

// Main class
class MapFunctions {

	// Method 1
	public static void main(String[] args)
	{

		// Entries in our map
		Map<String, String> map = new HashMap<>();

		map.put("A", "23");
		map.put("F", "43");
		map.put("C", "56");
		map.put("Z", "04");

		// Printing the largest value in map by
		// calling above method
		Optional<Map.Entry<String, String>> maxEntry = map.entrySet().stream().max(Map.Entry.comparingByValue());
		String maxValue = maxEntry.get().getKey();
		System.out.println("max value is "+maxValue);

		Optional<Map.Entry<String, String>> minEntry = map.entrySet().stream().min(Map.Entry.comparingByValue());
		String minValue = minEntry.get().getKey();
		System.out.println("min value is "+minValue);
	}
}
