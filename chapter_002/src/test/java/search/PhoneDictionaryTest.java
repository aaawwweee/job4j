package search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Alexander", "Kashkin", "125125", "Moscow")
        );
        List<Person> persons = phones.find("125125");
        assertThat(persons.iterator().next().getSurname(), is("Kashkin"));
    }
}