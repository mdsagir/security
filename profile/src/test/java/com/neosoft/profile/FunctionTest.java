package com.neosoft.profile;

import java.util.stream.Stream;

public class FunctionTest {

	public static void main(String[] args) {

		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		
		streamOfArray.forEach(System.out::println);
		
		
	}
}
