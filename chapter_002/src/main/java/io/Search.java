package io;
import java.io.File;
import java.util.*;
/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @since 30.06.2019
 * @version 1
 */
public class Search {
    /**
     * Метод перебирает заданную директорию и добавляет в List только файлы
     * с заданными расширениями
     * @param parent - корень
     * @param exts - List с расширениями файлов
     * @return - List с файлами
     */
    public List<File> fileWithExts(String parent, List<String> exts) {
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

    /**
     * Метод перебирает заданную директорию и добавляет в List все файлы
     * за исключением файла с расширением в аргументе метода (String ext)
     * @param parent - корень
     * @param ext - расширение файла
     * @return - List с файлами
     */
    public List<File> filesWithoutExts(String parent, String ext) {
        List<File> filesWithOutExts = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] files = current.listFiles();
            if (current.isDirectory() && files != null) {
                for (File file : files) {
                    queue.offer(file);
                }
            } else if (!ext.contains(current.getName().substring(current.getName().lastIndexOf(".") + 1))) {
                filesWithOutExts.add(current);
            }
        }
        return filesWithOutExts;
    }
}