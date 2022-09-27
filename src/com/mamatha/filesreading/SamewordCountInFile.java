package com.mamatha.filesreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SamewordCountInFile {
	public static void main(String args[]) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\91779\\OneDrive\\Desktop\\mammuw3schoolsfiles\\searchWordCount.txt");
		BufferedReader br = new BufferedReader(fr);
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the word you want to search");
		String wordToSearch = sc.nextLine(); //get form user
		String line = br.readLine();
		while (line != null) {

			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {

				boolean wordpresent = isSame(words[i], wordToSearch);
				if (wordpresent) {
					count++;

				}

			}

			line = br.readLine();
		}
		br.close();
		if (count > 0) {
			System.out.println("found the given word " + wordToSearch + " :" + count + " times  in the given file");
		} else {
			System.out.println("not foound the given word in the file");
		}

	}

	public static boolean isSame(String word, String searchWord) {
		
		String[] searchWords = { 
				searchWord + "," , 
				searchWord , 
				"\"" + searchWord ,
				"\"" + searchWord + "," ,
				searchWord + "\"" 
				};
		
		for (int i = 0; i < searchWords.length; i++) {
			if (word.equalsIgnoreCase(searchWords[i])) {
				return true;
			}
		}

		return false;
	}
}