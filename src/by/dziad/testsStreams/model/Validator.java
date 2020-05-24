package by.dziad.testsStreams.model;

public class Validator {
	public static boolean checkStringToBeInteger(String string) {
		boolean result = false;
		Integer m;

		try {
			m = Integer.parseInt(string);
			if (m instanceof Integer) {
				result = true;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
