package by.dziad.testsStreams.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.dziad.testsStreams.model.CharsToWords;
import by.dziad.testsStreams.model.FilesOperations;

/*
  В данном текстовом файле удалить все слова, которые содержат хотя бы одну цифру.
  
 In this text file, delete all words that contain at least one digit.
 */

public class ControllerTest2 {
	public static void main(String[] args) {
		String fileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test3.txt";
		
		char [] buffer = new char [4096];
		buffer = FilesOperations.takeCharFromInputStreamFileWithCharSet(fileName, buffer);
		
		ArrayList<String> list = new ArrayList<>();
		list = CharsToWords.giveArrayFromWodds(buffer);
				
		ArrayList<String> listForDelete = new ArrayList<>();
		String ptr = "(\\D+)([\\+-]?\\d+)(\\D{0,})";
		String ptr2 = "(\\D{0,})([\\+-]?\\d+)(\\D+)";
		
		Pattern pattern = Pattern.compile(ptr);
		Pattern pattern2 = Pattern.compile(ptr2);
		
		for (String i : list) {
			Matcher matcher = pattern.matcher(i);
			Matcher matcher2 = pattern2.matcher(i);
			if (matcher.find() || matcher2.find()) {
				listForDelete.add(i);
			}
		}
			
		
		list.removeAll(listForDelete);
		
		String finalString = "";
		
		for (String i : list) {
			finalString += i;
		}
		
		FilesOperations.updateFile(fileName, finalString); 
		System.out.println("ok");
		
	}
	
}