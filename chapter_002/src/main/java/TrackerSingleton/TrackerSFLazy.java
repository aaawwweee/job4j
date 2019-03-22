package TrackerSingleton;

public class TrackerSFLazy {
    private static TrackerSFLazy instance;

    private TrackerSFLazy() {}

    public static TrackerSFLazy getInstance() {
        if (instance == null) {
            instance = new TrackerSFLazy();
        }
        return instance;
    }
}
