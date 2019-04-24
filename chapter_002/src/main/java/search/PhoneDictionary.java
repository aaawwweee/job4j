package search;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Alexander Kashkin
 * @since 01.04.2019
 * @version 1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (var person : persons) {
            String name = person.getName();
            String surname = person.getSurname();
            String address = person.getAddress();
            String phone = person.getPhone();
            if (key.contains(name) || key.contains(surname)
            || key.contains(address) || key.contains(phone)) {
                result.add(person);
            }
        }
        return result;
    }
}
