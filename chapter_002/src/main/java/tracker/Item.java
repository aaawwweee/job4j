package tracker;

public class Item {
    private String name;
    private String id;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public long getCreated() {
        return created;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
