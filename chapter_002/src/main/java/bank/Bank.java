package bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> bank = new HashMap<>();

    public void addUser(User user) {
        this.bank.putIfAbsent(user, new ArrayList<>());
    }
    public void deleteUser(User user) {
        if (user != null) {
            this.bank.remove(user);
        }
    }
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = bank.get(findUserByPassport(passport));
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }
    public void deleteAccountToUser(String passport, Account account) {
        List<Account> accounts = bank.get(findUserByPassport(passport));
            if (accounts.contains(account)) {
                accounts.remove(account);
            }
        }

    private User findUserByPassport(String passport) {
        User result = null;
        Set<User> users = bank.keySet();
        for (User user : users) {
            if (passport == user.getPassport()) {
                result = user;
                break;
            }
        }
        return result;
    }
}
