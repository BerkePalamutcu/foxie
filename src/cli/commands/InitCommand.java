package cli.commands;

import core.Repository.RepositoryInitializer;

public class InitCommand implements Command{
    @Override
    public void execute(String[] args){
        RepositoryInitializer initializer = new RepositoryInitializer();
        initializer.initialize();
    }
}
