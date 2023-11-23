package core.Filewatcher;

import java.nio.file.*;
import java.util.List;

public class Filewatcher {
    private final Path pathToWatch;
    private final WatchService watchService;

    public Filewatcher(String directoryName) throws Exception {
        this.watchService = FileSystems.getDefault().newWatchService();
        this.pathToWatch = Paths.get(System.getProperty("user.dir"), directoryName);
        this.pathToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
    }

    public void startMonitorting(){
        try{
            while(true) {
                WatchKey key = watchService.take();
                List<WatchEvent<?>> eventList = key.pollEvents();
                for (WatchEvent<?> event : eventList) {
                    System.out.println("Event kind: " + event.kind() +
                            ". File affected: " + event.context() + ".");
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch(Exception e){
            System.out.println("Interruption happened " + e.getMessage());
        }
    }
}
