package com.svv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Demo3 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = Files.newBufferedReader(Paths.get("FP Demo.txt"));
		
		Stream<String> lines = br.lines();
		
		lines.distinct().forEach(System.out::println);
		
		// changes done by other developer -- git testing
		
	}

}
