/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment6View;
import Assignment6Model.BankAccount;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karunmehta
 */
public class AccountList extends javax.swing.JFrame {
	 private JList<String> accountList;
	 private JButton showDetailButton;
	 private List<BankAccount> accounts;
	 private AccountDetail detail;
    /**
     * Creates new form AccountList
     */
	 public AccountList(List<BankAccount> accounts) {
	        this.accounts = accounts;
	        initComponents();
	    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (BankAccount account : accounts) {
            listModel.addElement("Account ID: " + account.getAccountNum() +
                                 ", Type: " + account.getType() +
                                 ", Balance: " + account.getBalance() +
                                 ", Created: " + account.getCreateDate());
        }

        accountList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(accountList);
        showDetailButton = new JButton("Show Detail");
        showDetailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	showDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(showDetailButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDetailButton)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showDetailActionPerformed(ActionEvent evt) {
        int selectedIndex = accountList.getSelectedIndex();
        if (selectedIndex != -1) {
            BankAccount selectedAccount = accounts.get(selectedIndex);
            AccountDetail accountDetailFrame = new AccountDetail(selectedAccount);
            accountDetailFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an account from the list.");
        }
    }
    public JList<String> getAccountList() {
        return accountList;
    }

    public JButton getAccountDetailsButton() {
        return showDetailButton;
    }
    
    public JButton getCloseButton() {
        return closeButton;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	 new AccountList(new ArrayList<>()).setVisible(true);
            }
        });
    }
    private javax.swing.JButton closeButton;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
	public AccountDetail getAccountDetailFrame() {
		return detail;
	}
}