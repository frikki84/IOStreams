package by.dziad.testsStreams.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import by.dziad.testsStreams.model.FilesOperations;

/*
Даны два текстовых файла, содержащие целые числа. 
Создать файл из различных чисел, которые содержатся: 
	а) в каждом исходном файле;  
	б) только в одном из двух исходных файлов; 
	в) только в первом исходном файле; 
	г) хотя бы в одном из двух исходных файлов.
	
Given two text files containing integers.
Create a file from various numbers that are contained:
a) in each source file;
b) only in one of the two source files;
c) only in the first source file;
d) in at least one of the two source files.
		
	*/


public class ControllerTest5 {
	public static void main(String[] args) {
		String initialFile1 = "d:\\itiu\\JavaIvanchenko\\training\\io\\test8.txt";
		String initialFile2 = "d:\\itiu\\JavaIvanchenko\\training\\io\\test9.txt";
		String resultFile1 = "d:\\itiu\\JavaIvanchenko\\training\\io\\test10.txt";
		
		char [] buffer = new char[64];
		int c;
		
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			
			reader = new FileReader(initialFile1);
			writer = new FileWriter(resultFile1, true);
			
			while ((c = reader.read(buffer)) != -1) {
				reader.read(buffer);
				for (char i : buffer) {
					System.out.println(i);
				}
				writer.write(buffer);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("ok");
	}
	

}
