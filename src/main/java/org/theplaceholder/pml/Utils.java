package org.theplaceholder.pml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Utils {
    public static String readStringFromZip(Path zipFile, String fileNameInsideZip) throws IOException {

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (entry.getName().equals(fileNameInsideZip)) {
                    return readEntryContent(zipInputStream);
                }
            }
        }
        return null;
    }

    private static String readEntryContent(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }

    public static void unzipSubfolderToParent(Path zipFilePath, Path outputFolderPath, String subfolderName) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath.toFile()))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                // Check if the entry is a directory and matches the subfolder name
                if (entry.isDirectory() && entry.getName().equals(subfolderName + "/")) {
                    // Extract the contents of the subfolder to the parent directory
                    extractFolderToParent(zipInputStream, outputFolderPath.toFile(), subfolderName);
                    break; // Stop processing after finding and extracting the desired subfolder
                }
            }
        }
    }

    private static void extractFolderToParent(ZipInputStream zipInputStream, File parentDestination, String subfolderName) throws IOException {
        byte[] buffer = new byte[1024];
        ZipEntry entry;

        // Iterate through each entry in the subfolder and extract it to the parent directory
        while ((entry = zipInputStream.getNextEntry()) != null) {
            String entryName = entry.getName();

            // Remove the subfolder hierarchy from the entry name
            String relativePath = entryName.substring(subfolderName.length() + 1);
            File entryFile = new File(parentDestination, relativePath);

            // Create directories if necessary
            if (entry.isDirectory()) {
                entryFile.mkdirs();
            } else {
                // Create parent directories for file
                entryFile.getParentFile().mkdirs();

                // Write the file content
                try (FileOutputStream fos = new FileOutputStream(entryFile)) {
                    int length;
                    while ((length = zipInputStream.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                }
            }

            // Close the current entry
            zipInputStream.closeEntry();
        }
    }
}
