/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karunmehta
 */
public class AccountDAO {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result; 
    final String checking = "CH";
    final String saving = "SV";

    public AccountDAO() {
        connection = DataConnection.getDBConnection();
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert an account into the database
    public int create(BankAccount act) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement("INSERT INTO Account (accountId, balance, accountType, createDate, customerId) VALUES (?, ?, ?, ?, ?)");
        pStatement.setInt(1, act.getAccountNum());
        pStatement.setDouble(2, act.getBalance());
        pStatement.setString(3, act.getType());
        pStatement.setString(4, act.getCreateDate().toString());
        pStatement.setString(5, act.getCustNum());
        res = pStatement.executeUpdate();
        disconnect();
        return res;
    }

    // Method to retrieve an account from the database by ID
    public BankAccount get(int accountNum) throws SQLException {
        pStatement = connection.prepareStatement("SELECT * FROM Account WHERE accountId = ?");
        pStatement.setInt(1, accountNum);
        result = pStatement.executeQuery();
        
        BankAccount updatedAct = null;
        if (result.next()) {
            if(result.getString("accountType").equalsIgnoreCase(checking))
                updatedAct = new CheckingAccount(result.getInt("accountId"));
            else
                updatedAct = new SavingsAccount(result.getInt("accountId"));
            
            updatedAct.setBalance(result.getDouble("balance"));
            LocalDate ld = createLocalDate(result.getString("createDate"));
            updatedAct.setCreateDate(ld);
            updatedAct.setCustNum(result.getInt("customerId"));
        }
      
        return updatedAct;
    }

    // Method to create LocalDate from string
    private LocalDate createLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return localDate;
    }

    // Method to update an account in the database
    public int update(BankAccount act) throws SQLException {
        int result = -1;
        pStatement = connection.prepareStatement("UPDATE Account SET balance = ?, createDate = ?, accountType = ?, customerId = ? WHERE accountId = ?");
        pStatement.setDouble(1, act.getBalance());
        pStatement.setString(2, act.getCreateDate().toString());
        pStatement.setString(3, act.getType());
        pStatement.setString(4, act.getCustNum());
        pStatement.setInt(5, act.getAccountNum());
        result = pStatement.executeUpdate();
        disconnect();
        return result;
    }

    // Method to delete an account from the database
    public int delete(int accountNum) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement("DELETE FROM Account WHERE accountId = ?");
        pStatement.setInt(1, accountNum);
        res = pStatement.executeUpdate();
        disconnect();
        return res;
    }

    // Method to retrieve accounts by customer ID
    public List<BankAccount> getAccountsByCustomerId(int customerId) throws SQLException {
        List<BankAccount> accounts = new ArrayList<>();
        pStatement = connection.prepareStatement("SELECT * FROM Account WHERE customerId = ?");
        pStatement.setInt(1, customerId);
        result = pStatement.executeQuery();

        while (result.next()) {
            BankAccount account;
            if(result.getString("accountType").equalsIgnoreCase(checking))
                account = new CheckingAccount(result.getInt("accountId"));
            else
                account = new SavingsAccount(result.getInt("accountId"));

            account.setBalance(result.getDouble("balance"));
            LocalDate ld = createLocalDate(result.getString("createDate"));
            account.setCreateDate(ld);
            account.setCustNum(result.getInt("customerId"));
            accounts.add(account);
        }

        disconnect();
        return accounts;
    }

	public static AccountDAO getInstance1() {
		// TODO Auto-generated method stub
		return null;
	}
}

