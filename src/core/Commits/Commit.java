package core.Commits;

import core.Repository.FileChange;

import java.util.Date;
import java.util.List;

public class Commit implements ICommit{
    private String id;
    private Date timestamp;
    private String author;
    private String message;
    private List<FileChange> changes;

    public Commit(String id, Date timestamp, String author, String message, List<FileChange> changes){
        this.id = id;
        this.timestamp = new Date();
        this.author = author;
        this.message = message;
        this.changes = changes;
    }

    @Override
    public Date getTimestamp(){
        return timestamp;
    }

    @Override
    public String getAuthor(){
        return author;
    }

    @Override
    public  String getMessage(){
        return message;
    }

    @Override
    public List<FileChange> getChanges(){
        return changes;
    }

    @Override
    public  String getId(){
        return id;
    }
}
