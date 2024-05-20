package Assignment6View;

import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
    private JButton startButton;

    public LandingPage() {
        setTitle("Landing Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        startButton = new JButton("Start Application");
        add(startButton, BorderLayout.CENTER);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LandingPage frame = new LandingPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
