package StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice1 {
	public static void main(String[] args) {
		
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);  
//		int sum = numbers.stream().reduce(2, Integer::sum);  
//		// Result: 15  
//		System.out.println(sum);
		
		List<String> myList = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");  
//		Map<Integer, List<String>> groupedByLength = myList.stream().collect(Collectors.groupingBy(String::length));  
		// Result: {5=[apple, grape], 6=[banana], 7=[orange], 4=[kiwi]}  
		
		Map<Integer, List<String>> groupByLength = myList.stream().collect(Collectors.groupingBy(String::length));
		Map<Character, List<String>> groupByCharecter = myList.stream().collect(Collectors.groupingBy(f->f.charAt(0)));
		System.out.println(groupByLength);
		System.out.println(groupByCharecter);
		
	}

}
