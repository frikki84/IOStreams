package by.dziad.testsStreams.controller;

import java.util.ArrayList;

import by.dziad.testsStreams.model.CharsToWords;
import by.dziad.testsStreams.model.FilesOperations;

/*
Дан текстовый файл. Создать новый файл, каждая строка которого получается из соответствующей строки 
исходного файла перестановкой слов в обратном порядке.

*/

public class ControllerTest3 {
	public static void main(String[] args) {
		String sourceFileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test4.txt";
		
		char[] buffer = new char[2048];
		buffer = FilesOperations.takeCharFromInputStreamFileWithCharSet(sourceFileName, buffer);
		
		ArrayList<ArrayList<String>> wordList = new ArrayList<>();
		wordList = CharsToWords.giveArrayFromWordPerLines(buffer);
		System.out.println("Первый заход " + wordList);
		
		ArrayList<ArrayList<String>> resultList = new ArrayList<>();
		for (ArrayList<String> item : wordList) {
			ArrayList<String> mid = new ArrayList<>();
			for (int i = item.size()- 1; i >=0; i --) {
				mid.add(item.get(i));
			}
			resultList.add(mid);
		}
		
		System.out.println(resultList);
		
		String resultString = "";
		
		for (ArrayList<String> item : resultList) {
			for (String i : item) {
				resultString += i;
				resultString += " ";
			}
			//resultString += "\n";
		}
		
		System.out.println(resultString);
	}

}
