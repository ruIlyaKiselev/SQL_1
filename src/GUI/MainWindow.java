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
    private JButton initButton;
    private JButton dropButton;
    private JButton manageDatabaseButton;
    private JLabel countOfStringsLabel;

    private String countOfStrings = "0";

    public MainWindow(ApplicationManager applicationManager) {
        super("Main window");
        this.setSize(1024, 768);
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
        connectButton.addActionListener(new CountButtonListener());

        initButton = new JButton();
        initButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        initButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        initButton.setText("Init database");
        initButton.addActionListener(new InitButtonListener());

        dropButton = new JButton();
        dropButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        dropButton.setText("Drop database");
        dropButton.addActionListener(new DropButtonListener());

        manageDatabaseButton = new JButton();
        manageDatabaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageDatabaseButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageDatabaseButton.setText("Manage database");
        manageDatabaseButton.addActionListener(new ManageTableButton());

        countOfStringsLabel = new JLabel("Count of strings in a table: ?");
        countOfStringsLabel.setBorder(BorderFactory.createEmptyBorder(140, 0, 0, 0));
        countOfStringsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(clickLabel);
        this.getContentPane().add(connectButton);
        this.getContentPane().add(initButton);
        this.getContentPane().add(dropButton);
        this.getContentPane().add(manageDatabaseButton);
        this.getContentPane().add(countOfStringsLabel);
    }

    class CountButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                countOfStrings = applicationManager.getCountOfStrings();
                countOfStringsLabel.setText("Count of strings in a table: " + countOfStrings);
            } catch (SQLException throwables) {
                countOfStringsLabel.setText(throwables.getMessage());
            }
        }
    }

    class InitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.initDatabase();
        }
    }

    class DropButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.dropTables();
        }
    }

    class ManageTableButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showTableManageWindow();
        }
    }

    public String getCountOfStrings() {
        return countOfStrings;
    }

    public void setCountOfStrings(String countOfStrings) {
        this.countOfStrings = countOfStrings;
    }
}
