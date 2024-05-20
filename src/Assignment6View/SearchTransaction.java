package Assignment6View;

import Assignment6Controller.AccountTransactionDTO;
import Assignment6Model.BankAccountTransaction;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SearchTransaction extends javax.swing.JFrame {
	private JTextField accountIdField;
    private JButton searchButton;
    private JButton cancelButton;

    public SearchTransaction() {
        initComponents();
    }

    private void initComponents() {
        JLabel accountIdLabel = new JLabel("Account ID:");
        accountIdField = new JTextField(20);
        searchButton = new JButton("Search");
        cancelButton = new JButton("Cancel");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(accountIdLabel);
        add(accountIdField);
        add(searchButton);
        add(cancelButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void searchActionPerformed(ActionEvent evt) {
        findTransactions();
    }

    private void findTransactions() {
        int accountId = Integer.parseInt(accountIdField.getText());
        List<BankAccountTransaction> transactions = AccountTransactionDTO.transactionsByAccountID(accountId);
        TransactionList transactionListFrame = new TransactionList(transactions);
        transactionListFrame.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchTransaction().setVisible(true);
            }
        });
    }
}
