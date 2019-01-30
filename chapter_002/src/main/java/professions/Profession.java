package professions;

public class Profession {
    String name;
    String profession;
    public Profession() {
    }
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }
    public String getName() {
        return this.name;
    }
    public String getProfession() {
        return this.profession;
    }
}
