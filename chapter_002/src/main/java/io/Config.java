package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load(){
        List<String> temps = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            temps = read.lines().filter(x -> x.contains("=")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String temp : temps) {
            while (temp.contains(" ")) {
                String x = temp.replace(" ","");
                temp = x;
            }
            if (temp.contains("#")) {
                String[] partsOne = temp.split("#");
                String y = partsOne[0];
                temp = y;
            }
            String[] parts = temp.split("=");
            values.put(parts[0], parts[1]);
        }
    }


    public String value(String key) {
        return values.get(key);
   }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
