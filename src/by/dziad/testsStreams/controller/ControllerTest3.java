package by.dziad.testsStreams.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import by.dziad.testsStreams.model.CharsToWords;
import by.dziad.testsStreams.model.FilesOperations;

/*
Дан текстовый файл. Создать новый файл, каждая строка которого получается из соответствующей строки 
исходного файла перестановкой слов в обратном порядке.


There is a text file. Create a new file, each line of which is obtained from the corresponding line
source file by rearranging words in reverse order.
*/

public class ControllerTest3 {
	public static void main(String[] args) {
		String sourceFileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test4.txt";
		String resultFile = "d:\\itiu\\JavaIvanchenko\\training\\io\\test6.txt";

		char[] buffer = new char[2048];
		buffer = FilesOperations.takeCharFromInputStreamFileWithCharSet(sourceFileName, buffer);

		ArrayList<ArrayList<String>> wordList = new ArrayList<>();
		wordList = CharsToWords.giveArrayFromWordPerLines(buffer);

		ArrayList<ArrayList<String>> resultList = new ArrayList<>();
		for (ArrayList<String> item : wordList) {
			ArrayList<String> mid = new ArrayList<>();
			for (int i = item.size() - 1; i >= 0; i--) {
				mid.add(item.get(i));
			}
			resultList.add(mid);
		}

		String resultString = "";

		for (ArrayList<String> item : resultList) {
			for (String i : item) {
				resultString += i;
				resultString += " ";
			}
			resultString += "\n";
		}
		System.out.println(resultString);
		
		FilesOperations.writeInfoToNewFileWithUTF(resultFile, resultString);

		System.out.println("ok");

	}

}
