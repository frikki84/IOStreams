package by.dziad.testsStreams.model;

import java.util.ArrayList;

public class CharsToWords {

	public static ArrayList<String> giveArrayFromWodds(char[] buffer) {
		String res = "";
		ArrayList<String> list = new ArrayList<>();
		for (char i : buffer) {
			if (i != ' ') {
				res += i;
			} else {
				list.add(res);
				res = "";
			}

		}
		return list;
	}

	public static ArrayList<ArrayList<String>> giveArrayFromWordPerLines(char[] buffer) {
		String res = "";
		ArrayList<ArrayList<String>> finalList = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		for (char i : buffer) {
			if (i != '\n' && i != ' ' && i != '\r') {
				res += i;
			} else if (i == ' ') {
				list.add(res);
				res = "";
			} else if (i == '\n') {
				list.add(res);
				ArrayList<String> midList = new ArrayList<>(list);
				finalList.add(midList);
				list.clear();
				res = "";
			} else {
				continue;
			}
			

		}
		return finalList;
	}

}
