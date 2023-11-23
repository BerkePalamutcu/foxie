import cli.parser.CommandlineParser;
public class Main {
    public static void main(String[] args) {
        CommandlineParser parser = new CommandlineParser();
        parser.parse(args);
    }
}