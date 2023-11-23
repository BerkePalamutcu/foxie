package core.Indexing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IndexCreator {
    public static void IndexFileCreator(Path path) {
        try {
            Files.createFile(path.resolve("index.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create .foxie directory or index file", e);
        }
    }
}
