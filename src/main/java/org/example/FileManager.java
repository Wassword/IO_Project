package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
    //1.Display the contents of a specified directory, including file names, file sizes, and last modified dates
    public void displayDirectoryContents(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                for (File file : files) {
                    String lastModified = sdf.format(new Date(file.lastModified()));
                    System.out.println("Name: " + file.getName() + ", Size: " + file.length() + "bytes, Modified: " + lastModified);
                }
            }
        } else {
            System.out.println("Invalid directory: " + directoryPath);
        }
    }

    //2.Copy, move, and delete files within the specified directory
    //Copy:
    public void copyFile(String source, String destination) throws IOException {
        try {
            Path sourcePath = new File(source).toPath();
            Path destinationPath = new File(destination).toPath();
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File coped successfully");
        } catch (IOException e) {
            System.out.println("File could not be copied" + e.getMessage());
        }
    }

    //Move File:
    public void moveFile(String source, String destination) {
        try {
            Path sourcePath = new File(source).toPath();
            Path destinationPath = new File(destination).toPath();
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File could not be moved" + e.getMessage());
        }
    }

    //Delete file

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("File could not be deleted");
        }
    }

    // 3. Create and delete directories within the specified directory
    //Create

    public void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory could not be created");
        }
    }
    //Delete

    public void deleteDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
        if (directory.delete()) {
            System.out.println("Directory deleted successfully");
        } else {
            System.out.println("Directory could not be deleted");
        }
    }

    //Search files
    public void searchFiles(String directoryPath, String query) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(query)) {
                        System.out.println("Found: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
