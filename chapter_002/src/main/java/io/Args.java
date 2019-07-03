package io;

/***
 * Обработка аргументов (строк) для Zip
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 02.07.2019
 * @version 1
 */
public class Args {
    private String dir;
    private String exc;
    private String out;

    /**
     * String переменные, хранящие путь (директорию),
     * расширение файлов и путь zip-файла
     * @param args - массив строк
     */
    public Args(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].contains("-d")) {
                dir = args[i + 1];
            }
            if (args[i].contains("-e")) {
                exc = args[i + 1].substring(2);
            }
            if (args[i].contains("-o")) {
                out = args[i + 1];
            }
        }
    }
    /**
     * Метод возвращает строку директории
     * @return - возвращает строку после "-d"
     */
    public String directory() {
        return this.dir;
    }
    /**
     * Метод возвращает строку с расширением файла
     * @return - возвращает строку после "-e" и 2 символов после
     */
    public String exclude() {
        return this.exc;
    }
    /**
     * Метод возвращает строку пути создающегося zip-файла
     * @return - возвращает строку после "-o"
     */
    public String output() {
        return this.out;
    }
}