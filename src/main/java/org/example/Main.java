package org.example;

import java.io.IOException;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //Create an instance of file Manager
       FileManager fileManager = new FileManager();

        //Directory path
        String directoryPath = "C:/User/Admin";

        //Display contents of directory
        fileManager.displayDirectoryContents((directoryPath));

        //Source and file path

        String sourceFilePath = "C:/User/Admin/.txt";
        String destinationPath = "C:/User/Admin/file_copy.txt";


        //Copy a file
        fileManager.copyFile(sourceFilePath, destinationPath);

        //Move a file
        String moveDestinationPath ="C:/User/Admin/moved_file.txt";
        fileManager.moveFile(destinationPath, moveDestinationPath);

        //Delete File
        fileManager.deleteFile(moveDestinationPath);

        //Create new directory
        String newDirectoryPath = "C:/User/Admin/new_directory";
        fileManager.createDirectory(newDirectoryPath);

        ////Search files within directory
        String searchQuery = ".txt";
        fileManager.searchFiles(directoryPath,searchQuery );
        //Initializing UI
        CLI.startApplication();

        //Setting up the logger
        Logger logger = LoggerSetup.getLogger();
        logger.info("Searching for " + searchQuery);


        }
    }
