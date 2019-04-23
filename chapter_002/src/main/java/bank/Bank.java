package bank;
import java.util.*;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 10.04.2019
 * @version 1
 */
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
    public List<Account> addAccountToUser(String passport, Account account) {
        List<Account> accounts = bank.get(findUserByPassport(passport));
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        return accounts;
    }
    public List<Account> deleteAccountToUser(String passport, Account account) {
        List<Account> accounts = bank.get(findUserByPassport(passport));
        if (accounts.contains(account)) {
            accounts.remove(account);
        }
        return accounts;
    }
    public User findUserByPassport(String passport) {
//        User result = null;
//        Set<User> users = bank.keySet();
//        for (User user : users) {
//            if (user != null) {
//                if (passport == user.getPassport()) {
//                    result = user;
//                    break;
//                }
//            }
//        }
        Optional<User> user = bank.keySet().stream().filter(x -> x.getPassport().equals(passport)).findAny();
        return user.orElseGet(() -> user.orElseGet(null));
    }
    public List<Account> getUserAccounts(String passport) {
        return bank.get(findUserByPassport(passport));
    }
    public Account findUsersAccount(String passport, int requisites) {
        Account result = null;
        User user = findUserByPassport(passport);
        if (user != null) {
            for (Account account : bank.get(user)) {
                if (requisites == account.getRequisites()) {
                    result = account;
                }
            }
        }
        return result;
    }
    public boolean transfer(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        boolean result = false;
        Account srcAcc = findUsersAccount(srcPassport, srcRequisite);
        Account destAcc = findUsersAccount(destPassport, dstRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getValue() >= amount) {
            destAcc.setValue(destAcc.getValue() + amount);
            srcAcc.setValue(srcAcc.getValue() - amount);
            result = true;
        }
        return result;
    }
}