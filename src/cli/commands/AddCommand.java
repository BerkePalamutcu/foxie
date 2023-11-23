package cli.commands;

import core.Indexing.IndexManager;

import java.io.IOException;

public class AddCommand implements Command{
    private final IndexManager indexManager;
    public AddCommand(IndexManager indexManager){
        this.indexManager = indexManager;
    }
    @Override
    public void execute(String[] args){
        if(args.length == 0){
            System.out.println("No files specified to add!");
            return;
        }

        for(String filepath : args){
            try{
                indexManager.addFileToIndex(filepath);
            } catch (IOException e){
                System.out.println("Error happened while adding file to the index " + e.getMessage());
            }
        }
    }
}
