package com.mamatha.filesreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class wordCountUsingMap {

	private static Scanner sc = new Scanner(System.in);
	// private static Map<String, Integer> mapData = new
	// TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	private static Map<String, Integer> mapData = new HashMap();

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\91779\\OneDrive\\Desktop\\mammuw3schoolsfiles\\searchWordCount.txt");
		BufferedReader br = new BufferedReader(fr);
		int count = 0;
		String line = br.readLine();
		String[] words;

		while (line != null) {
			words = line.split(" ");
			for (String word : words) {
				// converting word to lowercase
				word = word.toLowerCase();
				if (mapData.containsKey(word) == false) {
					mapData.put(word, 1);
				} else {
					int oldVal = mapData.get(word);
					int newVal = oldVal + 1;
					mapData.put(word, newVal);
				}
			}
			line = br.readLine();
		}
		while (true) {
			System.out.println("enter the choice you want Press 1:TO search Word \n press 2 : TO Exist");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				searchWordCount();
				break;
			case 2:
				return;

			}
		}
	}

	public static void searchWordCount() {
		Integer count = 0;
		System.out.println("enter the word you want to search");
		   String searchWord = sc.nextLine();
		   String[] searchWords = { 
					searchWord + "," , 
					searchWord , 
					"\"" + searchWord ,
					"\"" + searchWord + "," ,
					searchWord + "\"" 
					};
		   
		   for(String wordSearch :searchWords)
		   {
			   
	       Integer  tempCount = mapData.get(wordSearch.toLowerCase());
	       //check if  first time tempCount is null
	       if(tempCount==null) 
	    	   tempCount =0;
	       count +=tempCount;
	       
		   }
		  
//		System.out.println("enter the word you want to search");
//		String searchWord = sc.nextLine();
//
//		Integer count = mapData.get(searchWord.toLowerCase());

		if (count!=null&&count>0) {
			System.out.println("found the given search word "+"\"" + searchWord +"\""+ "  : " + count + " times");
		} else {
			System.out.println("not found given word " + "\"" + searchWord +"\"");
		}
	}

}
