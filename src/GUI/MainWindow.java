package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainWindow extends JFrame {

    private final int textFieldWidth = 200;
    private final int textFieldHeight = 20;

    private ApplicationManager applicationManager;

    private JButton connectButton;
    private JLabel countOfStringsLabel;

    private String countOfStrings = "0";

    public MainWindow(ApplicationManager applicationManager) {
        super("Main window");
        this.setSize(620, 480);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        JLabel clickLabel = new JLabel("Click the button:");
        clickLabel.setBorder(BorderFactory.createEmptyBorder(140, 0, 0, 0));
        clickLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectButton = new JButton();
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        connectButton.setText("Click me");
        connectButton.addActionListener(new ButtonEventListener());

        countOfStringsLabel = new JLabel("Count of strings in a table: ?");
        countOfStringsLabel.setBorder(BorderFactory.createEmptyBorder(140, 0, 0, 0));
        countOfStringsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(clickLabel);
        this.getContentPane().add(connectButton);
        this.getContentPane().add(countOfStringsLabel);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                countOfStrings = applicationManager.getCountOfStrings();
                countOfStringsLabel.setText("Count of strings in a table: " + countOfStrings);
            } catch (SQLException throwables) {
                countOfStringsLabel.setText(throwables.getMessage());
            }
        }
    }

    public String getCountOfStrings() {
        return countOfStrings;
    }

    public void setCountOfStrings(String countOfStrings) {
        this.countOfStrings = countOfStrings;
    }
}
