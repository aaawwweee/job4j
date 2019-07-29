package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kashkin(kashkinmsk@gmail.com)
 * @version 1
 * @since 28.06.2019
 */
public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            boolean checkServer = true;
            List<String> list = new ArrayList<>();
            while (read.ready()) {
                String check = read.readLine();
                if (checkServer) {
                    if (check.contains("400") || check.contains("500")) {
                        String[] date = check.split(" ");
                        check = date[1] + ";";
                        list.add(check);
                        checkServer = false;
                    }
                }
                if (!checkServer) {
                    if (check.contains("200") || check.contains("300")) {
                        String[] date = check.split(" ");
                        check = date[1] + System.lineSeparator();
                        list.add(check);
                        checkServer = true;
                    }
                }
            }
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                for (String temp : list) {
                    out.write(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}