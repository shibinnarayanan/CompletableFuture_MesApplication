package com.svv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = Files.newBufferedReader(Paths.get("FP Demo.txt"));
		Stream<String> lines = br.lines();
		lines.forEach(System.out::println);
		// git test new commend added by other developer
		// git test new commend added by other developer
		// new line added by shibin
	}

}
