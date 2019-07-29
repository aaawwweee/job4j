package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {

    Scanner sc;

    public void chatting(File fileReader, File fileWriter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileReader))) {
            sc = new Scanner(System.in);
            String phrase = sc.nextLine();
            String stop = "стоп";
            String continueChat = "продолжить";
            String finish = "закончить";
            String answer = getRandomPhraseFromFile(fileReader);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriter))) {
            while (!phrase.equals(finish)) {
                System.out.println(answer);
                answer = getRandomPhraseFromFile(fileReader);
                writer.write(phrase + System.lineSeparator());
                writer.write(answer + System.lineSeparator());
                phrase = sc.nextLine();
                if (phrase.equals(stop)) {
                    phrase = sc.nextLine();
                    while (!phrase.equals(continueChat)) {
                        phrase = sc.nextLine();
                        writer.write(stop + System.lineSeparator());
                    }
                } else if (phrase.equals(continueChat)) {
                    System.out.println(getRandomPhraseFromFile(fileReader));
                    writer.write(continueChat);
                }
            }
            writer.write(finish + System.lineSeparator());
            writer.close();
            reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomPhraseFromFile(File fileReader) {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader rd = new BufferedReader(new FileReader(fileReader.getAbsolutePath()));
            String read;
            while ((read = rd.readLine()) != null) {
                words.add(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words.get((int) (Math.random() * words.size()));
    }

    public static void main(String[] args) {
        Chat chat = new Chat();
        String source = System.getProperty("java.io.tmpdir") + "chat.log";
        String target = System.getProperty("java.io.tmpdir") + "answers.log";
        File fileReader = new File(source);
        File fileWriter = new File(target);
        chat.chatting(fileReader, fileWriter);
    }
}
