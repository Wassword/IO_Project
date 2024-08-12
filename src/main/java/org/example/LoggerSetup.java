package org.example;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSetup {
    // Single instance of the Logger to ensure only one instance is used throughout the application
    private static Logger logger;

    /**
     * Returns a Logger instance configured to log messages to a file.
     * If the logger is already initialized, it returns the existing instance.
     * This ensures that only one logger is used throughout the application.
     *
     * @return Logger instance configured with a file handler and simple formatter
     */

public static Logger getLogger() {
    // Check if the logger is already initialized
    if (logger == null) {

        // Create a new logger instance with the name "FileManagerLogger"
        logger = Logger.getLogger("FileManagerLogger");
        try {
            // Set up a FileHandler to write log messages to a file (appends to the file if it exists)
            FileHandler fileHandler = new FileHandler("logs/file_manager.log");
            // Set a simple text formatter for the log messages
            fileHandler.setFormatter(new SimpleFormatter());
            // Attach the FileHandler to the logger
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            // Print an error message if there's an issue setting up the logger
            System.err.println("Could not open log file. " + e.getMessage());
        }
    }
    return logger;//Return the initialized logger instance
}


}
