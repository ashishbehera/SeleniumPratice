package SeleniumDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamsExamples {
	
 public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Count the number of names starting with letter A in a List
	 streamCollect();

	}
 
 public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arjun");
		names.add("Krishna");
		names.add("Chaitanya");
		names.add("RadhaRani");
		names.add("Balaram");
		names.add("Arkur");
		names.add("Agasti");
		int count =0;
		
		for(int i=0; i < names.size(); i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println("Number of names starting with letter A in a List: "+count);
 }
 
 public static void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Arjun");
		names.add("Krishna");
		names.add("Chaitanya");
		names.add("RadhaRani");
		names.add("Balaram");
		names.add("Arkur");
		names.add("Agasti");
		Long count =  names.stream().filter(s->s.startsWith("A")).count();
		
		System.out.println("Number of names starting with letter A in a List: "+count);
		
		long newCount = Stream.of("Arjun","Krishna","Chaitanya","RadhaRani","Balaram","Arkur","Agasti").filter(s-> {
			s.startsWith("A");
			return true;
		}).count();
		
		System.out.println("Number of names starting with letter A in a List: "+newCount);
		//names.stream().filter(s-> s.length()>6).forEach(name-> System.out.println(name));
		names.stream().filter(s-> s.length()>6).limit(1).forEach(name-> System.out.println(name));


}
 
 public static void streanMap() {
	 
		ArrayList<String> names = new ArrayList<String>();
		names.add("Jagannath");
		names.add("Baladeva");
		names.add("Subhadra");
		names.add("Nityananda");
		names.add("Sudama");
		names.add("YashodaMaya");
		names.add("NandaBaba");
	 
	 // print names which has last letter as "a	" with Uppercase
	 Stream.of("Arjun","Krishna","Chaitanya","RadhaRani","Balaram","Arkur","Agasti")
	 .filter(s -> s.endsWith("a")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));;
	 
	 // print names which has first letter as "a" with Uppercase and sorted
	 List<String> names1 = Arrays.asList("Arjun","Krishna","Chaitanya","RadhaRani","Balaram","Arkur","Agasti");
	 names1.stream().filter(s->s.startsWith("A")).sorted()
	       .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	 
	 System.out.println("****************Merge Array List using Stream********************");
	  Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
	  //newStream.sorted().forEach(s-> System.out.println(s));
	  boolean bMatch = newStream.anyMatch(s->s.equalsIgnoreCase("Vasudeva"));
	  Assert.assertTrue(bMatch);
	  
		
 }
 
 public static void streamCollect() {
	 List<String> names = Stream.of("Arjun","Krishna","Chaitanya","RadhaRani","Balaram","Arkur","Agasti")
	 .filter(s -> s.endsWith("a")).map(s-> s.toUpperCase()).collect(Collectors.toList());
	 
	 System.out.println(names.get(0));
	 
	 
	 
	 List<Integer> num = Arrays.asList(3,2,2,5,7,7,8,9,9);
	 
	 //Print unique numer of this array
	 //Sort the array
	 //num.stream().distinct().sorted().forEach(s-> System.out.println(s));
	 List<Integer> li = num.stream().distinct().sorted().collect(Collectors.toList());
	 System.out.println(li.get(2));
	 
	 
 }

}


