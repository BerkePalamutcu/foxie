package cli.commands;

import core.Indexing.IndexManager;

public class StatusCommand implements Command{
    @Override
    public void execute(String[] args){
        IndexManager indexManager = new IndexManager();
        indexManager.printIndexedFiles();
    }
}
