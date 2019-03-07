package tracker;

public enum TrackerEnum {
    //перечисление объектов
    INSTANCE,
    SECOND,
    THIRD,
    FOURTH;

    //конструкторы и методы
    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerEnum tracker = TrackerEnum.INSTANCE;
    }
}