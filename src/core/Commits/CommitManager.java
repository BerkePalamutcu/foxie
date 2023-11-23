package core.Commits;

import core.Repository.FileChange;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommitManager {
    private Map<String, ICommit> commits;

    public void CommitManaager() {
        this.commits = new HashMap<>();
    }

    public Commit createCommit(String author, Date timestamp, String message, List<FileChange> changes) {
        String commitId = generateCommitId(author, message, changes);
        Commit newCommit = new Commit(commitId, timestamp,author, message, changes);
        commits.put(commitId, newCommit);
        saveCommit();
        return newCommit;
    }

    private String generateCommitId(String author, String message, List<FileChange> changes) {
        try {
            //NOTE: MessageDigest is used to create hash value from java std library!
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String dataToHash = author + message + changes.toString() + System.currentTimeMillis();

            byte[] hashBytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot create a hash for Commit ID", e);
        }
    }

    private static String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for(byte b : hash){
            String hex = Integer.toHexString(0xff & b);
            if(hexString.length() == 1){
                hexString.append('0');
            }

            hexString.append(hex);
        }
        return hexString.toString();
    }

    private void ensureCommitDirectoryExists() throws IOException {
        Path commitsDir = Paths.get(System.getProperty("user.dir"), ".foxie", "commits");
        if(!Files.exists(commitsDir)){
            Files.createDirectory(commitsDir);
        } else {
            System.out.println("Saving Directory exists!");
        }
    }
    private void saveCommit() {
        System.out.println("Saving the commit...");
    }
}
