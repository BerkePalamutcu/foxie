package core.Repository;

import core.Indexing.IndexCreator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RepositoryInitializer {
    private final Path trackingFolderPath;

    public RepositoryInitializer() {
        this.trackingFolderPath = Paths.get(System.getProperty("user.dir"), ".foxie");
    }

    public void  initialize() {
        try {
            if (!Files.exists(trackingFolderPath)) {
                Files.createDirectory(trackingFolderPath);
                IndexCreator.IndexFileCreator(trackingFolderPath);
                System.out.println("Foxie initialized successfully!");
            } else {
                System.out.println("Foxie has already been initialized!");
            }
        } catch (IOException e) {
            System.out.println("Failed to initialize foxie because of " + e.getMessage());
        }
    }
}
