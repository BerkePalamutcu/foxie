package core.Commits;

import core.Repository.FileChange;

import java.util.Date;
import java.util.List;

public interface ICommit {
    String getId();
    Date getTimestamp();
    String getAuthor();
    String getMessage();
    List<FileChange> getChanges();
}
