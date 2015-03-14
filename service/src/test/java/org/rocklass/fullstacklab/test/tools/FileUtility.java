package org.rocklass.fullstacklab.test.tools;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtility {
	public static String getResourceFileAsString(String fileName) {

		StringBuilder result = new StringBuilder("");

		// get file from resources folder
		ClassLoader classLoader = FileUtility.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line);
				if (scanner.hasNextLine()) {
					result.append(System.lineSeparator());
				}
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
}
