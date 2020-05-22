package by.dziad.testsStreams.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FilesOperations {

	public static char[] takeCharArrayFromFiles(String fileName, char[] buffer) {
		/*
		 * open files and return char buffer from it
		 */
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(fileName);
			fileReader.read(buffer);
			while (fileReader.read(buffer) != -1) {
				fileReader.read(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buffer;
	}

	public static void updateFile(String fileName, String newInformation) {
		/*
		 * take the file, delete all the information and write new String in it
		 */
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			writer.write(newInformation);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static char[] takeCharFromInputStreamFileWithCharSet(String fileName, char[] buffer) {
		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
			try {
				while (reader.read(buffer) != -1) {
					reader.read(buffer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer;
	}

	public static void createNewFileWithInformation(String newFileName, String string) {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(newFileName), "UTF-8");
			try {
				writer.write(string);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
