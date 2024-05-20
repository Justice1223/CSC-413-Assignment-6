package Assignment6View;
import Assignment6Model.BankAccountTransaction;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionList extends javax.swing.JFrame {
	 private JList<String> transactionList;

	    public TransactionList(List<BankAccountTransaction> transactions) {
	        initComponents(transactions);
	    }

	    private void initComponents(List<BankAccountTransaction> transactions) {
	        DefaultListModel<String> listModel = new DefaultListModel<>();
	        for (BankAccountTransaction transaction : transactions) {
	            listModel.addElement(transaction.toString());
	        }

	        transactionList = new JList<>(listModel);
	        JScrollPane scrollPane = new JScrollPane(transactionList);

	        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	        add(scrollPane);

	        pack();
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }

	    public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TransactionList(new ArrayList<>()).setVisible(true);
	            }
	        });
	    }
}
