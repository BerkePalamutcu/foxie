package cli.parser;

import cli.commands.*;
import core.Indexing.IndexManager;
import java.util.HashMap;
import java.util.Map;
public class CommandlineParser {
    private final Map<String, Command> commandMap;

    public CommandlineParser(){
        IndexManager indexManager = new IndexManager();
        commandMap = new HashMap<>();
        commandMap.put("init", new InitCommand());
        commandMap.put("add", new AddCommand(indexManager));
        commandMap.put("remove", new RemoveCommand(indexManager));
        commandMap.put("status", new StatusCommand());
    }

    public void parse(String[] args){
        if(args.length == 0){
            showUsage();
            return;
        }

        String commandKey = args[0];
        Command command = commandMap.get(commandKey);

        if(command != null) {
            String[] commandArgs = java.util.Arrays.copyOfRange(args, 1, args.length);
            command.execute(commandArgs);
        } else {
            System.out.print("Unknown Command Detected");
            showUsage();
        }
    }

    private void showUsage(){
        System.out.println("The usage will  be shown here!");
    }
}
