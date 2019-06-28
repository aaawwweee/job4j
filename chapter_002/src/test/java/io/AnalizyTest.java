package io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;

public class AnalizyTest {
    public Analizy analizy;

    @Before
    public void init() {
        analizy = new Analizy();
    }

    @Test
    public void whenItsWorking() throws Exception {
        String source = "C:/projects/job4j/server.log";
        String target = "C:/projects/job4j/unavailable.csv";
        analizy.unavailable(source, target);
        BufferedReader reader = new BufferedReader(new FileReader(target));
        assertThat(reader.readLine(), is("10:58:01;10:59:01"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02"));
        }
}