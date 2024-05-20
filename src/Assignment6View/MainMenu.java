package Assignment6View;

import java.awt.EventQueue;

import javax.swing.*;

public class MainMenu extends JFrame {
    private JButton showCustomersButton;
    private CustomerList customerListFrame;

    public MainMenu() {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showCustomersButton = new JButton("Show All Customers");
        showCustomersButton.addActionListener(e -> {
            customerListFrame = new CustomerList();
            customerListFrame.setVisible(true);
        });
        add(showCustomersButton);
    }

    public JButton getShowCustomersButton() {
        return showCustomersButton;
    }

    public CustomerList getCustomerListFrame() {
        return customerListFrame;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
