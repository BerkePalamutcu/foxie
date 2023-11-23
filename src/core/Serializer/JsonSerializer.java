package core.Serializer;

import core.Commits.Commit;

public class JsonSerializer {
    public static String Serialize(Commit commit){
        return "{"
                + "\"id\":\"" + commit.getId() + "\","
                + "\"author\":\"" + escapeString(commit.getAuthor()) + "\","
                + "\"message\":\"" + escapeString(commit.getMessage()) + "\","
                + "\"timestamp\":\"" + commit.getTimestamp().getTime() + "\""
                + "}";
    }

    public static String escapeString(String escapeValue) {
        return escapeValue.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
