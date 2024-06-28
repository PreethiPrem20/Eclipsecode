package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

import java.util.List;

public class javaStreams {
	// @Test
	public void regular() {
		// TODO Auto-generated method stub
		// print name starts with a
		ArrayList<String> name = new ArrayList<String>();
		name.add("Abhi");
		name.add("akshu");
		name.add("abhir");
		name.add("Don");
		name.add("preethi");
		int count = 0;
		for (int i = 1; i < name.size(); i++) {
			String actual = name.get(i);
			if (actual.startsWith("a")) {
				count++;
			}
		}
		System.out.println(count);
	}

	// @Test
	public void StringFilter() {
		ArrayList<String> name = new ArrayList<String>();
		name.add("Abhi");
		name.add("akshu");
		name.add("abhir");
		name.add("Don");
		name.add("preethi");
		Long c = name.stream().filter(s -> s.startsWith("a")).count();
		System.out.println(c);
		Stream.of("Abhi", "akshu", "abhir", "Don", "preethi").filter(s -> s.startsWith("a")).count();
		name.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
	}

	//@Test
	public void streamMap() {
		ArrayList<String> name1 = new ArrayList<String>();
		name1.add("Abhinav");
		name1.add("Ruhi");
		Stream.of("Abhi", "akshu", "abhir", "Don", "preethi").filter(s -> s.endsWith("i")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		List<String> names = Arrays.asList("Abhi", "akshu", "abhir", "Don", "preethi");
		names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		//merging two different list
		Stream<String> newString=Streams.concat(name1.stream(),names.stream());
		//newString.sorted().forEach(s -> System.out.println(s));
		boolean flag=newString.anyMatch(s->s.equalsIgnoreCase("akshu"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test
	public void streamCollect() {
		List<String> ls=Stream.of("Abhi", "akshu", "abhir", "Don", "preethi").filter(s -> s.startsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> value = Arrays.asList(2,5,6,7,5,6,9,0);
		value.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> ls1=value.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls1.get(3));
	}
	
}
