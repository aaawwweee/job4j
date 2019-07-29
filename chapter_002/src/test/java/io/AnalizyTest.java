package io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class AnalizyTest {
    @Test
    public void whenItsWorking() throws Exception {
        Analizy analizy = new Analizy();
        String source = System.getProperty("java.io.tmpdir") + "server.log";
        String target = System.getProperty("java.io.tmpdir") + "unavailable.csv";
        try (PrintWriter out = new PrintWriter(new FileOutputStream(source))) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analizy.unavailable(source, target);
        BufferedReader reader = new BufferedReader(new FileReader(target));
        assertThat(reader.readLine(), is("10:58:01;10:59:01"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02"));
        }
}