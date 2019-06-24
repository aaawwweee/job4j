package testtask;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalyzeTest {

    Analyze analyze = new Analyze();
    List<Analyze.User> prev = new ArrayList<>();
    List<Analyze.User> curr = new ArrayList<>();

    @Before
    public void addingElements() {
        prev.add(new Analyze.User(1, "Grisha"));
        prev.add(new Analyze.User(2, "Sasha"));
        prev.add(new Analyze.User(3, "Masha"));
    }

    @Test
    public void when2ObjectsDeleted1Renamed1Added() {
        curr.add(new Analyze.User(1, "Misha"));
        curr.add(new Analyze.User(4, "Pasha"));
        Analyze.Info result = analyze.diff(prev,curr);
        assertThat(result.added, is(1));
        assertThat(result.changed, is(1));
        assertThat(result.deleted, is(2));
    }
}