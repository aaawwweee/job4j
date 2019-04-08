package bank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    @Test
    public void whenFindUserByPassportThenTrue() {
        Bank bank = new Bank();
        User user = new User("Vasya", "Ivanov Vasya");
        bank.addUser(user);
        assertThat(user.getPassport(), is("Ivanov Vasya"));
    }
}
