package cli.commands;

import core.Indexing.IndexManager;

import java.io.IOException;

public class RemoveCommand implements Command{
    private final IndexManager indexManager;
    public RemoveCommand(IndexManager indexManager){
        this.indexManager = indexManager;
    }
    @Override
    public void execute(String[] args){
        if(args.length == 0){
            System.out.println("You need to give a file name to remove!");
            return;
        } else {
            for(String filepath : args){
                try{
                    indexManager.removeFileFromIndex(filepath);
                } catch (IOException e){
                    System.out.println("Error happened while adding file to the index " + e.getMessage());
                }
            }
        }
    }
}
