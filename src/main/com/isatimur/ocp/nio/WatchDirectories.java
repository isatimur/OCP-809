package com.isatimur.ocp.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

/**
 * Created by tisachenko on 25.04.16.
 */
public class WatchDirectories {
    public static void main(String[] args) {
        try (WatchService watchService = FileSystems.getDefault().newWatchService();) {
            Path dir1 = Paths.get("/home/tisachenko/ROSTRUD");
            Path dir2 = Paths.get("/home/tisachenko/ROSTRUD/8");

            dir1.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            dir2.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);

            WatchKey watchKey = null;
            while (true) {
                watchKey = watchService.take();

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path path = ((WatchEvent<Path>)event).context();

                    if (kind == OVERFLOW) {
                        continue;
                    }
                    else if (kind == ENTRY_CREATE) {
                        System.out.format("\nCreate - %s", path);
                    }
                    else if (kind == ENTRY_MODIFY) {
                        System.out.format("\nModify - %s", path);
                    }
                    else if (kind == ENTRY_DELETE) {
                        System.out.format("\nDelete - %s", path);
                    }

                }
                if (!watchKey.reset()) {
                    break;
                }
            }

        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
