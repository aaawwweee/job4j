package trackersingleton;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerEnumTest {
    @Test
    public void whenTrackerEnum() {
        TrackerEnum tracker = TrackerEnum.WINTER;
        TrackerEnum tracker2 = TrackerEnum.WINTER;
        assertThat(tracker.equals(tracker2), is(true));
    }

    @Test
    public void whenTrackerEnumWrong() {
        TrackerEnum tracker = TrackerEnum.SPRING;
        TrackerEnum tracker2 = TrackerEnum.SUMMER;
        assertThat(tracker.equals(tracker2), is(false));
    }
}
