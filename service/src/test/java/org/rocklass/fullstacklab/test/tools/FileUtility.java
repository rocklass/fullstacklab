package org.rocklass.fullstacklab.test.tools;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class FileUtility {
    private FileUtility() {
    }

    public static String getResourceFileAsString(final String fileName) {
        final StringBuilder result = new StringBuilder("");

        try {
            // get file from resources folder
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final File file = new File(classLoader.getResource(fileName).getFile());
            final Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
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
