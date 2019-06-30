package io;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SearchTest {
    @Test
    public void whenRequestedDocsThenReturnEmptyList() throws IOException {
        File root = new File(System.getProperty("java.io.tmpdir"));
        root.mkdirs();
        File subDir1 = new File(root, "subDir1");
        subDir1.mkdir();
        File subDir3 = new File(subDir1, "subDir3");
        subDir3.mkdir();
        File file1 = new File(root, "first.txt");
        file1.createNewFile();
        File file4 = new File(subDir1, "fourth.dwg");
        file4.createNewFile();
        File file6 = new File(subDir3, "sixth.dwg");
        file6.createNewFile();
        Search search = new Search();
        assertThat(search.files(System.getProperty("java.io.tmpdir"), List.of("docs")),
                is(List.of()));
    }

    @Test
    public void whenRequestedTxtThenReturnTxt() throws IOException {
        File root = new File(System.getProperty("java.io.tmpdir"));
        root.mkdirs();
        File subDir1 = new File(root, "subDir1");
        subDir1.mkdir();
        File subDir2 = new File(root, "subDir2");
        subDir2.mkdir();
        File subDir3 = new File(subDir1, "subDir3");
        subDir3.mkdir();
        File file1 = new File(root, "first.txt");
        file1.createNewFile();
        File file2 = new File(root, "second.doc");
        file2.createNewFile();
        File file3 = new File(subDir1, "third.txt");
        file3.createNewFile();
        File file4 = new File(subDir1, "fourth.dwg");
        file4.createNewFile();
        File file5 = new File(subDir2, "fifth.log");
        file5.createNewFile();
        File file6 = new File(subDir3, "sixth.dwg");
        file6.createNewFile();
        Search search = new Search();
        assertThat(search.files(System.getProperty("java.io.tmpdir"), List.of("txt")),
                is(List.of(file1,file3)));
    }
}