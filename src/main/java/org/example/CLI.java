package org.example;
import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static FileManager fileManager = new FileManager();
    public static Scanner scanner = new Scanner(System.in);

    public static void startApplication() throws IOException {
        while (true) {
            System.out.println("File Manager");
            System.out.println("1. Display Directory Contents");
            System.out.println("2. Copy File");
            System.out.println("3. Move File");
            System.out.println("4. Delete File");
            System.out.println("5. Create Directory");
            System.out.println("6. Delete Directory");
            System.out.println("7. Search Files");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Directory Path: ");
                    String directory = scanner.nextLine();
                    fileManager.displayDirectoryContents(directory);
                    break;
                case 2:
                    System.out.println("Enter source file path");
                    String sourceCopy = scanner.nextLine();
                    System.out.println("Enter destination file path");
                    String destinationCopy = scanner.nextLine();
                    fileManager.copyFile(sourceCopy, destinationCopy);
                    break;
                case 3:
                    System.out.println("Enter source file path");
                    String sourceMove = scanner.nextLine();
                    System.out.println("Enter destination file path");
                    String destinationMove = scanner.nextLine();
                    fileManager.moveFile(sourceMove, destinationMove);
                    break;
                case 4:
                    System.out.println("Enter source file path to delete");
                    String fileDelete = scanner.nextLine();
                    fileManager.deleteFile(fileDelete);
                    break;
                case 5:
                    System.out.println("Enter directory path to create: ");
                    String dirCreate = scanner.nextLine();
                    fileManager.createDirectory(dirCreate);
                    break;
                case 6:
                    System.out.println("Enter directory path to delete: ");
                    String dirDelete = scanner.nextLine();
                    fileManager.deleteFile(dirDelete);
                    break;
                case 7:
                    System.out.println("Enter directory path to search: ");
                    String dirSearch = scanner.nextLine();
                    System.out.println("Enter destination file path or file name to search for: ");
                    String query = scanner.nextLine();
                    fileManager.searchFiles(dirSearch, query);
                    break;
                case 8:
                    System.out.println("Exiting the App.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }
    }
}


