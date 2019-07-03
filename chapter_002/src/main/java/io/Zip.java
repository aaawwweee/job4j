package io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 02.07.2019
 * @version 1
 */
public class Zip {
    /**
     * Метод полностью перебирает указанную директорию
     * и добавляет в коллекцию все файлы, за исключением файлов с расширением,
     * указанным в аргументе метода
     * @param root - корневой файл (директория)
     * @param ext - расширение файла, которое не включается в дальнейший zip
     * @return - List-файлов, без указанного в аргументе метода расширения
     */
    List<File> seekBy(String root, String ext) {
        List<File> filesWithOutExts = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(root));
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
    /**
     * Метод принимает в качестве аргументов List-файлов и создает zip
     * @param source - лист файлов
     * @param target - файл-зип для записи файлов коллекции
     */
    void pack(List<File> source, File target){
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(
                        file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Zip zip = new Zip();
        Args args1 = new Args(args);
        List<File> files = zip.seekBy(args1.directory(), args1.exclude());
        File newFile = new File(args1.output());
        zip.pack(files, newFile);
    }
}
