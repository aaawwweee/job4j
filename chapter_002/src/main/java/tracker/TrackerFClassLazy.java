package tracker;

public class TrackerFClassLazy {
    private TrackerFClassLazy() {
    }

    public static TrackerFClassLazy getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerFClassLazy INSTANCE = new TrackerFClassLazy();
    }

    public static void main(String[] args) {
        TrackerFClassLazy tracker = TrackerFClassLazy.getInstance();
    }


}
