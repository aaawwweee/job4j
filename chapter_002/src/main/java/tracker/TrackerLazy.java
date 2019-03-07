package tracker;

public class TrackerLazy {
    private static TrackerLazy instance;

    private TrackerLazy() {
    }

    public static TrackerLazy getInstance() {
        if (instance == null) {
            instance = new TrackerLazy();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerLazy tracker = TrackerLazy.getInstance();
    }
}
