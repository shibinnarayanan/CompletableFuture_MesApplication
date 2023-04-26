package com.svv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo4 {

	public static void main(String[] args) throws IOException {

		BufferedReader bfrReader = Files.newBufferedReader(Paths.get("FP Demo.txt"));

		bfrReader.lines().parallel().distinct().forEach(System.out::println);
		
		// take advantages using multi core
	}

}
