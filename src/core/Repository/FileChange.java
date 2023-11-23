package core.Repository;

public class FileChange {
    private ChangeType changeType;
    private String filePath;
    private String content;

    public FileChange(ChangeType changeType, String filePath) {
        this.changeType = changeType;
        this.filePath = filePath;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "FileChange{" +
                "changeType=" + changeType +
                ", filePath='" + filePath + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
