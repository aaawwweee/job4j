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
    @Test
    public void whenAddAccountThenTrue() {
        Bank bank = new Bank();
        User vasyaUser  = new User("Vasya");
        bank.addUser(vasyaUser);
        Account vasyaAccount = new Account(1000, 123123);
        List<Account> result = bank.addAccountToUser("Vasya", vasyaAccount);
        assertThat(result.get(0).getRequisites(), is(123123));
    }
    @Test
    public void whenDeleteAccountThenTrue() {
        Bank bank = new Bank();
        User olegUser = new User("Oleg");
        bank.addUser(olegUser);
        Account olegAccount = new Account(1100, 3213211);
        bank.addAccountToUser("Oleg", olegAccount);
        bank.deleteAccountToUser("Oleg", olegAccount);
        List<Account> result = bank.deleteAccountToUser("Oleg", olegAccount);
        assertThat(result.isEmpty(), is(true));
    }
    @Test
    public void findAccountOfUser() {
        Bank bank = new Bank();
        User olegUser = new User("Oleg");
        bank.addUser(olegUser);
        Account olegAccount = new Account(1100, 3213211);
        bank.addAccountToUser("Oleg", olegAccount);
        List<Account> result = bank.getUserAccounts("Oleg");
        assertThat(result.get(0), is(olegAccount));
        result = bank.deleteAccountToUser("Oleg", olegAccount);
        assertThat(result.isEmpty(), is(true));
    }
    @Test
    public void whenTransferThenTrue() {
        Bank bank = new Bank();
        User userOleg = new User("Oleg");
        User userOlga = new User("Olga");
        bank.addUser(userOleg);
        bank.addUser(userOlga);
        Account accOleg = new Account(1000, 123);
        Account accOlga = new Account(500, 321);
        bank.addAccountToUser("Oleg", accOleg);
        bank.addAccountToUser("Olga", accOlga);
        bank.transfer("Oleg", 123, "Olga", 321, 200);
        assertThat(bank.findUsersAccount("Olga", 321).getValue(), is(700.0));
    }
}