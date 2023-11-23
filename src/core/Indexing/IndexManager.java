package core.Indexing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IndexManager {
    private static final Path INDEX_FILE = Paths.get(System.getProperty("user.dir"), ".foxie", "index.txt");
    private static final Path ROOT_DIR = Paths.get(System.getProperty("user.dir"));

    public void addFileToIndex(String filePath) throws IOException {
        if (!filesExistRecursively(ROOT_DIR, filePath)) {
            printError("File not found: " + filePath);
            return;
        }

        Set<String> indexedFiles = loadIndexedFiles();

        if(indexedFiles.contains(filePath)){
            printSuccess("File was already indexed but the contents are overwritten.");
        } else {
            printSuccess("File was added to the index successfully.");
        }

        indexedFiles.add(filePath);
        saveIndexedFiles(indexedFiles);
    }

    public void removeFileFromIndex(String filepath) throws  IOException{
        Set<String> indexedFiles = loadIndexedFiles();

        if(indexedFiles.contains(filepath)){
            indexedFiles.remove(filepath);
            saveIndexedFiles(indexedFiles);
            printSuccess("The file was removed from the index successfully");
        } else {
            printError("File was not found the index");
        }
    }

    public void printIndexedFiles(){
        try{
            if(Files.exists(INDEX_FILE)){
                List<String> lines = Files.readAllLines(INDEX_FILE);
                for(String line: lines){
                    printSuccess(line);
                }
            } else {
                printError("Index file doesn't exist");
            }
        } catch(IOException e){
            System.out.println("Error reading the file " + e.getMessage());
        }
    }

    private boolean filesExistRecursively(Path directory, String filename) throws  IOException{
        try(var paths = Files.walk(directory)) {
            return paths.anyMatch(path -> path.endsWith(filename));
        }
    }

    private Set<String> loadIndexedFiles() throws IOException {
        Set<String> indexedFiles = new HashSet<>();
        if (Files.exists(INDEX_FILE)) {
            for (String line : Files.readAllLines(INDEX_FILE)) {
                indexedFiles.add(line);
            }
        }
        return indexedFiles;
    }

    private void saveIndexedFiles(Set<String> indexedFiles) throws  IOException{
        Files.write(INDEX_FILE, indexedFiles);
    }

    private void printSuccess(String message) {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    private void printError(String message) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
}
