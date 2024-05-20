package Assignment6View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {

    public static void main(String[] args) {
        // Step 1: Launch the Landing Page of the Application
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LandingPage landingPage = new LandingPage();
                    landingPage.setVisible(true);

                    // Add action listener to proceed to the Main Menu
                    JButton startButton = landingPage.getStartButton();
                    startButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            landingPage.dispose();
                            showMainMenu();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void showMainMenu() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);

                    // Testing Step 1: Show All Customers
                    JButton showCustomersButton = mainMenu.getShowCustomersButton();
                    showCustomersButton.doClick();

                    // Wait for the CustomerList frame to open
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            CustomerList customerList = mainMenu.getCustomerListFrame();
                            if (customerList != null) {
                                customerList.setVisible(true);

                                // Testing Step 2: Select a customer and show details
                                JList<String> custList = customerList.getCustomerList();
                                custList.setSelectedIndex(0); // Select the first customer
                                JButton showDetailsButton = customerList.getShowDetailsButton();
                                showDetailsButton.doClick();

                                // Wait for the CustomerDetail frame to open
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        CustomerDetail customerDetail = customerList.getCustomerDetailFrame();
                                        if (customerDetail != null) {
                                            customerDetail.setVisible(true);

                                            // Testing Step 3: Update customer attribute and click 'Update'
                                            JTextField firstNameField = customerDetail.getFirstNameField();
                                            firstNameField.setText("UpdatedFirstName");
                                            JButton saveButton = customerDetail.getSaveButton();
                                            saveButton.doClick();

                                            JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully.");

                                            // Close CustomerDetail frame
                                            JButton cancelButton = customerDetail.getCancelButton();
                                            cancelButton.doClick();

                                            // Testing Step 4: Show Accounts
                                            JButton showAccountsButton = customerList.getShowAccountsButton();
                                            showAccountsButton.doClick();

                                            // Wait for the BankAccountList frame to open
                                            SwingUtilities.invokeLater(new Runnable() {
                                                public void run() {
                                                    AccountList bankAccountList = customerList.getBankAccountListFrame();
                                                    if (bankAccountList != null) {
                                                        bankAccountList.setVisible(true);

                                                        // Testing Step 5: Show Account Details
                                                        JList<String> accountList = bankAccountList.getAccountList();
                                                        accountList.setSelectedIndex(0); // Select the first account
                                                        JButton accountDetailsButton = bankAccountList.getAccountDetailsButton();
                                                        accountDetailsButton.doClick();

                                                        // Wait for the AccountDetail frame to open
                                                        SwingUtilities.invokeLater(new Runnable() {
                                                            public void run() {
                                                                AccountDetail accountDetail = bankAccountList.getAccountDetailFrame();
                                                                if (accountDetail != null) {
                                                                    accountDetail.setVisible(true);

                                                                    // Close AccountDetail frame
                                                                    JButton closeAccountDetailButton = accountDetail.getCloseButton();
                                                                    closeAccountDetailButton.doClick();
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
