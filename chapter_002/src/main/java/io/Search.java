package io;
import java.io.File;
import java.util.*;
/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @since 30.06.2019
 * @version 1
 */
public class Search {
    public List<File> files(String parent, List<String> exts) {
        List<File> filesWithExts = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] files = current.listFiles();
            if (current.isDirectory() && files != null) {
                for (File file : files) {
                    queue.offer(file);
                }
            } else if (exts.contains(current.getName().substring(current.getName().lastIndexOf(".") + 1))) {
                filesWithExts.add(current);
            }
        }
        return filesWithExts;
    }
}
