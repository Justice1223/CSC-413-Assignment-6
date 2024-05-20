package Assignment6Controller;

import Assignment6Model.BankAccount;

public class AccountDTO {
    public static int createAccount(BankAccount account) {
        int result = -1;
        try {
            AccountDAO dao = new AccountDAO();
            result = dao.create(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static BankAccount getAccount(int accountNum) {
        BankAccount account = null;
        try {
            AccountDAO dao = new AccountDAO();
            account = dao.get(accountNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public static int updateAccount(BankAccount account) {
        int result = -1;
        try {
            AccountDAO dao = new AccountDAO();
            result = dao.update(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int deleteAccount(int accountNum) {
        int result = -1;
        try {
            AccountDAO dao = new AccountDAO();
            result = dao.delete(accountNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}