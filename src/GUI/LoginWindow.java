package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginWindow extends JFrame {

    private final int textFieldWidth = 300;
    private final int textFieldHeight = 25;

    private ApplicationManager applicationManager;

    private String connectionURL;
    private String username;
    private String password;

    private JTextField  connectionURLTextField;
    private JTextField  loginTextField;
    private JPasswordField  passwordTextField;
    private JLabel buttonLabel;
    private JButton connectButton;

    public LoginWindow(ApplicationManager applicationManager) {
        super("Connecting to database");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        JLabel connectionURLLabel = new JLabel("Connection URL:");
        connectionURLLabel.setBorder(BorderFactory.createEmptyBorder(240, 0, 0, 0));
        connectionURLLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectionURLTextField = new JTextField(16);
        connectionURLTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectionURLTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        connectionURLTextField.setText("jdbc:oracle:thin:@//localhost:1521/XEPDB1");

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginTextField = new JTextField(16);
        loginTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordTextField = new JPasswordField(16);
        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        passwordTextField.setEchoChar('*');

        buttonLabel = new JLabel("~");
        buttonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectButton = new JButton();
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        connectButton.setText("Connect");
        connectButton.addActionListener(new ButtonEventListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(connectionURLLabel);
        this.getContentPane().add(connectionURLTextField);
        this.getContentPane().add(loginLabel);
        this.getContentPane().add(loginTextField);
        this.getContentPane().add(passwordLabel);
        this.getContentPane().add(passwordTextField);
        this.getContentPane().add(buttonLabel);
        this.getContentPane().add(connectButton);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            connectionURL = connectionURLTextField.getText();
            username = loginTextField.getText();
            password = new String(passwordTextField.getPassword());

            try {
                applicationManager.login(connectionURL, username, password);
            } catch (SQLException throwables) {
                buttonLabel.setText(throwables.getMessage());
            }
        }
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
