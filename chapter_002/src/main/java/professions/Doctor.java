package professions;

public class Doctor extends Profession {
    Diagnose treat(Pacient pacient) {
        return new Diagnose();
    }
}
