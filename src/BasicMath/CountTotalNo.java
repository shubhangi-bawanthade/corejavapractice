package BasicMath;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountTotalNo {
	public static void main(String[] args) {
		
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		System.out.println(n +"= "+countTotalNoUsingRecursion(n));
		
		List<Person> persons = Arrays.asList(
			    new Person("Alice", 25),
			    new Person("Bob", 30),
			    new Person("Charlie", 35)
			);
			double averageAge = persons.stream()
			                          .mapToInt(Person::getAge)
			                          .average()
			                          .orElse(0);
			
			System.out.println("averageAge="+averageAge);
		
	}
	
	public static int countTotalNo(int n) {
		int c=0;
		while(n!=0)
		{
			n=n/10;
			c++;
		}
		return c;
		
	}
	
	public static int countTotalNoUsingRecursion(int n) {
		if(n/10==0)
			return 1;
		else
			return 1+countTotalNoUsingRecursion(n/10);

	}
	
	public boolean isPrime(int number) {
		  if (number <= 1) {
		    return false;
		  }
		  for (int i = 2; i <= Math.sqrt(number); i++) {
		    if (number % i == 0) {
		        return false;
		    }
		  }
		  return true;
		}
		 
		private void printPrime() {
		  List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
		  boolean containsPrime = numbers.stream()
		                                 .anyMatch(this::isPrime);
		  System.out.println("List contains a prime number: " + containsPrime);

		 }

}
