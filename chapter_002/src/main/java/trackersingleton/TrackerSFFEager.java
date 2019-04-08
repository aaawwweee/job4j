package trackersingleton;

public class TrackerSFFEager {
    private static final TrackerSFFEager INSTANCE = new TrackerSFFEager();

    private TrackerSFFEager() { }

    public static TrackerSFFEager getInstance() {
        return INSTANCE;
    }
}
