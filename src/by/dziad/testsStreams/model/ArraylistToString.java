package by.dziad.testsStreams.model;

import java.util.ArrayList;

public class ArraylistToString {
	
	
	public static String modifyArrayOfArraysOfStringsToOneString(ArrayList<ArrayList<String>> list) {
		String resultString = "";

		for (ArrayList<String> item : list) {
			for (String i : item) {
				resultString += i;
				resultString += " ";
			}
			resultString += "\n";
		}
		
		return resultString;
	}
	
	public static String modifyArrayOfArraysOfIntegerToOneString(ArrayList<ArrayList<Integer>> list) {
		String resultString = "";

		for (ArrayList<Integer> item : list) {
			for (Integer i : item) {
				resultString += i;
				resultString += " ";
			}
			resultString += "\n";
		}
		
		return resultString;
	}

}
