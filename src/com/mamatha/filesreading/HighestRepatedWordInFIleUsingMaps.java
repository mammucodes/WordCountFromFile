package com.mamatha.filesreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HighestRepatedWordInFIleUsingMaps {
	// private static Map<String, Integer> mapInfo = new HashMap();
	private static Map<String, Integer> mapInfo = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\91779\\OneDrive\\Desktop\\highrepWord\\highestwordCount.txt");
		BufferedReader br = new BufferedReader(fr);
		highestWordCount(br);

	}

	public static void highestWordCount(BufferedReader br) throws IOException {
		String line = br.readLine();
		String words[];
		while (line != null) {
			words = line.split(" ");
			for (String eachWord : words) {

				eachWord = eachWord.toLowerCase();
				if (mapInfo.containsKey(eachWord) == false) {
					mapInfo.put(eachWord, 1);

				} else {
					int oldval = mapInfo.get(eachWord);
					int newVal = oldval + 1;
					mapInfo.put(eachWord, newVal);
				}

			}
			line = br.readLine();
		}
		getHighestCountOfWordInFile(mapInfo);
//		while (true) {
//			System.out.println(
//					"Press 1 : TO getCountOfSearchWord\n Press 2: TO get HighestCount of word in the file\n press 3 : To exist");
//			int choice = sc.nextInt();
//			sc.nextLine();
//			switch (choice) {
//
//			case 1:
//				System.out.println("enter the seearchWord");
//				String searchWord = sc.nextLine();
//				getCountOfSearchWord(searchWord);
//				break;
//			case 2:
//				getHighestCountOfWordInFile(mapInfo);
//				break;
//			case 3 : return;
//
//			}
//
//		}

	}

	private static void getHighestCountOfWordInFile(Map<String, Integer> mapData) {
		int maxValue = 0;
		String highestRepatedWord = "";
		for (Map.Entry<String, Integer> temp : mapData.entrySet()) {
			int count = temp.getValue();
			if (maxValue < count) {
				maxValue = count;
				highestRepatedWord = temp.getKey();

			}
		}
		System.out.println("The highestWord is  " +"\""+ highestRepatedWord + "\""+" its count is " + maxValue);

//		int[] DataCount =null;
//		
//		
//		for(Map.Entry temp : mapData.entrySet()) {
//			int i=0;
//			DataCount[i] = temp.get(temp);
//		i++;
//		}
//		Arrays.sort(DataCount);
//		int length = DataCount.length;
//		int count = DataCount[length-1];
//		System.out.println("the highestCount of word in the file is "+count+" and the word is "+mapData.get(count));

	}

	private static void getCountOfSearchWord(String serachWord) {

	}

}
