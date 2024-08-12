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
        String directoryPath = "C:";

        //Display contents of directory
        fileManager.displayDirectoryContents((directoryPath));

        //Source and file path

        String sourceFilePath = "";
        String destinationPath = "";


        //Copy a file
        fileManager.copyFile(sourceFilePath, destinationPath);

        //Move a file
        String moveDestinationPath ="";
        fileManager.moveFile(destinationPath, moveDestinationPath);

        //Delete Fil
        fileManager.deleteFile(moveDestinationPath);

        //Create new directory
        String newDirectoryPath = "";
        fileManager.createDirectory(newDirectoryPath);

        ////Search files within directory
        String searchQuery = "";
        fileManager.searchFiles(directoryPath,searchQuery );
        //Initializing UI
        CLI.startApplication();

        //Setting up the logger
        Logger logger = LoggerSetup.getLogger();
        logger.info("Searching for " + searchQuery);


        }
    }
