package org.rocklass.fullstacklab.test.tools;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * File utility class
 * 
 * @author rocklass
 *
 */
public final class FileUtility {
    
    /**
     * Private constructor of static class {@link FileUtility}
     */
    private FileUtility() {
    }

    /**
     * Get file from resources as a {@link String}
     * 
     * @param fileName
     *            name of the file in the resources folder
     * @return file as a {@link String}
     */
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
            // TODO error log
            e.printStackTrace();
        }

        return result.toString();
    }
}
