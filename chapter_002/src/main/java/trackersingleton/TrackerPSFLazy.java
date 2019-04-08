package trackersingleton;

public class TrackerPSFLazy {
    private TrackerPSFLazy() {
    }

    public static TrackerPSFLazy getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerPSFLazy INSTANCE = new TrackerPSFLazy();
    }
}
