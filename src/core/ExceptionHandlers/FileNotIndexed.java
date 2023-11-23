package core.ExceptionHandlers

public class FileNotIndexedException extends Exception {
    public FileNotIndexedException(String fileName) {
        super("File not indexed: " + fileName);
    }
}