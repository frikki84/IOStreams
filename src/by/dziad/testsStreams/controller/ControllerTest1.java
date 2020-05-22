package by.dziad.testsStreams.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import by.dziad.testsStreams.model.FilesOperations;

/*
Дан текстовый файл, содержащий целые числа. Удалить из него все четные числа.
*/

public class ControllerTest1 {

	public static void main(String[] args) {
		String fileName = "d:\\itiu\\JavaIvanchenko\\training\\io\\test1.txt";

		char[] buffer = new char[4096];

		buffer = FilesOperations.takeCharArrayFromFiles(fileName, buffer);

		String res = "";

		ArrayList<Integer> list = new ArrayList<>();
		for (char i : buffer) {
			if (i != ' ') {
				res += i;
			} else {
				Integer m = Integer.valueOf(res);
				list.add(m);
				res = "";
			}

		}
		StringBuilder last = new StringBuilder();
		for (Integer i : list) {
			if (i % 2 != 0) {
				last.append(i);
				last.append(" ");
			}
		}
		FilesOperations.updateFile(fileName, last.toString());

	}
}
