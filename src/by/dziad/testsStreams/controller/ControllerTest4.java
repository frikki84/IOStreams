package by.dziad.testsStreams.controller;

import java.util.ArrayList;

import by.dziad.testsStreams.model.ArraylistToString;
import by.dziad.testsStreams.model.CharsToWords;
import by.dziad.testsStreams.model.FilesOperations;
import by.dziad.testsStreams.model.Validator;

/*
Дан текстовый файл. 
Создать новый файл, состоящий из тех строк исходного файла, из чисел 
которых можно составить арифметическую прогрессию.
*/

public class ControllerTest4 {
	public static void main(String[] args) {
		String sourceFileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test6.txt";
		String resultFileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test7.txt";

		char[] buffer = new char[4096];
		buffer = FilesOperations.takeCharArrayFromFiles(sourceFileName, buffer);

		ArrayList<ArrayList<String>> list = CharsToWords.giveArrayFromWordPerLines(buffer);

		ArrayList<ArrayList<Integer>> intList = new ArrayList<>();

		int counter = 0;

		for (ArrayList<String> i : list) {
			intList.add(new ArrayList<Integer>());
			for (String s : i) {
				if (s != "" && Validator.checkStringToBeInteger(s)) {
					Integer r = Integer.parseInt(s);
					intList.get(counter).add(r);
					
				}
			}
			counter += 1;

		}

		ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

		for (ArrayList<Integer> i : intList) {
			int itemCounter = 0;
			if (i.size() >= 2) {
				int count = 0;
				int res = i.get(1) - i.get(0);
				if (res != 0) {
					for (int k = 1; k < i.size(); k++) {
						count = i.get(k) - i.get(k - 1);
						if (count == res) {
							itemCounter += 1;
						} else {
							break;
						}
					}
				}
				if (itemCounter == i.size() - 1) {
					resList.add(i);
				}
			}
		}

		String resultString = ArraylistToString.modifyArrayOfArraysOfIntegerToOneString(resList);
		
		FilesOperations.writeInfoToNewFileWithUTF(resultFileName, resultString);


	}

}
