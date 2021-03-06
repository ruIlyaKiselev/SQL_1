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

    private static final String windowName = "Подключение к базе данных";
    private static final String connectionURLLabelText = "URL для подключения:";
    private static final String connectionURLTextFieldText = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    // jdbc:oracle:thin:@84.237.50.81:1521:xe
    // jdbc:oracle:thin:@//localhost:1521/XEPDB1
    private static final String loginLabelText = "Логин: ";
    private static final String passwordLabelText = "Пароль: ";
    private static final String connectButtonText = "Войти";
    private static final String registrationButtonText = "Регистрация";

    private static final String loginTextFieldText = "shop"; // database hardcoded login
    private static final String passwordTextFieldText = "admin"; // database hardcoded password

    private JButton helpButton;
    private static final String helpButtonText = "Помощь";
    private static final String helpText = "Это окно входа в базу данных.\n" +
            "В поле \"URL для подключения\" пишется URL базы данных для соединения.\n" +
            "В поле \"Логин\" пишется имя пользователя в этой базе данных.\n" +
            "В поле \"Пароль\" пишется пароль для выбранного пользователя.\n" +
            "После ввода данных нажмите \"Войти\".\n" +
            "В случае ошибки информация о ней будет выведена на место символа \"~\".";

    private ApplicationManager applicationManager;

    private String connectionURL;
    private String username;
    private String password;

    private JTextField  connectionURLTextField;
    private JTextField  loginTextField;
    private JPasswordField  passwordTextField;
    private JLabel buttonLabel;

    private JButton connectButton;
    private JButton registrationButton;


    public LoginWindow(ApplicationManager applicationManager) {
        super(windowName);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        JLabel connectionURLLabel = new JLabel(connectionURLLabelText);
        connectionURLLabel.setBorder(BorderFactory.createEmptyBorder(240, 0, 0, 0));
        connectionURLLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectionURLTextField = new JTextField(16);
        connectionURLTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectionURLTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        connectionURLTextField.setText(connectionURLTextFieldText);

        JLabel loginLabel = new JLabel(loginLabelText);
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginTextField = new JTextField(16);
        loginTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        loginTextField.setText(loginTextFieldText);

        JLabel passwordLabel = new JLabel(passwordLabelText);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordTextField = new JPasswordField(16);
        passwordTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordTextField.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        passwordTextField.setEchoChar('*');
        passwordTextField.setText(passwordTextFieldText);

        buttonLabel = new JLabel("~");
        buttonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        connectButton = new JButton();
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        connectButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        connectButton.setText(connectButtonText);
        connectButton.addActionListener(new ConnectListener());

        registrationButton = new JButton();
        registrationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrationButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        registrationButton.setText(registrationButtonText);
        registrationButton.addActionListener(new RegistrationListener());

        helpButton = new JButton();
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        helpButton.setText(helpButtonText);
        helpButton.addActionListener(new HelpListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(connectionURLLabel);
        this.getContentPane().add(connectionURLTextField);
        this.getContentPane().add(loginLabel);
        this.getContentPane().add(loginTextField);
        this.getContentPane().add(passwordLabel);
        this.getContentPane().add(passwordTextField);
        this.getContentPane().add(buttonLabel);
        this.getContentPane().add(connectButton);
        this.getContentPane().add(registrationButton);
        this.getContentPane().add(new JLabel(" "));
        this.getContentPane().add(helpButton);
    }

    class ConnectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            connectionURL = connectionURLTextField.getText();
            username = loginTextField.getText();
            password = new String(passwordTextField.getPassword());

            try {
                applicationManager.login(connectionURL, username, password);
            } catch (SQLException throwables) {
                buttonLabel.setText(throwables.getMessage());
                System.err.println(throwables.getMessage());
            }
        }
    }

    class RegistrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showRegistrationWindow();
        }
    }

    class HelpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, helpText);
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
